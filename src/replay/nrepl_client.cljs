(ns replay.nrepl-client
  ;; XXX currently npm is only available via manual npm installing in target
  (:require [cljs.nodejs :as node]))

(def bencode (node/require "bencode"))
(def util (node/require "util"))
(def net (node/require "net"))
(def stream (node/require "stream"))
(def events (node/require "events"))

(defn replacer [character]
    (let [random-number (Math.floor (* (Math.random) 16))
          value (if (= character "x")
                  random-number
                  (-> random-number (bit-and 3) (bit-or 8)))]
      (.toString value 16)))

(defn nrepl-uuid []
  (.toUpperCase
    (.replace "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx"
              (js/RegExp. "[xy]" "g") replacer)))

(def sends-in-progress {})

(defn socket []
  (.connect net #js {:port 9999}))

(defn test-send [socket]
  (.write socket (.encode bencode #js {:id (nrepl-uuid) :op "eval" :code "(def noway 777)"} "binary")))

(defn custom-send [socket code]
  (.write socket (.encode bencode #js {:id (nrepl-uuid) :op "eval" :code code} "binary")))

(defn translate-output-to-cljs [response]
  (into {} (for [[k v] (js->clj response)]
             [(keyword k)
              (if (vector? v)
                (map #(.toString (js->clj %)) v)
                (.toString (js->clj v)))])))

(def nrepl-responses [])

;; reading what is passed back
(defn receive-and-close [socket]
  (.on socket "data"
       (fn [data]
         (def nrepl-responses (conj nrepl-responses data))
         (.destroy socket))))

(defn show-logs []
  (map #(translate-output-to-cljs (.decode bencode %)) nrepl-responses))

;; .connect
;; .write
;; .end
