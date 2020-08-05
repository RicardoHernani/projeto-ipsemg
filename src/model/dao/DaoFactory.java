package model.dao;

import db.DB;
import model.dao.impl.ProducaoDaoJDBC;
import model.dao.impl.ReferenciaDaoJDBC;

public class DaoFactory {

	public static ProducaoDao createProducaoDao() {
		return new ProducaoDaoJDBC(DB.getConnection());
	}

	public static ReferenciaDao createReferenciaDao() {
		return new ReferenciaDaoJDBC(DB.getConnection());
	}
	
}

