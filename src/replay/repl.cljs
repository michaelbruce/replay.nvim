(ns replay.repl
  (:require [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

(def hello "what")

(defn -main []
  (println "what is going on?"))
