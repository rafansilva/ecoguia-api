create table ecoponto (
	id bigint not null auto_increment,
	nome varchar(80) not null,
    ativo tinyint(1) not null,
    aberto tinyint(1) not null,
    horario_abertura time not null,
    horario_fechamento time not null,

	endereco_cidade_id bigint,
	endereco_cep varchar(9),
	endereco_logradouro varchar(100),
	endereco_numero varchar(20),
	endereco_complemento varchar(60),
	endereco_bairro varchar(60),
	endereco_latitude varchar(60),
    endereco_longitude varchar(60),

	data_atualizacao datetime not null,
    data_cadastro datetime not null,
	primary key (id)
) engine=InnoDB default charset=utf8;

create table ecoponto_usuario_responsavel (
  ecoponto_id bigint not null,
  usuario_id bigint not null,

  primary key (ecoponto_id, usuario_id)
) engine=InnoDB default charset=utf8;

update ecoponto set ativo = true;
update ecoponto set aberto = false;

alter table ecoponto add constraint fk_ecoponto_cidade
foreign key (endereco_cidade_id) references cidade (id);

alter table ecoponto_usuario_responsavel add constraint fk_ecoponto_usuario_ecoponto
foreign key (ecoponto_id) references ecoponto (id);

alter table ecoponto_usuario_responsavel add constraint fk_ecoponto_usuario_usuario
foreign key (ecoponto_id) references usuario (id);