(ns waitron.core
  (:require
   [reitit.ring :as ring]
   [ring.adapter.jetty :as jetty]
   [ring.middleware.params :refer [wrap-params]]
   [waitron.middlewares :refer [ignore-trailing-slash]]
   [waitron.routes :refer [app-routes]])
  (:gen-class))

(def app
  (-> (ring/ring-handler
       (app-routes)
       (ring/create-default-handler))
      (wrap-params)
      (ignore-trailing-slash)))

(defn -main
  [& args]
  (let [port (or (System/getenv "PORT") 8080)]
    (println (str "starting the server in port " port))
    (jetty/run-jetty app
                     {:port port
                      :join? true})))
