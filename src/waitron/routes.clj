(ns waitron.routes
  (:require
   [reitit.exception :as exception]
   [reitit.ring :as ring]
   [ring.middleware.json :refer [wrap-json-response]]
   [waitron.dishes.routes :as dishes-routes]
   [waitron.tables.routes :as tables-routes]
   [waitron.uikit :refer [handle-home-page]]))

(defn home-redirect [_]
  {:status 301
   :headers {"Location" "/admin"}})

(defn- print-conflicts [conflicts]
  (println (exception/format-exception :path-conflicts nil conflicts)))

(defn app-routes []
  (ring/router
   [""
    ["/" home-redirect]
    ["/api" {:middleware [wrap-json-response]}
     ["/dishes" (dishes-routes/apis)]
     ["/tables" (tables-routes/apis)]]
    ["/admin"
     ["" handle-home-page]
     ["/dishes" (dishes-routes/pages-and-fragments)]
     ["/tables" (tables-routes/pages-and-fragments)]]]
   {:conflicts print-conflicts}))


