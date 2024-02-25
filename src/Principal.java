import java.time.LocalDateTime;
import java.util.Scanner;
 


/*
 * TODO		Generar Pruebas unitarias
 * TODO		Depuración general de métodos
 * TODO		Mejora: Añadir opción de ordenación teniendo en cuenta fecha de inserción
 * TODO		Documentar código
 * TODO		Generar JavaDoc 
 * TODO		Empaquetar como librería
 */
public class Principal {

	int posicion = -1 ; // Posición de la puntuación que se envía, (-1 si no está
	// entre las 10 mejores y sino la posición en la que queda.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Principal App = new Principal();
		App.run(); 
		System.out.println("** Aplicación Terminada **");
	}
	 public void run() {
		 

			ListaPuntuaciones  TopTen = new ListaPuntuaciones("RoadRunner");

			// Se puede elegir cualquiera de las 3 opcciones
			// 1 - Ordenación propia
			// 2 - Ordenación mediante interfaz Comparator
			// 3 - Ordenación mediante interfaz Comparable
			int modo = 1;
			boolean stop = true;

			posicion = TopTen.insertScore(modo,100, "AFX", "1WET", LocalDateTime.now());
			lista(TopTen,true);
			posicion = TopTen.insertScore(modo,600, "AFX", "1WET", LocalDateTime.now());
			lista(TopTen,true);
			posicion = TopTen.insertScore(modo,950, "UVI", "1WET", LocalDateTime.now());
			lista(TopTen,true);
			posicion = TopTen.insertScore(modo,800, "JFC", "1WET", LocalDateTime.now());
			lista(TopTen,true);
			posicion = TopTen.insertScore(modo,999, "RMS", "1WET", LocalDateTime.now());
			lista(TopTen,true);
			posicion = TopTen.insertScore(modo,601, "AFX", "1WET",LocalDateTime.now());
			lista(TopTen,true);
			posicion = TopTen.insertScore(modo,400, "MIA", "1WET",LocalDateTime.now());
			lista(TopTen,true);
			posicion = TopTen.insertScore(modo,823, "VDP", "1WET",LocalDateTime.now());
			lista(TopTen,true);
			posicion = TopTen.insertScore(modo,998, "R02", "1WET",LocalDateTime.now());
			lista(TopTen,true);
			posicion = TopTen.insertScore(modo,997, "R03", "1WET",LocalDateTime.now());
			lista(TopTen,true);
			posicion = TopTen.insertScore(modo,996, "HAL", "1WET",LocalDateTime.now());
			lista(TopTen,true);
			posicion = TopTen.insertScore(modo,300, "RRR", "1WET",LocalDateTime.now());			
			lista(TopTen,true);
			
		} // run()

	 /**
	  * Muestra por consola la lista de puntuaciones
	  * @param _TopTen Array de objetos marcador (10 elemento)
	  * @param espera indica si el programa detiene su ejecución hasta 
	  * pulsar ENTER
	  */
	 public void lista(ListaPuntuaciones _TopTen, boolean espera) {
		 
		 String[] TablaPuntuaciones = new String[10];
			
		
			TablaPuntuaciones = _TopTen.getScoreBoard();
			
			System.out.println("        "+ _TopTen.getJuego());
			System.out.println("-----------------------------------");
			System.out.println("        ALL OF FAME");
			System.out.println("-----------------------------------");
			for (int i=0;i<10;i++) {
				
				if (posicion == i) TablaPuntuaciones[i] = "> " + TablaPuntuaciones[i];
				else TablaPuntuaciones[i]= "  "+ TablaPuntuaciones[i];
				System.out.println(TablaPuntuaciones[i]);
				
			}
			if (espera) {
				System.out.println("Pulsa Enter para continuar");
				Scanner sc = new Scanner(System.in);
				sc.nextLine();
			}
	 }

}  // Class
