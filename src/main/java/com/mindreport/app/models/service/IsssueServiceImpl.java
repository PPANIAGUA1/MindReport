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

import com.mindreport.app.models.dao.IissuesDao;
import com.mindreport.app.models.entity.DatosFichero;
import com.mindreport.app.models.entity.Issues;

@Service
public class IsssueServiceImpl implements IisssueService{

	@Autowired
	private IissuesDao issuesDao;
	
	final static Logger logger = LoggerFactory.getLogger(DatosFichero.class);


	@Override
	public void save(List<Issues> issues) {
	
		for (Issues issue : issues) {
			
			issuesDao.save(issue);
		}
	}
	
	@Override
	public List<Issues> findAll() {
		
		return toList(issuesDao.findAll());
	}
	
	
	private static <E> List<E> toList(Iterable<E> iter) {
		
		List<E> list = new ArrayList<E>();
	    for (E item : iter) {
	        list.add(item);
	    }
	    return list;
	}	
	
	@Override
	public List<Issues> leerIssuesDeExcel(String fichero) {

		List<Issues> listaIssues = new ArrayList<Issues>();
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
					
					Issues issue = new Issues();
					
					for (Entry<Columna, Integer> indiceColumna : setIndiceColumnas) {
												
						Columna columna = indiceColumna.getKey();
						Cell celda = fila.getCell(indiceColumna.getValue());
						
						if(celda != null) {
						
							Object valorDeCelda = getValorDeCelda(celda);							
							informaCampoIssue(issue, columna, valorDeCelda);								
						}					
					}
					
					if(!StringUtils.isEmpty(issue.getIssueKey())) {
					
						listaIssues.add(issue);
					}										
				}							
			}		    
		} catch (Exception e) {

			throw new RuntimeException(e);
		}		

		return listaIssues;
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
	
	// ConfiguraciÃ³n especÃ­fica para la hoja en concreto
	
	final static String NOMBRE_HOJA = "Sheet0";

	void informaCampoIssue(Issues issues, Columna columna, Object valorDeCelda) {

		switch (columna) {
		
		case ISSUE_KEY:
			issues.setIssueKey((String) valorDeCelda); 
			break;

		case SUMMARY:
			issues.setSummary((String) valorDeCelda); 
			break;
			
		case AFFECTS_VERSIONS:
			break;
			
		case ASSIGNEE:
			break;
			
		case COMPONENTS:
			break;
			
		case CREATED:
			break;
			
		case CUSTOM_ESTIMATE:
			break;
			
		case DUE_DATE:
			break;
			
		case ESTIMATION_DELIVERY_COMMITMENT:
			break;
			
		case EXTERNAL_ISSUE_ID:
			break;
			
		case FIX_VERSIONS:
			break;
			
		case GEP_PROJECT:
			break;
			
		case ISSUE_TYPE:
			issues.setIssueType((String) valorDeCelda); 
			break;
			
		case KEY_CLIENT:
			break;
			
		case LABELS:
			break;
			
		case ORIGINAL_ESTIMATE:
			break;
			
		case PARENT_ISSUE_KEY:
			break;
			
		case PARENT_ISSUE_SUMMARY:
			break;
			
		case PLANNED_END_DATE:
			break;
			
		case PLANNED_END_DATE_INITIAL:
			break;
			
		case PLANNED_START_DATE:
			break;
			
		case PLANNED_START_DATE_INITIAL:
			break;
			
		case PLANNING_DELIVERY_COMMITMENT:
			break;
			
		case PRIORITY:
			break;
			
		case PROGRESS:
			break;
			
		case PROJECT_KEY:
			break;
			
		case PROJECT_PARAMETER_1:
			break;
			
		case PROJECT_PARAMETER_10:
			break;
			
		case PROJECT_PARAMETER_11:
			break;
			
		case PROJECT_PARAMETER_12:
			break;
			
		case PROJECT_PARAMETER_2:
			break;
			
		case PROJECT_PARAMETER_3:
			break;
			
		case PROJECT_PARAMETER_4:
			break;
			
		case PROJECT_PARAMETER_5:
			break;
			
		case PROJECT_PARAMETER_6:
			break;
			
		case PROJECT_PARAMETER_7:
			break;
			
		case PROJECT_PARAMETER_8:
			break;
			
		case PROJECT_PARAMETER_9:
			break;
			
		case RANK:
			break;
			
		case REAL_END_DATE:
			break;
			
		case REAL_START_DATE:
			break;
			
		case REMAINING_ESTIMATE:
			break;
			
		case REPORTER:
			break;
			
		case RESOLUTION:
			break;
			
		case RESOLVED:
			break;
			
		case REWORK:
			break;
			
		case SOLD_UNITS:
			break;
			
		case SPRINT:
			break;
			
		case STATUS:
			break;
			
		case STOP_REASONS:
			break;
			
		case STORY_POINTS:
			break;
		case TIME_SPENT:
			break;
			
		case TOTAL_ESTIMATE_HOURS:
			break;
			
		case UPDATED:
			break;
			
		case Î£_ORIGINAL_ESTIMATE:
			break;
			
		case Î£_REMAINING_ESTIMATE:
			break;
			
		case Î£_TIME_SPENT:
			break;
		}
	}
	
	public enum Columna {
		ISSUE_TYPE("Issue Type"),
		ISSUE_KEY("Issue Key"),
		PRIORITY("Priority"),
		SUMMARY("Summary"),
		ASSIGNEE("Assignee"),
		REPORTER("Reporter"),
		FIX_VERSIONS("Fix versions"),
		COMPONENTS("Components"),
		CUSTOM_ESTIMATE("Custom estimate"),
		ORIGINAL_ESTIMATE("Original estimate"),
		TIME_SPENT("Time spent"),
		REMAINING_ESTIMATE("Remaining estimate"),
		PROGRESS("Progress"),
		CREATED("Created"),
		UPDATED("Updated"),
		STATUS("Status"),
		DUE_DATE("Due date"),
		PLANNED_END_DATE("Planned end date"),
		SPRINT("SPRINT"),
		RESOLUTION("Resolution"),
		REAL_START_DATE("Real start date"),
		REAL_END_DATE("Real end date"),
		RESOLVED("Resolved"),
		RANK("Rank"),
		GEP_PROJECT("GEP project"),
		LABELS("Labels"),
		STORY_POINTS("Story points"),
		PROJECT_PARAMETER_1("Project parameter 1"),
		PROJECT_PARAMETER_2("Project parameter 2"),
		PROJECT_PARAMETER_3("Project parameter 3"),
		PROJECT_PARAMETER_4("Project parameter 4"),
		PROJECT_PARAMETER_5("Project parameter 5"),
		PROJECT_PARAMETER_6("Project parameter 6"),
		PROJECT_PARAMETER_7("Project parameter 7"),
		PROJECT_PARAMETER_8("Project parameter 8"),
		PROJECT_PARAMETER_9("Project parameter 9"),
		PROJECT_PARAMETER_10("Project parameter 10"),
		AFFECTS_VERSIONS("Affects versions"),
		PROJECT_KEY("Project key"),
		PARENT_ISSUE_KEY("Parent issue key"),
		PARENT_ISSUE_SUMMARY("Parent issue summary"),
		KEY_CLIENT("Key client"),
		PLANNED_START_DATE("Planned start date"),
		TOTAL_ESTIMATE_HOURS("Total Estimate Hours"),
		PLANNED_START_DATE_INITIAL("Planned Start Date Initial"),
		PLANNED_END_DATE_INITIAL("Planned End Date Initial"),
		Î£_ORIGINAL_ESTIMATE("Î£ Original Estimate"),
		Î£_TIME_SPENT("Î£ Time Spent"),
		Î£_REMAINING_ESTIMATE("Î£ Remaining Estimate"),
		STOP_REASONS("Stop Reasons"),
		ESTIMATION_DELIVERY_COMMITMENT("Estimation Delivery Commitment"),
		PLANNING_DELIVERY_COMMITMENT("Planning Delivery Commitment"),
		REWORK("Rework"),
		SOLD_UNITS("Sold Units"),
		PROJECT_PARAMETER_11("Project parameter 11"),
		PROJECT_PARAMETER_12("Project parameter 12"),
		EXTERNAL_ISSUE_ID("External Issue Id")
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
