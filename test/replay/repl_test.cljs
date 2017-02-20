(ns replay.repl-test
  (:require [cljs.test :refer [deftest testing is]]
            [replay.repl :as repl]))

(deftest this-test
  (testing "sanity"
    (is (= 9 9))))

(deftest example-test
  (testing "that methods from replay.repl can be tested"
    (is (= (repl/example-function)
           "this returns a string to test my testing framework"))))
