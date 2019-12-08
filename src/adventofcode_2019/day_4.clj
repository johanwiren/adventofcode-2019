(ns adventofcode-2019.day-4
  (:require [adventofcode-2019.util :refer [slurp-input slurp-reference-input]]
            [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :as t]))

(def start 146810)
(def end 612564)

(defn has-adjacent-pair? [password]
  (re-seq #"(.)\1+" password))

(defn is-increasing? [password]
  (apply <= (map (comp edn/read-string str)
                 password)))

(defn matches? [password]
  (when (and (has-adjacent-pair? password)
             (is-increasing? password))
    password))

(defn part-1-solver []
  (->> (range start (inc end))
       (map str)
       (keep matches?)
       count))

(defn part-2-solver []
  )

(comment

  (part-1-solver)

  (part-2-solver input)

  )


