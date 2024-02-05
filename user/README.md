# Users Microservices

## Database:

#### This database was built with PostgreSQL. To start it, follow the instructions below:
1. Install [Docker](https://docs.docker.com/get-docker/)
2. Create a Postgres `docker run --name pg-ms -e POSTGRES_PASSWORD=admin -p 5432:5432 -d postgres`
3. Create a db with name **ms-user**
4. Create a db with name **ms-email**

## How to run
1. Create a database **ms-user** and **ms-email**
2. Create a accont in [CouldAMQP](https://www.cloudamqp.com/)
3. In folder **email** create a .env file
4. In folder **user** create a .env file
5. Go to /user and run **mvn spring-boot:run**
6. Go to /email and run **mvn spring-boot:run**

#### mail/.env
```
MAIL_URL=<Your cloudamqp URL>
USER_EMAIL=<Your email>
USER_PASSWORD=<Your password app>
```

#### user/.env
```
MAIL_URL=<Your cloudamqp URL>
```

## Techs:
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)

## About the project
This project consists of 2 microservices that communicate with each other. With them, it is possible to create a user and send an email. For sending emails, we use [CloudAMQP](https://customer.cloudamqp.com/).

### Tests
This project was developed using tests. Two types of tests were created. One using **Mockito** to simulate the behavior of services, and another using a local database **H2**, to simulate the entire process carried out by the service.

# Images:
![insomnia](https://ik.imagekit.io/mbrites/Captura%20de%20tela%20de%202024-02-05%2016-38-25_9TJ7-Ssw6.png?updatedAt=1707162495432)

![email](https://ik.imagekit.io/mbrites/Captura%20de%20tela%20de%202024-02-05%2016-38-45_2wOopFP1g.png?updatedAt=1707163136025)