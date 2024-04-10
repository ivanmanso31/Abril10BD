package com.softtek.presentacion;

import com.softtek.modelo.Producto;
import com.softtek.persistencia.AccesoProducto;
import com.softtek.persistencia.Conexion;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conexion c1 = new Conexion();
        try {
            c1.abrirConexion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        AccesoProducto ap= new AccesoProducto();
        try{
            System.out.println(ap.obtenerTodos());;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            System.out.println("Introduzca id del producto");
            System.out.println(ap.obtenerUno(sc.nextInt()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            Producto i= new Producto();
            System.out.println("Introduzca id del producto a insertar");
            i.setIdProducto(sc.nextInt());
            System.out.println("Introduzca nombre del producto a insertar");
            i.setNombreProducto(sc.next());
            System.out.println("Introduzca precio del producto a insertar");
            i.setPrecioUnitario(sc.nextDouble());
            System.out.println("Introduzca unidades del producto a insertar");
            i.setUnidadesStock(sc.nextInt());
            ap.insertarProducto(i);
            ap.obtenerTodos();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            Producto u= new Producto();
            System.out.println("Introduzca id del producto a modificar");
            u.setIdProducto(sc.nextInt());
            System.out.println("Introduzca nombre del producto a modificar");
            u.setNombreProducto(sc.next());
            System.out.println("Introduzca precio del producto a modificar");
            u.setPrecioUnitario(sc.nextDouble());
            System.out.println("Introduzca unidades del producto a modificar");
            u.setUnidadesStock(sc.nextInt());
            ap.actualizarProducto(u);
            ap.obtenerTodos();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            System.out.println("Introduzca id del producto a borrar");
            ap.borrarProducto(sc.nextInt());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
