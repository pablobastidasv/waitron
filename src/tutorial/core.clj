(ns tutorial.core
  (:require
   [compojure.core :refer [context defroutes]]
   [ring.adapter.jetty :as jetty]
   [ring.middleware.json :refer [wrap-json-response]]
   [tutorial.dishes.handlers :refer [dishes-routes]]
   [tutorial.middlewares :refer [ignore-trailing-slash]]
   [tutorial.tables.handlers :refer [table-routes]])
  (:gen-class))

(defroutes my-routes
  (context "/dishes" [] dishes-routes)
  (context "/tables" [] table-routes))

(def app
  (-> my-routes
      (ignore-trailing-slash)
      (wrap-json-response)))

(def port 8080)

(defn -main
  [& args]
  (println (str "starting the server in port " port))
  (jetty/run-jetty app
                   {:port port
                    :join? true}))
