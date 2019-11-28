(ns adventofcode-2019.day-0
  (:require [adventofcode-2019.util :refer [slurp-input slurp-reference-input]]
            [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :as t]))

(def reference-input (slurp-reference-input))

(def input (slurp-input))

(defn parse-input [in]
  (map edn/read-string in))

(defn part-1-solver [in]
  (reduce + (parse-input in)))

(defn part-2-solver [in]
  (let [changes (parse-input in)]
    (loop [f 0
           fs #{}
           [change & more] (flatten (repeat changes))]
      (if (fs f)
        f
        (recur (+ f change) (conj fs f) more)))))

(t/deftest part-1-test
  (t/is (= 3 (part-1-solver reference-input))))

(t/deftest part-2-test
  (t/is (= 2 (part-2-solver reference-input))))
