create table DANCER
(
    DancerID          int         not null
        primary key,
    Name              varchar(45) not null,
    Address           varchar(45) not null,
    Phone             varchar(45) not null,
    Age               varchar(45) not null,
    `Parent/Guardian` varchar(45) not null
);

