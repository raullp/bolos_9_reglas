

public class Juego {

	private Lanzamientos lanzamientos = new Lanzamientos();
	private Puntaje puntajeTotal;
	private IndexFrame indexFrame;

	public void lanzar(int pinos) {
		lanzamientos.add(pinos);
	}

	public Puntaje puntaje() {
		puntajeTotal = new Puntaje();
		indexFrame = new IndexFrame();
		for (int frame = 0; frame < 10; frame++) {
			calcularPuntajeParaFrame();
		}
		return puntajeTotal;
	}
	private void calcularPuntajeParaFrame() {
		Lanzamiento lanzamiento = lanzamientos.get(indexFrame);
		Puntaje puntajeLanzamiento;
		if (lanzamiento.esStrike()) {
			puntajeLanzamiento = new Puntaje(10 + lanzamientos.bonoStrike(indexFrame));
			puntajeTotal.sumar(puntajeLanzamiento);
			indexFrame.incrementar(1);
			return;
		}
		if (lanzamientos.esSpare(indexFrame)) {
			puntajeLanzamiento = new Puntaje(10 + lanzamientos.bonoSpare(indexFrame));
			puntajeTotal.sumar(puntajeLanzamiento);
			indexFrame.incrementar(2);
			return;
		} 	
		lanzamiento = lanzamientos.sumaDeDosLanzamientos(indexFrame);
		puntajeLanzamiento = new Puntaje(lanzamiento.getPinosDerribados());
		puntajeTotal.sumar(puntajeLanzamiento);
		indexFrame.incrementar(2);
	}
}
