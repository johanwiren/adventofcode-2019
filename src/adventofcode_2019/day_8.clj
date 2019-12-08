(ns adventofcode-2019.day-8
  (:require [adventofcode-2019.util :refer [slurp-input slurp-reference-input]]
            [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :as t]))

(def reference-input (slurp-reference-input))

(def input (slurp-input))

(defn parse-input [in]
  (->> in
       first
       (re-seq #"[0-9]")
       (map edn/read-string)))

(defn get-digits [layer digit]
  (->> layer
       flatten
       (filter (partial #{digit}))))

(defn part-1-solver [in width height]
  (let [layer (->> in
                   parse-input
                   (partition width)
                   (partition height)
                   (sort-by (comp count #(get-digits % 0)))
                   first)
        one-digits (count (get-digits layer 1))
        two-digits (count (get-digits layer 2))]
    (* one-digits two-digits)))

(defn part-2-solver [in]
  in)

(comment

  (part-1-solver input 25 6)

  (part-2-solver input)

  )

(t/deftest part-1-test
  (t/is (= 1 (part-1-solver reference-input 3 2))))

(t/deftest part-2-test
  (t/is (= :FIXME (part-2-solver reference-input))))
