package com.dam2.extraescolar.test;

import com.dam2.extraescolar.model.dao.ParticipantesDao;
import com.dam2.extraescolar.model.entity.Participante;
import com.dam2.extraescolar.util.UtilFecha;

public class Test {
	
	public static void main(String[] args) {	
		test1();
	}
	
	private static void test1() {
		ParticipantesDao participantesDao = new ParticipantesDao();		
		participantesDao.add( new Participante("111","Pepito","Pérez López",UtilFecha.StringToLocalDateTo("01/01/2000"),null));
		participantesDao.add( new Participante("112","Pepito","Pérez López",UtilFecha.StringToLocalDateTo("01/01/2000"),null));
		participantesDao.add( new Participante("113","Pepito","Pérez López",UtilFecha.StringToLocalDateTo("01/01/2000"),null));
		participantesDao.add( new Participante("114","Pepito","Pérez López",null,null));
		
		for(Participante participante:participantesDao.listAll()) {
			System.out.println(participante.toString());
		}
	}

}
