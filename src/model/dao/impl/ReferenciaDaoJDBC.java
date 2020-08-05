package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ReferenciaDao;
import model.entities.Producao;
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
	public List<Referencia> findByProdedimento(String procedimento) {
		// TODO Auto-generated method stub
		return null;
	}
}
