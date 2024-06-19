## APP Clinica
## Spring Boot 3 => spring-boot-3- aplique practicas proteja api rest
## Instructor: Diego Rojas
## Alura Latam

| Clase | Pasos                                                                                          | Errores/Observación                                |
|-------|------------------------------------------------------------------------------------------------|----------------------------------------------------|
|       | Iniciando rama para esta parte del curso                                                       |                                                    |
|       |                                                                                                |                                                    |
| 01-03 | Estandarizando retornos de API                                                                 |                                                    |
|       | Es necesario enviar respuestas mas claras al cliente                                           |                                                    |
|       | con codigos personalizados ejem: 201 y no solo 200                                             |                                                    |
|       | en el metodo eliminarMedico() que es public void                                               |                                                    |
|       |                                                                                                |                                                    |
|       | **PARA DELETE**                                                                                |                                                    |
|       | se debe cambiar por ResponseEntity para que spring ayude a retornar                            |                                                    |
|       | el valor especifico, ahora obliga al metodo a responder                                        | ahora tenemos esta respuesta:                      |
|       | para este caso return ResponseEntity.noContent().build();                                      | ![img_1.png](img_1.png)                            |
|       |                                                                                                |                                                    |
|       | **PARA UPDATE**                                                                                |                                                    |
|       | igual se agrega al metodo la respuesta ResponseEntity, pero tambien                            | ahora da respuesta 200 ok + info                   |
|       | es necesario agregar un nuevo DTO que solo devuelva los datos necesarios                       | ![img_2.png](img_2.png)                            |
|       |                                                                                                |                                                    |
| 01-04 | Devolviendo el codigo 201                                                                      |                                                    |
|       | **PARA POST**  agregar medico                                                                  |                                                    |
|       | API REST es un standar, y pide indiferentemente del lenguaje                                   |                                                    |
|       | para el caso de POST:                                                                          |                                                    |
|       | 1. retornar  201+ created                                                                      |                                                    |
|       | 2. la url donde esta el nuevo recurso guardado  id = xx                                        |                                                    |
|       | - ejem: GET: http://localhost:8080/medico/xx   se deberia ver el medico                        |                                                    |
|       | ---                                                                                            |                                                    |
|       | se cambia void por ResponseEntity                                                              |                                                    |
|       | se agrega la variable: Medico medico = medicoRepository.save(new Medico(datosRegistroMedico)); |                                                    |
|       | se re utiliza el dto de datosRespuestaMedico() para retornar esos datos y no la entidad        |                                                    |
|       | como es necesario retornar una URL entonces se usa en la clase un helper de spring para eso:   | nuevo id agregado:                                 |
|       | UriComponentsBuilder en los parametros                                                         | ![img_3.png](img_3.png)                            |
|       | URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();   | en el header devuelve la url:                      |
|       |                                                                                                | ![img_4.png](img_4.png)                            |
| 01-05 | Detallando los datos de API                                                                    |                                                    |
|       | Un error 405 dice que el metodo no esta habilitado o implementado, en nuestro caso existe      | esto daba error  de proxy. buscando con la ia      |
|       | el metodo get para el listado de medicos, pero no para un medico en especifico                 | me dice que falta: @Transactional(readOnly = true) |
|       | su usa ahora un wrapper o envoltorio para el getmappin del listado de medicos                  | en el metodo. agregado y ahora si funciona.        |
|       |                                                                                                |                                                    |
| 02-02 | Tratando los errores de API                                                                    |                                                    |
|       | Por ejemplo el error 500 devuelve mucha informacion en el "tracer", info sensible              |                                                    |
|       | lo cual son brechas de seguridad que puede ser usadas por hackers                              |                                                    |
|       | se debe configurar el application.properties                                                   |                                                    |
|       | se busca en google: spring boot properties                                                     |                                                    |
|       | https://docs.spring.io/spring-boot/appendix/application-properties/index.html                  | ![img_5.png](img_5.png)                            |
|       | en el aprtado: server properties (a la derecha)                                                |                                                    |
|       | server.error.include-stacktrace=never                                                          |                                                    |
|       |                                                                                                |                                                    |
| 02-03 | Tratando el error 404 #1                                                                       |                                                    |
|       | la excepcion cuando se busca un medico que no existe es: EntityNotFoundException               |                                                    |
|       | y deberia devolver el erro 404 que es no encontrado y no error 500 que es de servidor          |                                                    |
|       | para tratar la excepcion se puede usar try-catch, pero spring ya trae un opcion                |                                                    |
|       | 1. se crea nuevo paquete - infra                                                               |                                                    |
|       | 2. se crea nueva clase TratadorDeErrores.java  para tratar los errores de manera global        |                                                    |
|       |                                                                                                |                                                    |
| 02-04 | Tratando el error 404 #2                                                                       |                                                    |
|       | se crea el metodo en la clase tratadorDeErrores, con la anotacion:  @RestControllerAdvice      | ![img_6.png](img_6.png)                            |
|       | @ExceptionHandler y la excepcion: EntityNotFoundException.class                                |                                                    |
|       |                                                                                                |                                                    |
|       |                                                                                                |                                                    |


### Objetivos:

![img.png](img.png)


### Payload para actualizar un medico. en insomia, metodo PUT, actualizar solo el nombre

    {
			"id": 1,
			"nombre": "nombre 11"
    }

