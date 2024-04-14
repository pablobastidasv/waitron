(ns waitron.dishes.routes
  (:require
   [ring.middleware.json :refer [wrap-json-body]]
   [waitron.dishes.handlers :as handlers]))

(defn apis []
  [["" {:get handlers/handle-get-dishes}]
   ["/:id" {:get handlers/handle-get-dish}]])

(defn pages-and-fragments []
  [["" {:get handlers/handle-get-index-page
        :post handlers/handle-post-dishes :middleware [wrap-json-body]}]
   ["/list" {:get handlers/handle-get-dishes-table}]
   ["/new" {:get handlers/handle-get-new-dish}]
   ["/:id" {:get handlers/handle-get-dish-by-id-page}]])

