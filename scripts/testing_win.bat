REM Crear libros
curl -X POST "http://localhost:8080/v1/book/add" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"isbn\": \"HAWK\",  \"language\": \"English\",  \"name\": \"Brief Time History\",  \"urlImage\": \"hawking.jpg\",  \"authorId\": 0,  \"publisherId\": 0}"
curl -X POST "http://localhost:8080/v1/book/add" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"isbn\": \"GABO\",  \"language\": \"Espanol\",  \"name\": \"El amor en los tiempos del colera\",  \"urlImage\": \"gabo.jpg\",  \"authorId\": 0,  \"publisherId\": 0}"

REM Buscar libros
curl -X GET "http://localhost:8080/v1/book?isbn=HAWK" -H  "accept: */*"
curl -X GET "http://localhost:8080/v1/book?isbn=GABO" -H  "accept: */*"

REM Crear autores
curl -X POST "http://localhost:8080/v1/author/add" -H  "accept: */*" -H  "Content-Type: application/json;charset=UTF-8" -d "{  \"name\": \"Gabriel\",  \"lastName\": \"Garcia Marquez\",  \"nickname\": \"Gabo\",  \"birthday\": \"1949-02-13\",  \"picture\": \"gaboselfie.jpg\"}"
curl -X POST "http://localhost:8080/v1/author/add" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"name\": \"Stephen\",  \"lastName\": \"Hawking\",  \"nickname\": \"Professor X\",  \"birthday\": \"1959-02-14\",  \"picture\": \"hawkingselfie.jpg\"}"

REM Actualizar autores
curl -X PUT "http://localhost:8080/v1/author/update?id=1" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"name\": \"Gabriel\",  \"lastName\": \"Garcia Marquez\",  \"nickname\": \"Gabo\",  \"birthday\": \"1927-03-06\",  \"picture\": \"gaboselfie.jpg\"}"
curl -X PUT "http://localhost:8080/v1/author/update?id=2" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"name\": \"Stephen\",  \"lastName\": \"Hawking\",  \"nickname\": \"Professor X\",  \"birthday\": \"1942-01-08\",  \"picture\": \"hawkingselfie.jpg\"}"

REM Asociar a libros
curl -X PUT "http://localhost:8080/v1/book/HAWK/author?id=2" -H  "accept: */*"
curl -X PUT "http://localhost:8080/v1/book/GABO/author?id=1" -H  "accept: */*"

REM Asociar a el libro de Hawking a Gabo, Hawking queda sin libros en BD y Gabo con dos
curl -X PUT "http://localhost:8080/v1/book/HAWK/author?id=1" -H  "accept: */*"

REM Crear editoriales
curl -X POST "http://localhost:8080/v1/publisher/add" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"brand\": \"Norma\"}"
curl -X POST "http://localhost:8080/v1/publisher/add" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"brand\": \"Salamandra\"}"

REM Asociar a libros
curl -X PUT "http://localhost:8080/v1/book/GABO/publisher?id=2" -H  "accept: */*"
curl -X PUT "http://localhost:8080/v1/book/HAWK/publisher?id=1" -H  "accept: */*"