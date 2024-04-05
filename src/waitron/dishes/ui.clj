(ns waitron.dishes.ui
  (:require
   [waitron.templates :refer [main-template]]))

(defn- dish-list-item [{:keys [id name]}]
  [:tr
   [:td (take-last 8 (str id))]
   [:td name]])

(defn list-of-dishes [{:keys [dishes]}]
  [:table {:class "table table-hover"}
   [:thead
    [:tr
     [:td "Id"]
     [:td "Name"]]]
   [:tbody
    (map dish-list-item dishes)]])

(defn home []
  (main-template
   [:h2 "Dishes manager"]
   [:button {:hx-get "/admin/dishes/new" :hx-target "#form-panel" :class "btn btn-primary"} "Create"]
   [:div {:hx-get "/admin/dishes/list" :hx-trigger "load dishesCreated"}]))

(defn create-dish-form []
  [:form {:hx-post "/admin/dishes" :autocomplete "off"}
   [:h3 "Create Dish"]
   [:input {:type "hidden" :value (random-uuid) :name "id"}]
   [:div {:class "mb-3"}
    [:label {:for "name" :class "form-label"}  "Name"]
    [:input {:autofocus true :name "name" :class "form-control"}]]
   [:div
    [:label {:for "description" :class "form-label"} "Description"]
    [:textarea {:name "description" :class "form-control"}]]
   [:div {:class "d-grid gap-2 col-6 mx-auto"}
    [:button {:type "submit" :class "btn btn-primary"} "Save"]]])

(defn  dish-created-correctly-alert [id]
  [:div {:class "alert alert-primary d-flex align-items-center" :role "alert"} 
   [:svg {:class "bi flex-shrink-0 me-2" :width "24" :height "24" :role "img" :aria-label "Info:"}
    [:use {:xlink:href "#info-fill"}]]
   [:div "Dish created correctly. See details "
   [:a {:href (str "/admin/dishes/" id)} "here."]]])
