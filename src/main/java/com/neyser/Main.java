package com.neyser;

import com.neyser.data.EmpleadoDao;
import com.neyser.data.EmpleadoDaoJdbc;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmpleadoDaoJdbc empleadoDaoJdbc = new EmpleadoDaoJdbc();
        empleadoDaoJdbc.select();
    }
}