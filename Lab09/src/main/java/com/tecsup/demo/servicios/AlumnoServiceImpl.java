package com.tecsup.demo.servicios;
import com.tecsup.demo.modelo.entidades.Alumno;
import com.tecsup.demo.modelo.daos.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    private AlumnoRepository dao;

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> listar() {
        return (List<Alumno>) dao.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void grabar(Alumno alumno) {
        dao.save(alumno);
    }

    @Override
    @Transactional(readOnly = true)
    public Alumno buscar(String codigo) {
        return dao.findById(codigo).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void eliminar(String codigo) {
        dao.deleteById(codigo);
    }

}
