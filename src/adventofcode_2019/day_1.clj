(ns adventofcode-2019.day-1
  (:require [adventofcode-2019.util :refer [slurp-input slurp-reference-input]]
            [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :as t]))

(def reference-input (slurp-reference-input))

(def input (slurp-input))

(defn parse-input [in]
  (map edn/read-string in))

(defn fuel-requirement [mass]
  (let [fuel (-> mass
                 (quot 3)
                 (- 2))]
    (if (pos? fuel)
      fuel
      0)))

(defn part-1-solver [in]
  (transduce (map fuel-requirement)
             +
             (parse-input in)))

(defn total-fuel-requirement [mass]
  (loop [total-fuel 0
         mass mass]
    (if (pos? mass)
      (let [fuel (fuel-requirement mass)]
        (recur (+ total-fuel fuel) fuel))
      total-fuel)))

(defn part-2-solver [in]
  (transduce (map total-fuel-requirement)
             +
             (parse-input in)))

(comment

  (part-1-solver input)

  (part-2-solver input)

  )

(t/deftest part-1-test
  (t/is (= 33583 (part-1-solver reference-input))))

(t/deftest part-2-test
  (t/is (= 50346 (part-2-solver reference-input))))
