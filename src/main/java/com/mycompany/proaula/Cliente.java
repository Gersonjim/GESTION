/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proaula;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 *
 * @author diego mendoza,gerson jimenez.jefersson ortega
 */
public class Cliente {

 



    public void mostrarPuntuacion() {
        Random random = new Random();
        JOptionPane.showMessageDialog(null, "la puntuacion para el almacen es " + random.nextInt(50));
    }

    public void verLocalesRegistrados() {

        String almances = "";
        int indice = 1;
        for (Almacen item : Main.almacenes) {
            int indiceProducto = 1;
            almances += "Almacen # " + indice + ". " + item.getNombre() + "\n";

            String productos = "";
            for (Producto producto : item.getProductos()) {
                productos += "Producto # " + indiceProducto + " " + producto.getNombre() + "\n";
                indiceProducto++;
            }
            almances+="\n Puntuacion: "+ item.getPuntaje()+"\n";
            almances += productos + "================\n";
            indice++;
        }

        JOptionPane.showMessageDialog(null, "Almacenes Regitrados \n" + almances);

    }

    public String obtenerLocalesRegistrados() {

        String almances = "";
        int indice = 1;
        for (Almacen item : Main.almacenes) {
            almances += "Almacen # " + indice + ". " + item.getNombre() + "\n";
          
            almances +="================\n";
            indice++;
        }


        return almances;
    }

    public String almacenes(int opcion) {
        if (opcion == 1) {
            return "Ropa y Calzado";
        }
        if (opcion == 2) {
            return "Entretenimiento";
        }
        if (opcion == 3) {
            return "Restaurantes";
        }
        return "Opcion incorrecta";
    }
    
    
    public void puntuarAlmacen(int codigoALmacen){
    
        
         int puntaje = Integer.parseInt(
                                     JOptionPane.showInputDialog(null,
                                  "Digite la puntuacion para el almacen entre 0 y 10"));
    
        if(Main.almacenes.get(codigoALmacen)!= null){
        
            Almacen almacen = Main.almacenes.get(codigoALmacen);
            
           almacen.setPuntaje(puntaje);
           
           Main.almacenes.set(codigoALmacen, almacen);
                   JOptionPane.showMessageDialog(null, "Almacen Puntuado Exitosa Mente");

           return;
        }
        JOptionPane.showMessageDialog(null, "Almacen no encontrado");
    }

}
