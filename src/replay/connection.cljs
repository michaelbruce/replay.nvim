(ns replay.connection
  (:require [cljs.nodejs :as node]))

;; bencoding
;; socket

;; get cljs repl up and running to dev...
(def net (node/require "net"))

(defn connect [options]
  (let [con (.connect net options)
        message-stream "mock"]
    (aset con "sessions" #js [])))

(defn create-link [nvim args]

  ;; (def connection (.createServer net))
  ;; (.listen connection 9999, "127.0.0.1")
  ;; (.write (connect (js-obj "port" 9999))
  ;; (.write (.connect net (js-obj "port" 9999))
  ;;         "d4:code20:(def boot.user/h 59)2:id7:test-id2:op4:eval7:session7:test-ide", "binary")

  (def nrepl-client (js/require "nrepl-client"))
  (def client (.connect nrepl-client #js {:port 9999}))
  (def expr "(def boot.user/g 6)")

  (.eval client expr (fn [err result]
                  (println expr err)
                  (.end client)))

  (.input nvim ":echo \"beamed\"" args)
  )
