package dds.grupo3.Interfaces.EnDesuso;

import java.util.Calendar;
import java.util.TimerTask;

import dds.grupo3.Interfaces.User;

public interface CommandProcesos {

	public void run();
	public void setTask(TimerTask task,Calendar fechaInicio,User usuario, String terminalID);
	public void pedirInfo();
	public String setProceso();
}
