(ns ch06-databases
  (:require [next.jdbc :as jdbc]))

(def ds {:dbtype "postgres"
         :dbname "postgres" :user "postgres" :password "mysecretpassword"})

(jdbc/execute! ds ["
create table address (
  id SERIAL PRIMARY KEY,
  name VARCHAR(32),
  email VARCHAR(255)
)"])

(jdbc/execute-one! ds ["select * from accounts"])