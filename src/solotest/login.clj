(ns solotest.useraccts
  (:require [noir.util.crypt :as crypt]
            [noir.session :as sesh]
            [noir.validation :as val]
            [noir.response :as resp]
            [solotest.kormadb :as db])
  (:use hiccup.core
        hiccup.page
        hiccup.form))

(defn log-fields [coll]
  (for [[div label id type]]
    [div
     [:input label
      [:input {:type type :id id :name id :required}]]]))

(defn registration []
  [:form {:method "POST" :action "/registration"}
   [:fieldset
    [:legend [:h3 "Register"]]
    [:div.row
     (make-fields 
      [[:div.small-5 "User Name (5+ characters)" "username" "text" ]
       [:div.small-5 "Password (8 + characters)" "passwd" "password"]
       [:div.small-5 "Retype Password" "passwd2" "password"]
       [:div.small-5 "Email" "email" "email"]])
     [:input.buttons {:type "submit" :value "Create Account"}]]]])

(defn do-registration [handle passwd passwd2 email]
  (if (valid? passwd passwd2)
    ((insert db/allusers 
             (values {:username handle :password (crypt/encrypt passwd) :usertype "employee" :active "yes" :email email}))
     (response/redirect "/create-account"))))






