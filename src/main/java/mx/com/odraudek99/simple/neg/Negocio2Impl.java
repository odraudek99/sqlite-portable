package mx.com.odraudek99.simple.neg;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import mx.com.odraudek99.simple.dao.DaoImpl;
import mx.com.odraudek99.simple.dto.TPadre;


@Service
public class Negocio2Impl {
	final static Logger logger = Logger.getLogger(NegocioImpl.class);
	@Autowired
	DaoImpl daoImpl;
	
	@Autowired
	NegocioImpl negocioImpl;
	
	@Transactional(rollbackFor = ServiceException.class)
	public void pruebaTransaccionHilos() throws ServiceException{
		logger.info("idTrans.Negocio2Impl: "+TransactionAspectSupport.currentTransactionStatus().hashCode());
		List<TPadre> listaP = daoImpl.selectPadreAll();
		
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        for (TPadre p : listaP) {
        	logger.info("idTrans.Negocio2Impl for2: "+TransactionAspectSupport.currentTransactionStatus().hashCode());
        	HiloTransaccional task = new HiloTransaccional(p.getIdTPadre(),p.getDescripcion(), negocioImpl);
            logger.info("A new task has been added : " + task.getNombreHilo());
            executor.execute(task);
        }
        executor.shutdown();
        
        logger.error("Errores: "+HiloTransaccional.errores.size());
        if (HiloTransaccional.errores.size() > 0) {
        	throw new ServiceException("Error forzado en Negocio2");
        }
        
        
	}
	
	
}
