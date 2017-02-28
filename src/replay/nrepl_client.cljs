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

(defn uuid []
  ;; cljs regex doesn't have global mode encoded - alternative required
  (.replace "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx" #"[xy]" replacer))

(def sends-in-progress {})

(def message-log-printer [response length]
  "wip")
