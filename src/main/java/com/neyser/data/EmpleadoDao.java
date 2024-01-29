package com.neyser.data;

import com.neyser.domain.EmpleadoDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmpleadoDao
{
    // Apunte en la interface del método "select"
    // Que devuelve una List de tipo EmpleadoDto
    public List<EmpleadoDto> select() throws SQLException;

    // Apunte en la interface del método "insert"
    // Que recibe un argumento del tipo EmpleadoDto y devuelve un int
    public Integer insert(EmpleadoDto empleado) throws SQLException;

    // Apunte en la interface del método "update"
    // Que recibe un argumento del tipo EmpleadoDto y devuelve un int
    public Integer update(EmpleadoDto empleado) throws SQLException;

    // Apunte en la interface del método "delete"
    // Que recibe un argumento del tipo EmpleadoDto y devuelve un int
    public Integer delete(Integer id) throws SQLException;

}
