/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.proaula;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

    public static List<Almacen> almacenes = new ArrayList<>();

    public static void main(String[] args) {

        int op = 0;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("""
                                                              ***SELECCIONA UNA OPCION*** 
                                                               1. Administrador
                                                               2. propietario
                                                               3. Cliente
                                                               0. Salir"""));
            switch (op) {
                case 1 -> {
                    Administrador almighty = new Administrador();
                    String accion = JOptionPane.showInputDialog(null,
                            "Que opcion desea realizar\n 1 Agregar Almacen\n 2.Eliminar Almacen \n 3. Ver Almacenes");

                    switch (accion) {
                        case "1" ->
                            almighty.registrarAlmacen();
                        case "2" ->
                            almighty.elimarAlmacen();
                        case "3" ->
                            almighty.verLocalesRegistrados();
                        default ->
                            JOptionPane.showMessageDialog(null, "Accion No permitida");
                    }
                }
                case 2 -> {

                    Propietario anuel = new Propietario();

                    String codigoAlmacen = JOptionPane.showInputDialog(null,
                            "Seleccione el # del almacen para ver los productos \n" + anuel.verLocalesRegistrados());

                    op = Integer.parseInt(JOptionPane.showInputDialog("""
                                                              ***SELECCIONA UNA OPCION *** 
                                                               1. Ver Productos
                                                               2. Actualizar Producto"""));
                    switch (op) {
                        case 1 ->
                            anuel.verProductosRegistrados(Integer.parseInt(codigoAlmacen) - 1);
                        case 2 -> {
                            String codigoProducto = JOptionPane.showInputDialog(null,
                                    "Seleccione el # del Producto para actualizar \n" + anuel.obtenerProductosRegistrados(Integer.parseInt(codigoAlmacen)));
                            anuel.actualizarProducto(Integer.parseInt(codigoAlmacen) - 1, Integer.parseInt(codigoProducto) - 1);
                        }
                        default ->
                            JOptionPane.showMessageDialog(null, "Dato incorrecto");
                    }

                }
                case 3 -> {
                    Cliente diego = new Cliente();

                    op = Integer.parseInt(JOptionPane.showInputDialog("""
                                                              ***SELECCIONA UNA OPCION *** 
                                                               1. Puntuar almacen 
                                                               2. Ver informacion de almacen"""));

                    switch (op) {
                        case 1 -> {

                            int codigoAlmacen = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Seleccione el # del almacen que desea Puntuar \n" + diego.obtenerLocalesRegistrados()));

                            diego.puntuarAlmacen(codigoAlmacen - 1);

                        }
                        case 2 -> {
                            diego.verLocalesRegistrados();
                        }
                        default ->
                            JOptionPane.showMessageDialog(null, "Dato incorrecto");
                    }

                }
                default ->
                    JOptionPane.showMessageDialog(null, "Dato incorrecto");

            }
        } while (op > 0);

    }

}
