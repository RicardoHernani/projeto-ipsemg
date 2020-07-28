package model.dao;

import model.dao.impl.ProducaoDaoJDBC;

public class DaoFactory {

	public static ProducaoDao createProducaoDao() {
		return new ProducaoDaoJDBC();
	}
	
}
