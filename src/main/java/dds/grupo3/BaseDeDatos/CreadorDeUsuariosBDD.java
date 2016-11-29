package dds.grupo3.BaseDeDatos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import dds.grupo3.User.Rol;
import dds.grupo3.User.Usuario;

public class CreadorDeUsuariosBDD {
	public static void inicializar(Session session) {
		List<Usuario> usuarios =new ArrayList<Usuario>();
		usuarios=cargarUsuarios();
        for(Usuario u:usuarios){
        	session.beginTransaction();
        	session.save(u);
        	session.getTransaction().commit();
        }	
        
        Rol rol=new Rol();
		rol.setNombre("transeunte");
		List<String> permisos=new ArrayList<String>();
		permisos.add("ConsultarPOI");
		rol.setPermisos(permisos);
		session.beginTransaction();
    	session.save(rol);
    	session.getTransaction().commit();
   }
	private static List<Usuario> cargarUsuarios(){
		
		Rol rol=new Rol();
		rol.setNombre("administrador 1");
		List<String> permisos=new ArrayList<String>();
		permisos.add("AgregarPOI");
		permisos.add("BorrarPOI");
		permisos.add("ConsultarPOI");
		permisos.add("ModificarPOI");
		permisos.add("VerHistorial");
		permisos.add("RealizarAcciones");
		rol.setPermisos(permisos);
		
		List<Usuario> usuarios =new ArrayList<Usuario>();
		Usuario u1= new Usuario();
		u1.setNombre("Lucas");
		u1.setContrasenia("hola1234");
		u1.setUsername("lucas");
		u1.setRol(rol);
		usuarios.add(u1);
		u1=new Usuario();
		u1.setNombre("Nicole");
		u1.setContrasenia("dds3");
		u1.setUsername("Nicole");
		u1.setRol(rol);
		usuarios.add(u1);
		u1=new Usuario();
		u1.setNombre("Kevin");
		u1.setContrasenia("kevin");
		u1.setUsername("Kevin");
		u1.setRol(rol);
		usuarios.add(u1);
		u1=new Usuario();
		u1.setNombre("Federico");
		u1.setContrasenia("38636837");
		u1.setUsername("Federico");
		u1.setRol(rol);
		usuarios.add(u1);
		
		return usuarios;
	}
}
