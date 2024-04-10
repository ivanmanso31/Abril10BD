package com.softtek.persistencia;

import com.softtek.modelo.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoProducto extends Conexion{


    public List<Producto> obtenerTodos() throws  ClassNotFoundException, SQLException{
        Statement sentencia;
        ResultSet resultado;
        String sql = "Select product_id, product_name, unit_price, units_in_stock from products;";
        List<Producto> productos = new ArrayList<>();
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        while (resultado.next()){
            productos.add(new Producto(resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock")));
        }
        return productos;
    }

    public Producto obtenerUno(int id) throws  ClassNotFoundException, SQLException{
        Statement sentencia;
        ResultSet resultado;
        String sql = "Select product_id, product_name, unit_price, units_in_stock from products where product_id="+id+";";
        Producto producto;
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        if(resultado.next()){
            producto = new Producto(resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock"));
        }else{
            producto=new Producto();
        }

        return producto;
    }

    public void insertarProducto(Producto p) throws  ClassNotFoundException, SQLException{
        Statement sentencia;
        String sql = "INSERT INTO products VALUES ("+p.getIdProducto()+", '"+p.getNombreProducto()+"', null, null, null, "+p.getPrecioUnitario()+", "+p.getUnidadesStock()+", null, null, 0);";
        abrirConexion();
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
    }

    public void actualizarProducto(Producto p) throws  ClassNotFoundException, SQLException{
        Statement sentencia;
        String sql = "UPDATE products SET product_name = '"+p.getNombreProducto()+"', unit_price ="+p.getPrecioUnitario()+", units_in_stock ="+p.getUnidadesStock()+" WHERE product_id = "+p.getIdProducto()+";";
        abrirConexion();
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
    }

    public void borrarProducto(int id) throws  ClassNotFoundException, SQLException{
        Statement sentencia;
        String sql = "DELETE FROM products WHERE product_id = "+id+";";
        abrirConexion();
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
    }
}
