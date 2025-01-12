package Palindormo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import validadorPal.ValidaroPal;

@RestController
public class PalindromoController {


    ValidaroPal val = new ValidaroPal();

    /**
     * Endpoint para verificar si una palabra es un palindromo o no
     * @param name la palabra a verificar
     * @return un mensaje indicando si la palabra es un palindrome o no
     */
    @GetMapping("/pal/{name}")
    public String lector(@PathVariable String name){
        if(val.isPalindrome(name)){
            return "La palabra escrita  " + name + ": SI es un palindromo";
        }else{
            return "La palabra escrita  " + name + ": NO es un palindromo";
        }
    }

}
