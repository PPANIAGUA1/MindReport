package com.mindreport.app.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class Util {

	public static class Excel {
		
		public static Object getValorDeCelda(Cell celda) {
			
			switch (celda.getCellType()) {
			case STRING:
				return celda.getStringCellValue();
			case BOOLEAN:
				return celda.getBooleanCellValue();
			case NUMERIC:
                if(DateUtil.isCellDateFormatted(celda)) {
                    return celda.getDateCellValue();
                }
                return celda.getNumericCellValue();
			case FORMULA:
				return celda.getCellFormula();
			case BLANK:
				return "";
			default:
				return "";
			}
	    }					
	}
	
}
