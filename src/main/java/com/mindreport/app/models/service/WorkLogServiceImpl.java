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
import com.mindreport.app.util.Util;

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
						
						if(columna.getNombreColumna().equals(Util.Excel.getValorDeCelda(celda))) {
							
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
						
							Object valorDeCelda = Util.Excel.getValorDeCelda(celda);							
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
	
	// Configuración específica para la hoja en concreto
	
	final static String NOMBRE_HOJA = "Sheet0";

	void informaCampoWorkLog(WorkLog workLog, Columna columna, Object valorDeCelda) {

		switch (columna) {
		case COMPONENTS:
			workLog.setComponents((String) valorDeCelda);
			break;
			
		case CREATED:
			workLog.setCreated((String) valorDeCelda);
			break;
			
		case FULL_NAME:
			workLog.setFullName((String) valorDeCelda);
			break;
			
		case HOURS:
			if(!"".equals(valorDeCelda))
				workLog.setHours((Double) valorDeCelda);
			break;
			
		case INTERNAL_DESC:
			workLog.setInternalDesc((String) valorDeCelda);
			break;
			
		case ISSUE_KEY:
			workLog.setIssueKey((String) valorDeCelda);
			break;
			
		case ISSUE_TYPE:
			workLog.setIssueType((String) valorDeCelda);
			break;
			
		case KEY_CLIENT:
			workLog.setKeyClient((String) valorDeCelda);
			break;
			
		case LOGIN:
			workLog.setLogin((String) valorDeCelda);
			break;
			
		case PARENT_ISSUE_KEY:
			workLog.setParentIssueKey((String) valorDeCelda);
			break;
			
		case PHASE:
			workLog.setPhase((String) valorDeCelda);
			break;
			
		case PROJECT_KEY:
			workLog.setProjectKey((String) valorDeCelda);
			break;
			
		case STATUS:
			workLog.setStatus((String) valorDeCelda);
			break;
			
		case SUMMARY:
			workLog.setSummary((String) valorDeCelda);
			break;
			
		case VERSION:
			workLog.setVersion((String) valorDeCelda);
			break;
			
		case WORKDATE:
			workLog.setWorkDate((String) valorDeCelda);
			break;
			
		case WORKLOG_DESCRIPTION:
			workLog.setWorklogDescription((String) valorDeCelda);
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