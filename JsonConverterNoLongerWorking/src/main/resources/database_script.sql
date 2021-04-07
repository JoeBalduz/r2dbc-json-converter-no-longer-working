CREATE TABLE house (
    address varchar,
    pets    jsonb,
    id      serial constraint house_pk primary key
);

INSERT INTO house VALUES ('address', '{"data": [{"animal" : "bird", "name" : "birdy"}]}');