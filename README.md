# spring_user_service
В компании «А» возникла потребность в хранении и управлении учетными записями пользователей (добавление, удаление и поиск по email).
Задача по реализации данных потребностей выпала Вам. Необходимо реализовать REST сервис, отвечающий следующим требованиям:

* данные пользователя, которые будут храниться: Фамилия, Имя, Дата рождения, email и пароль;
* пароль пользователя должен храниться в безопасной форме;
* использовать InMemory реализацию базы данных (т.е. хранить данные в памяти);
* приложение необходимо реализовать на одном из языков: Java 8, Groovy или Kotlin с использованием Spring Boot;
* наличие примеров запросов к сервису (например, curl).

**Add new user**

_Example:_

    curl -d '{
        "username": "Username",
        "surname": "Surname",
        "dateOfBirth": "1995-11-20",
        "password": "password123",
        "email": "email@example.com"
    }' -H 'Content-Type: application/json'  http://localhost:8080/api/registration

User password will be stored in encrypted form, using BCrypt

**List all users**

    curl http://localhost:8080/api/users | json_pp

`json_pp` is used for pretty JSON response
 
**Delete user**

    curl -X DELETE http://localhost:8080/api/users/{id}

_Example:_

    curl -X DELETE http://localhost:8080/api/users/4


**Find user by email**

    curl http://localhost:8080/api/users/find/{email}
    
_Example:_

    curl http://localhost:8080/api/users/find/email@example.com
