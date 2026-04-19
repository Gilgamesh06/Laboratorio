# Documentacion 

* A continuacion se realizara el conjunto de actividades del `Lab 04`

    ## Ejecutar los dos contenedores 

    ![**docker ps**](img/docker_ps.png)

    ## Pruebas obligatorias en Swagger

    1. **URLs que debe verificarse**

        * Swagger de auth-service: `http://localhost:8081/swagger-ui.html`

            ![**Swagger auth-service**](img/swagger_auth_service.png)

        * Swagger de consulta-service: `http://localhost:8082/swagger-ui.html`

            ![**Swagger de consulta-service**](img/swagger_consulta_service.png)

        * H2 Console de auth-service: `http://localhost:8081/h2-console`

            * No permite conexion: `webAllowOthers`

                ![**H2 Console remote conection no permit**](img/web_allow_others.png)

            * Para permitir agregar esto en el `application.yml`

                ```yaml
                  h2:
                    console:
                    settings:
                        web-allow-others: true
                    enabled: true
                    path: /h2-console
                ```

            ![**Console de auth-service**](img/h2_auth_service.png)

        * H2 Console de consulta-service: `http://localhost:8082/h2-console`

            ![**Console de consulta-service**](img/h2_consulta_service.png)


    
    ## Actividades minimas obligatorias


    1. **Realizar login existoso con un usuario válido**

        ![**Login exitoso**](img/post_login_auth_service.png)

    2. **Realziar login fallido con contraseña incorrecta**

        ![**Login incorrecto**](img/login_incorrecto.png)

    3. **Validar manualmente un token válido**

        ![**Validate token**](img/validate_token.png)

    
    4. **Consumir GET /api/estudiantes con un token válido.**

        
        * Colocar token en Authorize

            ![**Authorize**](img/authorize_buttom.png)

        * Ejecutar GET `/api/estudiantes`

            ![**Estudiantes**](img/get_estudiantes.png)


    5. **Consumir GET /api/estudiantes sin autorizar en Swagger.**

        ![**Get sin autorizar**](img/get_sin_autorizar.png)

    6. **Consumir GET /api/estudiantes con token inválido.**

        ![**Get token invalido**](img/get_token_invalido.png)