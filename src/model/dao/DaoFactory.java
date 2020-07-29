package model.dao;

import db.DB;
import model.dao.impl.ProducaoDaoJDBC;

public class DaoFactory {

	public static ProducaoDao createProducaoDao() {
		return new ProducaoDaoJDBC(DB.getConnection());
	}
	
}
