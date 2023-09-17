package pe.edu.cibertec.apirestdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.apirestdemo.model.ResultadoResponse;

@RestController
@RequestMapping("api/operacion")
public class OperacionController {

    @GetMapping("")
    public ResponseEntity<String> saludoRest(){
        return new ResponseEntity<>("Hola Mundo",
                HttpStatus.OK);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<ResultadoResponse> saludoConParametro(
            @PathVariable("nombre") String nombre
    ){
        ResultadoResponse response = ResultadoResponse
                .builder()
                .respuesta(true)
                .mensaje("Hola "+ nombre+", bienvenido!")
                .build();
        return new ResponseEntity<>(response,
                HttpStatus.OK);
    }

    @GetMapping("/parametro")
    public ResponseEntity<ResultadoResponse> saludoConParametros(
          @RequestParam(value = "nombre") String nombres, //Especificando nombre del parametro
          @RequestParam(value = "apematerno", required = false, defaultValue = "Sin Apellido") String apellidoMaterno
    ){
        ResultadoResponse response = ResultadoResponse
                .builder()
                .respuesta(true)
                .mensaje("Hola "+ nombres+" "+apellidoMaterno+", bienvenido!")
                .build();
        return new ResponseEntity<>(response,
                HttpStatus.OK);
    }

}
