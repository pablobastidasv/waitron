(ns waitron.dishes.handlers
  (:require
   [waitron.database :as db]
   [waitron.dishes.db :refer [read-all-dishes]]))

(defn handle-get-dishes [{{:strs [limit offset]
                           :or {limit "10", offset "0"}} :query-params}]
  {:status 200
   :body {:dishes (read-all-dishes db/connection limit offset)}})

(defn handle-get-dish [{{:keys [id]} :path-params}]
  {:status 200
   :body {:id id
          :name "shomething else"}})

