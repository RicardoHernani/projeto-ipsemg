package application;

import model.dao.DaoFactory;
import model.dao.ProducaoDao;
import model.entities.Producao;

public class Program {
	
	public static void main(String[] args) {

		ProducaoDao producaoDao = DaoFactory.createProducaoDao();
		
		System.out.println("===== TEST 1: producao findById =====");
		Producao producao = producaoDao.findById(3);
		System.out.println(producao);

	}
}