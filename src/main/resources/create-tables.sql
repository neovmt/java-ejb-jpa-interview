
CREATE TABLE accounts (
    id NUMBER(9) NOT NULL,
    name VARCHAR2(100 CHAR) NOT NULL,
    version NUMBER(9) NOT NULL
);

CREATE TABLE transactions (
    id NUMBER(9) NOT NULL,
    debited_account NUMBER(9) NOT NULL,
    credited_account NUMBER(9) NOT NULL,
    amount NUMBER NOT NULL,
    version NUMBER(9) NOT NULL
);

CREATE SEQUENCE accounts_id_seq
    INCREMENT BY 1
    START WITH 1;

CREATE SEQUENCE transactions_id_seq
    INCREMENT BY 1
    START WITH 1;