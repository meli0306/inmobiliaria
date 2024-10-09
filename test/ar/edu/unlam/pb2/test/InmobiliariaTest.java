package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.Casa;
import ar.edu.unlam.pb2.dominio.Departamento;
import ar.edu.unlam.pb2.dominio.Estado;
import ar.edu.unlam.pb2.dominio.Inmobiliaria;
import ar.edu.unlam.pb2.dominio.Propiedad;

public class InmobiliariaTest {

	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
		Propiedad casa = new Casa("peron", 123, "san justo", 10, Estado.VENTA);
		
		inmobiliaria.darDeAltaPropiedad(casa);
		
		
		assertEquals(1, inmobiliaria.getPropiedades().size());
	}
	
	@Test
	public void queSePuedaDarDeAltaDosCasaEnLaInmobiliaria() {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
		Propiedad casa1 = new Casa("peron", 123, "san justo", 10, Estado.VENTA);
		Propiedad casa2 = new Casa("peron", 125, "san justo", 50, Estado.VENTA);
		
		inmobiliaria.darDeAltaPropiedad(casa1);
		inmobiliaria.darDeAltaPropiedad(casa2);
		
		assertEquals(2, inmobiliaria.getPropiedades().size());
	}
	
	@Test
	public void queNoSePuedaDarDeAltaDosCasaConUnaMismaDireccion() {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
		Propiedad casa1 = new Casa("peron", 123, "san justo", 10, Estado.VENTA);
		Propiedad casa2 = new Casa("peron", 123, "san justo", 50, Estado.VENTA);
		
		inmobiliaria.darDeAltaPropiedad(casa1);
		inmobiliaria.darDeAltaPropiedad(casa2);
		
		assertEquals(1, inmobiliaria.getPropiedades().size());
	}
	
	@Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
		Propiedad departamento = new Departamento("peron", 123, 1, "A", "san justo",20, Estado.ALQUILER);
		
		inmobiliaria.darDeAltaPropiedad(departamento);
		
		assertEquals(1, inmobiliaria.getPropiedades().size());
	}
	
	@Test
	public void queSePuedaDarDeAltaDosDepartamentosEnLaInmobiliaria() {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
		Propiedad departamento1 = new Departamento("peron", 123, 1, "A", "san justo",20, Estado.ALQUILER);
		Propiedad departamento2 = new Departamento("peron", 123, 1, "B", "san justo",30, Estado.ALQUILER);
		
		inmobiliaria.darDeAltaPropiedad(departamento1);
		inmobiliaria.darDeAltaPropiedad(departamento2);
		
		assertEquals(2, inmobiliaria.getPropiedades().size());
	}
	
	@Test
	public void queNoSePuedaDarDeAltaDosDepartamentosConUnaMismaDireccion() {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
		Propiedad departamento1 = new Departamento("peron", 123, 1, "A", "san justo",20, Estado.ALQUILER);
		Propiedad departamento2 = new Departamento("peron", 123, 1, "A", "san justo",30, Estado.ALQUILER);
		
		inmobiliaria.darDeAltaPropiedad(departamento1);
		inmobiliaria.darDeAltaPropiedad(departamento2);
		
		assertEquals(1, inmobiliaria.getPropiedades().size());
	}

	@Test
	public void queSePuedaObtenerValorPromedioDeLasCasas() {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
		Propiedad casa1 = new Casa("peron", 123, "san justo", 10, Estado.VENTA);
		Propiedad casa2 = new Casa("peron", 125, "san justo", 50, Estado.VENTA);
		
		inmobiliaria.darDeAltaPropiedad(casa1);
		inmobiliaria.darDeAltaPropiedad(casa2);
		
		Integer valorEsperado = 30;
		Integer valorObtenido = inmobiliaria.promedioValorCasas();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaObtenerValorPromedioDeLOsDepartamentos() {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
		Propiedad departamento1 = new Departamento("peron", 123, 1, "A", "san justo",20, Estado.ALQUILER);
		Propiedad departamento2 = new Departamento("peron", 123, 1, "B", "san justo",30, Estado.ALQUILER);
		
		inmobiliaria.darDeAltaPropiedad(departamento1);
		inmobiliaria.darDeAltaPropiedad(departamento2);
		
		Integer valorEsperado = 25;
		Integer valorObtenido = inmobiliaria.promedioValorDepartamentos();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queLaBusquedaPorRangoDePrecioMeArrojeUnaListaNoNuloSiAplicaResultados() {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
		Propiedad casa1 = new Casa("peron", 123, "san justo", 10, Estado.VENTA);
		Propiedad casa2 = new Casa("peron", 125, "san justo", 50, Estado.VENTA);
		Propiedad departamento1 = new Departamento("peron", 123, 1, "A", "san justo",20, Estado.ALQUILER);
		Propiedad departamento2 = new Departamento("peron", 123, 1, "B", "san justo",30, Estado.ALQUILER);
		
		inmobiliaria.darDeAltaPropiedad(casa1);
		inmobiliaria.darDeAltaPropiedad(casa2);
		inmobiliaria.darDeAltaPropiedad(departamento1);
		inmobiliaria.darDeAltaPropiedad(departamento2);
		
		List<Propiedad> listaObtenida = inmobiliaria.busquedaPorRangoDePrecio(20,30);
		
		assertNotNull(listaObtenida);
	}
	
	@Test
	public void queLaBusquedaPorRangoDePrecioMeArrojeUnaListaNuloSiNoAplicaResultados() {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
		Propiedad casa1 = new Casa("peron", 123, "san justo", 10, Estado.VENTA);
		Propiedad casa2 = new Casa("peron", 125, "san justo", 50, Estado.VENTA);
		Propiedad departamento1 = new Departamento("peron", 123, 1, "A", "san justo",20, Estado.ALQUILER);
		Propiedad departamento2 = new Departamento("peron", 123, 1, "B", "san justo",30, Estado.ALQUILER);
		
		inmobiliaria.darDeAltaPropiedad(casa1);
		inmobiliaria.darDeAltaPropiedad(casa2);
		inmobiliaria.darDeAltaPropiedad(departamento1);
		inmobiliaria.darDeAltaPropiedad(departamento2);
		
		List<Propiedad> listaObtenida = inmobiliaria.busquedaPorRangoDePrecio(100,200);
		
		assertNull(listaObtenida);
	}
	
	@Test
	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista() {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
		Propiedad casa1 = new Casa("peron", 123, "san justo", 10, Estado.VENTA);
		Propiedad casa2 = new Casa("peron", 125, "san justo", 50, Estado.VENTA);
		Propiedad departamento1 = new Departamento("peron", 123, 1, "A", "san justo",20, Estado.ALQUILER);
		Propiedad departamento2 = new Departamento("peron", 123, 1, "B", "san justo",30, Estado.ALQUILER);
		
		inmobiliaria.darDeAltaPropiedad(casa1);
		inmobiliaria.darDeAltaPropiedad(casa2);
		inmobiliaria.darDeAltaPropiedad(departamento1);
		inmobiliaria.darDeAltaPropiedad(departamento2);
		
		List<Propiedad> listaObtenida = inmobiliaria.busquedaPropiedadesPorVenta();
		
		assertNotNull(listaObtenida);
	}
	
	@Test
	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaListaNuloSiNoAplicaResultados() {
		Inmobiliaria inmobiliaria = new Inmobiliaria();
	
		Propiedad departamento1 = new Departamento("peron", 123, 1, "A", "san justo",20, Estado.ALQUILER);
		Propiedad departamento2 = new Departamento("peron", 123, 1, "B", "san justo",30, Estado.ALQUILER);
		
		inmobiliaria.darDeAltaPropiedad(departamento1);
		inmobiliaria.darDeAltaPropiedad(departamento2);
		
		List<Propiedad> listaObtenida = inmobiliaria.busquedaPropiedadesPorVenta();
		
		assertNull(listaObtenida);
	}
}
