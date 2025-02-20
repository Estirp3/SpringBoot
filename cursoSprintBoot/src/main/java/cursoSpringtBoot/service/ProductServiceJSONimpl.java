package cursoSpringtBoot.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cursoSpringtBoot.domain.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Primary
@Service("jsonResourceService")
public class ProductServiceJSONimpl implements ProductService{

    //Deserialización combierte el json en lista java
    //serialización cobuierte una lista Java en JSON

    @Override
    public List<Product> getProducts() {
        List<Product> products;
        try {
           products = new ObjectMapper()
                   .readValue(this.getClass().getResourceAsStream("/products.json"),
                           new TypeReference<List<Product>>() {});
           return products;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
