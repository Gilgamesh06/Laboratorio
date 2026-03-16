# Documentacion 

* A continuacion se realizara la muestra del nuevo conjunto de pruebas acorde al nueva estructura del proyecto demoacademico

* **Nota:** En el laboratorio se especifica ralizar las siguientes pruebas:

    1. `POST` estudiante válido → respuesta exitosa
    2. `POST` email inválido → 400 (validación)
    3. `POST` email duplicado → error controlado (A: 400, B: 409)
    4. `GET` paginado → 200
    5. `GET` buscar por email inexistente → 404 (en B) / 404 (en A si agregas endpoint)

* Utilizando la herramienta Swagger

    ![**Swagger**](/Documentacion/img/swagger.png)

* Pero ya que hemos trabajado en el `laboratorio 01` con Postman seguiremos usandolo para esta.

    ## 1. `POST` estudiante válido → respuesta exitosa (`http://localhost:8080/api/estudiantes`)

    * Cuerpo de la solicitud

        ```json
        {
        "nombre":"Dario",
        "email":"dario@demo.com"
        }
        ```
    
    ![**Estudiante Valido**](/Documentacion/img/estudiante_valido.png)

    ## 2. `POST` email inválido → 400 (validación) (`http://localhost:8080/api/estudiantes`)

    * Cuerpo de la solicitud

        ```json
        {
        "nombre": "Pepito Peres",
        "email": "correoInvalido"
        }
        ```
    
    ![**Email inválido**](/Documentacion/img/email_invalido.png)

    ## 3. `POST` email duplicado → error controlado (A: 400, B: 409)  (`http://localhost:8080/api/estudiantes`)

    * Cuerpo de la solicitud

        ```json
        {
        "nombre": "Ana Rodriguez",
        "email": "ana@demo.com"
        }
        ```
    
    ![**Email Duplicado**](/Documentacion/img/email_duplicado.png)

    ## 4. `GET` paginado → 200 (`http://localhost:8080/api/estudiantes?page=0&size=5&sort=nombre,asc`)

    ![**Get Pagínado**](/Documentacion/img/get_paginado.png)

    ## 5. `GET` buscar por email inexistente → 404 (en B) / 404 (en A si agregas endpoint) (`http://localhost:8080/api/estudiantes/email/sara@demo.com`)

    ![**Email No Existente**](/Documentacion/img/email_no_existente.png)

    ## Funcionamiento de Seeder con Faker

    ![**Data Automatica**](/Documentacion/img/seeder.png)