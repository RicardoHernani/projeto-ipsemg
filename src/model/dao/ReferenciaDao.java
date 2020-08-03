package model.dao;

import java.util.List;

import model.entities.Referencia;

public interface ReferenciaDao {

	Referencia findByCodigo (Integer codigo);
	Referencia findByProcedimento (String procedimento);
	List<Referencia> findAll();

}
