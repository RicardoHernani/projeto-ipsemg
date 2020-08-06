package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ReferenciaDao;
import model.entities.Referencia;

public class ReferenciaDaoJDBC implements ReferenciaDao {

	private Connection conn;
	
	public ReferenciaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Referencia findByCodigo(Integer codigo) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM referencia WHERE codigo=? ");
		
			st.setInt(1, codigo);
			rs = st.executeQuery();
			if (rs.next()) {
				Referencia obj = new Referencia();
				obj.setCodigo(rs.getInt("Codigo"));
				obj.setProcedimento(rs.getString("Procedimento"));
				obj.setPontos(rs.getDouble("Pontos"));
				obj.setValor(rs.getDouble("Valor"));
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
	public List<Referencia> findByProcedimento(Referencia referencia) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM referencia WHERE procedimento LIKE ? ");
		
			st.setString(1, referencia.getProcedimento());
			rs = st.executeQuery();
			
			List<Referencia> list = new ArrayList<>();					
			
			while (rs.next()) {
				Referencia obj = new Referencia(); 
				obj.setCodigo(rs.getInt("Codigo"));
				obj.setProcedimento(rs.getString("Procedimento"));
				obj.setPontos(rs.getDouble("Pontos"));
				obj.setValor(rs.getDouble("Valor"));
				list.add(obj);
			
			}
			return list;
		
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	
	
}
