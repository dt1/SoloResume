(ns solotest.kormadb
  (use korma.core
       korma.db))


(defdb solodb
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "//localhost:5432/"
   :user ""
   :password ""})
   
(defentity allusers)
(defentity jobhunteremployers)
(defentity jobhuntercontact)
(defentity jobhunterobjectives)
(defentity jobhunterskills)
(defentity jobhunterhighschools)
(defentity jobhunterhighered)
(defentity jobhunterscores)
(defentity companies)
(defentity comviewed)
(defentity comdeclines)
(defentity combought)
(defentity comscores)
(defentity comsavedresumes)

