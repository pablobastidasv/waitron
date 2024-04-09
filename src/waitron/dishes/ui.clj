(ns waitron.dishes.ui
  (:require
   [waitron.uikit :refer [info-alert main-template input textarea]]))

(defn- dish-list-item [{:keys [id name]}]
  [:tr
   [:td (take-last 8 (str id))]
   [:td name]])

(defn list-of-dishes [{:keys [dishes]}]
  [:table {:class "table table-hover"}
   [:thead
    [:tr
     [:th "Id"]
     [:th "Name"]]]
   [:tbody {:class "table-group-divider"}
    (map dish-list-item dishes)]])

(defn home []
  (main-template
   [:h2 "Dishes manager"]
   [:button {:hx-get "/admin/dishes/new" :hx-target "#form-panel" :class "btn btn-primary"} "Create"]
   [:div {:hx-get "/admin/dishes/list" :hx-trigger "load, dishCreated from:body"}]))

(defn create-dish-form
  ([] (create-dish-form nil))
  ([{:keys [data errors]}]
   [:form {:hx-post "/admin/dishes" :hx-swap "outerHTML" :autocomplete "off"}
    [:h3 "Create Dish"]
    [:input {:type "hidden" :value (random-uuid) :name "id"}]
    (let [name (:name data)
          error (:name errors)]
      (input name error))
    (let [description (:description data)
          error (:description errors)]
      (textarea description error))
    [:div {:class "d-grid gap-2 col-6 mx-auto"}
     [:button {:type "submit" :class "btn btn-primary"} "Save"]]]))

(defn  dish-created-correctly-alert [id]
  (info-alert [:span "Dish created correctly. See details "
               [:a {:href (str "/admin/dishes/" id)} "here."]]))


