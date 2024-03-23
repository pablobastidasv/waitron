(ns tutorial.dishes.handlers)

(defn handle-get-dishes []
  {:status 200
   :body {:dishes [{:id "something"
                    :name "shomething else"}]}})

(defn handle-get-dish [id]
  {:status 200
   :body {:id id
          :name "shomething else"}})


