package model.dao;

import java.util.Date;
import java.util.List;

import model.entities.Producao;

public interface ProducaoDao {

	void insert (Producao obj);
	void update (Producao obj);
	void deleteById (Integer id);
	Producao findById (Integer id);
	Producao findByData (Date data);
	List<Producao> findByRegistro (Producao producao);
	List<Producao> findAll();
	
	
}
