package com.tecsup.demo.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @Column(name = "chrAluCodigo", length = 10)
    @NotNull
    private String codigo;

    @Column(name = "vchAluNombres", length = 50)
    @Size(min = 2, max = 50)
    @NotNull
    private String nombres;

    @Column(name = "vchAluApellidos", length = 50)
    @Size(min = 2, max = 50)
    @NotNull
    private String apellidos;

    @Column(name = "dtmAluFechaNac")
    @Past
    @NotNull
    private LocalDate fechaNacimiento;

    @Column(name = "chrAluSexo", length = 1)
    @Pattern(regexp = "[MF]", message = "Debe ser 'M' o 'F'")
    @NotNull
    private String sexo;

    public Alumno() {
    }

    public Alumno(String codigo, String nombres, String apellidos, LocalDate fechaNacimiento, String sexo) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "codigo='" + codigo + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
