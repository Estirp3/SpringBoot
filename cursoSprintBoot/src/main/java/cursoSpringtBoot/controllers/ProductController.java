package cursoSpringtBoot.controllers;


import cursoSpringtBoot.domain.Product;
import cursoSpringtBoot.service.ProductService;
import cursoSpringtBoot.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {
    // Instancia de clase
    // ProductService productsService = new ProductServiceImpl();//polimorfismo dinamico
    @Autowired // inyeccion de dependencia por campo
    private ProductService productsService;

    @GetMapping
    public ResponseEntity<?> getProductos(){//
        List<Product> products = productsService.getProducts();
        return ResponseEntity.ok(products);
    }

}
