(defproject clojure-clojure_cookbook "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [com.github.seancorfield/honeysql "2.4.1002"]
                 [com.github.seancorfield/next.jdbc "1.3.862"]
                 [org.postgresql/postgresql "42.2.10"]]
  :main ^:skip-aot clojure-clojure-cookbook.core
  :target-path "target/%s"
  :plugins [[cider/cider-nrepl "0.28.5"]
            [mx.cider/enrich-classpath "1.9.0"]]
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
