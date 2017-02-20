(ns replay.repl
  (:require [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

(defn test-function [nvim]
  (.command nvim "echo \"The eagle has landed!\""))

(defn -main []
  (.command js/plugin "ReplayFunction" #js {:nargs 0} test-function))
