(ns verbalexpressions.core)

(defn start-of-line [] "^")

(defn then [value]
  (fn [] value))

(defn maybe [value]
  (fn [] (str "(" value ")?")))

(defn anything-but [value]
  (fn [] (str "[^" value "]+")))

(defn end-of-line [] "$")

(defn- translate-to-regex [expr]
  (loop [result ""
         list expr]
    (if (empty? list)
        result
        (recur (str result ((first list)))
               (rest list)))))

(defn verbal-expression [& expr]
  (let [expression (translate-to-regex expr)
        regex      (re-pattern expression)]
    (println expression)
    (fn [x] (not (empty? (re-seq regex x))))))