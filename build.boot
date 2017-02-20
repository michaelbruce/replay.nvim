(set-env!
  :source-paths #{"src" "test"}
  :dependencies '[[org.clojure/clojure "1.8.0"]
                  [org.clojure/clojurescript "1.9.473"]
                  [adzerk/boot-cljs "1.7.228-2" :scope "test"]
                  [crisptrutski/boot-cljs-test "0.2.2-SNAPSHOT" :scope "test"]])

(require '[adzerk.boot-cljs :refer [cljs]])

(deftask build []
  (comp (cljs :optimizations :simple)
        (sift :include #{#"replay.js"})
        (target :dir #{"rplugin/node"})))
