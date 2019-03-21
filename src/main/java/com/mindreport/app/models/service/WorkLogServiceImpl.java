package com.mindreport.app.models.service;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mindreport.app.models.dao.IWorkLogDao;
import com.mindreport.app.models.entity.DatosFichero;
import com.mindreport.app.models.entity.WorkLog;

@Service
public class WorkLogServiceImpl implements IworkLogService{

	@Autowired
	private IWorkLogDao workLogDao;
	
	final static Logger logger = LoggerFactory.getLogger(DatosFichero.class);
	
	@Override
	public void save(List<WorkLog> workLogs) {
		
		for (WorkLog workLog : workLogs) {
		
			workLogDao.save(workLog);
		}
	}
	
	@Override
	public List<WorkLog> leerWorkLogDeExcel(String fichero) {
		
		List<WorkLog> listaWorkLog = new ArrayList<WorkLog>();
		File input = new File(fichero);

		try {
		
			Workbook wb = WorkbookFactory.create(input);
			
			Sheet hoja = wb.getSheet(NOMBRE_HOJA);
						
			if(hoja == null) {
				
				throw new Exception("No se ha encontrado la hoja");
			}			
			
			Iterator<Row> filaIterator = hoja.iterator();
			HashMap<Columna, Integer>  hashIndiceColumnas = new HashMap<Columna, Integer>() ;
			
			while(filaIterator.hasNext() && hashIndiceColumnas.isEmpty()) {
				
				Row fila = filaIterator.next();

				Iterator<Cell> celdaIterator = fila.cellIterator();
				
				while(celdaIterator.hasNext()) {
					
					Cell celda = celdaIterator.next();
					
					for(Columna columna : Columna.values() ) {
						
						if(columna.getNombreColumna().equals(getValorDeCelda(celda))) {
							
							hashIndiceColumnas.put(columna, celda.getColumnIndex());
						}
					}							
				}									
			}
			
			if(hashIndiceColumnas.isEmpty()) {
				
				throw new Exception("No se ha encontrado ninguna columna");
				
			} else {
			
				while(filaIterator.hasNext()) {
					
					Row fila = filaIterator.next();
					
					Set<Entry<Columna, Integer>> setIndiceColumnas = hashIndiceColumnas.entrySet();
					
					WorkLog workLog = new WorkLog();
					
					for (Entry<Columna, Integer> indiceColumna : setIndiceColumnas) {
												
						Columna columna = indiceColumna.getKey();
						Cell celda = fila.getCell(indiceColumna.getValue());
						
						if(celda != null) {
						
							Object valorDeCelda = getValorDeCelda(celda);							
							informaCampoWorkLog(workLog, columna, valorDeCelda);								
						}					
					}
					
					if(!StringUtils.isEmpty(workLog.getIssueKey())) {
						
						listaWorkLog.add(workLog);
					}						
				}							
			}		    
		} catch (Exception e) {

			throw new RuntimeException(e);
		}		

		return listaWorkLog;
	}
	
	
	private Object getValorDeCelda(Cell celda) {
		
		switch (celda.getCellType()) {
		case STRING:
			return celda.getStringCellValue();
		case BOOLEAN:
			return celda.getBooleanCellValue();
		case NUMERIC:
			return celda.getNumericCellValue();
		case FORMULA:
			return celda.getCellFormula();
		case BLANK:
			return "";
		default:
			return "";
		}
    }		
	
	// Configuración específica para la hoja en concreto
	
	final static String NOMBRE_HOJA = "Sheet0";

	void informaCampoWorkLog(WorkLog workLog, Columna columna, Object valorDeCelda) {

		switch (columna) {
		
		case ISSUE_KEY:
			workLog.setIssueKey((String) valorDeCelda); 
			break;
			
		case FULL_NAME:
			workLog.setFullName((String) valorDeCelda); 
			break;
			
		case COMPONENTS:
			break;
			
		case CREATED:
			break;
			
		case HOURS:
			break;
			
		case INTERNAL_DESC:
			break;
			
		case ISSUE_TYPE:
			break;
			
		case KEY_CLIENT:
			break;
			
		case LOGIN:
			break;
			
		case PARENT_ISSUE_KEY:
			break;
			
		case PHASE:
			break;
			
		case PROJECT_KEY:
			break;
			
		case STATUS:
			break;
			
		case SUMMARY:
			break;
			
		case VERSION:
			break;
			
		case WORKDATE:
			break;
			
		case WORKLOG_DESCRIPTION:
			break;		
		}
	}
	
	public enum Columna {

		ISSUE_KEY("Issue Key"),
		HOURS("Hours"),
		WORKDATE("Workdate"),
		SUMMARY("Summary"),
		LOGIN("Login"),
		FULL_NAME("Full Name"),
		STATUS("Status"),
		ISSUE_TYPE("Issue Type"),
		PROJECT_KEY("Project Key"),
		WORKLOG_DESCRIPTION("Worklog description"),
		PHASE("Phase"),
		VERSION("Version"),
		COMPONENTS("Components"),
		PARENT_ISSUE_KEY("Parent issue key"),
		CREATED("Created"),
		KEY_CLIENT("Key_Client"),
		INTERNAL_DESC("Internal Desc")
		;
		
		String nombreColumna;
		
		Columna(String nombreColumna) {
			this.nombreColumna = nombreColumna;
		}
		
		String getNombreColumna() {
			return nombreColumna;
		}
	};	
	
}