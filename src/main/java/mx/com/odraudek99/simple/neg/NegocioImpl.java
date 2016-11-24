package mx.com.odraudek99.simple.neg;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import mx.com.odraudek99.simple.dao.DaoImpl;
import mx.com.odraudek99.simple.dto.THija;
import mx.com.odraudek99.simple.dto.TPadre;


@Service
public class NegocioImpl {

	final static Logger logger = Logger.getLogger(NegocioImpl.class);
	@Autowired
	DaoImpl daoImpl;
	
	List<Integer> padres = new ArrayList<Integer>();
	

	
	@Transactional(rollbackFor = ServiceException.class, propagation = Propagation.REQUIRES_NEW)
	public void iniciaPrueba(List<TPadre> idPadres) throws DataAccessException, ServiceException {
		logger.info("idTrans: "+TransactionAspectSupport.currentTransactionStatus().hashCode());
		
		 afectarC(idPadres);
	}
	
	@Transactional(rollbackFor = ServiceException.class, propagation = Propagation.REQUIRED)
    public void afectarC(List<TPadre> idPadres) throws ServiceException {
		
		for (TPadre tPadre : idPadres) {
			validarVigilables(tPadre);
		}
		
	}
	
	
	@Transactional(rollbackFor = ServiceException.class, propagation = Propagation.REQUIRED)
	public void validarVigilables(TPadre tPadre) throws ServiceException  {
		
		if (daoImpl.updateHijas(tPadre) == null) {
			logger.info("Lanzar excepcion");
			throw new ServiceException();
		}
		daoImpl.actualizaEdo(tPadre.getIdTPadre());
		
	}

	public void selectAll() {
		List<TPadre> lista = daoImpl.selectPadreAll();
		for (TPadre padre : lista) {
			logger.info(padre.toString());
			List<THija> hijas= daoImpl.selectHijaAll(padre.getIdTPadre());
			for (THija hija: hijas) {
				logger.info(hija.toString());	
			}
		}
		
	}

	
}
