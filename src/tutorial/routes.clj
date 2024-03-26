(ns tutorial.routes
  (:require
   [reitit.ring :as ring]
   [tutorial.dishes.routes :refer [dishes-routes]]
   [tutorial.tables.routes :refer [table-routes]]))

(def app-routes
  (ring/router
   [["/dishes" dishes-routes]
    ["/tables" table-routes]]))

