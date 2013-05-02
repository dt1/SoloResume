(ns solotest.getforms
  (:require [solotest.layouts :as layouts])
  (:use hiccup.core
        hiccup.page
        hiccup.form))

(defn make-fields [coll]
  (for [[div label input id type] coll]
    (cond (= input :input)
          [div
           [:label label] [:i ""]
           [:input {:type type :id id :name id}]]
          (= input :select)
          [div
           [:label label [:i ""]]
           (layouts/menu-build id type)])))

(defn name-and-contact []
  (layouts/res-heads
   [:form {:method "POST" :action "/name-and-contact"}
    [:fieldset 
     [:legend [:h3 "Name and Contact"]]
     [:div.row 
      (make-fields [[:div.small-5 "First Name:" :input "firstname" "text"]
                    [:div.small-5 "Middle Name:" :input "middlename" "text"]      
                    [:div.small-4  "Last Name:" :input "lastname" "text"]
                    [:div.large-6 "Phone Number:" :input "phoneNumber" "text"]
                    [:div.large-6 "Phone Number 2:" :input "phoneNumberTwo" "text"]
                    [:div.large-6 "Email:" :input "email" "email"]
                    [:div.large-6 "Street:" :input "street" "text"]
                    [:div.large-6 "Apt:" :input "apt" "text"]
                    [:div.large-6 "City:" :input "city" "text"]
                    [:div.large-6 "State:" :select "state" :state]
                    [:div.large-6 "Zip Code:" :input "zip" "text"]])
      [:input.buttons {:type "submit" :value "Update"}]]]]))

(defn objectives-and-skills []
  (layouts/res-heads
   [:form {:metod "POST" :action "/obvectives-and-skills"}
    [:fieldset
     [:legend [:h3 "Objectives and Skills"]]
     [:div.row
      (make-fields
       [[:div.large-8 "Objectives:" :textarea "objectives" "text"]
        [:div.large-8 "Skills:" :textarea "skills" "text"]])]]
    [:input.buttons {:type "submit" :value "Update"}]]))

(defn emp-pages [v]
  (let [[s n] v]
    (layouts/res-heads
     [:form {:method "POST" :action (str "/employer-" s)}
      [:fieldset
       [:legend [:h3 (str "Employer " n)]]
       [:div.row
        (make-fields
         [[:div.large-6 "Employer Name" :input "empname" "text"]
          [:div.large-6 "City" :input "empcity" "text"]
          [:div.large-6 "State" :input "empstate" "text"]
          [:div.large-6 "Position:" :input "emppos" "text"]
          [:div.large-6 "Start Month:" :select "startmonth" :month]
          [:div.large-6 "Start Year:" :select "startyear" :year]
          [:div.large-6 "End Month:" :select "endmonth" :month]
          [:div.large-6 "End Year:" :select "endyear" :year]
          [:div.large-6 "Duty One:" :input "dutyone" "text"]
          [:div.large-6 "Duty Two:" :input "dutytwo" "text"]
          [:div.large-6 "Duty Three:" :input "dutythree" "text"]
          [:div.large-6 "Duty Four:" :input "dutyfour" "text"]
          [:div.large-6 "Duty Five:" :input "dutyfive" "text"]])]
      [:input.buttons {:type "submit" :value "Update"}]]])))

(defn high-school []
  (layouts/res-heads
   [:form {:method "POST" :action "/high-school"}
    [:fieldset
     [:legend [:h3 "High School"]]
     [:div.row
      (make-fields
       [[:div.large-6 "High School Name" :input "hsName" "text"]
        [:div.large-6 "Did You Graduate?" :select "hsGradQuestion" :yn]
        [:div.large-6 "If Yes, What year?" :select "hsGradYear" :year]
        [:div.large-6 "Do You have a G.E.D?" :select "getQuestion" :yn]
        [:div.large-6 "If Yes, What Year?" :select "endyear" :year]])]
     [:input.buttons {:type "submit" :value "Update"}]]]))

(defn higher-ed [v]
  (let [[s n] v]
    (layouts/res-heads
     [:form {:method "POST" :action (str "/employer" s)}
      [:fieldset
       [:legend [:h3 (str "Employer " n)]]
       [:div.row
        (make-fields
         [[:div.large-6 "School Name" :input "heName" "text"]
          [:div.large-6 "Type of School" :input "heType" "text"]
          [:div.large-6 "Did You Graduate?" :select "heGradQueston" :yn]
          [:div.large-6 "Start Year:" :select "heStartYear" :year]
          [:div.large-6 "End Year:" :select "heEndYear" :year]
          [:div.large-6 "Type of Degree:" :input "heDegreeType" "text"]
          [:div.large-6 "Major:" :input "heMajor" "text"]])]
       [:input.buttons {:type "submit" :value "Update"}]]])))

