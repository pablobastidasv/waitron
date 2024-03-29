(ns waitron.dishes.db
  (:require [clojure.java.jdbc :as sql]))

(defn read-all-dishes
  ([connection limit offset]
   (let [limit (read-string limit)
         offset (read-string offset)]
     (into [] (sql/query connection ["select * from dishes limit ? offset ?" limit offset])))))

