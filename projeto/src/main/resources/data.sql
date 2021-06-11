create table estado_civil
(
id_e_civil  serial  primary key ,
descricao varchar(40) not null
);

create table pessoa_fisica
(
id_p_fisica serial,
nome varchar(80) not null,
data_nasc date,
fk_estado_civil int not null,
primary key(id_p_fisica),
 constraint fk_estado_civil foreign key(fk_estado_civil) references estado_civil(id_e_civil)
);

create table dependente
(
id_dependente serial primary key,
nome varchar(80) not null,
cpf varchar(11) not null,
fk_p_fisica int,
constraint fk_p_fisica foreign key(fk_p_fisica) references pessoa_fisica(id_p_fisica)

);

insert into estado_civil(descricao) values
               ('Solteiro(a)'),
               ('União Estável'),
               ('Casado(a)'),
               ('Divorciado(a)'),
               ('Viúvo(a)');





