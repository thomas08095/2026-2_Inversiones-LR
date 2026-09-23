package co.edu.unbosque.model;

public class Huesped {

    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    
    public Huesped() {
		super();
	}
    
	public Huesped(String id, String nombre, String apellido, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public boolean validarCorreo(String correo) {
    	if(correo.contains("@")) {
    		return true;
    	}
    	else return false;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getApellido() {
        return apellido;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getCorreo() {
        return correo;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    

}
