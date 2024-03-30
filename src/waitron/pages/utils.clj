(ns waitron.pages.utils 
  (:require
   [hiccup2.core :as h]))

(defn render [content]
  (-> (content)
      (h/html)
      (str)))

(defn respond-with [content]
  {:status 200
   :body (render content)})


