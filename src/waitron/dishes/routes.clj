(ns waitron.dishes.routes
  (:require
   [waitron.dishes.handlers :refer [handle-get-dish handle-get-dishes]]))

(def dishes-routes
  [["" {:get handle-get-dishes}]
   ["/:id" {:get handle-get-dish}]])

