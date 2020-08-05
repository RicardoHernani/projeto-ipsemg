package application;

import model.dao.DaoFactory;
import model.dao.ReferenciaDao;
import model.entities.Referencia;

public class Program2 {

	public static void main(String[] args) {
	
	ReferenciaDao referenciaDao = DaoFactory.createReferenciaDao();
	
	System.out.println("===== TEST 1: producao findByCodigo =====");

	Referencia ref = referenciaDao.findByCodigo(31104134);
	System.out.println(ref);
	
	}

}
