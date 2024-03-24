(ns tutorial.dishes.db
  (:require [clojure.java.jdbc :as sql]))

(defn read-all-dishes
  ([connection] (read-all-dishes connection 10 0))
  ([connection limit offset] (into [] (sql/query connection ["select * from dishes limit ? offset ?" limit offset]))))

