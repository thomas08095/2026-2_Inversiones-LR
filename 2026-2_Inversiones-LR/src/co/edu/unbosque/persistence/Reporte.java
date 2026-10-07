package co.edu.unbosque.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import co.edu.unbosque.model.ProgramException;

public class Reporte {
	
	public void generarReporteTxt(String contenido, String nombreArchivo) throws ProgramException {
		
		try {
			File archivo = new File(nombreArchivo + ".txt");
            FileWriter fw = new FileWriter(archivo);
            PrintWriter pw = new PrintWriter(fw);
            
            pw.print(contenido);
            pw.close();
		}
		catch (Exception e) {
			throw new ProgramException("Error al generar el reporte: " + nombreArchivo + ".txt: " + e.getMessage());
		}
	}
	
}
