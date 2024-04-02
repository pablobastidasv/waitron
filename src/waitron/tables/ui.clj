(ns waitron.tables.ui
  (:require
   [waitron.templates :refer [main-template]]))

(defn home []
  (main-template
   [:h2 "Tables Manager"]))

