# NanoLink 🔗⚡
NanoLink is a powerful URL management application built using Spring Boot 🍃, Cassandra, AWS, and Docker 🐳. This versatile tool allows users to create, store, and manage custom URL mappings efficiently. Think of it as a modern-day URL shortener with robust features. 

Key Features:

- **URL Mapping**: NanoLink enables users to associate long URLs with shorter, more manageable aliases.
- **REST API**: The provided **REST API** offers seamless CRUD (Create, Read, Update, Delete) operations for managing these mappings.
- **Database** Integration: NanoLink stores URL mappings in a **Cassandra** database, ensuring scalability and fault tolerance.
- **Flexible** Database Options: Users can choose between a managed database or Amazon Keyspaces (a fully managed Cassandra-compatible service) for storing URL mappings.
- **Scalability and Fault Tolerance**: By leveraging **Amazon Keyspaces**, NanoLink ensures scalability and high availability, even during traffic spikes.
- **Containerization** : The entire application is packaged into a **Docker** container, simplifying deployment and maintenance.

Whether you’re sharing links on social media, tracking campaign performance, or simplifying complex URLs, NanoLink streamlines the process. Give it a try and experience the efficiency of concise, user-friendly links! 🚀

## Getting started with Managed Database
### Clone the repo
```bash
git clone https://github.com/gomezbc/NanoLink.git
```
### Configure Cassandra connection
Add the following ENV variables to your OS.
```bash
export SPRING_CASSANDRA_PORT=9042
export SPRING_CASSANDRA_KEYSPACE_NAME=nanolink_keyspace
export SPRING_CASSANDRA_CONNECTION_CONNECT_TIMEOUT=10s
export SPRING_CASSANDRA_CONNECTION_INIT_QUERY_TIMEOUT=10s
export SPRING_CASSANDRA_USERNAME=cassandra
export SPRING_CASSANDRA_PASSWORD=cassandra
export SPRING_CASSANDRA_CONTACT-POINTS=cassandra
export SPRING_CASSANDRA_LOCAL_DATACENTER=datacenter1
```

### Run the application
#### Maven
Build the application with Maven
```bash
mvn clean install
mvn compile
```

#### Docker 🐳
The docker compose file will create and configure a Cassandra container to connect to the application. Feel free to modify any value.
```bash
docker build -t nano-link:latest -f ./Dockerfile .
docker compose -f docker-compose.yml up -d
```

## Getting started with AWS
### Clone the repo
```bash
git clone https://github.com/gomezbc/NanoLink.git
```

### Create and configure AWS credentials for Amazon Keyspaces
Follow this [AWS guide](https://docs.aws.amazon.com/keyspaces/latest/devguide/access.credentials.html) to create a AMI user for our appliction.
#### Normal
```bash
export AWS_ACCESS_KEY_ID=AKIAIOSFODNN7EXAMPLE
export AWS_SECRET_ACCESS_KEY=wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
```

#### Docker 🐳
In `docker-compose-aws.yml` file update `AWS_ACCESS_KEY_ID` and `AWS_SECRET_ACCESS_KEY` with your credential
```docker
AWS_ACCESS_KEY_ID: AKIAIOSFODNN7EXAMPLE
AWS_SECRET_ACCESS_KEY: wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
```

### Create a JKS trust store file
To connect to Amazon Keyspaces with SSL, we have to create a JKS trust store file following this [guide](https://docs.aws.amazon.com/keyspaces/latest/devguide/dsbulk-upload-prequs.html).

1) Move to /src/main/resources folder
```
cd ./src/main/resources
```

2) Download the Starfield digital certificate using the following command and save sf-class2-root.crt locally or in your home directory.
```bash
curl https://certs.secureserver.net/repository/sf-class2-root.crt -O
```

3) Convert the Starfield digital certificate into a trustStore file.
```bash
openssl x509 -outform der -in sf-class2-root.crt -out temp_file.der
keytool -import -alias cassandra -keystore cassandra_truststore.jks -file temp_file.der
```

4) Paste the defined `truststore-password` in the `keyspaces-application.conf` file:
```
advanced.ssl-engine-factory {
      class = DefaultSslEngineFactory
      truststore-path = "./src/main/resources/cassandra_truststore.jks"
      truststore-password = "password"

      #hostname validation must be set to false
      hostname-validation = false
    }
```

### Run the application
#### Docker 🐳
```bash
docker build -t nano-link:aws -f ./Dockerfile-AWS .
docker compose -f docker-compose-aws.yml -p nanolink up -d nanoLink
```
