package com.crudAlumnos.controllers;


import com.crudAlumnos.AlumnosApplication;
import com.crudAlumnos.dataAlumnos.ListaAlumnos;
import com.crudAlumnos.domain.Alumnos;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnosControllers {

    ListaAlumnos la = new ListaAlumnos();
    // trae a todos los alumnos
    @RequestMapping(method = RequestMethod.GET)
    public List<Alumnos> getAlumno(){
        return la.alumnos;
    }
    //Busca al alumno por medio del mail
    @RequestMapping(value = "{email}", method = RequestMethod.GET)
    public Alumnos getAlumnoEmail(@PathVariable String email){
        for(Alumnos a : la.alumnos){
            if(a.getEmail().equalsIgnoreCase(email)){
                return a;
            }
        }
        return null;
    }
    // Agrega un nuevo registro
    @RequestMapping(method = RequestMethod.POST)
    public Alumnos postAlumno(@RequestBody Alumnos alumnos){
        la.alumnos.add(alumnos);
        return alumnos;
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT)
    public Alumnos putAlumno(@RequestBody Alumnos alumnos){
        for (Alumnos a : la.alumnos){
            if(a.getId() == alumnos.getId()){
                a.setNombre(alumnos.getNombre());
                a.setCurso(alumnos.getCurso());
                a.setEmail(alumnos.getEmail());
                a.setEdad(alumnos.getEdad());
                return a;
            }

        }
        return null;
    }

    /**
     *
     * @param alumnos Modifica el parametro espesifico
     *                este se busca por ID
     * @return el alumno con la modificación
     */
    //PATCH
    @RequestMapping(method = RequestMethod.PATCH)
    public Alumnos patchAlumno(@RequestBody Alumnos alumnos){
        for (Alumnos a : la.alumnos){
            if(a.getId() == alumnos.getId()){
                if(alumnos.getNombre() != null){
                    a.setNombre(alumnos.getNombre());
                }
                if(alumnos.getCurso() != null){
                    a.setCurso(alumnos.getCurso());
                }
                if(alumnos.getEdad() != -1){
                    a.setEdad(alumnos.getEdad());
                }
                if(alumnos.getEmail() != null){
                    a.setEmail(alumnos.getEmail());
                }
                return a;
            }

        }
        return null;
    }

    /**
     *
     * @param id el ID del alumno para buscarlo e eliminar
     * @return al alumno eliminado
     */
    //DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Alumnos deleteAlumno(@PathVariable int id){
        for(Alumnos a : la.alumnos){
            if(a.getId() == id){
                la.alumnos.remove(a);
                return a;
            }
        }
        return null;
    }






}
