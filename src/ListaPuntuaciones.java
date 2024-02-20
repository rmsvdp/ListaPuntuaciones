import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class ListaPuntuaciones {

	// Main Branch  Ordenación propia
	
	/* Versión con algoritmo de ordenación propio
	 * ------------------------------------------------------------
	 * Esta versión utiliza un algoritmo propio de ordenación,
	 * el principio consiste en suponer que se parte siempre
	 * de una lista ordenada.
	 * Se recorre la lista y se para cuando la posición sea menor
	 * que la puntuación que estamos intentando registrar.
	 * En ese momento, se desplazan hacia abajo el resto de puntuaciones
	 */

	// Comparator Branchh
	
	/*
	 * Interfaz Comparator
	 * Esta interfaz tiene un único método abstracto
	 * 
	 * int compare(Object ob1, Object ob2)
	 * 
	 * Cuando necesitamos otros criterios distintos de la ordenación natural (orden alfabético, alguna
	 * otra condición), debemos usar mejor este interfaz.
	 * 
	 * devuelve <0 si ob1 va antes de ob2
	 * devuelve >0 si ob1 va después de ob2
	 * devuelve 0 si son iguales
	 * Podemos disponer de varios criterios de comparación, para ello se debe crear una 
	 * clase específica para que implemente el criterio
	 * 
	 * Disponemos de una variante del método sort que acepta el criterio de comparación
	 * 
	 */
	
	// Clase específica para compararPuntos
	
	 private class comparaPuntos implements Comparator<Marcador>{
		 @Override
		 public int compare(Marcador s1, Marcador s2)
	   {
			 // si s2>s1   será negativo --> s2 va antes !
			 // Ojo con la comparación !!!
	      return (int) (s2.getPuntos() - s1.getPuntos()); 
	   }
	 }
	 
	 
	
	
	private class Marcador {
		
		private long puntos;
		private String nick;
		private String curso;
		private LocalDateTime fecha;
				
		public Marcador() {};
		public Marcador(long i) {
			this.puntos = i;
			this.nick = "---";
			this.curso = "----";
		}
		public Marcador(long puntos, String nick, String curso,LocalDateTime fecha) {
			this.puntos = puntos;this.nick = nick;this.curso = curso;this.fecha = fecha;}
		public long getPuntos() {return puntos;	}
	
	} // Inner Class Marcador
	

	/**
	 * Lista con las 10 mejores puntuaciones ordenadas
	 */
	private Marcador[] myScoreBoard=new Marcador[10] ;
	/**
	 * Objeto Marcador auxiliar
	 */
	private Marcador lineapunt= new Marcador();
	/**
	 * Nombre del juego al que hace referencia la lista de puntuaciones
	 */
	private String juego;
	
	
	public String getJuego() {return juego;	}
	public void setJuego(String juego) {this.juego = juego;	}
	
	/**
	 * Constructor por defecto
	 * @param _juego Nombre del juego sobre el que se genera la lista.
	 */
	public ListaPuntuaciones(String _juego) {
		juego = _juego;						// Especifica el juego
		
		for (int i=0; i<10;i++) {
			myScoreBoard[i] = new Marcador(0);
		}
	}

	public int insertScore(int _modo, long _puntos, String _nick, String _curso,   LocalDateTime _fecha) {
		
		int result = -1;
			switch (_modo) {
			
				case 1: // Propio
					insertScorePropio(_puntos, _nick, _curso, _fecha);
					break;
				case 2: // Comparator
					break;
			}
			

			return result;
	}
	
	/**
	 * Gestiona la inserción de una puntuación.
	 * @param puntos Puntuación
	 * @param nick   Nick del jugador que registra la puntuación
	 * @param curso  Grupo del jugador
	 * @param fecha  Fecha de creación de la puntación
	 * @return Posción en la que se inserta (-1) si no entra
	 * dentro de las 10 primeras.
	 */
	public int insertScorePropio(long puntos, String nick, String curso,   LocalDateTime fecha) {
		int result = -1;
		this.lineapunt = new Marcador(puntos,nick,curso,fecha);
		for (int i=0; i<10;i++) {
			if (myScoreBoard[i].puntos <= lineapunt.puntos) {
				for (int j= 9;j>i;j--) {
					myScoreBoard[j]=myScoreBoard[j-1];
				}
				myScoreBoard[i]=lineapunt;
			result = i;
			break;
			}
		}
		return result;
	}
	

	public int insertScoreComparator(long puntos, String nick, String curso,   LocalDateTime fecha) {
		int result = -1;
		this.lineapunt = new Marcador(puntos,nick,curso,fecha);
		Marcador[] tempM ;
		tempM = Arrays.copyOf(this.myScoreBoard, 11);
		tempM[10]= this.lineapunt;
		Arrays.sort(tempM,new comparaPuntos());
		this.myScoreBoard = Arrays.copyOf(tempM, 10);
		result = indexOf(this.myScoreBoard, this.lineapunt);

		return result;
	}
	/**
	 * Devuelve la posición de un objeto Marcador dentro del array
	 * @param myArr Array ordenado
	 * @param item  Elemento a buscar
	 * @return   -1 no está, 0..myArr.length-1
	 */
	public int indexOf(Marcador[] myArr, Marcador item) {
		int result = -1;
				for (int i=0;i<myArr.length;i++) {
					
					if (item.equals(myArr[i])) { // Ojo como comparas!!
						result = i;
						break;
					}
				}
		return result;
	}
	
	
	
	public String[] getScoreBoard() {
		String[] s = new String[10];
		String tab = "      ";
		for (int i=0;i<10;i++) {
			s[i] = "   " + String.format("%1$" + 2 + "s", Integer.toString(i+1)).replace(' ', '0')+ tab +
					    String.format("%1$" + 4 + "s", Long.toString(myScoreBoard[i].puntos)).replace(' ', '0') + tab + 
					    myScoreBoard[i].nick + tab + myScoreBoard[i].curso;
 		}
		return s;
	}
	
} // ScoreBoard


