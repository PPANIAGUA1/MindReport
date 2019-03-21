package com.mindreport.app.models.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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
import com.mindreport.app.util.Util;

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
					
					Issues issue = new Issues();
					
					for (Entry<Columna, Integer> indiceColumna : setIndiceColumnas) {
												
						Columna columna = indiceColumna.getKey();
						Cell celda = fila.getCell(indiceColumna.getValue());
						
						if(celda != null) {
						
							Object valorDeCelda = Util.Excel.getValorDeCelda(celda);							
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
	
	// Configuracion especifica para la hoja en concreto
	
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
			issues.setAffectsVersions((String) valorDeCelda);
			break;
			
		case ASSIGNEE:
			issues.setAssignee((String) valorDeCelda);
			break;
			
		case COMPONENTS:
			issues.setComponents((String) valorDeCelda);
			break;
			
		case CREATED:
			if(!"".equals(valorDeCelda))
				issues.setCreated((Date) valorDeCelda);
			break;
			
		case CUSTOM_ESTIMATE:
			if(!"".equals(valorDeCelda))
				issues.setCustomEstimate((Double) valorDeCelda);
			break;
			
		case DUE_DATE:
			if(!"".equals(valorDeCelda))
				issues.setDueDate((Date) valorDeCelda);
			break;
			
		case ESTIMATION_DELIVERY_COMMITMENT:
			issues.setEstimationDeliveryCommitment((String) valorDeCelda);
			break;
			
		case EXTERNAL_ISSUE_ID:
			issues.setExternalIssueId((String) valorDeCelda);
			break;
			
		case FIX_VERSIONS:
			issues.setFixVersions((String) valorDeCelda);
			break;
			
		case GEP_PROJECT:
			issues.setGepProject((String) valorDeCelda);
			break;
			
		case ISSUE_TYPE:
			issues.setIssueType((String) valorDeCelda);
			break;
			
		case KEY_CLIENT:
			issues.setKeyClient((String) valorDeCelda);
			break;
			
		case LABELS:
			issues.setLabels((String) valorDeCelda);
			break;
			
		case ORIGINAL_ESTIMATE:
			if(!"".equals(valorDeCelda))
				issues.setOriginalEstimate((Double) valorDeCelda);
			break;
			
		case PARENT_ISSUE_KEY:
			issues.setParentIssueKey((String) valorDeCelda);
			break;
			
		case PARENT_ISSUE_SUMMARY:
			issues.setParentIssueSummary((String) valorDeCelda);
			break;
			
		case PLANNED_END_DATE:
			if(!"".equals(valorDeCelda))
				issues.setPlannedEndDate((Date) valorDeCelda);
			break;
			
		case PLANNED_END_DATE_INITIAL:
			if(!"".equals(valorDeCelda))
				issues.setPlannedEndDateInitial((Date) valorDeCelda);
			break;
			
		case PLANNED_START_DATE:
			if(!"".equals(valorDeCelda))
				issues.setPlannedStartDate((Date) valorDeCelda);			
			break;
			
		case PLANNED_START_DATE_INITIAL:
			if(!"".equals(valorDeCelda))
				issues.setPlannedStartDateInitial((Date) valorDeCelda);			
			break;
			
		case PLANNING_DELIVERY_COMMITMENT:
			issues.setPlanningDeliveryCommitment((String) valorDeCelda);
			break;
			
		case PRIORITY:
			issues.setPriority((String) valorDeCelda);
			break;
			
		case PROGRESS:
			if(!"".equals(valorDeCelda))
				issues.setProgress((Double) valorDeCelda);
			break;
			
		case PROJECT_KEY:
			issues.setProjectKey((String) valorDeCelda);
			break;
			
		case PROJECT_PARAMETER_1:
			issues.setProjectParameter1((String) valorDeCelda);
			break;
			
		case PROJECT_PARAMETER_2:
			issues.setProjectParameter2((String) valorDeCelda);
			break;
			
		case PROJECT_PARAMETER_3:
			issues.setProjectParameter3((String) valorDeCelda);
			break;
			
		case PROJECT_PARAMETER_4:
			issues.setProjectParameter4((String) valorDeCelda);
			break;
			
		case PROJECT_PARAMETER_5:
			issues.setProjectParameter5((String) valorDeCelda);
			break;
			
		case PROJECT_PARAMETER_6:
			issues.setProjectParameter2((String) valorDeCelda);
			break;
			
		case PROJECT_PARAMETER_7:
			issues.setProjectParameter7((String) valorDeCelda);
			break;
			
		case PROJECT_PARAMETER_8:
			issues.setProjectParameter8((String) valorDeCelda);
			break;
			
		case PROJECT_PARAMETER_9:
			issues.setProjectParameter9((String) valorDeCelda);
			break;
						
		case PROJECT_PARAMETER_10:
			issues.setProjectParameter10((String) valorDeCelda);
			break;
			
		case PROJECT_PARAMETER_11:
			issues.setProjectParameter11((String) valorDeCelda);
			break;
			
		case PROJECT_PARAMETER_12:
			issues.setProjectParameter12((String) valorDeCelda);
			break;			
			
		case RANK:
			if(!"".equals(valorDeCelda))
				issues.setRank((Double) valorDeCelda);
			break;
			
		case REAL_END_DATE:
			if(!"".equals(valorDeCelda))
				issues.setRealEndDate((Date) valorDeCelda);			
			break;
			
		case REAL_START_DATE:
			if(!"".equals(valorDeCelda))
				issues.setRealStartDate((Date) valorDeCelda);					
			break;
			
		case REMAINING_ESTIMATE:
			if(!"".equals(valorDeCelda))
				issues.setRemainingEstimate((Double) valorDeCelda);		
			break;
			
		case REPORTER:
			issues.setReporter((String) valorDeCelda);
			break;
			
		case RESOLUTION:
			issues.setResolution((String) valorDeCelda);
			break;
			
		case RESOLVED:
			if(!"".equals(valorDeCelda))
				issues.setResolved((Date) valorDeCelda);
			break;
			
		case REWORK:
			issues.setRework((String) valorDeCelda);
			break;
			
		case SOLD_UNITS:
			if(!"".equals(valorDeCelda))
				issues.setSoldUnits((Double) valorDeCelda);
			break;
			
		case SPRINT:
			issues.setSprint((String) valorDeCelda);
			break;
			
		case STATUS:
			issues.setStatus((String) valorDeCelda);
			break;
			
		case STOP_REASONS:
			issues.setStopReasons((String) valorDeCelda);
			break;
			
		case STORY_POINTS:
			if(!"".equals(valorDeCelda))
				issues.setStoryPoints((Double) valorDeCelda);
			break;
			
		case TIME_SPENT:
			if(!"".equals(valorDeCelda))
				issues.setTimeSpent((Double) valorDeCelda);
			break;
			
		case TOTAL_ESTIMATE_HOURS:
			if(!"".equals(valorDeCelda))
				issues.setTotalEstimateHours((Double) valorDeCelda);
			break;
			
		case UPDATED:
			if(!"".equals(valorDeCelda))
				issues.setUpdated((Date) valorDeCelda);
			break;
			
		case TOTAL_ORIGINAL_ESTIMATE:
			if(!"".equals(valorDeCelda))
				issues.setTotalOriginalEstimate((Double) valorDeCelda);			
			break;
			
		case TOTAL_REMAINING_ESTIMATE:
			if(!"".equals(valorDeCelda))
				issues.setTotalRemainingEstimate((Double) valorDeCelda);					
			break;
			
		case TOTAL_TIME_SPENT:
			if(!"".equals(valorDeCelda))
				issues.setTotalTimeSpent((Double) valorDeCelda);					
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
		TOTAL_ORIGINAL_ESTIMATE("\u03A3 Original Estimate"),
		TOTAL_TIME_SPENT("\u03A3 Time Spent"),
		TOTAL_REMAINING_ESTIMATE("\u03A3 Remaining Estimate"),
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
