create table CLASSES
(
    ClassID      int  not null
        primary key,
    Day          date not null,
    Time         time not null,
    InstructorID int  not null,
    constraint InstructorID
        foreign key (InstructorID) references INSTRUCTOR (InstructorID)
            on update cascade on delete cascade
);

create index InstructorID_idx
    on CLASSES (InstructorID);

