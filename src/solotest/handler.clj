(ns solotest.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [solotest.homepages :as homes]
            [solotest.getforms :as get-forms]
            [solotest.postforms :as post-forms]
            [solotest.useraccts :as log]))

(defroutes app-routes
  (GET "/" [] (homes/home-page))
  (GET "/find-a-job" [] (homes/job-page))
  (GET "/find-an-employee" [] (homes/company-page))

  (GET "/account-login" [] (homes/login-page))
  (POST "/account-login" {{:keys [handle passwd]} :params}
        (log/do-login handle passwd))

  (GET "/create-account" [] (homes/reg-page))
  (POST "/create-account" {{:keys [handle passwd passwd2 email]} :params} 
        (log/do-registration handle passwd passwd2 email))
 
  (GET "/account-created" [] (homes/job-page))

  (GET "/name-and-contact" [] (get-forms/name-and-contact))
  (POST "/name-and-contact" {{:strs [first-name mn ln ph ph2 email str apt city st zip]} :params} 
        (post-forms/post-name-and-contact first-name mn ln ph ph2 email str apt city st zip))
  (GET "/objectives-and-skills" [] (get-forms/objectives-and-skills))
  (GET "/employer-one" [] (get-forms/emp-pages ["one" 1]))
  (GET "/employer-two" [] (get-forms/emp-pages ["two" 2]))
  (GET "/employer-three" [] (get-forms/emp-pages ["three" 3]))
  (GET "/employer-four" [] (get-forms/emp-pages ["four" 4]))
  (GET "/employer-five" [] (get-forms/emp-pages ["five" 5]))
  (GET "/high-school" [] (get-forms/high-school))
  (GET "/higher-ed-one" [] (get-forms/higher-ed ["one" 1]))
  (GET "/higher-ed-two" [] (get-forms/higher-ed ["two" 2]))
  (GET "/preview-resume" [] "Hello World")
  (GET "/company-interface" [] "Hello World")
  (GET "/resume-search" [] "Hello World")
  (GET "/resume-search/preview-resume" [] "Hello World")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
