package ddsgrupo3;

import java.io.FileInputStream;
import java.util.Properties;

public class Factory
{
	public static Object getObject (String name)
	{
		try
		{
			FileInputStream file = new FileInputStream("Factory.properties");
			Properties propiedades = new Properties();
			propiedades.load(file);
			String clase = propiedades.getProperty(name);
			return Class.forName(clase).newInstance();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
