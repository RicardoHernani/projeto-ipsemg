package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProducaoDao;
import model.entities.Producao;

public class Program {
	
	public static void main(String[] args) {

		ProducaoDao producaoDao = DaoFactory.createProducaoDao();
		
		System.out.println("===== TEST 1: producao findById =====");
		Producao producao = producaoDao.findById(3);
		System.out.println(producao);
		
		
		System.out.println("\n===== TEST 2: producao findByRegistro =====");
		Producao producao2 = new Producao(null, null, 100117968, null);
		List<Producao> list= producaoDao.findByRegistro(producao2);
		for (Producao obj : list) {
			System.out.println(obj);
		}
	}	
}