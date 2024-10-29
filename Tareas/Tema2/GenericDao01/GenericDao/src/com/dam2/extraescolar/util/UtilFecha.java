package com.dam2.extraescolar.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtilFecha {
	public static String LocalDateToString(LocalDate fecha) {
		String date = null;
		try {
			date = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch (Exception ex) {
		}
		return date;
	}

	public static LocalDate StringToLocalDateTo(String strFecha) {
		LocalDate date = null;
		try {
			date = LocalDate.parse(strFecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch (Exception ex) {
		}
		return date;
	}

	public static String LocalDateToStringMysql(LocalDate fecha) {
		String date = null;
		try {
			date = fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		} catch (Exception ex) {
		}
		return date;
	}

	public static java.sql.Date LocalDateToDateSql(LocalDate fecha) {
		java.sql.Date date = null;
		try {
			date = java.sql.Date.valueOf(fecha);
		} catch (Exception ex) {
		}
		return date;
	}

	public static LocalDate DateSqlToLocalDate(java.sql.Date fecha) {
		LocalDate date = null;
		try {
			date = fecha.toLocalDate();
		} catch (Exception ex) {
		}
		return date;
	}

}
