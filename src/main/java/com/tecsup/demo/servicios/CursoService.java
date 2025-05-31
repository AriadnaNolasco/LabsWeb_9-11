package com.tecsup.demo.servicios;

import com.tecsup.demo.modelo.entidades.Curso;
import java.util.List;

public interface CursoService {

    public List<Curso> listar();

    public void grabar(Curso curso);

    public Curso buscar(Integer id);

    public void eliminar(Integer id);
}
