package co.edu.unbosque.view;

import java.time.LocalDate;

import javax.swing.JOptionPane;

/**
 * Clase de la vista que centraliza la interacción con el usuario mediante
 * ventanas emergentes (JOptionPane): mostrar mensajes, preguntar y leer datos.
 */
public class VentanaEmergente {
	
	/**
	 * Muestra una ventana informativa con un mensaje.
	 * 
	 * @param txt Mensaje a mostrar.
	 */
	public void mostrar(String txt) {
		JOptionPane.showMessageDialog(null, txt);
	}
	
	/**
	 * Muestra una ventana de error con un título personalizado.
	 * 
	 * @param txt Mensaje de error a mostrar.
	 * @param titulo Título de la ventana.
	 */
	public void mostrarERROR(String txt, String titulo) {
		JOptionPane.showMessageDialog(null, txt, titulo, 0, null);
	}
	
	/**
	 * Muestra una ventana de confirmación con las opciones Sí y No.
	 * 
	 * @param txt Pregunta que se presenta al usuario.
	 * @param titulo Título de la ventana.
	 * @return 0 si el usuario elige Sí, 1 si elige No, o -1 si cierra la ventana.
	 */
	public int preguntarSiNo(String txt, String titulo) {
	    return JOptionPane.showConfirmDialog(null, txt, titulo, JOptionPane.YES_NO_OPTION);
	}
		
	/**
	 * Solicita al usuario un texto mediante una ventana de entrada.
	 * 
	 * @param txt Mensaje que se muestra al pedir el dato.
	 * @return Texto ingresado, o null si el usuario cancela o cierra la ventana.
	 */
	public String LeerString(String txt) {
		String aux = JOptionPane.showInputDialog(txt);
		return aux;
	}
	
	/**
	 * Solicita al usuario un número entero mediante una ventana de entrada.
	 * 
	 * @param txt Mensaje que se muestra al pedir el dato.
	 * @return Número ingresado, o -1 si el usuario cancela o el valor no es un entero válido.
	 */
	public int LeerInt(String txt) {
		String aux = JOptionPane.showInputDialog(txt);
		if (aux == null) {
	        return -1;
	    }
		try {
			int dato = Integer.parseInt(aux);
			return dato;
		} catch(Exception e) {
			return -1;
		}	
	}
	
	/**
	 * Solicita al usuario un número decimal mediante una ventana de entrada.
	 * 
	 * @param txt Mensaje que se muestra al pedir el dato.
	 * @return Número decimal ingresado.
	 * @throws NumberFormatException Si el valor ingresado no es un número válido.
	 * @throws NullPointerException Si el usuario cancela o cierra la ventana.
	 */
	public static double LeerDouble(String txt) {
		String aux = JOptionPane.showInputDialog(txt);
		double dato = Double.parseDouble(aux);
		return dato;
	}
	
	/**
	 * Solicita al usuario un valor booleano mediante una ventana de entrada.
	 * Solo se interpreta como verdadero el texto "true" (sin importar mayúsculas).
	 * 
	 * @param txt Mensaje que se muestra al pedir el dato.
	 * @return true si el usuario escribió "true"; false en cualquier otro caso.
	 */
	public static boolean LeerBoolean(String txt) {
		String aux = JOptionPane.showInputDialog(txt);
		boolean dato = Boolean.parseBoolean(aux);
		return dato;
	}
	/**
	 * Solicita al usuario una fecha en formato AAAA-MM-DD.
	 * Si el formato es inválido, muestra un error y vuelve a pedir el dato
	 * hasta que se ingrese una fecha válida o se cancele.
	 * 
	 * @param txt Mensaje que se muestra al pedir la fecha.
	 * @return Fecha ingresada, o null si el usuario cancela o cierra la ventana.
	 */
	public LocalDate LeerFecha(String txt) {
	    while (true) {
	        try {
	            String aux = JOptionPane.showInputDialog(txt);
	            if (aux == null) {
	            	return null;
	            }
	            return LocalDate.parse(aux);
	        } 
	        catch (Exception e) {
	            mostrarERROR("Formato de fecha inválido.\nPor favor use el formato AAAA-MM-DD (ej: 2026-12-31)", "ERROR DE FECHA");
	        }
	    }
	}

}