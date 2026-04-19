# Laboratorio: `04`

* **Indice:**

    1. [Como ejecutar los servicios localmente](#como-ejecutar-los-servicios-localmente)
    2. [Cómo levantar la solución con Docker Compose](#cómo-levantar-la-solución-con-docker-compose)
    3. [Las URLs de Swagger y H2 Console](#las-urls-de-swagger-y-h2-console)
    4. [Los usuarios de prueba](#los-usuarios-de-prueba)
    5. [El flujo correcto de uso del botón Authorize](#el-flujo-correcto-de-uso-del-botón-authorize)

* [**Captura de pantalla de las actividades minimas**](Documentacion/documentacion.md)


    ## Como ejecutar los servicios localmente

    * Para ejecutar de forma local los dos microservicios se debe:

        1. Compilar el microservicio `auth-service`

            * Para eso ingrese en el directorio `/microservicios-demoacademico/auth-service` y ejecute el siguiente comando:

            ```bash
            ./mvnw clean package -DskipTests
            ```
            * Esto generara el archivo **.jar** (ejecutable) en el directorio: `target`


        2. Compilar el microservicio `consulta-service`

            * Para eso ingrese en el directorio `/microservicios-demoacademico/consulta-service` y ejecute el siguiente comando:

            ```bash
            ./mvnw clean package -DskipTests
            ```
            * Esto generara el archivo **.jar** (ejecutable) en el directorio: `target`

        3. Levantar el microservicio `auth-service` de forma local 

            ```
            java -jar Laboratorio/microservicios-demoacademico/auth-service/target/auth-service-0.0.1-SNAPSHOT.jar
            ```

        4. Levantar el microservicio `consulta-service` de forma local 

            ```
            java -jar Laboratorio/microservicios-demoacademico/consulta-service/target/consulta-service-0.0.1-SNAPSHOT.jar
            ```

        > **Nota:** Esto en mi caso porque la variable de java esta asociada a mi raiz y pues no me deja si lo ejecuto directamente en el directorio.

    ##  Cómo levantar la solución con Docker Compose

    * Para poder levantar usando docker compose se necesita dos cosas:

        1. Los archivos Dockerfile de los microservicios
        2. El archivo `docker-compose.yml`

    * Primero validamos que existen los docker file y docker compose:

        ```bash
        ├── auth-service
        │   ├── Dockerfile
        │   ├── HELP.md
        │   ├── mvnw
        │   ├── mvnw.cmd
        │   ├── pom.xml
        │   ├── src
        │   └── target
        ├── consulta-service
        │   ├── Dockerfile
        │   ├── HELP.md
        │   ├── mvnw
        │   ├── mvnw.cmd
        │   ├── pom.xml
        │   ├── src
        │   └── target
        └── docker-compose.yml
        ```
    * Ejecutamos el docker compose:

        * Para ello nos ubicamos en el directorio donde esta el `docker-compose.yml`

        * Creamos la imagenes a partir de los Dockerfile:
            
            ```bash
            sudo docker compose build
            ```
        * Levantamos las imagenes:

            ```bash
            sudo docker compose up
            # si queremos en segundo plano
            sudo docker compose -d up
            ```
    * Si queremos eliminar los contenedores: 

        ```bash
        sudo docker compose down
        # si queremos eliminar volumenes
        sudo docker compose down -v
        ```

    * Si queremos ver los contenedores que se estan ejecutando:

        ```bash
        sudo docker ps
        ```


    ## Las URLs de Swagger y H2 Console

    * **Swagger de auth-service:** http://localhost:8081/swagger-ui.html
    * **Swagger de consulta-service:** http://localhost:8082/swagger-ui.html
    * **H2 Console de auth-service:** http://localhost:8081/h2-console
    * **H2 Console de consulta-service:** http://localhost:8082/h2-console

    ## Los usuarios de prueba


    |Usuario	|Contraseña	 |Rol       |
    |-----------|------------|----------|
    |admin	    |Admin2026*  |ADMIN     |
    |docente	|Docente2026*|DOCENTE   |
    |estudiante1|Estu2026*   |ESTUDIANTE|

    ## El flujo correcto de uso del botón Authorize.

    * Para poder usar los endpoints de consulta-service necesitan authorizacion se usa el boton Authorize el cual recibe el token que se genera al realizar login con un usuario en `auth-service`

        1. **Paso 1:** En auth-service ir al endpoint: `/auth/login` y logearse:

            ```json
            {
            "username": "admin",
            "password": "Admin2026*"
            }
            ``` 

        2. **Paso 2:** Colocar el token generado en consulta-service en el boton Authorization

        3. Ahora se tiene permiso para usar los endpoints.

    > **Nota:** La autenticacion no valida roles usuario `estudiante1` puede ejecutar eliminaciones y actualizaciones de estudiantes esto deberia estar limitado por roles tarea solo permitida para ADMIN, actualizacion podria tambien ser ejecuta por DOCENTE.

