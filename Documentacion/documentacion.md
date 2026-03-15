# Documentacion 

* **Diagrama de Arquitectura en Capas**

    ![**Capas SpringBoot**](/Documentacion/img/Capas.png)

* **Capturas de Pantalla de H2**

    1. **Pagina de Login**

        ![**H2**](/Documentacion/img/login.png)

        * Se debe cambiar el valor de **JDBC URL** por: `jdbc:h2:mem:demoacademico;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`
    
    2. **Consulta SELECT**

        ![**SELECT**](/Documentacion/img/select.png)

        * Se realizo una consulta `SELECT * FROM estudiante;` y cargo de forma correcta los tres estudiante que se crean mediante el `data.sql`

    3. **Insercion de Usuario**

        ![**View User Insert**](/Documentacion/img/insert.png)

        * Se realizo la insercion del usuario por medio del api (*SpringBoot*)

            ```json
            {
                "nombre":"Dario",
                "email":"dario@demo.com"
            }
            ```

        * Y se confirmo mediante su visualizacion en el **H2**

    
    ## Falencias de la arquitectura en Capas

    1. La arquitectura en capas tiene un alto acoplamiento por ejemplo cuando yo estudiaba los principios **SOLID** uno de los principios es que uno no instacia contra clases sino contra interfaces (es decir contratos) de esta forma las clases no saben como se implementan y se puede modificar sin necesitada de hacer cambios en la clase que esta inyectando la interfaz, pero esto no es claro en Spring por ejemplo si yo:

        ```java
        
        @RestController
        @RequestMapping("api/v1/student")
        class StudentController {
            // StudentService es una interfaz
            private final StudentService studentServiceImpl

            public StudentController(studentService studentServiceImpl){
                this.studentServiceImpl = studentServiceImpl
            }
        }
        ```
        * Esto solo funciona si solo hay una implementacion de la interfaz StudentService ya que si hay mas de una interfaz toca decirle de forma explicita que interfaz usar esto no es una aplicacion completa de SOLID por lo cual en menor medida hay alto acoplamiento

        ```java
        @Controller
        public class StudentController {

            private final StudentService studentService;

            @Autowired
            public StudentController(@Qualifier("specificStudentService") StudentService studentService) {
                this.studentService = studentService;
            }
        }
        ```
        * Aqui se utiliza la anotacion`@Qualifier` para indicarle a SpringBoot cual es la implemetacion que debe usar
        * Tambien existe anotaciones como `@Primary` que se coloca sobre la implementacion que queremos dejar como default     

    2. Al tener dividido tantas funciones en diferentes capas es bastante molesto al realizar pruebas unitarias debido a que todos estos componentes se deben Mockear y esto aveces puede tener problemas Ej: una vez cuando trabaje en un proyecto de Software II al realizar las pruebas unitarias para el microservicio de carrito de compras no podia debido a que el carrito funcionaba usando Redis (en forma de cache) pero en mi clase yo utilizaba la siguiente `<String,String, Producto> hashOperations;` y a la hora de realizar los test no me dejaba ya que aunque en codigo aceptaba `String,String` en test algo muy estraño donde el polimorfismo si servia en la aplicacion normal pero a la hora de mockear no servia 

    3. Por ultimo esta la falencia (personalmente me da igual pero hay gente que le molesta), la cual es que el codigo puede volverse muy extenso pues no solo de por si Java es un leguaje verboso sino  que al dividir todo en capas y clases hace que el codigo sea mas extenso de lo que necesariamente tiene que ser.

