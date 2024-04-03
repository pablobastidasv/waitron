(ns waitron.dishes.handlers
  (:require
   [waitron.database :refer [connection]]
   [waitron.dishes.db :as data]
   [waitron.dishes.ui :as ui]
   [waitron.templates :refer [render]]))

(defn handle-get-dishes [{{:strs [limit offset]
                           :or {limit "10", offset "0"}} :query-params}]
  {:status 200
   :body {:dishes (data/read-all-dishes connection limit offset)}})

(defn handle-get-dish [{{:keys [id]} :path-params}]
  {:status 200
   :body {:id id
          :name "shomething else"}})

(defn handle-get-dishes-table [{{:strs [limit offset]
                                 :or {limit "10", offset "0"}} :query-params}]
  (let [dishes (data/read-all-dishes connection limit offset)]
    {:status 200
     :body (render (ui/list-of-dishes {:dishes dishes :limit limit :offset offset}))}))

(defn handle-get-index-page [_]
  {:status 200
   :body (render (ui/home))})

(defn handle-get-new-dish [_]
  {:status 200
   :headers {"Hx-Trigger" "toggleFormPanel"}
   :body (render (ui/create-dish-form))})

(defn handle-post-dishes [{{:strs [id name description]} :form-params}]
  (data/insert-a-new-dish connection {:id id :name name :description description})
  {:status 200})
