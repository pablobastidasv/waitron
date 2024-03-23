(ns tutorial.tables.routes 
  (:require
   [compojure.core :refer [GET routes]]
   [tutorial.tables.handlers :refer [handle-get-table handle-get-tables]]))

(def table-routes
  (routes
   (GET "/" [] (handle-get-tables))
   (GET "/:id" [id] (handle-get-table id))))


