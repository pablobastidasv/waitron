(ns waitron.dishes.ui
  (:require
   [clojure.string :as string]
   [waitron.uikit :refer [info-alert input main-template textarea]]))

(defn- dish-list-item [{:keys [id name]}]
  [:tr {:hx-on:click  (str "window.location.href = '/admin/dishes/" id "';") :style "cursor: pointer"}
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

(defn- random-name []
  (apply str (repeatedly 10 #(rand-nth "abcdefghijklmnopqrstuvwxyz0123456789"))))

(defn- input-classes
  "Define the classes to apply to the input element based on the given data"
  [{:keys [readonly error]}]
  (string/join " " ["form-control" (cond error "is-invalid") (cond readonly "form-control-plaintext")]))

(defn another-input [{:keys [error data label readonly autofocus]}]
  (let [name (random-name)
        classes (input-classes {:error error :readonly readonly})]
    [:div  {:class "mb-3 row"}
     [:label {:for name :class "col-sm-2 col-form-label"}  label]
     [:div {:class "col-sm-10"}
      [:input {:autofocus (boolean autofocus) :name name :value data  :readonly (boolean readonly) :class classes}]
      (cond error
            [:div {:class "invalid-feedback"} error])]]))

(defn another-textarea [{:keys [error data label readonly autofocus]}]
  (let [name (random-name)
        classes (input-classes {:error error :readonly readonly})]
    [:div  {:class "mb-3 row"}
     [:label {:for name :class "col-sm-2 col-form-label"}  label]
     [:div {:class "col-sm-10"}
      [:textarea {:autofocus (boolean autofocus) :name name  :readonly (boolean readonly) :class classes} data]
      (cond error
            [:div {:class "invalid-feedback"} error])]]))

(defn dish-detail-page [{:keys [id name description]}]
  (main-template
   [:h2 (str "Dish details")]
   (another-input {:readonly true :data id :label "Id"})
   (another-input {:readonly true :data name :label "Name"})
   (another-textarea {:readonly true :data description :label "Description"})))




