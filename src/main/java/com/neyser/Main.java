package com.neyser;

import com.neyser.data.Connect;
import com.neyser.data.EmpleadoDao;
import com.neyser.data.EmpleadoDaoJdbc;
import com.neyser.domain.EmpleadoDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException
    {
        Connection conexion = null;

        // Select
        try
        {
            conexion  = Connect.getConnection();

            if(conexion.getAutoCommit())
            {
                conexion.setAutoCommit(false);
            }

            EmpleadoDao EmpleadoDao = new EmpleadoDaoJdbc(conexion);
            List<EmpleadoDto> empleados = EmpleadoDao.select();
            for(EmpleadoDto empleado: empleados)
            {
                System.out.println("Empleado DTO: " + empleado);
            }
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion (select)");

        }
        catch(SQLException ex)
        {
            ex.printStackTrace(System.out);
            System.out.println("Se ha hecho rollback de la transaccion (select)");
            try
            {
                conexion.rollback();
            }
            catch(SQLException ex1)
            {
                ex1.printStackTrace(System.out);
            }
        }

        // Insert
        try
        {
            conexion = Connect.getConnection();
            if (conexion.getAutoCommit())
            {
                conexion.setAutoCommit(false);
            }

            EmpleadoDao EmpleadoDao = new EmpleadoDaoJdbc(conexion);
            EmpleadoDto empleado = new EmpleadoDto();
            empleado.setNom_emp("Cristina");
            empleado.setApe_emp("Velasco");
            EmpleadoDao.insert(empleado);

            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion (insert)");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
            System.out.println("Se ha hecho rollback de la transaccion (insert)");
            try
            {
                conexion.rollback();
            }
            catch (SQLException ex1)
            {
                ex1.printStackTrace(System.out);
            }
        }

        // Update

        try
        {
            conexion = Connect.getConnection();
            if (conexion.getAutoCommit())
            {
                conexion.setAutoCommit(false);
            }

            EmpleadoDao EmpleadoDao = new EmpleadoDaoJdbc(conexion);
            EmpleadoDto empleado = new EmpleadoDto();
            empleado.setIde_emp(3);
            empleado.setNom_emp("Cristina");
            empleado.setApe_emp("Velez");
            EmpleadoDao.update(empleado);

            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion (update)");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
            System.out.println("Se ha hecho rollback de la transaccion (update)");
            try
            {
                conexion.rollback();
            }
            catch (SQLException ex1)
            {
                ex1.printStackTrace(System.out);
            }
        }

        // Delete
        try
        {
            conexion = Connect.getConnection();
            if (conexion.getAutoCommit())
            {
                conexion.setAutoCommit(false);
            }

            EmpleadoDao EmpleadoDao = new EmpleadoDaoJdbc(conexion);
            EmpleadoDto empleado = new EmpleadoDto();
            empleado.setIde_emp(1);
            EmpleadoDao.delete(empleado);

            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion (delete)");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
            System.out.println("Se ha hecho rollback de la transaccion (delete)");
            try
            {
                conexion.rollback();
            }
            catch (SQLException ex1)
            {
                ex1.printStackTrace(System.out);
            }
        }

    }
}