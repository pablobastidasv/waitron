(ns waitron.pages.dishes
  (:require
   [waitron.pages.templates :refer [main-template]]
   [waitron.pages.utils :refer [respond-with]]))

(defn home []
  (main-template
   [:h2 "Dishes manager"]))

(defn home-page 
  "Renders the Dishes manager's Home page"
  [_]
  (respond-with home))


