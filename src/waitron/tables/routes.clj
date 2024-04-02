(ns waitron.tables.routes
  (:require
   [waitron.tables.handlers :refer [handle-get-table handle-get-tables]]))

(defn- handler [_]
  {:status 200
   :body "Hello world from tables tmp page"})

(defn apis []
  [["" {:get handle-get-tables}]
   ["/:id" {:get handle-get-table}]])

(defn pages-and-fragments []
  [["" {:get handler}]])
