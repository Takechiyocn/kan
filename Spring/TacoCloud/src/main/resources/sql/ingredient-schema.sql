create table if not exists Ingredient (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
);
create table if not exists Taco_Ingredients (
    taco bigint not null,
    ingredient varchar(4) not null
);
alter table Taco_Ingredients
    add foreign key (ingredient) references Ingredient(id);
