(ns waitron.dishes.validations
  (:require
   [struct.core :as st]))

(defn- to-monad [pair]
  {:errors (first pair)
   :data (last pair)})

(defn- validate [value schema]
  (to-monad (st/validate value schema)))

(def dish-schema
  {:id [[st/required :message "dish id is mandatory"]
        [st/uuid-str :message "id format is not valid"]]
   :name [st/required st/string]
   :description [st/required st/string]})

(defn validate-dish [dish]
  (validate dish dish-schema))

