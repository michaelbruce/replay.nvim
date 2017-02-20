(ns replay.repl
  (:require [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

;; current-buffer is req'd by .commandSync
(defn test-function [nvim current-buffer]
  (.command nvim "echo \"The eagle has landed!\""))

(defn -main []
  ;; (.commandSync js/plugin "ReplayFunction" #js {:nargs 0} test-function)
  (.commandSync js/plugin "ReplayFunction" test-function)
  )
