(ns verbalexpressions.core-test
  (:require [clojure.test :refer :all]
            [verbalexpressions.core :refer :all]))

(deftest a-test
  (testing "A simple URL"
    (let [valid? (verbal-expression start-of-line
                                    (then "http")
                                    (maybe "s"))
;                                    (then "://")
;                                    (maybe "www.")
;                                    (anything-but " ")
;                                    end-of-line)
          url  "http://www.google.com"
          urls "https://www.google.com"]
    (is (valid? url))
    (is (valid? urls)))))