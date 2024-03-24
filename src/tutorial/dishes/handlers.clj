(ns tutorial.dishes.handlers 
  (:require
   [tutorial.database :as db]
   [tutorial.dishes.db :refer [read-all-dishes]]))

(defn handle-get-dishes []
  {:status 200
   :body {:dishes (read-all-dishes db/connection)}})

(defn handle-get-dish [id]
  {:status 200
   :body {:id id
          :name "shomething else"}})


