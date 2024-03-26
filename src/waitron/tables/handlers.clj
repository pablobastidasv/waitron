(ns waitron.tables.handlers)

(defn handle-get-tables [_]
  {:status 200
   :body {:tables [{:id "something"
                    :name "shomething else"}]}})

(defn handle-get-table [_]
  {:status 200
   :body {:id "ID"
          :name "shomething else"}})


