(ns tutorial.dishes.routes
  (:require
   [tutorial.dishes.handlers :refer [handle-get-dish handle-get-dishes]]))

(def dishes-routes
  [["" {:get handle-get-dishes}]
   ["/:id" {:get handle-get-dish}]])

