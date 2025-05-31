package com.tecsup.demo.servicios;

import com.tecsup.demo.modelo.entidades.Alumno;

import java.util.List;

public interface AlumnoService {
    public List<Alumno> listar();
    public void grabar(Alumno alumno);
    public Alumno buscar(String codigo);
    public void eliminar(String codigo);
}
