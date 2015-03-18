;; arrays / lists

(def my-list (list 1 2 3 4 5))

my-list 

(first my-list) ; returns the first element of the array
(nth my-list 3) ; returns the 0-index element of the array

(conj my-list 100) ; adds 100 to my-list

my-list ; but note: my-list does not change

;; in order to add 100, you must define a new array
(def my-new-list (conj my-list 100)) 
my-new-list

;; same story for vectors
(def my-vector [1 2 3 4 5 6])
(conj my-vector 300)

;; guessing a number

(def target (inc (rand-int 10))

(loop [n 0] 
	(print ln "Guess a number between 1 and 15:")
	(let [guess (read)]
		(if (= guess target)
			(printf "Correct! \n" n)
			(do
				(println "Nope. Try again!")
				(recur (inc n))))))

;; swapping

;; define a and b

(defn swap [pair] (reverse pair))
(defn swap [[a b]] '(b a))
(defn swap [[a b]] [b a])

;; anagrams
(require '[clojure.java.io :as io])

(def groups
	(with-open [r (io/reader wordfile)]
		(group-by sort (line-seq r))))

(let [wordlists (sort-by (comp - count) (vals groups))
	maxlength (count (first wordlists))]
	(doseq [wordlist (take-while #(= (count %) maxlength) wordlists)]
		(println wordlist))
