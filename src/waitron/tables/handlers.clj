(ns waitron.tables.handlers)

(defn handle-get-tables [{{:strs [limit offset] 
                           :or {limit 10, offset 0}} :query-params}]
  {:status 200
   :body {:tables [{:id "something"
                    :name (str "limit: " limit ", offset: " offset)}]}})

(defn handle-get-table [{{:keys [id]} :path-params}]
  {:status 200
   :body {:id id
          :name "shomething else"}})


