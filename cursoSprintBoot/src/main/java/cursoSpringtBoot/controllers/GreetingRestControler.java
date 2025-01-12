package cursoSpringtBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestControler {

    @GetMapping({"/saludo/{name}","/hola/{name}"})//optiene la ruta donde ejecutar, tambien reseve parametro
    public String greeting(@PathVariable String name){//resive el nombre que se escibew en la rua EJ loclhost:8080
        return "Hola " + name;
    }

}
