(ns tutorial.dishes.handlers
  (:require
   [tutorial.database :as db]
   [tutorial.dishes.db :refer [read-all-dishes]]))

(defn handle-get-dishes [_]
  {:status 200
   :body {:dishes (read-all-dishes db/connection)}})

(defn handle-get-dish [_]
  {:status 200
   :body {:id "any"
          :name "shomething else"}})


