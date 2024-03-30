(ns waitron.pages.dishes
  (:require
   [waitron.pages.templates :refer [main-template]]
   [waitron.pages.utils :refer [render respond-with]]))

(defn list-of-dishes [{:keys [limit offset]}]
  [:table
   [:thead
    [:tr
     [:td "Id"]
     [:td "Name"]]]])

(defn home []
  (main-template
   [:h2 "Dishes manager"]
   [:button "Create"]
   [:div {:hx-get "/dishes/list" :hx-trigger "load"}]))

;; Pages or fragments
(defn dishes-list-fragment [{{:strs [limit offset]
                              :or {limit 10, offset 0}} :query-params}]
  {:status 200
   :body (render (list-of-dishes {:limit limit :offset offset}))})

(defn home-page
  "Renders the Dishes manager's Home page"
  [_]
  (respond-with home))


