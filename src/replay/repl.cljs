(ns replay.repl)

(defn test-function [nvim args]
  (.input nvim "ihello" args))

(defn -main []
  (.commandSync js/plugin "HolyDiver" test-function))
