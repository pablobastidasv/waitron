(ns tutorial.tables.handlers
  (:require
   [compojure.core :refer [GET routes]]))

(defn handle-get-tables []
  {:status 200
   :body {:tables [{:id "something"
                    :name "shomething else"}]}})

(defn handle-get-table [id]
  {:status 200
   :body {:id id
          :name "shomething else"}})

(def table-routes
  (routes
   (GET "/" [] (handle-get-tables))
   (GET "/:id" [id] (handle-get-table id))))


