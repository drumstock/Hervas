package com.local.conoce_hervs.db_alojamientos;

/**
 * Created by user on 19/03/2018.
 */

public class ModelAlojamiento {

    private String nombre;
    private String descripcion;
    private String localizacion;
    private String foto;

    public ModelAlojamiento(String nombre, String descripcion, String localizacion, String foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.localizacion = localizacion;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
}
