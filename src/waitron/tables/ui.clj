(ns waitron.tables.ui
  (:require
   [waitron.uikit :refer [main-template]]))

(defn home []
  (main-template
   [:h2 "Tables Manager"]))

