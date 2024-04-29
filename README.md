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

#### Docker
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
#### Docker
```bash
docker build -t nano-link:aws -f ./Dockerfile-AWS .
docker compose -f docker-compose-aws.yml -p nanolink up -d nanoLink
```
