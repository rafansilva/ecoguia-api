create table usuario (
	id bigint not null auto_increment,
	nome varchar(80) not null,
	email varchar(255) not null,
	senha varchar(255) not null,

	endereco_cidade_id bigint,
    endereco_cep varchar(9),
    endereco_logradouro varchar(100),
    endereco_numero varchar(20),
    endereco_complemento varchar(60),
    endereco_bairro varchar(60),

	data_cadastro datetime not null,

	primary key (id)
) engine=InnoDB default charset=utf8;

create table cidade (
	id bigint not null auto_increment,
	estado_id bigint not null,
	nome varchar(80) not null,

	primary key (id)
) engine=InnoDB default charset=utf8;

create table estado (
	id bigint not null auto_increment,
	nome varchar(80) not null,

	primary key (id)
) engine=InnoDB default charset=utf8;

alter table cidade add constraint fk_cidade_estado
foreign key (estado_id) references estado (id);

alter table usuario add constraint fk_usuario_cidade
foreign key (endereco_cidade_id) references cidade (id);