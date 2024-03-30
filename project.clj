(defproject waitron "0.1.0-SNAPSHOT"
  :description "A demo API to learn how to make one using clojure"

  :url "https://pablobastidasv.co"

  :license {:name "MIT"
            :url "https://opensource.org/license/mit"}

  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [org.postgresql/postgresql "42.7.3"]
                 [org.slf4j/slf4j-simple "2.0.12"]
                 [hiccup "2.0.0-RC3"]
                 [ring/ring-core "1.12.0"]
                 [ring/ring-jetty-adapter "1.12.0"]
                 [ring/ring-json "0.5.1"]
                 [metosin/reitit-ring "0.6.0"]]

  :main ^:skip-aot waitron.core

  :target-path "target/%s"

  :plugins [[lein2-eclipse "2.0.0"]
            [lein-ring "0.12.6"]]

  :ring {:handler waitron.core/app}

  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
