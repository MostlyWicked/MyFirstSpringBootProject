package databaseImplementations;

import org.apache.commons.lang3.NotImplementedException;

import enums.DBType;
import interfaces.ITask;

public class TaskFactory {
	public static ITask getTaskObject(DBType dbType, int id, String title, String description) {
		switch(dbType) {
		case SimulationByJavaObjects:
			return new TaskImpl(id, title, description);
		default:
			throw new NotImplementedException("Task class not implemented for selected DB type");
		}
	}
}
