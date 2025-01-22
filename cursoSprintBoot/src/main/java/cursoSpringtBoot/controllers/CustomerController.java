package cursoSpringtBoot.controllers;

import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import cursoSpringtBoot.domain.Customer;
import jakarta.servlet.Servlet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    // se crea Data
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123,1,"Patricio Caldero","p1","123321"),
            new Customer(456,2,"Usuario1","u1","321123"),
            new Customer(789,2,"Usuario2","u2","231123"),
            new Customer(234,2,"Usuario3","u3","111333")
    ));

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public  ResponseEntity<List<Customer>> getCustomer(){
        return  ResponseEntity.ok(customers);
        // return customers;
    }

    //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public ResponseEntity<?> getCliente(@PathVariable String username){//
        for(Customer c : customers){
            if(c.getUsername().equalsIgnoreCase(username)){
               // System.out.println(getTipoCliente(username));
               // return c;
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con username : " + username);
    }

    //@RequestMapping(method = RequestMethod.POST)
    //post
    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Customer customer){
        customers.add(customer);
        //return ResponseEntity.status(HttpStatus.CREATED).body("El cliente fue creado con user name :" + customer.getUsername());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(customer.getUsername())
                .toUri();

        //return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(customer);
    }
    //@RequestMapping(method = RequestMethod.PUT)
    //PUT
    @PutMapping
    public ResponseEntity<?> putCliente(@RequestBody Customer customer){
        //iterar para modificar
        for (Customer c : customers){
            if(c.getID() == customer.getID()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                //return ResponseEntity.ok("Cliente modificado satifactoriamente : " +customer.getID() );
                return ResponseEntity.noContent().build();
            }
        }
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID de cliente no encontrado : "+ customer.getID());
        return ResponseEntity.noContent().build();
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable int id ){
        for (Customer c : customers){
            if(c.getID() == id){
                customers.remove(c);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El cliente fue eliminado satifactroriamente : " + c.getID());
            }
        }
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado : " + id);
        return ResponseEntity.noContent().build();
    }

    //@RequestMapping(method = RequestMethod.PATCH)
    // PATCH
    @PatchMapping
    public ResponseEntity<?> patchCliente(@RequestBody Customer customer){
        //iterar para modificar
        for (Customer c : customers){
            if(c.getID() == customer.getID()) {
                if(customer.getName() != null){
                    c.setName(customer.getName());
                }
                if(customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if(customer.getPassword()!= null ){
                    c.setPassword(customer.getPassword());
                }
                return ResponseEntity.ok(c);
            }

        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("EL campo no existe : " + customer.getID());
    }




    /**
     *     // para mostrar en web
     *     @GetMapping("/usuarios/{username}")
     *     public ResponseEntity<String> pae(@PathVariable String username) {
     *         for (Customer c : customers) {
     *             if (c.getUsername().equalsIgnoreCase(username)) {
     *                 return ResponseEntity.ok("Bienvenido " + c.getName());
     *             }
     *         }
     *         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
     *     }
     * */

}
