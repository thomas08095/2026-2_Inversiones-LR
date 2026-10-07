package co.edu.unbosque.controller;
import java.time.LocalDate;

import co.edu.unbosque.model.*;
import co.edu.unbosque.persistence.Reporte;
import co.edu.unbosque.view.*;

public class Controller {

    private static Menu menu = new Menu();
    private static VentanaEmergente ventana = new VentanaEmergente();
    
    private static Alojamiento a;
    
    private static Controller_HUESPED con_H = new Controller_HUESPED();
    private static Controller_ALOJAMIENTOS con_A = new Controller_ALOJAMIENTOS();
    
    public static void start() {
        boolean end = false;
        int respuesta = 0;
        
        crearALOJAMIENTOS();
       
        while(!end) {
            respuesta = ventana.LeerInt(Menu.menu_PRINCIPAL());
            
            switch(respuesta) {
            case 1:
                respuesta = ventana.LeerInt(Menu.menu_ALOJAMIENTOS());
                
                switch(respuesta) {
                case 1: 
                    alojamientos_BUSCAR(respuesta);
                    break;
                case 2:
                    alojamientos_CONSULTAR_SINFILTROS(respuesta);
                    break;
                default:
                    System.out.println("GAY");
                    break;
                }
                break;
                
            case 2:
                respuesta = ventana.LeerInt(menu.menu_HUESPEDES());
                switch(respuesta) {
                case 1: 
                    huespedes_REGISTRAR(respuesta);
                    break;
                case 2:
                     try {
                        con_H.consultarHuespedes();
                     } catch (ProgramException e) {
                         ventana.mostrarERROR("Lo Sentimos.\n" + e.getMessage(), "ERROR");
                     }
                    break;
                default:
                    System.out.println("GAY");
                    break;
                }
                break;
            case 3:
                respuesta = ventana.LeerInt(menu.menu_RESERVAS());
                switch(respuesta) {
                case 1:
                    try {
                        reservaCREAR(respuesta);
                    } catch (ProgramException e) {
                        ventana.mostrarERROR("No se pudo crear la reserva:\n" + e.getMessage(), "ERROR DE RESERVA");
                    }
                    break;
                case 2:
                	
                	break;
                case 3:
                	reservaCANCELAR(respuesta);
                	break;
                default:
                	System.out.println("GAY");
                	break;
                }
                break;
            case 4:
            	generarREPORTES();
                break;
            case 5:
                end = true;
                ventana.mostrar("\n!! == MUCHAS GRACIAS == !!\n");
                break;
            default:
                ventana.mostrar("\n!! == OPCION INVALIDA == !!\n");
                break;
            }
        }
    }
    
    public static void crearALOJAMIENTOS() {
    	 try {
             a = new Casa("1234567890", "CASA BLANCA DE DOS PISOS", "Calle 160b #10-55", 
                     4, 500_000, "Casa", Alojamiento.Ciudad.BOGOTA, Alojamiento.EstadoAlojamiento.ACTIVO);
             con_A.registrarAlojamiento(a);
             a = new Apartamento("0987654321", "APARTAMENTO PEQUEÑO PISO 4, TORRE 6", "Carrera 45 # 53-12", 
                     2, 250_000, "Apartamento", Alojamiento.Ciudad.MEDELLIN, Alojamiento.EstadoAlojamiento.ACTIVO);
             con_A.registrarAlojamiento(a);
             a = new Cabaña("2244556688", "CABAÑA GRANDE DE MADERA MODERNA", "Cra. 22 #45", 
                     6, 150_000, "Cabaña", Alojamiento.Ciudad.BARRACABERMEJA, Alojamiento.EstadoAlojamiento.ACTIVO);
             con_A.registrarAlojamiento(a);
             
             a = new Casa("874", "CASA GRANDE DE 3 PISOS CON PISCINA ", "Cra 72bis #24d-50", 
                     8, 900_000, "Casa", Alojamiento.Ciudad.BOGOTA, Alojamiento.EstadoAlojamiento.ACTIVO);
             con_A.registrarAlojamiento(a);
             a = new Apartamento("676767676767", "APARTA-STUDIO", "Calle 49 # 24-36, Barrio Colombia", 
                     3, 300_000, "Apartamento", Alojamiento.Ciudad.BARRACABERMEJA, Alojamiento.EstadoAlojamiento.ACTIVO);
             con_A.registrarAlojamiento(a);
             a = new Cabaña("000000000", "CABAÑA DIMINUTA", "Calle 10 # 43A-31", 
                     1, 100_000, "Cabaña", Alojamiento.Ciudad.MEDELLIN, Alojamiento.EstadoAlojamiento.ACTIVO);
             con_A.registrarAlojamiento(a);
             a = new Casa("99999999", "CASA DE DOS PISOS MEDIANA", "Carrera 35 # 7-52", 
                     3, 240_000, "Casa", Alojamiento.Ciudad.MEDELLIN, Alojamiento.EstadoAlojamiento.ACTIVO);
             con_A.registrarAlojamiento(a);
             a = new Apartamento("909", "APARTAMENTO DE LUJO", "Calle 164 #54-18", 
                     5, 390_000, "Apartamento", Alojamiento.Ciudad.BOGOTA, Alojamiento.EstadoAlojamiento.ACTIVO);
             con_A.registrarAlojamiento(a);
         } catch (ProgramException e) {
             ventana.mostrarERROR("Lo Sentimos.\n" + e.getMessage(), "ERROR");
         }

    }
        
    public static void alojamientos_BUSCAR(int respuesta) {
    	 respuesta = ventana.LeerInt("=== ALOJAMIENTO ===\n"
         		+ "= ¿Que tipo de Alojamiento le Interesa? =\n"
         		+ "| 1. CASA\n"
         		+ "| 2. APARTAMENTO\n"
         		+ "| 3. CABAÑA\n"); 
    	 while(respuesta != 1 && respuesta != 2 && respuesta != 3) {
    		 respuesta = ventana.LeerInt("=== !!CARACTER INVALIDO!! ===\n"
    	         		+ "= ¿Que tipo de Alojamiento le Interesa? =\n"
    	         		+ "| 1. CASA\n"
    	         		+ "| 2. APARTAMENTO\n"
    	         		+ "| 3. CABAÑA\n"); 
    	 }
    	 switch(respuesta) {
     	case 1:
     		a = new Casa();
     		break;
     	case 2:
     		a = new Apartamento();
     		break;
     	case 3:
     		a = new Cabaña();
     		break;
    	}
        respuesta = ventana.LeerInt("=== ALOJAMIENTO ===\n"
        		+ "= ¿En que Ciudad te interesa? =\n"
        		+ "| 1. BOGOTA\n"
        		+ "| 2. MEDELLIN\n"
        		+ "| 3. BARRACABERMEJA\n"
        		+ "| // Si se Ingresa cualquier otro dato, se tomara como si no importara este filtro."); 
        switch(respuesta) {
        	case 1:
        		a.setCiudadEnum(Alojamiento.Ciudad.BOGOTA);
        		break;
        	case 2:
        		a.setCiudadEnum(Alojamiento.Ciudad.MEDELLIN);
        		break;
        	case 3:
        		a.setCiudadEnum(Alojamiento.Ciudad.BARRACABERMEJA);
        		break;
        	default:
        		a.setCiudadEnum(null);
        		break;
        }
        int personMIN = ventana.LeerInt("=== ALOJAMIENTO ===\n"
        		+ "= ¿Que Capacidad Minima de Personas Busca? =\n");  
        int precioMIN = ventana.LeerInt("=== ALOJAMIENTO ===\n"
        		+ "= ¿Que Precio Minimo busca? =\n");
        try {
			ventana.mostrar(con_A.buscarFiltro(a,personMIN,precioMIN));
		} catch (ProgramException e) {
			e.printStackTrace(); // FALTA TEXTO !!!!!
		}
    }
        
    public static void alojamientos_CONSULTAR_SINFILTROS(int respuesta) {
        try {
            ventana.mostrar(con_A.consultar());
        } catch (ProgramException e) {
            ventana.mostrarERROR("Lo Sentimos.\n" + e.getMessage(), "ERROR");
        }
    }
        
    public static void huespedes_REGISTRAR(int respuesta) {
        boolean end = false;
        while(!end) {
            Huesped h = new Huesped();
            String str = ventana.LeerString("||====== IDENTIFICADOR =======||\n\n"
                    + "| 1. Ingrese su Identificador.\n\n"
                    + "||=============================||\n");   
            if (str == null) return;
            str = str.replaceAll("\\D", ""); 
            h.setId(str);
            
            str = ventana.LeerString("||====== NOMBRE Y APELLIDO =======||\n\n"
                    + "| 1. Ingrese su Nombre.\n\n"
                    + "||=============================||\n");   
            if (str == null) return;
            h.setNombre(str);
            
            str = ventana.LeerString("||====== NOMBRE Y APELLIDO =======||\n\n"
                    + "| 1. Ingrese su Apellido.\n\n"
                    + "||=============================||\n");   
            if (str == null) return;
            h.setApellido(str);
            
            str = ventana.LeerString("||====== CORREO / EMAIL =======||\n\n"
                    + "| 1. Ingrese su Correo Electronico. (Que contenga \'@\')\n\n"
                    + "||=============================||\n");   
            if (str == null) return;
            h.setCorreo(str);
            
            str = ventana.LeerString("||====== NUMERO TELEFONICO =======||\n\n"
                    + "| 1. Ingrese su Numero. (10 Digitos)\n\n"
                    + "||=============================||\n");   
            if (str == null) return;
            h.setTelefono(str);
            
            respuesta = ventana.preguntarSiNo("||====== COMFIRMACION =======||\n\n"
                    + "| Estas de Acuerdo con los siguientes datos?\n"
                    + "| ID: " + h.getId() + "\n"
                    + "| NOMBRE COMPLETO: " + h.getNombreCompleto() + "\n"
                    + "| CORREO: " + h.getCorreo() + "\n"
                    + "| TELEFONO: " + h.getTelefono() + "\n"
                    + "||=============================||\n", "COMFIRMAR");
            
            if(respuesta == 0) {
                try {
                    con_H.registrarHuesped(h);
                    ventana.mostrar("Se Registro Al Huesped con Exito.");
                    end = true;
                } catch (ProgramException e) {
                    ventana.mostrarERROR("Lo Sentimos.\n" + e.getMessage(), "ERROR DE VALIDACION");
                }
            } else {
                ventana.mostrar("Se Registrara el Huesped devuelta.");
            }
        }
    }   
    public static void reservaCREAR(int respuesta) throws ProgramException {
    	boolean end = false;
    	while(!end) {
    	
    	try {
    	 Reserva r = new Reserva();
    	 Huesped h = new Huesped();
    	 Alojamiento a;
    	 
    	 String str = ventana.LeerString("||====== RESERVA =======||\n\n"
                 + "| 1. Ingrese el Identificador de la Reserva.\n\n"
                 + "||=============================||\n");
    	 if (str == null) return;
         r.setId(str);

         str = ventana.LeerString(
        		 con_H.ID_MostrarHuespedes() 
                 + "| Ingrese el Identificador del Huesped.\n\n"
                 + "||=============================||\n");

         h = con_H.ID_buscarHuesped(str);
         
         str = ventana.LeerString("||====== ALOJAMIENTO =======||\n\n" + con_A.ID_MostrarAlojamiento() + 
        		 "||====================||\n"
                 + "| Ingrese el Identificador del Alojamiento.\n\n"
                 + "||=============================||\n");
         a = con_A.ID_buscarAlojamiento(str);
         
         LocalDate ld =  ventana.LeerFecha("||====== FECHA DE LLEGADA =======||\n\n"
                 + "| Ingrese la Fecha de Llegada. (AAAA-MM-DD)\n\n"
                 + "||=============================||\n");
         r.setFechaLlegada(ld);
         
         ld = ventana.LeerFecha("||====== FECHA DE SALIDA =======||\n\n"
                 + "|  Ingrese la Fecha de Salida. (AAAA-MM-DD)\n\n");
         r.setFechaSalida(ld);
         
         respuesta = ventana.LeerInt("||====== NUMERO DE HUESPEDES =======||\n\n"
                 + "| 1. Ingrese el Numero de Huespedes. (Capacidad Maxima: " + a.getCapacidad() + ")\n\n"
                 + "||=============================||\n");
         r.setNumeroHuespedes(respuesta);
         
         
         r.setAlojamiento(a);
         r.setHuesped(h);
         int noches = r.calcularNumNoches();
         double total = a.calcularValorReserva(noches);
         
         respuesta = ventana.preguntarSiNo("||====== COMFIRMACION =======||\n\n"
                 + "| Estas de Acuerdo con los siguientes datos?\n"
                 + "| ID RESERVA: " + r.getId() + "\n"
                 + "| HUESPED: " + h.getNombreCompleto() + "\n"
                 + "| ALOJAMIENTO: " + a.getNombre() + " (" + a.getTipo() + ")\n"
                 + "| LLEGADA: " + r.getFechaLlegada() + "\n"
                 + "| SALIDA: " + r.getFechaSalida() + "\n"
                 + "| NOCHES: " + noches + "\n"
                 + "| HUESPEDES: " + r.getNumeroHuespedes() + "\n"
                 + "| VALOR TOTAL: " + total + " COP\n"
                 + "||=============================||\n", "COMFIRMAR");
         if(respuesta == 0) {
             Controller_RESERVAS.crearRESERVA(r, h, a);
             ventana.mostrar("Se Creo la Reserva con Exito.");
             end = true;
         } else ventana.mostrar("Se Registrara la Reserva devuelta.");
         
    	} catch (ProgramException e) {
            ventana.mostrarERROR("Error en la reserva:\n" + e.getMessage(), "DATOS INVÁLIDOS");
        }
      }
    }
    public static void reservaDETALLES(int respuesta) {
    	
    }
    public static void reservaCANCELAR(int respuesta) {
    	
    }
    
    public static void generarREPORTES() {
        try {
            Reporte reporte = new Reporte();
            
            String infoAlojamientos = con_A.consultar();
            reporte.generarReporteTxt("Reporte_Alojamientos", infoAlojamientos);
            
            String infoHuespedes = con_H.consultarHuespedes();
            reporte.generarReporteTxt("Reporte_Huespedes", infoHuespedes);
        } 
        catch (ProgramException e) {
            ventana.mostrarERROR("No se pudieron generar los reportes:\n" + e.getMessage(), "ERROR DE REPORTES");
        }
    }
}