(ns replay.repl)

(defn test-function [nvim args]
  (.input nvim "ihello" args))

(defn example-function []
  "this returns a string to test my testing framework")

(defn -main []
  (.commandSync js/plugin "HolyDiver" test-function))
