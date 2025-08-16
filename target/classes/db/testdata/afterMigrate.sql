set foreign_key_checks = 0;

lock tables cidade write, estado write,	grupo write, grupo_permissao write, permissao write,
	 usuario write, usuario_grupo write, ecoponto write, ecoponto_usuario_responsavel write;

delete from cidade;
delete from estado;
delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from usuario;
delete from usuario_grupo;
delete from ecoponto;
delete from ecoponto_usuario_responsavel;

set foreign_key_checks = 1;

alter table cidade auto_increment = 1;
alter table estado auto_increment = 1;
alter table grupo auto_increment = 1;
alter table permissao auto_increment = 1;
alter table usuario auto_increment = 1;
alter table ecoponto auto_increment = 1;

insert into estado (id, nome) values (1, 'São Paulo');
insert into estado (id, nome) values (2, 'Minas Gerais');
insert into estado (id, nome) values (3, 'Ceará');

insert into cidade (id, nome, estado_id) values (1, 'São Paulo', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 2);
insert into cidade (id, nome, estado_id) values (3, 'Uberlândia', 2);
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 1);
insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into ecoponto (id, nome, ativo, aberto, horario_abertura, horario_fechamento, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, data_atualizacao, data_cadastro) values (1, 'Santo Amaro', true, true, utc_time, utc_time, 1, '1623-1373', 'Av. Guido Caloi', '1000', 'Jardim São Luís', utc_timestamp, utc_timestamp);
insert into ecoponto (id, nome, ativo, aberto, horario_abertura, horario_fechamento, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, data_atualizacao, data_cadastro) values (2, 'Vicente Rao', true, true, utc_time, utc_time, 1, '04636-000', 'Av. Professor Vicente Ráo', '9999', 'Campo Belo', utc_timestamp, utc_timestamp);
insert into ecoponto (id, nome, ativo, aberto, horario_abertura, horario_fechamento, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, data_atualizacao, data_cadastro) values (3, 'Vila Prudente', true, true, utc_time, utc_time, 1, '04220-030', 'R. Patriarca', '1', 'Vila Independencia', utc_timestamp, utc_timestamp);
insert into ecoponto (id, nome, ativo, aberto, horario_abertura, horario_fechamento, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, data_atualizacao, data_cadastro) values (4, 'Paraisópolis', false, false, utc_time, utc_time, 1, '05712-040', 'R. Dr. José Augusto de Souza e Silva', '3000', 'Jardim Parque Morumbi', utc_timestamp, utc_timestamp);
insert into ecoponto (id, nome, ativo, aberto, horario_abertura, horario_fechamento, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, data_atualizacao, data_cadastro) values (5, 'Sacomã', true, false, utc_time, utc_time, 1, '04252-020', 'R. Indaiaçu', '185', 'Sacomã', utc_timestamp, utc_timestamp);

insert into permissao (id, nome, descricao) values (1, 'EDITAR_CIDADES', 'Permite criar ou editar cidades');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_ESTADOS', 'Permite criar ou editar estados');
insert into permissao (id, nome, descricao) values (3, 'CONSULTAR_USUARIOS_GRUPOS_PERMISSOES', 'Permite consultar usuários, grupos e permissões');
insert into permissao (id, nome, descricao) values (4, 'EDITAR_USUARIOS_GRUPOS_PERMISSOES', 'Permite criar ou editar usuários, grupos e permissões');
insert into permissao (id, nome, descricao) values (5, 'EDITAR_ECOPONTOS', 'Permite criar, editar ou gerenciar ecopontos');
insert into permissao (id, nome, descricao) values (6, 'CONSULTAR_ECOPONTOS', 'Permite consultar ecopontos');
insert into permissao (id, nome, descricao) values (7, 'EDITAR_ROTAS', 'Permite criar, editar ou gerenciar rotas de coletas');
insert into permissao (id, nome, descricao) values (8, 'CONSULTAR_ROTAS', 'Permite consultar rotas de coleta');

insert into grupo (id, nome) values (1, 'Gerente'), (2, 'Encarregado'), (3, 'Cadastrador'), (4, 'Usuário');

insert into usuario (id, nome, email, senha, data_cadastro) values
(1, 'João da Silva', 'joao.ger@ecoguia.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
(2, 'Maria Joaquina', 'maria.vnd@ecoguia.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
(3, 'José Souza', 'jose.aux@ecoguia.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
(4, 'Sebastião Martins', 'sebastiao.cad@ecoguia.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
(5, 'Manoel Lima', 'manoel.loja@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp);

insert into usuario_grupo (usuario_id, grupo_id) values (1, 1), (1, 2), (2, 2), (3, 3), (4, 4);

insert into ecoponto_usuario_responsavel (ecoponto_id, usuario_id) values (1, 5), (3, 5);

# Adiciona todas as permissoes no grupo do gerente
insert into grupo_permissao (grupo_id, permissao_id)
select 1, id from permissao;

# Adiciona permissoes no grupo do encarregado
insert into grupo_permissao (grupo_id, permissao_id)
select 2, id from permissao where nome like '%_ROTAS';

# Adiciona permissoes no grupo do cadastrador
insert into grupo_permissao (grupo_id, permissao_id)
select 3, id from permissao where nome like '%_ROTAS';

# Adiciona permissoes no grupo do cadastrador
insert into grupo_permissao (grupo_id, permissao_id)
select 4, id from permissao where nome like 'CONSULTA_%';


unlock tables;