## Clinica
## Spring Boot 3
## Instructor: Diego Rojas
## Alura Latam

| Clase | Pasos                                                                               | Errores/Observación                         |
|-------|-------------------------------------------------------------------------------------|---------------------------------------------|
| 01-01 | Creando proyecto con Spring Boot 3                                                  |                                             |
|       | se ingresa a https://start.spring.io/                                               |                                             |
|       | se configura y se agregan 3 dependencias                                            |                                             |
|       | 1. Spring Boot Dev Tools<br/>2. Lombok <br/>3. Spring Web                           |                                             |
|       |                                                                                     |                                             |
| 01-06 | Estructura proyecto                                                                 | ![img.png](img.png)                         |
|       | se verifican las dependencias en maven                                              |                                             |
|       | se verifica la estructura del proyecto                                              | ![img_1.png](img_1.png)                     |
|       |                                                                                     |                                             |
| 01-07 | Hello World                                                                         |                                             |
|       | se crea el paquete controller luego la clase HelloController                        |                                             |
|       | se le coloca la anotacion al controlador: @RestController                           |                                             |
|       | se agrega la anotacion en el controlador @RequestMapping("/hello")                  | ![img_2.png](img_2.png)                     |
|       | se crea el metodo helloWorld(), con su @GetMapping                                  |                                             |
|       |                                                                                     |                                             |
| 02-02 | Enviando datos                                                                      | ![img_3.png](img_3.png)                     |
|       | se debe descargar insomia, para pruebas de api                                      |                                             |
|       | https://insomnia.rest/download                                                      |                                             |
|       | se crea el nuevo http request                                                       | ![img_4.png](img_4.png)                     |
|       | se verifica conexion con spring, y el endpoint                                      | ![img_5.png](img_5.png)                     |
|       | se puede enviar un datos json y ver que da error pero si establece la conexión      |                                             |
|       |                                                                                     |                                             |
| 02-03 | Recibiendo datos                                                                    |                                             |
|       | se crea MedicoController                                                            |                                             |
|       | se le coloca @RestController                                                        |                                             |
|       | se agrega el requestmapping  @RequestMapping("/medicos")                            |                                             |
|       | se crea el metodo registrarMedico, como recibe datos entonces se agrega su:         | ![img_6.png](img_6.png)                     |
|       | @PostMapping                                                                        |                                             |
|       | los datos que se envian son el @RequestBody                                         | ![img_7.png](img_7.png)                     |
|       |                                                                                     |                                             |
| 02-05 | CORS                                                                                |                                             |
|       | se crea el paquete de configuration                                                 |                                             |
|       | se agrega la clase corsconfiguration                                                |                                             |
|       | se agrega el codigo, CORS                                                           |                                             |
|       |                                                                                     |                                             |
| 02-06 | DTO Java Record #1                                                                  |                                             |
|       | se crea un record para mapear los parametros que se reciben de los datos del medico |                                             |
|       | en el nuevo paquete model, el tipo record DatosRegistroMedico                       |                                             |
|       | se crea la clase enum especialidad, con 4 especialidades                            | ![img_8.png](img_8.png)                     |
|       | se crea la clase record datosDireccion,                                             | muestra ok, solo envio datos, sin direccion |
|       |                                                                                     |                                             |
| 02-07 | DTO Java Record #2                                                                  | ![img_9.png](img_9.png)                     |
|       | se revisa el formato del dto y del json que se envia, todo ok                       |                                             |
|       | revision de las validaciones                                                        | ![img_10.png](img_10.png)                   |
|       | https://docs.oracle.com/en/java/javase/16/language/records.html                     |                                             |
|       | probando git                                                                        |                                             |


### CORS
    @Configuration
    public class CorsConfiguration implements WebMvcConfigurer {
    
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
        }
    }

### Json enviado en pruebas con insomia:
    `
    {
        "nombre":"luis",
        "email":"sanchez@gmail.com",
        "documento":"1114277",
        "especialidad":"ODONTOLOGIA",
        "direccion":
            {
            "calle":"pppal",
            "distrito":"distrito 1",
            "ciudad":"bucaramanga",
            "numero":"20",
            "complemento":"cerca de aqui"
            }
    }
    `
