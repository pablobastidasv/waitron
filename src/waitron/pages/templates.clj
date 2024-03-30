(ns waitron.pages.templates
  (:require
   [waitron.pages.utils :refer [respond-with]]))

(defn style [style]
  [:link {:rel "stylesheet" :href style}])

(defn styles []
  (let [url (list "https://cdn.jsdelivr.net/npm/water.css@2/out/water.css"
                  "/css/styles.css")]
    (map style url)))

(defn head []
  [:head
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
   [:title "Waitron Admin Console"]
   (styles)])

(defn body [& content]
  [:body (list content)])

(defn menu-item [{:keys [label url]}]
  [:li
   [:a {:href url} label]])

(defn menu []
  (let [options (list {:label "Home" :url "/"}
                      {:label "Dishes" :url "/dishes"}
                      {:label "Tables" :url "/tables"})]
    [:nav [:ul (map menu-item options)]]))

(defn header []
  [:h1 "Waitron"])

(defn footer []
  [:h6 "2024 Pablo Bastidas. All rights reserved"])

(defn main-template [& content]
  [:html
   (head)
   (body
    (header)
    (menu)
    content
    (footer))])

(defn home []
  (main-template
   [:h2 "Welcome!!!"]))

(defn home-page
  "Renders the Welcome's Home page"
  [_] ;; Request
  (respond-with home))


