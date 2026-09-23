package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class VentanaEmergente {
	
	public void mostrar(String txt) {
		JOptionPane.showMessageDialog(null, txt);
	}
	
	public void mostrarERROR(String txt, String titulo) {
		JOptionPane.showMessageDialog(null, txt, titulo, 0, null);
	}
	
	public int preguntarSiNo(String txt, String titulo) {
	    return JOptionPane.showConfirmDialog(null, txt, titulo, JOptionPane.YES_NO_OPTION);
	}
		
	public String LeerString(String txt) {
		String aux = JOptionPane.showInputDialog(txt);
		return aux;
	}
	
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
	
	public static String LeerConComboBox(String mensaje, String titulo, String[] opciones) {
		String seleccion = "";
		return seleccion;
	}

}
