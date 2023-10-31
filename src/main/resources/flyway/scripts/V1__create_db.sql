create table clients(
	id int AUTO_INCREMENT primary key,
	name varchar(200) not null
);

create table planets(
	id varchar(50) primary key,
	name varchar(500) not null
);

create table tickets(
	id int AUTO_INCREMENT primary key,
	created_at timestamp(6) not null,
	client_id int not null,
	from_planet_id varchar(50),
	to_planet_id varchar(50),
	foreign key (client_id) references clients(id),
	foreign key (from_planet_id) references planets(id),
	foreign key (to_planet_id) references planets(id)
);