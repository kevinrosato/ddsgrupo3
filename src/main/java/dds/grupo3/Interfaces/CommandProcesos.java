package dds.grupo3.Interfaces;

import java.util.Calendar;
import java.util.TimerTask;

public interface CommandProcesos {

	public void run();
	public void setTask(TimerTask task,Calendar fechaInicio,User usuario, String terminalID);
	public void pedirInfo();
	public String setProceso();
}
