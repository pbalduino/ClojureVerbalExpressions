(ns verbal-expressions.core-test
  (:require [clojure.test :refer :all]
            [verbal-expressions.core :refer :all]))

(def valid-url? (verbal-expression start-of-line
                                   (then "http")
                                   (maybe "s")
                                   (then "://")
                                   (maybe "www.")
                                   (anything-but " ")
                                   end-of-line))
(defn is-not [x] (is (not x)))

(deftest a-test
  (testing "valid URLs"
    (is (valid-url? "http://www.google.com"))
    (is (valid-url? "https://www.google.com")))

   (testing "invalid URLs"
    (is (not (valid-url? "ftp://www.google.com")))
    (is (not (valid-url? "ftps://www.google.com")))
    (is (not (valid-url? "foo http://www.google.com")))
    (is (not (valid-url? "meh")))
    (is (not (valid-url? "http://www.google. com")))))