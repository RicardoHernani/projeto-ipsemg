package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ProducaoDao;
import model.entities.Producao;
import model.entities.Referencia;

public class ProducaoDaoJDBC implements ProducaoDao {

	private Connection conn;
	
	public ProducaoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void insert(Producao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Producao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producao findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT producao .*, referencia.Procedimento as Procedimento, referencia.Pontos as Pontos, referencia.Valor as Valor "
					+ "FROM producao INNER JOIN referencia "
					+ "ON producao.ReferenciaCodigo = referencia.Codigo "
					+ "WHERE producao.Id = ?");
		
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Referencia ref = new Referencia();
				ref.setCodigo(rs.getInt("ReferenciaCodigo"));
				ref.setProcedimento(rs.getString("Procedimento"));
				Producao obj = new Producao();
				obj.setId(rs.getInt("Id"));
				obj.setData(rs.getDate("Data"));
				obj.setRegistro(rs.getInt("Registro"));				
				obj.setReferencia(ref);
				
				
				
				return obj;
			}
			return null;
		
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
	}

	
	
	
	@Override
	public Producao findByData(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producao findByRegistro(Integer registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
