# verbalexpressions

Clojure implementation of @jehna's Verbal Expression.

## Usage

(def valid-url? (verbal-expression start-of-line
                                   (then "http")
                                   (maybe "s")
                                   (then "://")
                                   (maybe "www.")
                                   (anything-but " ")
                                   end-of-line))

(valid-url? "http://www.google.com")

## License

Copyright © 2013

Distributed under the Eclipse Public License, the same as Clojure.
