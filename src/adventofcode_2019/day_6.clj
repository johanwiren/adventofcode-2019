(ns adventofcode-2019.day-6
  (:require [adventofcode-2019.util :refer [slurp-input slurp-reference-input]]
            [clojure.edn :as edn]
            [clojure.set :as set]
            [clojure.string :as str]
            [clojure.test :as t]))

(def reference-input (slurp-reference-input))

(def input (slurp-input))

(defn parse-input [in]
  (into {}
        (comp (map #(str/split % #"\)"))
              (map (partial map keyword))
              (map (comp vec reverse)))
        in))

(defn orbits [obj deps]
  (loop [orbits []
         obj obj]
    (if-let [o (get deps obj)]
      (recur (conj orbits o) o)
      orbits)))

(defn ->orbits [deps]
  (reduce-kv (fn [acc obj orbit]
               (assoc acc obj (orbits obj deps)))
             {}
             deps))

(defn part-1-solver [in]
  (->> in
       parse-input
       ->orbits
       vals
       flatten
       count))

(defn part-2-solver [in]
  (-> in
      parse-input))

(comment

  (->> reference-input
       parse-input
       ->orbits)

  (parse-input input)

  (part-1-solver input)

  (part-2-solver input)

  )

(t/deftest part-1-test
  (t/is (= 42 (part-1-solver reference-input))))

(t/deftest part-2-test
  (t/is (= 4 (part-2-solver reference-input))))
