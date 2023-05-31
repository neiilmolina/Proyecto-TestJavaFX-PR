package com.example.testjavafx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BD {
    public static Respuesta devolverRespuesta(String sql) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        Respuesta respuestaBD = new Respuesta();
        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/testJavaFX?autoReconnect=true&useSSL=false", "root", "");

            // creamos sentencias ejecutables sobre esa conexión
            sentenciaSQL = conexion.createStatement();

            // almaceno el resultado de la sql en un resulset (conjunto de registros)
            // System.out.println(sql);

            rs = sentenciaSQL.executeQuery(sql);

            // chequeo que el result set no sea vacío, moviendo el cursor a la
            // primer fila. (El cursor inicia antes de la primer fila)
            while (rs.next()) {
            // recojo respuestas en la BD y lo meto en el arraylist de respuestas del objeto Pregunta
                respuestaBD = new Respuesta(rs.getString("opcionA"), rs.getString("opcionB"),
                        rs.getString("opcionC"), rs.getString("opcionD"), rs.getInt("id_pregunta"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
                conexion.close();
            } catch (SQLException e) {
                // TODO Bloque catch generado automáticamente
                e.printStackTrace();
            }

            return respuestaBD;
        }

    }

    public static Pregunta devolverPregunta( String sql) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        Pregunta preguntaBD = new Pregunta();
        String imagenBD = "";
        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/testJavaFX?autoReconnect=true&useSSL=false", "root", "");

            // creamos sentencias ejecutables sobre esa conexión
            sentenciaSQL = conexion.createStatement();

            // almaceno el resultado de la sql en un resulset (conjunto de registros)
            // System.out.println(sql);

            rs = sentenciaSQL.executeQuery(sql);

            // chequeo que el result set no sea vacío, moviendo el cursor a la
            // primer fila. (El cursor inicia antes de la primer fila)
            while (rs.next()) {
                imagenBD = new String(rs.getString("rutaImagen"));
                preguntaBD = new Pregunta(rs.getString("pregunta"), imagenBD , rs.getInt("id"));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
                conexion.close();
            } catch (SQLException e) {
                // TODO Bloque catch generado automáticamente
                e.printStackTrace();
            }

        }
        return preguntaBD;

    }

    public static Resultado devolverResultado(String sql) {
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        String imagen = new String("");
        Resultado resultadoBD = new Resultado("","", imagen);
        try {
            // conectar con la base de datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/testJavaFX?autoReconnect=true&useSSL=false", "root", "");

            // creamos sentencias ejecutables sobre esa conexión
            sentenciaSQL = conexion.createStatement();

            // almaceno el resultado de la sql en un resulset (conjunto de registros)
            // System.out.println(sql);

            rs = sentenciaSQL.executeQuery(sql);

            // chequeo que el result set no sea vacío, moviendo el cursor a la
            // primer fila. (El cursor inicia antes de la primer fila)
            while (rs.next()) {
                imagen = new String(rs.getString("rutaImagen"));
                //coger resultados en función de la puntuacion del usuario, consulta: SELECT * FROM resultados WHERE nombre = usuario.getResultado().getNombre();
                resultadoBD = new Resultado(rs.getString("descripcion"), rs.getString("nombre"), imagen);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } finally {
            try {
                sentenciaSQL.close();
                conexion.close();
            } catch (SQLException e) {
                // TODO Bloque catch generado automáticamente
                e.printStackTrace();
            }

        }

        return resultadoBD;

    }
}

