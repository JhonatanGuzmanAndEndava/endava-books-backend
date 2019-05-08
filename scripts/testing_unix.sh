!#/bin/bash
curl -X POST "http://localhost:8080/v1/book/add" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"isbn\": \"ABCD\",  \"language\": \"English\",  \"name\": \"Brief Time History\",  \"urlImage\": \"hawking.jpg\",  \"authorId\": 0,  \"publisherId\": 0}"
curl -X POST "http://localhost:8080/v1/book/add" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"isbn\": \"ABCDE\",  \"language\": \"Espanol\",  \"name\": \"El amor en los tiempos del colera\",  \"urlImage\": \"gabo.jpg\",  \"authorId\": 0,  \"publisherId\": 0}"

curl -X GET "http://localhost:8080/v1/book?isbn=ABCD" -H  "accept: */*"
curl -X GET "http://localhost:8080/v1/book?isbn=ABCDE" -H  "accept: */*"

curl -X POST "http://localhost:8080/v1/author/add" -H  "accept: */*" -H  "Content-Type: application/json;charset=UTF-8" -d "{  \"name\": \"Gabriel\",  \"lastName\": \"Garcia Marquez\",  \"nickname\": \"Gabo\",  \"birthday\": \"1949-02-13\",  \"picture\": \"gaboselfie.jpg\"}"
curl -X POST "http://localhost:8080/v1/author/add" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"name\": \"Stephen\",  \"lastName\": \"Hawking\",  \"nickname\": \"Professor X\",  \"birthday\": \"1959-02-14\",  \"picture\": \"hawkingselfie.jpg\"}"