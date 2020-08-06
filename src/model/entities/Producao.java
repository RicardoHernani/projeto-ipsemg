//Coloquei a relação entre as classes Producao e Referencia. Todo item de produção possui uma referência
//Não declarei a referenciaCodigo (FK no banco) conforme feito pelo nélio. Ver depois
package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Producao implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date data;
	private Integer registro;
	
	private Date dataInicial;
	private Date dataFinal;
	

	private Referencia referencia;
	
	public Producao() {
}

	public Producao(Integer id, Date data, Integer registro, Referencia referencia) {
		this.id = id;
		this.data = data;
		this.registro = registro;
		this.referencia = referencia;
	}
	

	public Producao(Integer id, Integer registro, Date dataInicial, Date dataFinal, Referencia referencia) {
		this.id = id;
		this.registro = registro;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.referencia = referencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public Referencia getReferencia() {
		return referencia;
	}

	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}
	
	

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((dataFinal == null) ? 0 : dataFinal.hashCode());
		result = prime * result + ((dataInicial == null) ? 0 : dataInicial.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		result = prime * result + ((registro == null) ? 0 : registro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producao other = (Producao) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (dataFinal == null) {
			if (other.dataFinal != null)
				return false;
		} else if (!dataFinal.equals(other.dataFinal))
			return false;
		if (dataInicial == null) {
			if (other.dataInicial != null)
				return false;
		} else if (!dataInicial.equals(other.dataInicial))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		if (registro == null) {
			if (other.registro != null)
				return false;
		} else if (!registro.equals(other.registro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producao [id=" + id + ", data=" + data + ", registro=" + registro + ", dataInicial=" + dataInicial
				+ ", dataFinal=" + dataFinal + ", referencia=" + referencia + "]";
	}

	

	
	
}
