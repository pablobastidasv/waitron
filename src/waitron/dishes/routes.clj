(ns waitron.dishes.routes
  (:require
   [waitron.dishes.handlers :as handlers]))

(defn apis []
  [["" {:get handlers/handle-get-dishes}]
   ["/:id" {:get handlers/handle-get-dish}]])

(defn pages-and-fragments []
  [["" handlers/handle-get-index-page]
   ["/list" handlers/handle-get-dishes-table]])

