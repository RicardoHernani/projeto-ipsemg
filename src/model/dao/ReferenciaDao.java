package model.dao;

import java.util.List;

import model.entities.Referencia;

public interface ReferenciaDao {

	Referencia findByCodigo (Integer codigo);
	List<Referencia> findByProcedimento (Referencia referencia);
	

}
