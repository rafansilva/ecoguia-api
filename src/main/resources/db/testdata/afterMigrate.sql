set foreign_key_checks = 0;

lock tables cidade write, estado write, permissao write, usuario write, usuario_permissao write;

delete from cidade;
delete from estado;
delete from permissao;
delete from usuario;
delete from usuario_permissao;

set foreign_key_checks = 1;

alter table cidade auto_increment = 1;
alter table estado auto_increment = 1;
alter table permissao auto_increment = 1;
alter table usuario auto_increment = 1;

insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Ceará');

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2);
insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into permissao (id, nome, descricao) values (1, 'EDITAR_CIDADES', 'Permite criar ou editar cidades');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_ESTADOS', 'Permite criar ou editar estados');
insert into permissao (id, nome, descricao) values (3, 'CONSULTAR_USUARIOS_PERMISSOES', 'Permite consultar usuários e permissões');
insert into permissao (id, nome, descricao) values (4, 'EDITAR_USUARIOS_PERMISSOES', 'Permite criar ou editar usuários e permissões');

insert into usuario (id, nome, email, senha, data_cadastro) values
(1, 'João da Silva', 'joao.ger@algafood.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
(2, 'Maria Joaquina', 'maria.vnd@algafood.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
(3, 'José Souza', 'jose.aux@algafood.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
(4, 'Sebastião Martins', 'sebastiao.cad@algafood.com.br', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
(5, 'Manoel Lima', 'manoel.loja@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
(6, 'Débora Mendonça', 'email.teste.aw+debora@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp),
(7, 'Carlos Lima', 'email.teste.aw+carlos@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', utc_timestamp);

insert into usuario_permissao (usuario_id, permissao_id) values (1, 1), (1, 2), (2, 2), (3, 3), (4, 4);


unlock tables;