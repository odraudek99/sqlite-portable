package mx.com.odraudek99.simple;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import mx.com.odraudek99.simple.dto.THija;
import mx.com.odraudek99.simple.dto.TPadre;
import mx.com.odraudek99.simple.neg.NegocioImpl;
import mx.com.odraudek99.simple.neg.ServiceException;

public class MainCorreccion {


	final static Logger logger = Logger.getLogger(MainCorreccion.class);
	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring.xml");

		NegocioImpl negocioImpl = (NegocioImpl) context.getBean(NegocioImpl.class);
		
		
		TPadre p1 = new TPadre(1);
		p1.getDetalle().add(new THija(1,"1"));
		p1.getDetalle().add(new THija(2,"1"));
		p1.getDetalle().add(new THija(3,"1"));
		
		
		TPadre p2 = new TPadre(2);
		p1.getDetalle().add(new THija(4,"1"));
		p1.getDetalle().add(new THija(5,"1"));
		p1.getDetalle().add(new THija(6,"1"));
		
		List<TPadre> lista = new ArrayList<TPadre>();
		lista.add(p1);
		lista.add(p2);
		
		try {
			negocioImpl.iniciaPrueba(lista);
		} catch (ServiceException e) {
			logger.error("ServiceException: Debe hacer rollback", e);
		 } catch (DataAccessException ex) {
			 logger.error("DataAccessException:  Debe hacer rollback", ex); 
		 } catch (Exception ex) {
			 logger.error("Exception:  Debe hacer rollback", ex);
		 }

		negocioImpl.selectAll();
		
	}

}
