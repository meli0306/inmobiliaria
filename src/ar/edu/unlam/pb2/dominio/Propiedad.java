package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public class Propiedad {

	private String calle;
	private Integer numero;
	private String localidad;
	private Integer valor;
	private Estado estado;

	public Propiedad(String calle, Integer numero, String localidad, Integer valor, Estado estado) {
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.valor = valor;
		this.estado = estado;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, localidad, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propiedad other = (Propiedad) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(localidad, other.localidad)
				&& Objects.equals(numero, other.numero);
	}
}
