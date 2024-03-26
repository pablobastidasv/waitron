(ns waitron.tables.routes 
  (:require
   [waitron.tables.handlers :refer [handle-get-table handle-get-tables]]))

(def table-routes
  [["" {:get handle-get-tables}]
   ["/:id" {:get handle-get-table}]])


