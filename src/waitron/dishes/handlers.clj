(ns waitron.dishes.handlers
  (:require
   [waitron.database :as db]
   [waitron.dishes.db :refer [read-all-dishes]]
   [waitron.dishes.ui :as ui]
   [waitron.templates :refer [render]]))

(defn handle-get-dishes [{{:strs [limit offset]
                           :or {limit "10", offset "0"}} :query-params}]
  {:status 200
   :body {:dishes (read-all-dishes db/connection limit offset)}})

(defn handle-get-dish [{{:keys [id]} :path-params}]
  {:status 200
   :body {:id id
          :name "shomething else"}})

(defn handle-get-dishes-table [{{:strs [limit offset]
                                 :or {limit "10", offset "0"}} :query-params}]
  (let [dishes (read-all-dishes db/connection limit offset)]
    {:status 200
     :body (render (ui/list-of-dishes {:dishes dishes :limit limit :offset offset}))}))

(defn handle-get-index-page [_]
  {:status 200
   :body (render (ui/home))})
