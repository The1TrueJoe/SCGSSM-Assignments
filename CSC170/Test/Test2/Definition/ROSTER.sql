create table ROSTER
(
    ClassID  int not null,
    DancerID int not null,
    primary key (ClassID, DancerID),
    constraint ClassID
        foreign key (ClassID) references CLASSES (ClassID),
    constraint DancerID
        foreign key (DancerID) references DANCER (DancerID)
            on update cascade on delete cascade
);

create index DancerID_idx
    on ROSTER (DancerID);

