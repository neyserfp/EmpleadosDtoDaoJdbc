package com.neyser.domain;

public class EmpleadoDto
{
    // Atributos de Clase
    private Integer ide_emp;
    private String nom_emp, ape_emp;

    public EmpleadoDto() {
    }

    public EmpleadoDto(Integer ide_emp, String nom_emp, String ape_emp) {
        this.ide_emp = ide_emp;
        this.nom_emp = nom_emp;
        this.ape_emp = ape_emp;
    }

    public Integer getIde_emp() {
        return ide_emp;
    }

    public void setIde_emp(Integer ide_emp) {
        this.ide_emp = ide_emp;
    }

    public String getNom_emp() {
        return nom_emp;
    }

    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }

    public String getApe_emp() {
        return ape_emp;
    }

    public void setApe_emp(String ape_emp) {
        this.ape_emp = ape_emp;
    }

    @Override
    public String toString() {
        return "EmpleadoDto{" +
                "ide_emp=" + ide_emp +
                ", nom_emp='" + nom_emp + '\'' +
                ", ape_emp='" + ape_emp + '\'' +
                '}';
    }
}
