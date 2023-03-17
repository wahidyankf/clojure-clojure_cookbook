(ns ch06-databases
  (:require [clojure.java.jdbc :as jdbc]
            [java-jdbc.ddl :as ddl]
            [java-jdbc.sql :as sql]))

(def db-spec {:classname "org.postgresql.Driver"
              :subprotocol "postgresql"
              :subname "//localhost:5432/postgresql"
              :user "postgres"
              :password "mysecretpassword"})

(jdbc/db-do-commands db-spec false
                     (ddl/create-table
                      :tags
                      [:id :serial "PRIMARY KEY"]
                      [:name :varchar "NOT NULL"]))