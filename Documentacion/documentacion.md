# Documentacion 

* A continuacion se realizara la muestra del nuevo conjunto de pruebas acorde al nueva estructura del proyecto demoacademico

* **Nota:** En el laboratorio se especifica ralizar las siguientes Actividades: que ya se realizaron en la parte uno para validar que se hicieron de nuevo puede utilizar el timestamp de las capturas de pantalla.

    1. Arranca la app
    2. Entra a Swagger: http://localhost:8080/swagger-ui.html
    3. Entra a H2: http://localhost:8080/h2-console y verifica conteos

        ```sql
        SELECT COUNT(*) FROM programa;
        SELECT COUNT(*) FROM asignatura;
        SELECT COUNT(*) FROM grupo;
        SELECT COUNT(*) FROM matricula;
        ```
    4. Pruebas en Swagger

        1. `POST` Programa
        2. `POST` Asignatura con programaId
        3. `POST` Grupo con asignaturaId y cupoMax=2
        4. `POST` Estudiante (o usa seed)
        5. `POST` Matrícula 1 (OK)
        6. `POST` Matrícula 2 (OK)
        7. `POST` Matrícula 3 al mismo grupo (debe fallar por cupo)
        8. `POST` Matrícula duplicada (debe fallar por duplicado)

        * Pero ya que hemos trabajado en el `laboratorio 01 y 02` con Postman seguiremos usandolo para esta.

    ## 1. Arranca la app

    ![**Run App**](/Documentacion/img/run_app.png)


    ## 2. Entra a Swagger: `http://localhost:8080/swagger-ui.html`

    ![**Swagger**](/Documentacion/img/swagger.png)
    
    ## 3. Entra a H2: http://localhost:8080/h2-console y verifica 

    ```sql
    SELECT COUNT(*) FROM programa;
    SELECT COUNT(*) FROM asignatura;
    SELECT COUNT(*) FROM grupo;
    SELECT COUNT(*) FROM matricula;
    ```
    
    ![**SQL Querys**](/Documentacion/img/sql_querys.png)
    
    ## 4. Pruebas en Swagger

    * A continuacion se realizaran las pruebas pero usando Postman

        ### 1. `POST` Programa: `http://localhost:8080/api/programas`

        * Cuerpo de la solicitud

            ```json
            {
            "codigo": "PROG-ING",
            "nombre": "Ingeniería de Software"
            }
            ```
        
        ![**POST Programa**](/Documentacion/img/post_programa.png)

        ### 2. `POST` Asignatura con programaId `http://localhost:8080/api/asignaturas`

        * Cuerpo de la solicitud

            ```json
            {
            "codigo": "ASIG-IS3",
            "nombre": "Ingeniería de Software III",
            "creditos": 3,
            "programaId": 1
            }
            ```

        ![**Post Asignatura**](/Documentacion/img/post_asignatura.png)

        ### 3. `POST` Grupo con asignaturaId y cupoMax=2 `http://localhost:8080/api/grupos`

        * Cuerpo de la solicitud

            ```json
            {
            "codigoGrupo": "G-IS3-01",
            "cupoMax": 2,
            "asignaturaId": 1
            }
            ```

        ![**Post Grupo**](/Documentacion/img/post_grupo.png)

        ### 4. `POST` Estudiante Se uso un seed 

        ### 5. `POST` Matrícula 1 (OK) `http://localhost:8080/api/matriculas`

        * Cuerpo de la solicitud

            ```json
            {
            "estudianteId": 1,
            "grupoId": 1
            }
            ```

        ![**Post Matrícula**](/Documentacion/img/post_matricula_1.png)

        ### 6. `POST` Matrícula 2 (OK) `http://localhost:8080/api/matriculas`

        * Cuerpo de la solicitud

            ```json
            {
            "estudianteId": 2,
            "grupoId": 1
            }
            ```
        
        ![**Post Matrícula**](/Documentacion/img/post_matricula_2.png)

        ### 7. `POST` Matrícula 3 al mismo grupo (debe fallar por cupo) `http://localhost:8080/api/matriculas`

        * Cuerpo de la solicitud

            ```json
            {
            "estudianteId": 3,
            "grupoId": 1
            }
            ```
        
        ![**Exception Cupo no disponible**](/Documentacion/img/cupo_no_disponible.png)

        ### 8. `POST` Matrícula duplicada (debe fallar por duplicado) `http://localhost:8080/api/matriculas`

        * Cuerpo de la solicitud

            ```json
            {
            "estudianteId": 1,
            "grupoId": 1
            }
            ```
        
        ![**Exception estudiante ya matriculado en el grupo**](/Documentacion/img/estudiante_ya_matriculado.png)        