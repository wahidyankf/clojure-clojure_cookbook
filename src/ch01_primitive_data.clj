(ns ch01-primitive-data
  (:require [clojure.string :as str]))

(str/blank? "")
;; => true

(str/upper-case "an uppercase")
;; => "AN UPPERCASE"

(str/trim " \tBacon ipsum dolor sit.\n")
;; => "Bacon ipsum dolor sit."

(str/replace "Who\t\nput  all this\fwhitespace here?" #"\s+" " ")
;; => "Who put all this whitespace here?"

(seq "Hello, world!")
;; => (\H \e \l \l \o \, \space \w \o \r \l \d \!)

(map str (vec "Hello, world!"))
;; => ("H" "e" "l" "l" "o" "," " " "w" "o" "r" "l" "d" "!")

(frequencies "Hello world")
;; => {\H 1, \e 1, \l 3, \o 2, \space 1, \w 1, \r 1, \d 1}

(frequencies (map str (vec "Hello world")))
;; => {"H" 1, "e" 1, "l" 3, "o" 2, " " 1, "w" 1, "r" 1, "d" 1}

(apply str (seq "Hello world!"))
;; => "Hello world!"

((fn [name i] (format "%03d-%s" i name)) "my-awesome-file.txt" 42)
;; => "042-my-awesome-file.txt"

;; Create a table using justification
(defn tableify [row]
  (apply format "%-20s | %-20s | %-20s" row)) ; 2

(->> (concat [["First Name" "Last Name" "Employee ID"]]
             [["Ryan" "Neufeld" 2] ["Luke" "Vanderhart" 1]])
     (map tableify)
     (mapv println))
;; => [nil nil nil]
