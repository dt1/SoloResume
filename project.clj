(defproject solotest "0.1.0-SNAPSHOT"
  :description ""
  :url ""
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.3"]
                 [lib-noir "0.5.0"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [korma "0.3.0-RC5"]
                 [org.postgresql/postgresql "9.2-1002-jdbc4"]]
  :plugins [[lein-ring "0.8.3"]]
  :ring {:handler solotest.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
