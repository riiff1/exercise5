CREATE TABLE trade (
    id IDENTITY PRIMARY KEY ,
    asset VARCHAR(50),
    amount DOUBLE,
    date DATE
);