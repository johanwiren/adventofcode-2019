(ns adventofcode-2019.template
  (:require [adventofcode-2019.util :refer [slurp-input slurp-reference-input]]
            [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :as t]))

(def reference-input (slurp-reference-input))

(def input (slurp-input))

(defn parse-input [in]
  in)

(defn part-1-solver [in]
  in)

(defn part-2-solver [in]
  in)

(comment

  (part-1-solver input)

  (part-2-solver input)

  )

(t/deftest part-1-test
  (t/is (= :FIXME (part-1-solver reference-input))))

(t/deftest part-2-test
  (t/is (= :FIXME (part-2-solver reference-input))))
