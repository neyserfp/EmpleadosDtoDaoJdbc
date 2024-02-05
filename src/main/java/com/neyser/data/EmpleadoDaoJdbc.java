package com.neyser.data;

import com.neyser.domain.EmpleadoDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDaoJdbc implements EmpleadoDao
{

    // Declaración de la variable "conexinTransaccional" del tipo "Connection"
    private Connection conexionTransaccional;

    // Declaración de las constantes que incluyen las consultas SQL
    private static final String SQL_SELECT = "select ide_emp, nom_emp, ape_emp from empleados";
    private static final String SQL_INSERT = "insert into empleados (nom_emp, ape_emp) values (?, ?)";
    private static final String SQL_UPDATE = "update empleados set nom_emp=?, ape_emp=? where ide_emp=?";
    private static final String SQL_DELETE = "delete from empleados where ide_emp=?";

    // Sobrecarga de constructores que establecen la conexion con la base de datos


    public EmpleadoDaoJdbc() {
    }

    public EmpleadoDaoJdbc(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    // Definición de los métodos apuntados en la interfaz
    @Override
    public List<EmpleadoDto> select() throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        EmpleadoDto empleado = null;
        List<EmpleadoDto> empleados = new ArrayList<>();

        try
        {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Connect.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Integer ide_emp = rs.getInt("ide_emp");
                String nom_emp = rs.getString("nom_emp");
                String ape_emp = rs.getString("ape_emp");
                empleado = new EmpleadoDto(ide_emp, nom_emp, ape_emp);
                empleados.add(empleado);
            }

            System.out.println(empleados);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            Connect.close(rs);
            Connect.close(stmt);
            if (this.conexionTransaccional == null){
                Connect.close(conn);
            }
        }
        return empleados;
    }

    @Override
    public Integer insert(EmpleadoDto empleado) throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Connect.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getNom_emp());
            stmt.setString(2, empleado.getApe_emp());
            System.out.println("Instruccion ejecutada: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros insertados: " + rows);
        }
        finally
        {
            Connect.close(stmt);
            if(this.conexionTransaccional==null)
            {
                Connect.close(conn);
            }
        }
        return rows;
    }

    @Override
    public Integer update(EmpleadoDto empleado) throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Connect.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getNom_emp());
            stmt.setString(2, empleado.getApe_emp());
            stmt.setInt(3, empleado.getIde_emp());
            System.out.println("Instruccion ejecutada: " + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
        }
        finally
        {
            Connect.close(stmt);
            if(this.conexionTransaccional==null)
            {
                Connect.close(conn);
            }
        }
        return rows;
    }

    @Override
    public Integer delete(EmpleadoDto empleado) throws SQLException
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try
        {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Connect.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getIde_emp());
            System.out.println("Instruccion ejecutada: " + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        }
        finally
        {
            Connect.close(stmt);
            if(this.conexionTransaccional==null)
            {
                Connect.close(conn);
            }
        }
        return rows;
    }
}
