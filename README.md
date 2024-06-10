## Clinica
## Spring Boot 3
## Instructor: Diego Rojas
## Alura Latam

| Clase | Pasos                                                                          | Errores/Observación     |
|-------|--------------------------------------------------------------------------------|-------------------------|
| 01-01 | Creando proyecto con Spring Boot 3                                             |                         |
|       | se ingresa a https://start.spring.io/                                          |                         |
|       | se configura y se agregan 3 dependencias                                       |                         |
|       | 1. Spring Boot Dev Tools<br/>2. Lombok <br/>3. Spring Web                      |                         |
|       |                                                                                |                         |
| 01-06 | Estructura proyecto                                                            | ![img.png](img.png)     |
|       | se verifican las dependencias en maven                                         |                         |
|       | se verifica la estructura del proyecto                                         | ![img_1.png](img_1.png) |
|       |                                                                                |                         |
| 01-07 | Hello World                                                                    |                         |
|       | se crea el paquete controller luego la clase HelloController                   |                         |
|       | se le coloca la anotacion al controlador: @RestController                      |                         |
|       | se agrega la anotacion en el controlador @RequestMapping("/hello")             | ![img_2.png](img_2.png) |
|       | se crea el metodo helloWorld(), con su @GetMapping                             |                         |
|       |                                                                                |                         |
| 02-02 | Enviando datos                                                                 | ![img_3.png](img_3.png) |
|       | se debe descargar insomia, para pruebas de api                                 |                         |
|       | https://insomnia.rest/download                                                 |                         |
|       | se crea el nuevo http request                                                  | ![img_4.png](img_4.png) |
|       | se verifica conexion con spring, y el endpoint                                 | ![img_5.png](img_5.png) |
|       | se puede enviar un datos json y ver que da error pero si establece la conexión |                         |
|       |                                                                                |                         |
| 02-03 | Recibiendo datos                                                               |                         |
|       | se crea MedicoController                                                       |                         |
|       | se le coloca @RestController                                                   |                         |
|       | se agrega el requestmapping  @RequestMapping("/medicos")                       |                         |
|       | se crea el metodo registrarMedico, como recibe datos entonces se agrega su:    | ![img_6.png](img_6.png)                        |
|       | @PostMapping                                                                   |                         |
|       | los datos que se envian son el @RequestBody                                    |  ![img_7.png](img_7.png)                       |
|       |                                                                                |                         |

