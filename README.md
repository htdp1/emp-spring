# emp-spring
mariadb employees api sample application using Spring Boot


# maven build & docker build/push
```
mvn clean package
docker build -t emp-spring .
docker tag emp-spring htdp1/emp-spring:v1
docker push htdp1/emp-spring:v1
docker tag emp-spring htdp1/emp-spring:latest
docker push htdp1/emp-spring:latest
```
## spring data REST 적용
- Supported HTTP Method  
https://docs.spring.io/spring-data/rest/docs/3.4.5/reference/html/#repository-resources.collection-resource
