(ns solotest.useraccts
  (:require [noir.util.crypt :as crypt]
            [noir.session :as sesh]
            [noir.validation :as val]
            [ring.util.response :as response]
            [solotest.kormadb :as db])
  (:use hiccup.core
        hiccup.page
        hiccup.form
        korma.core))

(defn log-fields [coll]
  (for [[div label id type] coll]
    [div
     [:label label]
      [:input {:type type :required "required" :name id}]]))

(defn registration []
  [:form {:method "POST" :action "/registration"}
   [:fieldset
    [:legend [:h3 "Register"]]
    [:div.row
     (log-fields 
      [[:div.small-5 "User Name (5+ characters)" "handle" "text" ]
       [:div.small-5 "Password (8 + characters)" "passwd" "password"]
       [:div.small-5 "Retype Password" "passwd2" "password"]
       [:div.small-5 "Email" "email" "email"]])
     [:input.buttons {:type "submit" :value "Create Account"}]]]])

(defn do-registration [handle passwd passwd2 email]
  (if (= passwd passwd2)
    (do 
      (insert db/allusers 
              (values {:username handle :password (crypt/encrypt passwd) :usertype "employee" :active "yes" :email email}))
      (insert db/jobhunteremployers
              (values {:username handle :employernumber 1}))
      (insert db/jobhunteremployers
              (values {:username handle :employernumber 2}))
      (insert db/jobhunteremployers
              (values {:username handle :employernumber 3}))
      (insert db/jobhunteremployers
              (values {:username handle :employernumber 4}))
      (insert db/jobhunteremployers
              (values {:username handle :employernumber 5}))
      (insert db/jobhuntercontact 
              (values {:username handle}))
      (insert db/jobhunterobjectives 
              (values {:username handle}))
      (insert db/jobhunterskills
              (values {:username handle}))
      (insert db/jobhunterhighschools 
              (values {:username handle}))
      (insert db/jobhunterhighered
              (values {:username handle :henumber 1}))
      (insert db/jobhunterhighered 
              (values {:username handle :henumber 2}))
      (insert db/jobhunterscores 
              (values {:username handle}))
      (response/redirect "/"))))

(defn login []
  [:form {:method "POST" :action "/account-login"}
   [:fieldset
    [:legend [:h3 "Log In"]]
    [:div.row
     (log-fields 
      [[:div.small-5 "User Name:" "handle" "text" ]
       [:div.small-5 "Password:" "passwd" "password"]])
     [:input.round.button {:type "submit" :value "Log In"}]]]])

(defn do-login [username passwd]
  (let [tuser (select db/allusers
                      (fields :username :password :usertype)
                      (where {:username username}))]
    (if (crypt/compare passwd
                       (let [[{pwd :password}] tuser]
                         pwd))
      ;; (let [utype (let [[{ut :usertype}] tuser]
      ;;               ut)]
      (do (sesh/put! :uname username)
          (response/redirect "/")))
;;      (response/redirect "/account-login" {:handle tuser :error "Login Failed"})

))
