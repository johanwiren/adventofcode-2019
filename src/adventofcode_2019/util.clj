(ns adventofcode-2019.util
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(defmacro slurp-input []
  `(-> *ns*
       str
       (clojure.string/split #"\.")
       last
       clojure.java.io/resource
       clojure.java.io/reader
       line-seq))
