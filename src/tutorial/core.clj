(ns tutorial.core
  (:require
   [reitit.ring :as ring]
   [ring.adapter.jetty :as jetty]
   [ring.middleware.json :refer [wrap-json-response]]
   [tutorial.middlewares :refer [ignore-trailing-slash]]
   [tutorial.routes :refer [app-routes]])
  (:gen-class))

(def app
  (-> (ring/ring-handler app-routes (ring/create-default-handler))
      (ignore-trailing-slash)
      (wrap-json-response)))

(defn -main
  [& args]
  (let [port (or (System/getenv "PORT") 8080)]
    (println (str "starting the server in port " port))
    (jetty/run-jetty app
                     {:port port
                      :join? true})))
