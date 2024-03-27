(ns waitron.routes
  (:require
   [reitit.ring :as ring]
   [waitron.dishes.routes :refer [dishes-routes]]
   [waitron.tables.routes :refer [table-routes]]))

(defn app-routes []
  (ring/router
   [["/api"
     ["/dishes" (dishes-routes)]
     ["/tables" (table-routes)]]]))

