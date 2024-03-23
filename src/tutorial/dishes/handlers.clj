(ns tutorial.dishes.handlers 
  (:require
   [compojure.core :refer [GET routes]]))

(defn- handle-get-dishes []
  {:status 200
   :body {:dishes [{:id "something"
                    :name "shomething else"}]}})

(defn- handle-get-dish [id]
  {:status 200
   :body {:id id
          :name "shomething else"}})

(def dishes-routes
  (routes
   (GET "/" [] (handle-get-dishes))
   (GET "/:id" [id] (handle-get-dish id))))

