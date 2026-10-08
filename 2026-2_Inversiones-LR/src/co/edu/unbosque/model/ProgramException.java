package co.edu.unbosque.model;

/**
 * Excepción personalizada para manejar los errores lógicos y de reglas de negocio 
 * dentro de la aplicación de gestión de alojamientos.
 */
public class ProgramException extends Exception {
	
	/**
	 * Constructor que recibe el mensaje de error específico.
	 * 
	 * @param mensaje Detalles o causa de la excepción ocurrida.
	 */
    public ProgramException(String mensaje) {
        super(mensaje);
    }
}
