package com.dam2.extraescolar.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.dam2.extraescolar.model.dao.ConectaBD;
import com.dam2.extraescolar.model.dao.ExceptionDataBase;
import com.dam2.extraescolar.model.dao.ParticipantesDao;
import com.dam2.extraescolar.model.entity.Participante;
import com.dam2.extraescolar.util.UtilFecha;

public class Test {

    public static void main(String[] args) {
        try {
            test1();
        } catch (SQLException | ExceptionDataBase e) {
            System.err.println("Error durante la prueba: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void test1() throws SQLException, ExceptionDataBase {
        System.out.println("Iniciando test de participantes...");
        
        Connection connection = null;
        try {
            ConectaBD conn = ConectaBD.getConectaBD();
            connection = conn.getConnection();

            ParticipantesDao participantesDao = new ParticipantesDao();

            // Agregar participantes
            System.out.println("Agregando participantes...");
            participantesDao.add(new Participante("111", "Pepito", "Perez Lopez", UtilFecha.StringToLocalDateTo("01/01/2000"), null));
            participantesDao.add(new Participante("112", "Pepito", "Perez Lopez", UtilFecha.StringToLocalDateTo("01/01/2000"), null));
            participantesDao.add(new Participante("113", "Pepito", "Perez Lpez", UtilFecha.StringToLocalDateTo("01/01/2000"), null));
            participantesDao.add(new Participante("114", "Pepito", "Perez Lopez", null, null));
            System.out.println("Participantes añadidos correctamente.");
            connection.commit();

            // Mostrar participantes
            System.out.println("Mostrando todos los participantes:");
            for (Participante participante : participantesDao.listAll()) {
                System.out.println(participante.toString());
            }
        } catch (Exception e) {
            System.err.println("Error en test1: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        }
    }
}
