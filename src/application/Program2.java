package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ReferenciaDao;
import model.entities.Referencia;

public class Program2 {

	public static void main(String[] args) {
	
	ReferenciaDao referenciaDao = DaoFactory.createReferenciaDao();
	
	System.out.println("===== TEST 1: referencia findByCodigo =====");
	Referencia ref = referenciaDao.findByCodigo(31104134);
	System.out.println(ref);
	
	
	System.out.println("\n===== TEST 2: referencia findByProcedimento =====");
	
	Scanner sc = new Scanner(System.in);
	String busca= sc.nextLine();
	
	Referencia ref2 = new Referencia (null, "%" + busca+ "%", null, null); //Maiúscula e Minúscula não faz diferença
	List<Referencia> list= referenciaDao.findByProcedimento(ref2);
	for (Referencia obj : list) {
		System.out.println(obj);
		
	sc.close();
	}
	
	}

}
