package com.example.appprueba;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Personal {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nombre_personal")
    private String nombre;
    @ColumnInfo(name = "apellidos_personal")
    private String apellidos;
    @ColumnInfo(name = "direccion_personal")
    private String direccion;
    @ColumnInfo(name = "ine_personal")
    private String ine;
    @ColumnInfo(name = "telefono_personal")
    private Long telefono;
    @ColumnInfo(name = "puesto_personal")
    private String puesto;

    public Personal(String nombre, String apellidos, String direccion, String ine, Long telefono, String puesto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.ine = ine;
        this.telefono = telefono;
        this.puesto = puesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }







}
