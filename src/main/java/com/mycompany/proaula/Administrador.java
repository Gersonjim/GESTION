/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proaula;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Almighty,gerson jimenez,jefersson ortega
 */
public class Administrador {

    /**
     *
     * @author Araque
     */
    String nombre;
    String categoria;
    String op;

    public void registrarAlmacen() {

        Almacen almacen = new Almacen();

        nombre = JOptionPane.showInputDialog("Digite el nombre del local que quiera registrar:");

        almacen.setNombre(nombre);

        op = JOptionPane.showInputDialog("""
                                     Selecione la categoria en la cual quiere registar el almacen: 
                                      1.-Ropa y calzado
                                      2.-Entretenimiento
                                      3.-Restaurantes
                                     """);

        if (op.equalsIgnoreCase("1")) {
            this.categoria = "Ropa y calzado";
        } else if (op.equalsIgnoreCase("2")) {
            this.categoria = "Entretenimiento";
        } else if (op.equalsIgnoreCase("3")) {
            this.categoria = "Restaurantes";
        } else {
            JOptionPane.showMessageDialog(null, "opcion no valida");
            return;
        }

        almacen.setCategoria(categoria);

        int dialogButton = JOptionPane.showConfirmDialog(null, "Desea registrar un producto", "Registrar", JOptionPane.YES_NO_OPTION);

        System.out.println("OPCION ===> " + dialogButton);
        List<Producto> productos = registrarProducto(dialogButton);

        almacen.setProductos(productos);

        Main.almacenes.add(almacen);

        JOptionPane.showMessageDialog(null, "El local registrado fue " + nombre);

    }

    public List<Producto> registrarProducto(int dialogButton) {

        List<Producto> productos = new ArrayList<>();

        while (dialogButton != JOptionPane.NO_OPTION) {

            String nombre = JOptionPane.showInputDialog("Digite el nombre del Producto que quiera registrar:");

            productos.add(new Producto(nombre));

            dialogButton = JOptionPane.showConfirmDialog(null, "Desea registrar un nuevo producto", "Registrar Nuevo", JOptionPane.YES_NO_OPTION);
        }

        return productos;

    }

    /**
     *
     */
    public void elimarAlmacen() {

        nombre = JOptionPane.showInputDialog("Digite el nombre del local que desea Eliminar:");

        Almacen aux = null;
        for (Almacen item : Main.almacenes) {
            if (item.getNombre().equals(nombre)) {
                aux = item;
                break;
            }
        }

        if (aux != null) {
            Main.almacenes.remove(aux);
            JOptionPane.showMessageDialog(null, "El local Eliminado fue " + aux.getNombre());
            return;
        }

        JOptionPane.showMessageDialog(null, "El local " + aux.getNombre() + " no fue encontrado");

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
            almances += productos +"================\n";
            indice++;
        }

        JOptionPane.showMessageDialog(null, "Almacenes Regitrados \n" + almances);

    }
}
