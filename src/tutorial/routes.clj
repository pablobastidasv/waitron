(ns tutorial.routes 
  (:require
   [compojure.core :refer [context defroutes]]
   [tutorial.dishes.routes :refer [dishes-routes]]
   [tutorial.tables.routes :refer [table-routes]]))

(defroutes app-routes
  (context "/dishes" [] dishes-routes)
  (context "/tables" [] table-routes))


