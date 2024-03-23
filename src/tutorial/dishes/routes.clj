(ns tutorial.dishes.routes 
  (:require
   [compojure.core :refer [GET routes]]
   [tutorial.dishes.handlers :refer [handle-get-dish handle-get-dishes]]))

(def dishes-routes
  (routes
   (GET "/" [] (handle-get-dishes))
   (GET "/:id" [id] (handle-get-dish id))))

