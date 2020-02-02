(defn balanced? [s]
  (letfn [(cnt [c] (count (filter #(= c %) s)))]
    (= (cnt \() (cnt \)))))

(defn right? [s]
  (zero?
   (reduce (fn [open c] ((cond
                           (neg? open) identity
                           (= c \()    inc
                           (= c \))    dec) open))
           0 s)))

(defn split [s]
  (loop [u (vector (first s))
         v (rest s)]
    (if (balanced? u)
      [(apply str u) (apply str v)]
      (recur (conj u (first v)) (rest v)))))

(defn trim-reverse [s]
  (apply str
         (map #(if (= % \() \) \()
              (rest (drop-last s)))))

(defn correct [s]
  (if (right? s)
    s
    (let [[u v] (split s)]
      (if (right? u)
        (str u (correct v))
        (str "(" (correct v) ")" (trim-reverse u))))))
