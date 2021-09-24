create table if not exists Taco (
    id int auto_increment primary key,
    name varchar(50) not null,
    createdAt timestamp not null
);
alter table Taco_Ingredients
    add foreign key (taco) references Taco(id);
alter table Taco_Order_Tacos
    add foreign key (taco) references Taco(id);
