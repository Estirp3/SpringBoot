package cursoSpringtBoot.controllers;

import cursoSpringtBoot.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    // se crea Data
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123,1,"Patricio Caldero","p1","123321"),
            new Customer(456,2,"Usuario1","u1","321123"),
            new Customer(789,2,"Usuario2","u2","231123"),
            new Customer(234,2,"Usuario3","u3","111333")
    ));
    @GetMapping("/clientes")
    public List<Customer> getCustomer(){
        return customers;
    }
    @GetMapping("/clientes/{username}")
    public Customer getCliente(@PathVariable String username){
        for(Customer c : customers){
            if(c.getUsername().equalsIgnoreCase(username)){
               // System.out.println(getTipoCliente(username));
                return c;
            }
        }
        return null;
    }

    //post
    @PostMapping("/clientes")
    public Customer postCliente(@RequestBody Customer customer){
        customers.add(customer);
        return customer;

    }

    //PUT
    @PutMapping("/clientes")
    public Customer putCliente(@RequestBody Customer customer){
        //iterar para modificar
        for (Customer c : customers){
            if(c.getID() == customer.getID()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return c;
            }

        }

        return null;
    }

    //DELETE
    @DeleteMapping("/clientes/{id}")
    public Customer deleteCliente(@PathVariable int id ){
        for (Customer c : customers){
            if(c.getID() == id){
                customers.remove(c);
                return c;
            }
        }
        return null;
    }
    // PATCH
    @PatchMapping("/clientes")
    public Customer patchCliente(@RequestBody Customer customer){
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
                return c;
            }

        }

        return null;
    }

    // verlo después
     //public int getTipoCliente(String username){
     //    for ( Customer c : customer){
     //        if(c.getUsername().equalsIgnoreCase(username)){
     //            if(c.getTipoCliente() == 1){
     //                return 1;
     //            }else{}
     //        }
     //    }
     //    return 2;
     //}


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
