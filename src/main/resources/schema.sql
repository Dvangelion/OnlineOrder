drop table t_food if exists;
drop table t_order if exists;
drop table t_order_food if exists;

create table t_food (
    id bigint auto_increment,
    create_time timestamp,
    update_time timestamp,
    name varchar(255),
    price bigint,
    primary key (id)
);

create table t_order (
    id bigint auto_increment,
    create_time timestamp,
    update_time timestamp,
    customer varchar(255),
    state integer not null,
    primary key (id)
);

create table t_order_food (
    food_order_id bigint not null,
    items_id bigint not null
);

insert into t_food (name, price, create_time, update_time) values ('espresso', 2000, now(), now());
insert into t_food (name, price, create_time, update_time) values ('latte', 2500, now(), now());
insert into t_food (name, price, create_time, update_time) values ('cappuccino', 2500, now(), now());
insert into t_food (name, price, create_time, update_time) values ('mocha', 3000, now(), now());
insert into t_food (name, price, create_time, update_time) values ('machinate', 3000, now(), now());