(ns waitron.routes
  (:require
   [reitit.ring :as ring]
   [waitron.dishes.routes :refer [dishes-routes]]
   [waitron.tables.routes :refer [table-routes]]))

(def app-routes
  (ring/router
   [["/dishes" dishes-routes]
    ["/tables" table-routes]]))

