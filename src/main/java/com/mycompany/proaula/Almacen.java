package com.mycompany.proaula;

import java.util.List;

public class Almacen {

    private String nombre;
    private String categoria;
    private List<Producto> productos;
    private int puntaje;

    public Almacen(){

    }

    public Almacen(String nombre , String categoria){

    }

    public Almacen(String nombre, String categoria, List<Producto> productos) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.productos = productos;
    }

    public Almacen(String nombre, String categoria, List<Producto> productos, int puntaje) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.productos = productos;
        this.puntaje = puntaje;
    }
    
    
    

    public String getCategoria(){
        return this.categoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    
    
    
}
