package ar.edu.ucc.trabajoFinal.utils;

import java.util.Properties;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.model.Criticidad;
import ar.edu.ucc.trabajoFinal.model.Estado;
import ar.edu.ucc.trabajoFinal.model.HistorialNodo;
import ar.edu.ucc.trabajoFinal.model.Nodo;
import ar.edu.ucc.trabajoFinal.model.ObjetoGenerico;
import ar.edu.ucc.trabajoFinal.model.TipoProcesamiento;
import ar.edu.ucc.trabajoFinal.model.Trama;
import ar.edu.ucc.trabajoFinal.model.TramaProcesada;
import ar.edu.ucc.trabajoFinal.model.Umbral;
import ar.edu.ucc.trabajoFinal.model.UmbralEspecifico;
import ar.edu.ucc.trabajoFinal.model.UnidadMedida;
import ar.edu.ucc.trabajoFinal.model.Usuario;
import ar.edu.ucc.trabajoFinal.model.UserProfile;


public class SqlSchemaGenerator {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.put("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/TrabajoFinal"); 
		properties.put("hibernate.connection.username", "root");
		properties.put("hibernate.connection.password", "root");
		properties.put("hibernate.connection.driver_class", "org.gjt.mm.mysql.Driver");
		properties.put("hibernate.show_sql", "true");
		config.setProperties(properties);
		
		config.addAnnotatedClass(ObjetoGenerico.class);
		config.addAnnotatedClass(Trama.class);
		config.addAnnotatedClass(Nodo.class);
		config.addAnnotatedClass(Umbral.class);
		config.addAnnotatedClass(UmbralEspecifico.class);
		config.addAnnotatedClass(Alerta.class);
		config.addAnnotatedClass(TramaProcesada.class);
		config.addAnnotatedClass(Criticidad.class);
		config.addAnnotatedClass(UnidadMedida.class);
                config.addAnnotatedClass(TipoProcesamiento.class);
                config.addAnnotatedClass(Usuario.class);
                config.addAnnotatedClass(UserProfile.class);
                config.addAnnotatedClass(Estado.class);
                config.addAnnotatedClass(HistorialNodo.class);
		
		SchemaExport schemaExport = new SchemaExport(config);
		schemaExport.setDelimiter(";");

		schemaExport.setOutputFile("src/main/resources/Schema.sql");
		schemaExport.setFormat(true);
		schemaExport.execute(true, false, false, false);
	}
}
