//Coloquei a rela��o entre as classes Producao e Referencia. Todo item de produ��o possui uma refer�ncia

package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Producao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date data;
	private Integer registro;
	private Integer referenciaCodigo;

	private Referencia referencia;
	
	public Producao() {
}

	
	