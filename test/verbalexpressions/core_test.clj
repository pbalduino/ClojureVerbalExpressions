(ns verbalexpressions.core-test
  (:require [clojure.test :refer :all]
            [verbalexpressions.core :refer :all]))

(def valid-url? (verbal-expression start-of-line
                                   (then "http")
                                   (maybe "s")
                                   (then "://")
                                   (maybe "www.")
                                   (anything-but " ")
                                   end-of-line))
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