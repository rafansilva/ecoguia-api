# 📦 Projeto Java com Spring Boot + MySQL

Este projeto utiliza Java 21, Spring Boot, MySQL e ferramentas de apoio como IntelliJ IDEA e DBeaver. Ao final do processo, você poderá acessar a documentação da API via Swagger para confirmar que tudo está funcionando corretamente.

---

## ✅ Requisitos

Antes de iniciar o projeto, instale os seguintes softwares:

- **Java 21 (Temurin JDK)**  
  [Download Java 21](https://adoptium.net/temurin/releases/?arch=x64&package=jdk&os=windows)

- **IntelliJ IDEA Community**  
  [Download IntelliJ](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC)

- **MySQL**  
  [Download MySQL Installer](https://dev.mysql.com/downloads/installer/)

- **DBeaver Community (opcional, para visualizar o banco de dados)**  
  [Download DBeaver](https://dbeaver.io/download/)

---

## 🚀 Como iniciar o projeto

### 1. Clone o repositório

```bash
git clone <URL-do-repositório>
cd <nome-do-projeto>
```

### 2. Configure o banco de dados

- Abra o MySQL Installer e instale o MySQL Server.

### 3. Abra o projeto no IntelliJ

- Vá em File > Open e selecione a pasta do projeto.
- O IntelliJ irá identificar o projeto como Maven e baixar as dependências automaticamente.
- Vá em File > Project Structure (Estrutura do projeto) na janela aberta selecione a SDK > 21 e Languange level > 21
- Aguarde a indexação terminar.

### 4. Rode o projeto

- No IntelliJ, vá até a classe principal que contém o método main (geralmente algo como Application.java) e clique em Run. 

### 5. Verifique se o projeto está rodando

Abra o navegador e acesse:

- http://localhost:8080/swagger-ui.html

Se a página do Swagger abrir com a documentação da API, o projeto está rodando com sucesso! 🎉