package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public class Departamento extends Propiedad {

	private Integer piso;
	private String departamento;

	public Departamento(String calle, Integer numero, Integer piso, String localidad, String departamento, Integer valor, Estado estado) {
		super(calle, numero, localidad, valor, estado);
		this.piso = piso;
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(departamento, piso);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(departamento, other.departamento) && Objects.equals(piso, other.piso);
	}
	
	

}
