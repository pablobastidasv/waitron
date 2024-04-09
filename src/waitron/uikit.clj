(ns waitron.uikit
  (:require
   [hiccup2.core :as h]))

(defn- style [style]
  [:link {:rel "stylesheet" :href style}])

(def head-scripts
  '([:script {:src "https://unpkg.com/htmx.org@1.9.11"}]
    [:script {:src "https://unpkg.com/side-drawer/side-drawer.min.js" :type "module"}]
    [:script {:src "/js/scripts.js"}]))

(def foot-scripts
  [:script {:src "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"}])

(defn- styles []
  (let [url (list
             "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
             "/css/styles.css")]
    (map style url)))

(defn- head []
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
   [:title "Waitron Admin Console"]
   (styles)
   head-scripts])

(defn- body [& content]
  [:body {:class "container" :data-bs-theme "dark"}
   content])

(defn- menu-item [{:keys [label url]}]
  [:li
   [:a {:href url} label]])

(defn- menu []
  (let [options (list {:label "Home" :url "/"}
                      {:label "Dishes" :url "/admin/dishes"}
                      {:label "Tables" :url "/admin/tables"})]
    [:nav [:ul (map menu-item options)]]))

(defn- header []
  [:h1 "Waitron"])

(defn- side-drawer []
  [:side-drawer {:id "form-panel" :right "true"}])

(defn- footer []
  [:h6 "2024 Pablo Bastidas."]
  foot-scripts)

(defn- alert-icons []
  [:svg {:xmlns "http://www.w3.org/2000/svg", :class "d-none"}
   [:symbol {:id "check-circle-fill", :viewbox "0 0 16 16"}
    [:path {:d "M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"}]]
   [:symbol {:id "info-fill", :viewbox "0 0 16 16"}
    [:path {:d "M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"}]]
   [:symbol {:id "exclamation-triangle-fill", :viewbox "0 0 16 16"}
    [:path {:d "M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"}]]])

(defn- messages-container []
  [:div
   [:div#messages-container {:class "my-2"}]
   (alert-icons)])

(defn info-alert [message]
  [:div {:class "alert alert-success alert-dismissible fade show", :role "alert"}
   [:svg {:class "bi flex-shrink-0 me-2" :width "24" :height "24" :role "img", :aria-label "Success:"}
    [:use {:xlink:href "#check-circle-fill"}]]
   message
   [:button {:type "button", :class "btn-close", :data-bs-dismiss "alert", :aria-label "Close"}]])

;; UI components

(defn input [data error]
  [:div {:class "mb-3"}
   [:label {:for "name" :class "form-label"}  "Name"]
   [:input {:autofocus true :name "name" :value data
            :class (str "form-control" " " (cond error "is-invalid"))}]
   (cond error
         [:div {:class "invalid-feedback"} error])])

(defn textarea [data error]
  [:div
   [:label {:for "description" :class "form-label"} "Description"]
   (let [class (str "form-control" " " (cond error "is-invalid"))]
     [:textarea {:name "description" :class class} data])
   (cond error
         [:div {:class "invalid-feedback"} error])])

;; Page templates

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

