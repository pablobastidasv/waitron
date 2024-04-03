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
   [:button {:hx-get "/admin/dishes/new" :hx-target "#form-panel"} "Create"]
   [:div {:hx-get "/admin/dishes/list" :hx-trigger "load"}]))

(defn create-dish-form []
  [:form {:hx-post "/admin/dishes"}
   [:h3 "Create Dish"]
   [:input {:type "hidden" :value (random-uuid) :name "id"}]
   [:div
    [:label "Name" :for "name"]
    [:input {:autofocus true :name "name"}]]
   [:div
    [:label "Description" :for "description"]
    [:textarea {:name "description"}]]
   [:div
    [:button {:type "submit"} "Save"]]])
