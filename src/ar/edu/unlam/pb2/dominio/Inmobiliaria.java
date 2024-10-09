package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Inmobiliaria {

	private Set<Propiedad> propiedades;
	
	public Inmobiliaria() {
		this.propiedades = new HashSet<Propiedad>();
	}

	public void darDeAltaPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
		
	}
	
	public Integer promedioValorCasas() {
		Integer sumaValorCasas = 0;
		Integer contadorCasas = 0;
		for (Propiedad propiedadActual : propiedades) {
			if(propiedadActual instanceof Casa) {
				sumaValorCasas += propiedadActual.getValor(); 
				contadorCasas++;
			}
		}
		Integer promedioTotalDeCasas = sumaValorCasas / contadorCasas;
		
		return promedioTotalDeCasas;
		
	}
	
	public Integer promedioValorDepartamentos() {
		Integer sumaValorDepartamentos = 0;
		Integer contadorDepartamentos = 0;
		for (Propiedad propiedadActual : propiedades) {
			if(propiedadActual instanceof Departamento) {
				sumaValorDepartamentos += propiedadActual.getValor(); 
				contadorDepartamentos++;
			}
		}
		Integer promedioTotalDeDepartamentos = sumaValorDepartamentos / contadorDepartamentos;
		
		return promedioTotalDeDepartamentos;
	}
	
	public List<Propiedad> busquedaPorRangoDePrecio(Integer minimo, Integer maximo) {
		List<Propiedad> propiedadesObtenidasPorRango = new ArrayList<Propiedad>();
		for (Propiedad propiedadActual : propiedades) {
			if(propiedadActual.getValor() >= minimo && propiedadActual.getValor() <= maximo) {
				propiedadesObtenidasPorRango.add(propiedadActual);
			}
		}
		if(propiedadesObtenidasPorRango.isEmpty()) {
			propiedadesObtenidasPorRango = null;
		}
		return propiedadesObtenidasPorRango;
	}
	
	public List<Propiedad> busquedaPropiedadesPorVenta() {
		List<Propiedad> propiedadesPorVenta = new ArrayList<Propiedad>();
		for (Propiedad propiedadActual : propiedades) {
			if(propiedadActual.getEstado().equals(Estado.VENTA)) {
				propiedadesPorVenta.add(propiedadActual);
			}
		}
		if(propiedadesPorVenta.isEmpty()) {
			propiedadesPorVenta = null;
		}
		return propiedadesPorVenta;
	}
	
	
	

	public Set<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Set<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}
}
