(ns replay.repl
  (:require [replay.connection :as connection]))

(defn test-function [nvim args]
  (.input nvim "ihello" args))

(defn example-function []
  "this returns a string to test my testing framework")

(defn -main []
  (.commandSync js/plugin "HolyDiver" test-function)
  (.commandSync js/plugin "BeamMeUp" connection/create-link)
  )
