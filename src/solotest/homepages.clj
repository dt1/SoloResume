(ns solotest.homepages
  (:require [solotest.layouts :as layouts]
            [solotest.articles :as articles]
            [solotest.useraccts :as accts])
  (:use hiccup.core
        hiccup.page))


(defn home-page []
  (layouts/home-heads
   (articles/front-page)))

(defn job-page []
  (layouts/home-heads
   (articles/find-a-job)))

(defn company-page []
  (layouts/home-heads
   [:p "welcome"]))

(defn login-page []
  (layouts/home-heads
   (accts/login)))

(defn reg-page []
  (layouts/home-heads
   (accts/registration)))
