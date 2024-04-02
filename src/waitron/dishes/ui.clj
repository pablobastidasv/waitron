(ns waitron.dishes.ui
  (:require
   [waitron.templates :refer [main-template]]))

(defn- dish-list-item [{:keys [id name]}]
  [:tr
   [:td (take-last 8 (str id))]
   [:td name]])

(defn list-of-dishes [{:keys [dishes]}]
  [:table
   [:thead
    [:tr
     [:td "Id"]
     [:td "Name"]]]
   [:tbody
    (map dish-list-item dishes)]])

(defn home []
  (main-template
   [:h2 "Dishes manager"]
   [:button "Create"]
   [:div {:hx-get "/admin/dishes/list" :hx-trigger "load"}]))


