(defproject tutorial "0.1.0-SNAPSHOT"
  :description "A demo API to learn how to make one using clojure"

  :url "https://pablobastidasv.co"

  :license {:name "MIT"
            :url "https://opensource.org/license/mit"}

  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-core "1.12.0"]
                 [ring/ring-jetty-adapter "1.12.0"]
                 [ring/ring-defaults "0.4.0"]
                 [ring/ring-json "0.5.1"]
                 [compojure "1.7.1"]]

  :main ^:skip-aot tutorial.core

  :target-path "target/%s"

  :plugins [[lein2-eclipse "2.0.0"]
            [lein-ring "0.12.6"]]

  :ring {:handler tutorial.core/app}

  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
