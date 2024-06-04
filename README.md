# App Creation Users

### Connection to database H2
Connection to database in memory H2

- Url: jdbc:h2:mem:evaluation_db
- Database Name: evaluation_db
- UserName: sa
- Password: muruna

### Curl
Execute curl in postman, view image final for example
```bash
curl --location 'http://localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Andres",
    "email": "afranco22@gmail.cl",
    "password": "Andres2020//",
    "phones": [
        {
            "number": "12354",
            "citycode": "1",
            "countrycode": "57"
        },
        {
            "number": "54321",
            "citycode": "2",
            "countrycode": "75"
        }
    ]
}'
```
#### Response curl
```bash
{
    "code": 1,
    "httpStatus": "OK",
    "message": "OK",
    "body": {
        "id": "e4ff7f798ed112d0018ed112dc770000",
        "created": "2024-04-12T01:50:58.0149102",
        "modified": "2024-04-12T01:50:58.0149102",
        "lastLogin": "2024-04-12T01:50:58.0149102",
        "token": "f7ecab0b-986d-4e8e-8abe-1202c4487d88",
        "isActive": true
    }
}
```

![Alt text](https://github.com/afrancom2/spring-muruna-evaluation/blob/master/src/main/responsecurl.JPG "Curl Response")

### Diagram Class
![Alt text](https://github.com/afrancom2/spring-muruna-evaluation/blob/master/src/main/Diagram.JPG "Diagram class")
