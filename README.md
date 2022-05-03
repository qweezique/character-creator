### CHARACTER CREATOR API

- cоздание и управление игровыми персонажами
- добавление в гильдии
- выполнение игровых логик
- вывод игровых статистик

> [Swagger OpenAPI Docs .yml](swagger-api-docs/character-creator-0.0.1-SNAPSHOT-api-docs.yaml)
___

### Порядок установки: 
1. Клонировать проект на локальную машину
2. Открыть терминал в корне проекта
3. Запустить окружение через **docker-compose**
```
docker-compose up -d
   ```
- POSTGRESQL DATABASE 
- ADMINER - клиент подключения к DB, доступен по http://localhost:8090
4. Запустить приложение через Maven
```
mvn clean package
mvn spring-boot:run
```
___
5. [Управление API через SWAGGER UI](http://localhost:8080/character-creator/swagger-ui/index.html) 
