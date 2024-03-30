(ns waitron.pages.routes
  (:require
   [waitron.pages.dishes :as dishes]
   [waitron.pages.tables :as tables]
   [waitron.pages.templates :as welcome]))

(defn pages-routes []
  [["/" welcome/home-page]
   ["/tables" tables/home-page]
   ["/dishes"
    ["" dishes/home-page]
    ["/list" dishes/dishes-list-fragment]
    ]])

