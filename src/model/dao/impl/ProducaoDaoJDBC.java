package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
					+ "WHERE producao.Id = ? ");
		
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Referencia ref = instantiateReferencia(rs);
				
				
				Producao obj = instantiateProducao(rs, ref);
				
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
	
	private Producao instantiateProducao(ResultSet rs, Referencia ref) throws SQLException {
		Producao obj = new Producao();
		obj.setId(rs.getInt("Id"));
		obj.setData(rs.getDate("Data"));
		obj.setRegistro(rs.getInt("Registro"));				
		obj.setReferencia(ref);
		return obj;
	}


	private Referencia instantiateReferencia(ResultSet rs) throws SQLException {
		Referencia ref = new Referencia();
		ref.setCodigo(rs.getInt("ReferenciaCodigo"));
		ref.setProcedimento(rs.getString("Procedimento"));
		ref.setPontos(rs.getDouble("Pontos"));
		ref.setValor(rs.getDouble("Valor"));
		return ref;
	}


	@Override
	public Producao findByData(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<Producao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Producao> findByRegistro(Producao producao) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT producao .*, referencia.Procedimento as Procedimento, referencia.Pontos as Pontos, referencia.Valor as Valor "
					+ "FROM producao INNER JOIN referencia "
					+ "ON producao.ReferenciaCodigo = referencia.Codigo "
					+ "WHERE producao.registro=? ");
		
			st.setInt(1, producao.getRegistro());
			rs = st.executeQuery();
			
			List<Producao> list = new ArrayList<>();
			
			while (rs.next()) {
				Referencia ref = instantiateReferencia(rs); //Não fiz como indicado na aula 247 com a estrutura Map porque acho que nesse caso os objetos ref são diferentes e precisam ser instanciados.
				Producao obj = instantiateProducao(rs, ref);
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
