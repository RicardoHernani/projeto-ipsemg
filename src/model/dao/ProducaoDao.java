package model.dao;

import java.util.List;

import model.entities.Producao;

public interface ProducaoDao {

	void insert (Producao obj);
	void update (Producao obj);
	void deleteById (Integer id);
	Producao findById (Integer id);
	List<Producao> findByRegistro (Producao producao);
	List<Producao> findByData (Producao producao);
	List<Producao> findByIntervaloData (Producao producao);
	
}
