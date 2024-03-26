(ns waitron.fundamentals
  (:require [clojure.string :as string]))

(println "Hello"
         (+ 2 3))

\H \r \space
[1 2 3]
'(1 2 3)

(println (string/upper-case "Hello"))

(def ^:private y (+ 5 6))
(def x (+ 5 6))

(def person {:name "pepe"
             :age 17})

(println person)

(defn palindrome? [word]
  (let [lower-case (string/lower-case word)
        reverse (string/reverse lower-case)]
    (= reverse lower-case)))

(palindrome? "kajak")
(+ 4 6 5)

;;
(defn transform [person]
      (update (assoc person :hair-color :gray) :age inc))

(transform {:name "Socrates", :age 39})

(defn transform* [person]
  (-> person
      (assoc :hair-color :gray)
      (update :age inc)))

(transform* {:name "Socrates", :age 39})

(defn calculate* []
  (->> (range 10)
      (filter odd? ,,,)
      (map #(* % %) ,,,)
      (reduce + ,,,) ))
(calculate*)


(defn calculate []
  (->> (range (+ 5 5))
       (filter odd?)
       (map #(* % %))
       (reduce +)))
(calculate)

(as-> [:fua :bar] v
  (map name v) 
  (first v)
  (.substring v 1))
