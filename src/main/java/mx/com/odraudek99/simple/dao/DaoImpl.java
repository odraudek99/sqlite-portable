package mx.com.odraudek99.simple.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.com.odraudek99.simple.dto.THija;
import mx.com.odraudek99.simple.dto.TPadre;
import mx.com.odraudek99.simple.neg.ServiceException;

@Repository
public class DaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Integer updateHijas(TPadre tPadre) {
		
		final List<THija> hijas = tPadre.getDetalle();
		
		int[] total =  jdbcTemplate.batchUpdate("UPDATE T_HIJA SET ESTATUS = ? WHERE ID_T_HIJA = ? ", 
				new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i) throws SQLException {
					THija hija = hijas.get(i);
					ps.setLong(1, Integer.parseInt(hija.getEstatus()));
					ps.setInt(2,  hija.getIdTHija());
			}
			public int getBatchSize() {
					return hijas.size();
			}
			 });
		
		return total.length;

	}

	public Integer estatusHijas(TPadre tPadre) {
		
		Integer total =  jdbcTemplate.queryForObject("select count(*) from T_HIJA where ID_T_PADRE = " +tPadre.getIdTPadre()+" and ESTATUS = 0", Integer.class);
		return total;
		
	}

	 @Transactional(rollbackFor = ServiceException.class, propagation = Propagation.REQUIRED)
	public void actualizaEdo(Integer idPadre) throws ServiceException {

		 jdbcTemplate.update("UPDATE T_PADRE SET ESTATUS = 1 WHERE ID_T_PADRE = ? ", idPadre);
	}

	public List<THija> selectHijaAll(Integer idTPadre) {
		return jdbcTemplate.query("select * from T_HIJA where ID_T_PADRE="+idTPadre, new BeanPropertyRowMapper<THija>(THija.class));
	}


	public List<TPadre> selectPadreAll() {
		return jdbcTemplate.query("select * from T_PADRE ", new BeanPropertyRowMapper<TPadre>(TPadre.class));
	}

	public void actualizaPadre(Integer id, String nombre) {
		jdbcTemplate.update("UPDATE T_PADRE SET DESCRIPCION = ? WHERE ID_T_PADRE = ? ", new Object[]{nombre, id});
		
	}
	
}
