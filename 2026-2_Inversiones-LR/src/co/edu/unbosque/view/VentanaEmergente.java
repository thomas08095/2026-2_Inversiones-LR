package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class VentanaEmergente {
		
	public static String LeerString(String txt) {
		String aux = JOptionPane.showInputDialog(txt);
		return aux;
	}
	
	public static int LeerInt(String txt) {
		String aux = JOptionPane.showInputDialog(txt);
		int dato = Integer.parseInt(aux);
		return dato;
	}
	
	public static double LeerDouble(String txt) {
		String aux = JOptionPane.showInputDialog(txt);
		double dato = Double.parseDouble(aux);
		return dato;
	}
	
	public static boolean LeerBoolean(String txt) {
		String aux = JOptionPane.showInputDialog(txt);
		boolean dato = Boolean.parseBoolean(aux);
		return dato;
	}

}
