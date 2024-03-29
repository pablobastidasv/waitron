(ns waitron.routes
  (:require
   [reitit.ring :as ring]
   [ring.middleware.json :refer [wrap-json-response]]
   [waitron.dishes.routes :refer [dishes-routes]]
   [waitron.tables.routes :refer [table-routes]]))

(defn app-routes []
  (ring/router
   [["/api" {:middleware [wrap-json-response]}
     ["/dishes" (dishes-routes)]
     ["/tables" (table-routes)]]]))

