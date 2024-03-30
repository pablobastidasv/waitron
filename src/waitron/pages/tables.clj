(ns waitron.pages.tables
  (:require
   [waitron.pages.templates :refer [main-template]]
   [waitron.pages.utils :refer [respond-with]]))

(defn home []
  (main-template
   [:h2 "Tables Manager"]))

(defn home-page
  "Renders the Table manager's Home page"
  [_]
  (respond-with home))



