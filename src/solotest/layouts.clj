(ns solotest.layouts
  (:use hiccup.core
        hiccup.page
        hiccup.form
        hiccup.element))


(def head-includes {
                    :company-css (include-css "css/company.css")	
                    :button-css (include-css "css/button.css")
                    :css-main (include-css "css/main.css")
                    :css-custom (include-css "css/custom.css")})


(def menu-list {
                :year ["-""2013""2012""2011""2010""2009""2008""2007""2006""2005""2004""2003""2002""2001""2000""1999""1998""1997""1996""1995""1994""1993""1992""1991""1990""1989""1988""1987""1986""1985""1984""1983""1982""1981""1980""1979""1978""1977""1976""1975""1974""1973""1972""1971""1970""1969""1968""1967""1966""1965""1964""1963""1962""1961""1960""1959""1958""1957""1956""1955""1954""1953""1952""1951""1950""1949""1948""1947""1946""1945""1944""1943""1942""1941""1940""1939""1938""1937""1936""1935""1934""1933""1932""1931""1930""1929""1928""1927""1926""1925""1924""1923""1922""1921""1920""1919""1918""1917""1916""1915""1914""1913"]
                :month ["-""January" "February" "March" "April" "May" 
                        "June" "July" "August" "September" "October" 
                        "November" "December"]
                :state ["-""AL""AK""AZ""AR""CA""CO""CT""DE""FL"
                        "GA""HI""ID""IL""IN""IA""KS""KY""LA""ME"
                        "MD""MA""MI""MN""MS""MO""MT""NE""NV""NH""NJ"
                        "NM""NY""NC""ND""OH""OK""OR""PA""RI""SC""SD""TN"
                        "TX""UT""VT""VA""WA""WV""WI""WY"]
                :yn ["-""yes""no"]})

(defn menu-build [menu-name param]
  (drop-down menu-name (menu-list param)))

(defn google-analytics []
  (javascript-tag
   
   "  var _gaq = _gaq || [];
		  _gaq.push(['_setAccount', 'UA-35558888-1']);
		  _gaq.push(['_setDomainName', 'soloresume.com']);
		  _gaq.push(['_trackPageview']);

		  (function() {
			var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		  })();"))


(defn head-head [& content]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:title "One Resume | Many Jobs"]
    [:link {:rel "icon" :href "img/favicon.png" :type "image/png"}]
    (vals head-includes)
    (google-analytics)]
   [:body
    content]))

(defn top-nav []
  [:ul.inline-list
   [:li [:a {:href "/"} "Home"]]
   [:li [:a {:href "/find-a-job"} "Find A Job"]]
   [:li [:a {:href "/find-an-employee"} "Find An Employee"]]
   [:li [:a {:href "/"} "Blog"]]
   [:li [:a {:href "/account-login"} "Log In"]]])

(defn home-heads [& content]
  (head-head
   [:div.row 
    [:div
     [:img.large-2.columns {:src "/img/emblem.png" :alt "Solo Resume Emblem"}]
     [:h1 "Solo Resume"]
     [:i "One Resume: Many Jobs"]]
    [:img.ten {:src "img/group.png" :alt "Grouop of Job Seekers"}]
    (top-nav)
    content]))

(defn res-heads [& content]
  (head-head 
   [:div.row 
    [:div.large-12.columns 
     [:img {:src "/img/emblemGray.png" :alt "Solo Resume Emblem"}]]]
   [:div.row 
    [:div.large-3.columns
     [:div.content 
      [:ul.side-nav 
       [:li [:a {:href "name-and-contact"} "Name & Contact"]]
       [:li [:a {:href "objectives-and-skills"} "Objectives & Skills"]]
       [:li.divider]
       [:li [:a {:href "employer-one"} "Employer One"]]
       [:li [:a {:href "employer-two"} "Employer Two"]]
       [:li [:a {:href "employer-three"} "Employer Three"]]
       [:li [:a {:href "employer-four"} "Employer Four"]]
       [:li [:a {:href "employer-five"} "Employer Five"]]
       [:li.divider]
       [:li [:a {:href "high-school"} "High School"]]
       [:li [:a {:href "higher-ed-one"} "Higher Education One"]]
       [:li [:a {:href "higher-ed-two"} "Higher Education Two"]]
       [:li.divider]
       [:li [:a {:href "preview-resume"} "Preview Resume"]]]]]
    content]))


