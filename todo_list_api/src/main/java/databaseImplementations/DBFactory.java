package databaseImplementations;

import org.apache.commons.lang3.NotImplementedException;

import enums.DBType;
import interfaces.IToDoList;

public final class DBFactory {
	
	private static ToDoList listDBSimulatorInstance = null;
	
	public static IToDoList getDaoInstance(DBType daoType) {
		switch(daoType) {
		case SimulationByJavaObjects:
			if(listDBSimulatorInstance == null) {
				listDBSimulatorInstance = new ToDoList();
			}
			return listDBSimulatorInstance;
		default:
			throw new NotImplementedException("Database type " + daoType.toString() + 
					" is not currently implemented.");
		}
	}
}
