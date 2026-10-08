package co.edu.unbosque.model;

/**
 * Representa a un huésped registrado en el sistema de Inversiones LR.
 * Contiene la información personal y de contacto del cliente.
 */
public class Huesped {

    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    
    /**
     * Constructor por defecto de la clase Huesped.
     */
    public Huesped() {
		super();
	}
    
    /**
     * Constructor parametrizado para inicializar los datos de un huésped.
     * 
     * @param id Identificación personal del huésped (ej. Cédula).
     * @param nombre Nombres del huésped.
     * @param apellido Apellidos del huésped.
     * @param correo Correo electrónico de contacto.
     * @param telefono Número de teléfono.
     */
	public Huesped(String id, String nombre, String apellido, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
    
	/**
	 * Valida si una cadena de texto tiene el formato básico de un correo electrónico.
	 * 
	 * @param correo Cadena de texto a validar.
	 * @return true si contiene el carácter '@', false en caso contrario.
	 */
    public boolean validarCorreo(String correo) {
    	if(correo.contains("@")) {
    		return true;
    	}
    	else return false;
    }
    
    /**
     * Establece el identificador del huésped.
     * @param id Nuevo identificador.
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Obtiene el identificador del huésped.
     * @return ID del huésped.
     */
    public String getId() {
        return id;
    }
    
    /**
     * Establece los nombres del huésped.
     * @param nombre Nuevos nombres.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene los nombres del huésped.
     * @return Nombres del huésped.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece los apellidos del huésped.
     * @param apellido Nuevos apellidos.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /**
     * Obtiene los apellidos del huésped.
     * @return Apellidos del huésped.
     */
    public String getApellido() {
        return apellido;
    }
    
    /**
     * Establece el correo electrónico del huésped.
     * @param correo Nuevo correo electrónico.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * Obtiene el correo electrónico del huésped.
     * @return Correo electrónico.
     */
    public String getCorreo() {
        return correo;
    }
    
    /**
     * Establece el número de teléfono del huésped.
     * @param telefono Nuevo teléfono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Obtiene el número de teléfono del huésped.
     * @return Teléfono del huésped.
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Obtiene el nombre completo del huésped uniendo su nombre y apellido.
     * @return Cadena con el nombre y apellido concatenados.
     */
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}

