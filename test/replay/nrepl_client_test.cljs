(ns replay.nrepl-client-test
  (:require [cljs.test :refer [deftest testing is]]
            [replay.nrepl-client :as client]))

(deftest npm-modules
  (testing "bencode is accessible"
    (is (not= nil (cljs.nodejs/require "bencode")))))

;; (deftest external-clojure-repl-is-active
;;   (testing "we can write to a socket"
;;     (is (= true (client/socket)))))

(deftest nrepl-responses
  (testing "we get a response after writing to the nrepl"
    (let [a-socket (client/socket)]
      (client/custom-send a-socket "(def asa 234)")
      ;; (client/test-send socket)
      ;; (client/receive-and-close socket)
      ;; (is (= 2 (count (client/show-logs))))
      )))

