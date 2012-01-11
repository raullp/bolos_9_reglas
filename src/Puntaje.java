
public class Puntaje {
   private int total;
   public Puntaje() {
	   this(0);
   }
   public Puntaje(int valor){
	   inicializarPuntaje(valor);
   }
   

   private void inicializarPuntaje(int valor)
   {
	   total = valor;
   }
   public void sumar(Puntaje puntaje)
   {
	   total += puntaje.total;
   }
   
   @Override
   public boolean equals(Object nuevoPuntaje){
	   return total == ((Puntaje)nuevoPuntaje).total;
   }
}
