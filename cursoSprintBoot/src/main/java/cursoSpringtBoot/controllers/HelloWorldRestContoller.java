package cursoSpringtBoot.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestContoller {

    @GetMapping({"/hello","/hw","/hola"})
    public String helloWord(){
        System.out.println("Solicitud Ejecutada");
       return "Hola, Mundo!";
    }





}
