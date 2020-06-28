CREATE TABLE CNNMarket (
    TEST_ID varchar(1000),
    DESCRIPTION varchar(4000),
    Expected varchar(4000),
    Actual varchar(4000),
    Status varchar(1000) 
);

INSERT INTO CNNMarket (TEST_id, DESCRIPTION, EXPECTED,ACTUAL,STATUS) 
values('TC_001','Login','CNN','NBC','Failed');

select * from CNNMarket;