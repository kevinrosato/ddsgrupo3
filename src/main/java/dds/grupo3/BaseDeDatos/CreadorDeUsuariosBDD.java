package dds.grupo3.BaseDeDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;

import dds.grupo3.Interfaces.POIGral;
import dds.grupo3.User.Usuario;
import ddsgrupo3.Mapa;

public class CreadorDeUsuariosBDD {
	public static void inicializar(Session session) {
		List<Usuario> usuarios =new ArrayList<Usuario>();
		usuarios=cargarUsuarios();
        for(Usuario u:usuarios){
        	session.beginTransaction();
        	session.save(u);
        	session.getTransaction().commit();
        }	
   }
	private static List<Usuario> cargarUsuarios(){
		List<Usuario> usuarios =new ArrayList<Usuario>();
		Usuario u1= new Usuario();
		u1.setNombre("Lucas");
		u1.setContrasenia("hola1234");
		u1.setUsername("lucas");
		usuarios.add(u1);
		u1=new Usuario();
		u1.setNombre("Nicole");
		u1.setContrasenia("dds3");
		u1.setUsername("Nicole");
		usuarios.add(u1);
		u1=new Usuario();
		u1.setNombre("Kevin");
		u1.setContrasenia("kevin");
		u1.setUsername("Kevin");
		usuarios.add(u1);
		u1=new Usuario();
		u1.setNombre("Federico");
		u1.setContrasenia("38636837");
		u1.setUsername("Federico");
		usuarios.add(u1);
		
		return usuarios;
	}
}
