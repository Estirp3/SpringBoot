package cursoSpringtBoot.service;

import cursoSpringtBoot.domain.Customer;
import cursoSpringtBoot.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Laptop", 799.99, 10),
            new Product(2, "Audifonos", 69.25, 25),
            new Product(3, "Mouse logitech", 20.2, 15),
            new Product(4, "consola PS%", 450.20, 30)
    ));

   // Retornando la lsita de productos
   @Override
   public List<Product> getProducts(){
       return products;
   }

   


}
