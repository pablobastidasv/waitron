(ns waitron.templates
  (:require
   [hiccup2.core :as h]))

(defn style [style]
  [:link {:rel "stylesheet" :href style}])

(def scripts
  '([:script {:src "https://unpkg.com/htmx.org@1.9.11"}]
    [:script {:src "https://unpkg.com/side-drawer/side-drawer.min.js" :type "module"}]
    [:script {:src "/js/scripts.js"}]))

(defn styles []
  (let [url (list
             "https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
             "/css/styles.css")]
    (map style url)))

(defn head []
  [:head
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
   [:title "Waitron Admin Console"]
   (styles)
   scripts])

(defn body [& content]
  [:body {:class "container"} (list content)])

(defn menu-item [{:keys [label url]}]
  [:li
   [:a {:href url} label]])

(defn menu []
  (let [options (list {:label "Home" :url "/"}
                      {:label "Dishes" :url "/admin/dishes"}
                      {:label "Tables" :url "/admin/tables"})]
    [:nav [:ul (map menu-item options)]]))

(defn header []
  [:h1 "Waitron"])

(defn side-drawer []
  [:side-drawer {:id "form-panel" :right "true"}])

(defn footer []
  [:h6 "2024 Pablo Bastidas."])

(defn messages-container []
  [:div#messages-container])

(defn main-template [& content]
  [:html
   (head)
   (body
    (header)
    (menu)
    (messages-container)
    content
    (side-drawer)
    (footer))])

(defn home []
  (main-template
   [:h2 "Welcome!!!"]))

(defn render [content]
  (-> content
      (h/html)
      (str)))

(defn handle-home-page
  "Renders the Welcome's Home page"
  [_] ;; Request
  {:status 200
   :body (render (home))})

