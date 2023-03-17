(ns ch06-databases
  (:require
   [honey.sql :as sql]
   [next.jdbc.sql :refer [query]]
   [next.jdbc.result-set :as rs]))

(def ds {:dbtype "postgres"
         :dbname "postgres" :user "postgres" :password "mysecretpassword"})

(query ds ["
create table address (
  id SERIAL PRIMARY KEY,
  name VARCHAR(32),
  email VARCHAR(255)
)"])

(query ds ["
insert into address(name,email)
  values('Sean Corfield','sean@corfield.org')"])

(query ds ["select * from address"])
(query ds ["delete from address where id = 3"])

(def res (query ds (sql/format {:select [:*],
                                :from [:address]})
                {:return-keys true
                 :builder-fn rs/as-unqualified-maps}))

(:id (first res))