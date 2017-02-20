(set-env!
  :source-paths #{"src" "test"}
  :dependencies '[[org.clojure/clojure "1.8.0"]
                  [org.clojure/clojurescript "1.9.473"]
                  [adzerk/boot-cljs "1.7.228-2" :scope "test"]
                  [crisptrutski/boot-cljs-test "0.2.2-SNAPSHOT" :scope "test"]
                  ])

;; (require '[degree9.boot-npm :refer :all])
(require '[adzerk.boot-cljs :refer [cljs]])

(deftask build []
  (cljs :optimizations :advanced
        :compiler-options
        {:main replay.repl
         :asset-path "rplugin/node/replay/out"
         :target :nodejs
         :output-to "rplugin/node/replay.js"}))
