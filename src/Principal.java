import java.time.LocalDateTime;
import java.util.Scanner;
 
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Principal App = new Principal();
		App.run(); 
		System.out.println("** Aplicación Terminada **");
	}
	 public void run() {
		 

			ListaPuntuaciones  TopTen = new ListaPuntuaciones("RoadRunner");
			
<<<<<<< HEAD
			// Se puede elegir cualquiera de las 3 opcciones
			int modo = 1;
			boolean stop = true;
=======
			int modo = 3; 
			
>>>>>>> refs/heads/Comparable
			TopTen.insertScore(modo,100, "AFX", "1WET", LocalDateTime.now());
			lista(TopTen,true);
			TopTen.insertScore(modo,600, "AFX", "1WET", LocalDateTime.now());
			lista(TopTen,true);
			TopTen.insertScore(modo,950, "UVI", "1WET", LocalDateTime.now());
			lista(TopTen,true);
			TopTen.insertScore(modo,800, "JFC", "1WET", LocalDateTime.now());
			lista(TopTen,true);
			TopTen.insertScore(modo,999, "RMS", "1WET", LocalDateTime.now());
			lista(TopTen,true);
			TopTen.insertScore(modo,601, "AFX", "1WET",LocalDateTime.now());
			lista(TopTen,true);
			TopTen.insertScore(modo,400, "MIA", "1WET",LocalDateTime.now());
			lista(TopTen,true);
			TopTen.insertScore(modo,823, "VDP", "1WET",LocalDateTime.now());
			lista(TopTen,true);
			TopTen.insertScore(modo,998, "R02", "1WET",LocalDateTime.now());
			lista(TopTen,true);
			TopTen.insertScore(modo,997, "R03", "1WET",LocalDateTime.now());
			lista(TopTen,true);
			TopTen.insertScore(modo,996, "HAL", "1WET",LocalDateTime.now());
			
			lista(TopTen,true);
			
		} // run()

	 public void lista(ListaPuntuaciones _TopTen, boolean espera) {
		 
		 String[] TablaPuntuaciones = new String[10];
			
			TablaPuntuaciones = _TopTen.getScoreBoard();
			
			System.out.println("        "+ _TopTen.getJuego());
			System.out.println("-----------------------------------");
			System.out.println("        ALL OF FAME");
			System.out.println("-----------------------------------");
			for (int i=0;i<10;i++) {
				
				System.out.println(TablaPuntuaciones[i]);
				
			}
			if (espera) {
				System.out.println("Pulsa Enter para continuar");
				Scanner sc = new Scanner(System.in);
				sc.nextLine();
			}
	 }

}  // Class
