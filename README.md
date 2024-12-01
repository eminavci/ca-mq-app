### Building frontend and backend (qm-app) docker images
* `~/ca-mq-app > docker build -t mq-app:latest . --no-cache`
* `~/ca-mq-app/frontent > docker build -t frontend:latest . --no-cache`

### docker-compose to deploy all containers: frontend, backend and ibm QM containers

* `~/ca-mq-app> docker-compose up -d`

### Application end points
* Backend application has a swagger: http://localhost:8080/api/swagger-ui/index.html
* Frontend application http://localhost:4200

<br>

* Backend application has a custom profile 'test-message' in order to start the application with default 10 messages in the ibm queue.
* In docker-compose.yaml, this profile can be removed/added as seen.
```
...
environment:
- "SPRING_PROFILES_ACTIVE=docker,test-message"
...
```