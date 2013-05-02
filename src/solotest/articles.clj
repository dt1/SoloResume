(ns solotest.articles
  (:use hiccup.core
        hiccup.page
        hiccup.form
        hiccup.element))

(defn find-a-job []
  [:div.row
   [:div.large-8.columns
    [:h2 "Welcome to the Job Portal"]
    [:h3 "What You Would Want Before Starting:"]
    [:ol 
     [:li "Your Contact Information:"]
     [:ul 
      [:li "First Name"]
      [:li "Last Name"]
      [:li "Phone Number"]
      [:li "email address"]
      [:li "Home Address"]]
     [:br]
     [:li "About You:"]
     [:ul
      [:li "Skills"]
      [:li "Objective"]]
     [:br]
     [:li "Previous Employer(s):"]
     [:ul 
      [:li "Company Name(s)"]
      [:li "Years Worked"]
      [:li "Descriptions of Duties"]]
     [:br]
     [:li "College and/or High School Education:"]
     [:ul
      [:li "School(s) Names"]
      [:li "School(s) City"]
      [:li "School(s) State"]
      [:li "Year(s) Graduated"]
      [:li "Major(s)"]]]]
   [:div.large-4.columns
    [:a.round.button.margin-top-fifty {:href "/create-account"} "Get Started"]]])

(defn front-page []
  [:div.row
   [:div.large-12.columns
    [:h2 "The job-search market is broken."]
    [:p "The job-seeking process is frustrating for both the job-seeker and the hiring managers. Solo Resume aims to introduce a streamlined process that is quicker and easier for everyone involved."]
    [:hr]]
  [:div.row
   [:div.large-12.columns
    [:h2 "Our Solutions"]]]

  [:div.row
   [:div.large-6.columns
    [:h4 "Quality on Both Ends"]
    [:p "Other companies sell resumes or employee information to any and all companies, including \"Commission-Only\" jobs, \"Business Opportunities,\" and colleges. Inboxes are loaded with \"leads\" that applicants are not interested in. Many job-listings are from companies placing \"feeler ads\" that aren't interested in hiring. All of this combines to chase away quality applicants, which chases away quality employers, which spins into a feedback loop of diminishing quality."]
    [:i "Solo Resume promises to vet employers before they are allowed to use our system. Our stance is \"quality on both ends:\" quality employers and quality job seekers."]]
   [:div.large-6.columns
    [:img {:src "img/talking.png" :alt "Businesspersons talking"}]]
   [:hr]]
  
  [:div.row
   [:div.large-4.columns
    [:img {:src "img/reader.png" :alt "Man Reading and Document"}]]
   [:div.large-8.columns
    [:h4 "Focused & Concise Resumes"]
    [:p "Many experts tell job seekers to \"tailor\" their resumes to the various jobs they are applying for. This leads to many resumes that are cooked up with qualifications that don't exist and second guessing. Most of hte time, the second-guessing is incorrect. This wastes the employers and the job-seekers time. Hiring managers and human resources personal wastes a lot of time reading long resumes and deciphering the applicants intention."]
    [:i "Each applicant is allowed to create and store a targeted one-page resume. We believe this will save company time and each the employee and and employer will be happier with the results."]]
   [:hr]]
  
  [:div.row
   [:div.large-6.columns
    [:h4 "Helping The Best Find The Best"]
    [:p "Sometimes a hiring manager is faced with the choice of two excellent candidates but can only pick one. Some resumes are excellent but they can be difficult to find amid so many names in a tall stack of papers."]
    [:i "We believe it should be easy for excellent applicants to find jobs quickly. Through our system of voting and data collection, we believe we can create the most effective job-search engine on the market."]]
   [:div.large-6.columns
    [:img {:src "img/highfive.png"}]]
   [:hr]]

  [:div.row
   [:div.large-4.columns
    [:img {:src "img/twoPeople.png"}]]
   [:div.large-8.columns
    [:h4 "An Easy to Use Interface for All"]
    [:p "Some solutions expect employers to be a power-user to get all the functionality of the system. Many companies demand spending 45 minutes on an online application."]
    [:i "We believe no one likes to waste time looking for jobs or seeking employees. We are out to save everyone time looking for work so everyone can get back to work."]]
   [:hr]]

  [:div.row
   [:div.two.columns]
   [:div.large-7.columns
    [:h4 "The Power Is In Your Hands Now"]
    [:p "Whether you are looking for a job or looking for the perfect person for the job, our system is in place to save you time and money. We created Solo Resume because we believe finding a job shouldn't be harder than the job you land. We believe finding the perfect employee shouldn't be a fruitless search. By combining technology with the human spirit, Solo Resume helps to shape the future of businesses and job-seekers."]]
   [:div.large-3.columns]]
  [:div.row
   [:div.large-2.columns]
   [:div.large-3.columns
    [:a.round.button {:href "/find-a-job"} "Find a Job"]]
   [:div.large-2.columns]
   [:div.large-5.columns
    [:a.round.button {:href "/find-an-employee"} "Find an Employee"]]]
  [:div.row
   [:pre "






"]]])


(defn instructions []
  [:p "The process is easy. Just click on the menu items on the side and fill in the fields. You can preview your resume at any time."]
  [:p "Your resume will not be viewed by employers until your first name, last name, and phone number are filled int."])
