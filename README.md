# TODO: change to postgre
# NanoLink 🔗⚡
NanoLink is a powerful URL management application built using Spring Boot 🍃, PostgreSQL, and Docker 🐳. This versatile tool allows users to create, store, and manage custom URL mappings efficiently. Think of it as a modern-day URL shortener with robust features. 

Key Features:

- **URL Mapping**: NanoLink enables users to associate long URLs with shorter, more manageable aliases.
- **REST API**: The provided **REST API** offers seamless CRUD (Create, Read, Update, Delete) operations for managing these mappings.
- **Database** Integration: NanoLink stores URL mappings in a **PostgreSQL** database, ensuring scalability and fault tolerance.
- **Containerization** : The entire application is packaged into a **Docker** container, simplifying deployment and maintenance.

Whether you’re sharing links on social media, tracking campaign performance, or simplifying complex URLs, NanoLink streamlines the process. Give it a try and experience the efficiency of concise, user-friendly links! 🚀

## Getting started
### Clone the repo
```bash
git clone https://github.com/gomezbc/NanoLink.git && cd NanoLink
```
### Configure PostgreSQL connection
Add the following ENV variables to your OS.
```bash
export SPRING_DATASOURCE_URL: "jdbc:postgresql://postgres-db:5432/postgres"
export SPRING_DATASOURCE_USERNAME: postgres
export SPRING_DATASOURCE_PASSWORD: mysecretpassword
```

### Run the application
#### Maven
Build the application with Maven
```bash
mvn clean install
mvn compile
```

#### Docker 🐳
The docker compose file will create and configure a PostgreSQL container to connect to the application. Feel free to modify any value.
```bash
docker compose -f docker-compose.yml up -d
```