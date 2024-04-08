(ns waitron.dishes.db
  (:require [clojure.java.jdbc :as sql]))

(defn read-all-dishes
  [connection limit offset]
  (let [limit (read-string limit)
        offset (read-string offset)]
    (into [] (sql/query connection ["select id, name from dishes limit ? offset ?" limit offset]))))

(defn insert-a-new-dish
  [connection {:keys [id name description]}]
  (sql/insert! connection :dishes [:id :name :description] [id name description]))

