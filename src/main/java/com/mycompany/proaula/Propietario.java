/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proaula;

import javax.swing.JOptionPane;

/**
 *
 * @author diegomendoza,
 * @author gerson jimenez jefersson ortega
 */
public class Propietario {

    public void verProductosRegistrados(int codigoAlmacen) {

        if (Main.almacenes.get(codigoAlmacen) != null) {

            String productos = "Almacen  " + Main.almacenes.get(codigoAlmacen).getNombre() + "\n";
            int indice = 1;

            int indiceProducto = 1;
            for (Producto producto : Main.almacenes.get(codigoAlmacen).getProductos()) {
                productos += "Producto # " + indiceProducto + " " + producto.getNombre() + "\n";
                indiceProducto++;
            }

            JOptionPane.showMessageDialog(null, "Productos Regitrados \n" + productos);

            return;
        }

        JOptionPane.showMessageDialog(null, "Almacen no encontrado");

    }

    public String obtenerProductosRegistrados(int codigoAlmacen) {

        if (Main.almacenes.get(codigoAlmacen) != null) {

            String productos = "Almacen  " + Main.almacenes.get(codigoAlmacen).getNombre() + "\n";
            int indice = 1;

            int indiceProducto = 1;
            for (Producto producto : Main.almacenes.get(codigoAlmacen).getProductos()) {
                productos += "Producto # " + indiceProducto + " " + producto.getNombre() + "\n";
                indiceProducto++;
            }

            return productos;
        }

        return "no se encontraron productos";
    }

    public String verLocalesRegistrados() {

        String almacenes = "";
        int indice = 1;
        for (Almacen item : Main.almacenes) {
            almacenes += "Almacen # " + indice + ". " + item.getNombre() + "\n";
            indice++;
        }
        return almacenes;
    }

    public void actualizarProducto(int codigoAlmacen, int codigoProducto) {

        if (Main.almacenes.get(codigoAlmacen) != null) {

            Almacen almacen = Main.almacenes.get(codigoAlmacen);
            if (almacen.getProductos().get(codigoProducto) != null) {

                String nombreProducto = JOptionPane.showInputDialog("Digite el nuevo Nombre del producto");
                Producto nuevo = new Producto(nombreProducto);

                Main.almacenes.get(codigoAlmacen).getProductos().set(codigoProducto, nuevo);

                JOptionPane.showMessageDialog(null, "Producto Actualizado Correctamente");

                return;
            }

            JOptionPane.showMessageDialog(null, "Producto no Encontrado");

            return;
        }
        JOptionPane.showMessageDialog(null, "Almacen no encontrado");

        return;

    }

}
