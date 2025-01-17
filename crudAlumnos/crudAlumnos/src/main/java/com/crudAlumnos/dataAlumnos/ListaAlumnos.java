package com.crudAlumnos.dataAlumnos;

import com.crudAlumnos.domain.Alumnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaAlumnos {

    public List<Alumnos> alumnos = new ArrayList<>(Arrays.asList(
            new Alumnos(321,"Patricio Calderon", "Pcalder@gmail.cl", 18, "Univisersidad"),
            new Alumnos(543,"Alfonso Calderon", "ALcalder@gmail.cl", 15, "2-M°A"),
            new Alumnos(654,"Alexander Calderon", "Alecalder@gmail.cl", 12, "6°A"),
            new Alumnos(765,"Alfredo Calderon", "Alfcalder@gmail.cl", 7, "2°A")


    ));
}
