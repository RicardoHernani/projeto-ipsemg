package model.dao;

import java.util.List;

import model.entities.Referencia;

public interface ReferenciaDao {

	Referencia findbycodigo (Integer codigo);
	Referencia findbyprocedimento (String procedimento);
	List<Referencia> findAll();

}
