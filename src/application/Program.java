package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ProducaoDao;
import model.entities.Producao;
import model.entities.Referencia;

public class Program {
	
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
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
		
		System.out.println("\n===== TEST 3: producao findByDate =====");
		Producao producao3 = new Producao (null, new java.sql.Date(sdf.parse("30/07/2020").getTime()), null, null);
		list= producaoDao.findByData(producao3);
		for (Producao obj : list) {
			System.out.println(obj);
		}
	
		
		System.out.println("\n===== TEST 4: producao insert =====");
		Referencia referencia = new Referencia(31305016, null, null, null);
		Producao newProducao = new Producao(null, new Date(), 12345678, referencia);
		producaoDao.insert(newProducao);
		System.out.println("Inserted! New id = " + newProducao.getId());
		
		
		System.out.println("\n===== TEST 5: producao update =====");
		producao = producaoDao.findById(15);
		producao.setRegistro(11111);
		producaoDao.update(producao);
		System.out.println("Upadate completo!!");				
		
		System.out.println("\n===== TEST 6: producao delete =====");
		System.out.println("Entre o id para deletar");
		int id = sc.nextInt();
		producaoDao.deleteById(id);
		System.out.println("Delete realizado!!");
		sc.close();
		
	}
	
	
}