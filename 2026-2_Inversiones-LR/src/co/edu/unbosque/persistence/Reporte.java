package co.edu.unbosque.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import co.edu.unbosque.model.ProgramException;

/**
 * Clase encargada de generar reportes del sistema en archivos de texto plano.
 */
public class Reporte {

	/**
	 * Genera un archivo .txt con el contenido recibido.
	 * Al nombre del archivo se le agrega automáticamente la extensión ".txt".
	 * 
	 * @param contenido Texto que se escribirá dentro del reporte.
	 * @param nombreArchivo Nombre del archivo, sin extensión.
	 * @throws ProgramException Si ocurre un error al crear o escribir el archivo.
	 */
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