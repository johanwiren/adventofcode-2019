(ns adventofcode-2019.day-2
  (:require [adventofcode-2019.util :refer [slurp-input slurp-reference-input]]
            [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :as t]))

(def reference-input (slurp-reference-input))

(def input (slurp-input))

(defn parse-input [in]
  (->> in first (re-seq #"[0-9]+")
       (mapv edn/read-string)))

(defn part-1-solver [in]
  (loop [ints (-> in
                  parse-input
                  (assoc 1 12
                         2 2))
         ip 0]
    (let [opcode (get ints ip)]
      (if (= 99 opcode)
        (get ints 0)
        (let [p1 (get ints (+ ip 1))
              p2 (get ints (+ ip 2))
              pos (get ints (+ ip 3))
              res (let [v1 (get ints p1)
                        v2 (get ints p2)]
                    (case opcode
                      1 (+ v1 v2)
                      2 (* v1 v2)))]
          (recur (assoc ints pos res)
                 (+ ip 4)))))))

(defn part-2-run-program [program noun verb]
  (loop [ints (-> program
                  parse-input
                  (assoc 1 noun
                         2 verb))
         ip 0]
    (let [instr (subvec ints ip (+ ip 4))
          [opcode ax bx dx] instr]
      (if (= 99 opcode)
        (get ints 0)
        (let [res (let [v1 (get ints ax)
                        v2 (get ints bx)]
                    (case opcode
                      1 (+ v1 v2)
                      2 (* v1 v2)))]
          (recur (assoc ints dx res)
                 (+ ip (count instr))))))))

(defn part-2-solver [in]
  (let [[noun verb]
        (->> (mapcat (fn [x]
                       (map (fn [y] [x y])
                            (range 100)))
                     (range 100))
             (filter (comp #{19690720}
                           (partial apply part-2-run-program in)))
             first)]
    (-> (* 100 noun)
        (+ verb))))

(comment

  (part-1-solver reference-input)

  (part-1-solver input)

  (part-2-solver input)

  )
