(set-env!
  :source-paths #{"src" "test"}
  :dependencies '[[org.clojure/clojure "1.8.0"]
                  [org.clojure/clojurescript "1.9.473"]
                  [adzerk/boot-cljs "1.7.228-2" :scope "test"]
                  [crisptrutski/boot-cljs-test "0.2.2-SNAPSHOT" :scope "test"]
                  [adzerk/boot-cljs-repl   "0.3.3"] ;; latest release
                  [com.cemerick/piggieback "0.2.1"  :scope "test"]
                  [weasel                  "0.7.0"  :scope "test"]
                  [org.clojure/tools.nrepl "0.2.12" :scope "test"]])

(require '[adzerk.boot-cljs :refer [cljs]])

(deftask build []
  (comp (cljs :optimizations :simple)
        ;; XXX temporary disabled whilst using npm modules
        ;; (sift :include #{#"(replay.js"})
        (target :dir #{"rplugin/node"})))

(require '[crisptrutski.boot-cljs-test :refer [test-cljs]])

(deftask spec []
  (test-cljs :js-env :node))

;; either cljs repl or hotreload/figwheel would be nice.
;; (require '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]])
;; 
;; (deftask dev []
;;   (comp (watch)
;;         (cljs-repl) ; order is important!!
;;         (cljs)))
