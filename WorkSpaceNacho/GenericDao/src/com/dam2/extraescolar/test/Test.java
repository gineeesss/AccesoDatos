package com.dam2.extraescolar.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.dam2.extraescolar.model.dao.ConectaBD;
import com.dam2.extraescolar.model.dao.ExceptionDataBase;
import com.dam2.extraescolar.model.dao.ParticipantesDao;
import com.dam2.extraescolar.model.entity.Participante;
import com.dam2.extraescolar.util.UtilFecha;


public class Test {
	
	public static void main(String[] args) throws SQLException, ExceptionDataBase {	
		test1();
	}
	
	private static void test1() throws SQLException, ExceptionDataBase {
		try (Connection conn =  (Connection) ConectaBD.getConectaBD();){
			ParticipantesDao participantesDao = new ParticipantesDao();		
			participantesDao.add( new Participante("111","Pepito","Perez Lopez",UtilFecha.StringToLocalDateTo("01/01/2000"),null));
			participantesDao.add( new Participante("112","Pepito","Perez Lopez",UtilFecha.StringToLocalDateTo("01/01/2000"),null));
			participantesDao.add( new Participante("113","Pepito","Perez Lpez",UtilFecha.StringToLocalDateTo("01/01/2000"),null));
			participantesDao.add( new Participante("114","Pepito","Perez Lopez",null,null));
			
		    System.out.println("Mostrando todos los participantes:");
		    for(Participante participante:participantesDao.listAll()) {
				System.out.println(participante.toString());
			}
		}

		
	}

}
