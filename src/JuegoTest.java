import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JuegoTest {
	Juego juego = new Juego();
	Puntaje total;
	
	@Before
	public void inicializar() {
		juego= new Juego();
	}
	
	@Test
	public void todosLosLanzamientosAlCanal() throws Exception {
		total = new Puntaje();
		lanzarVarios(20, 0);
		assertEquals(total, juego.puntaje());
	}
	
	@Test
	public void todosLosLanzamientosDerribanUnPino() throws Exception {
		total = new Puntaje(20);
		lanzarVarios(20, 1);
		assertEquals(total, juego.puntaje());
	}
	
	@Test
	public void variosLanzamientosConUnSpare() throws Exception {
		total = new Puntaje(14);
		
		lanzarSpare();
		juego.lanzar(2);
		lanzarVarios(17, 0);
		
		assertEquals(total, juego.puntaje());
	}

	@Test
	public void variosLanzamientosConUnStrike() throws Exception {
		total = new Puntaje(24);
		
		lanzarStrike();
		juego.lanzar(3);
		juego.lanzar(4);
		lanzarVarios(17, 0);
		
		assertEquals(total, juego.puntaje());
	}

	private void lanzarStrike() {
		juego.lanzar(10);
	}
	
	@Test
	public void juegoPerfecto() throws Exception {
		total = new Puntaje(300);
		lanzarVarios(12, 10);
		assertEquals(total, juego.puntaje());
	}

	private void lanzarVarios(int n, int pinos) {
		for (int i = 0; i < n; i++)
			juego.lanzar(pinos);
	}
	
	private void lanzarSpare() {
		juego.lanzar(7);
		juego.lanzar(3);
	}
}
