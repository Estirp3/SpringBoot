package cursoSpringtBoot.controllers;


import cursoSpringtBoot.domain.Product;
import cursoSpringtBoot.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    // ProductService productsService = new ProductServiceImpl();//polimorfismo dinamico
    // Inyeccion de Depedencias

    @Autowired // inyeccion de dependencia por campo
    @Qualifier("jsonResourceService")
    private ProductService productsService; // intanziamos a la interface

    @GetMapping
    public ResponseEntity<?> getProductos(){//
        List<Product> products = productsService.getProducts();
        return ResponseEntity.ok(products);
    }

}
