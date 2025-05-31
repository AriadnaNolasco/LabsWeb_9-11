package com.tecsup.demo.modelo.daos;

import com.tecsup.demo.modelo.entidades.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Integer> {
}
