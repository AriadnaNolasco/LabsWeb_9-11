package com.tecsup.demo.modelo.daos;

import com.tecsup.demo.modelo.entidades.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, String> {

}
