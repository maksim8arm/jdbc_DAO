CREATE TABLE CUSTOMERS (
     id serial ,
     name CHARACTER VARYING(30),
     surname CHARACTER VARYING(30),
     age INTEGER,
     phone_number INTEGER,
     PRIMARY KEY (id)
);

CREATE TABLE ORDERS (
     id serial,
     date date,
     customer_id INTEGER,
     product_name CHARACTER VARYING(30),
     amount INTEGER,
     FOREIGN KEY (customer_id)  REFERENCES CUSTOMERS (id)
);

