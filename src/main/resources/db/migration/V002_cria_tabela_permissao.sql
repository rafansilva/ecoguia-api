create table usuario_permissao (
	usuario_id bigint not null,
	permissao_id bigint not null,

	primary key (usuario_id, permissao_id)
) engine=InnoDB default charset=utf8;

create table permissao (
	id bigint not null auto_increment,
	descricao varchar(60) not null,
	nome varchar(100) not null,

	primary key (id)
) engine=InnoDB default charset=utf8;

alter table usuario_permissao add constraint fk_usuario_permissao_permissao
foreign key (permissao_id) references permissao (id);

alter table usuario_permissao add constraint fk_usuario_permissao_grupo
foreign key (usuario_id) references usuario (id);