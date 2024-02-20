import java.time.LocalDateTime;
 
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Principal App = new Principal();
		App.run();
	
	}
	 public void run() {
		 

			ListaPuntuaciones  TopTen = new ListaPuntuaciones("RoadRunner");
			
			int modo = 1;
			
			TopTen.insertScore(modo,100, "AFX", "1WET", LocalDateTime.now());
			TopTen.insertScore(modo,600, "AFX", "1WET", LocalDateTime.now());
			TopTen.insertScore(modo,950, "UVI", "1WET", LocalDateTime.now());
			TopTen.insertScore(modo,800, "JFC", "1WET", LocalDateTime.now());
			TopTen.insertScore(modo,999, "RMS", "1WET", LocalDateTime.now());
			TopTen.insertScore(modo,601, "AFX", "1WET",LocalDateTime.now());
			TopTen.insertScore(modo,400, "MIA", "1WET",LocalDateTime.now());
			TopTen.insertScore(modo,823, "VDP", "1WET",LocalDateTime.now());
			TopTen.insertScore(modo,998, "R02", "1WET",LocalDateTime.now());
			TopTen.insertScore(modo,997, "R03", "1WET",LocalDateTime.now());
			TopTen.insertScore(modo,996, "HAL", "1WET",LocalDateTime.now());
			
			lista(TopTen);
			
		} // run()

	 public void lista(ListaPuntuaciones _TopTen) {
		 
		 String[] TablaPuntuaciones = new String[10];
			
			TablaPuntuaciones = _TopTen.getScoreBoard();
			
			System.out.println("        "+ _TopTen.getJuego());
			System.out.println("-----------------------------------");
			System.out.println("        ALL OF FAME");
			System.out.println("-----------------------------------");
			for (int i=0;i<10;i++) {
				
				System.out.println(TablaPuntuaciones[i]);
				
			}
	 }

}  // Class
