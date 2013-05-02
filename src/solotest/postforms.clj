(ns solotest.postforms
  (:require [solotest.layouts :as layouts]
            [ring.util.response :as response])
  (:use hiccup.core
        hiccup.page
        hiccup.form
        ))

(defn post-name-and-contact [first-name mn ln ph ph2 email str apt city st zip]
  (response/redirect "/name-and-contact"))
