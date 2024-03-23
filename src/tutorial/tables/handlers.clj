(ns tutorial.tables.handlers)

(defn handle-get-tables []
  {:status 200
   :body {:tables [{:id "something"
                    :name "shomething else"}]}})

(defn handle-get-table [id]
  {:status 200
   :body {:id id
          :name "shomething else"}})


