import org.hibernate.Session;
import java.sql.Date;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		añadirFestival();
		//recuperarFestival();
		
		//añadirActuacion();
		//recuperarActuacion();
		
		//añadirGrupo();
		//recuperarGrupo();
		
	}
	
		 
		public static void añadirFestival() {
			Session session=hibernate_utilities.getSessionFactory().openSession();
			session.beginTransaction();
			
			Festival f=new Festival();
			
			f.setNombre("Medusa3");
			f.setLugar("Cullera");
			java.util.Date utilDate = new java.util.Date();
			f.setFecha(new java.sql.Date(utilDate.getTime()));
			session.save(f);
			
			Festival f2=new Festival();
			
			f2.setNombre("Amoto3");
			f2.setLugar("Sueca");
			java.util.Date utilDate1 = new java.util.Date();
			f2.setFecha(new java.sql.Date(utilDate1.getTime()));
			session.save(f2);
			
			
			session.getTransaction().commit();
			session.close();
			hibernate_utilities.getSessionFactory().close();
		}
		
		public static void recuperarFestival() {
			Session session=hibernate_utilities.getSessionFactory().openSession();
			session.beginTransaction();
			
			Festival f=session.get(Festival.class, "Medusa");
			System.out.println("Se ha encontrado con el festival con nombre: "+f.getNombre()+"en "+f.getLugar()+"fecha: "+f.getFecha());
			
			session.getTransaction().commit();
			
			Festival f2=session.get(Festival.class, "Amoto");
			System.out.println("Se ha encontrado con el festival con nombre: "+f2.getNombre()+"en "+f2.getLugar()+"fecha: "+f2.getFecha());
			
			session.getTransaction().commit();
			
			session.close();
			hibernate_utilities.getSessionFactory().close();
		}
		
		public static void añadirActuacion() {
			Session session=hibernate_utilities.getSessionFactory().openSession();
			session.beginTransaction();
			
			Actuacion a=new Actuacion();
			
			a.setHora("00:00");
			a.setEscenario("Secundario");
			session.save(a);
			
			Actuacion a2=new Actuacion();
			
			a2.setHora("01:00");
			a2.setEscenario("Principal");
			session.save(a2);
			
			
			session.getTransaction().commit();
			session.close();
			hibernate_utilities.getSessionFactory().close();
		}
		
		public static void recuperarActuacion() {
			Session session=hibernate_utilities.getSessionFactory().openSession();
			session.beginTransaction();
			
			Actuacion a=session.get(Actuacion.class, "23:00");
			System.out.println("Se ha encontrado : "+a.getHora()+" "+a.getEscenario());
			
			Actuacion a2=session.get(Actuacion.class, "01:00");
			System.out.println("Se ha encontrado : "+a2.getHora()+" "+a2.getEscenario());
			
			session.getTransaction().commit();
			
			session.close();
			hibernate_utilities.getSessionFactory().close();
		}
		
		public static void añadirGrupo() {
			Session session=hibernate_utilities.getSessionFactory().openSession();
			session.beginTransaction();
			
			Grupo g=new Grupo();
			
			g.setNombre_grupo("Iron Maidennnn");
			g.setEstilo("Rock");
			g.setNum_Miembros(4);
			
			session.save(g);
			Grupo g2=new Grupo();
			
			g2.setNombre_grupo("Beatles");
			g2.setEstilo("Rock Suave");
			g2.setNum_Miembros(4);
			
			session.save(g2);
			
			session.getTransaction().commit();
			session.close();
			hibernate_utilities.getSessionFactory().close();
		}
		
		public static void recuperarGrupo() {
			Session session=hibernate_utilities.getSessionFactory().openSession();
			session.beginTransaction();
			
			Grupo g=session.get(Grupo.class, "ACDC");
			System.out.println("Se ha encontrado : "+g.getNombre_grupo()+" "+g.getEstilo()+" "+g.getNum_Miembros());
			
			Grupo g2=session.get(Grupo.class, "Iron Maiden");
			System.out.println("Se ha encontrado : "+g2.getNombre_grupo()+" "+g2.getEstilo()+" "+g2.getNum_Miembros());
			
			session.getTransaction().commit();
			
			session.close();
			hibernate_utilities.getSessionFactory().close();
		}
		

		/*
		 List datos=null;
		 datos=session.find("from users");
		 */
	

}
