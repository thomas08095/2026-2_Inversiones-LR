package co.edu.unbosque.controller;
import co.edu.unbosque.model.*;
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
        a = new Casa("1234567890", "CASA BLANCA DE DOS PISOS", "Calle 160b #10-55", 
                4, 5_000_000, "Casa", Alojamiento.Ciudad.BOGOTA, Alojamiento.EstadoAlojamiento.ACTIVO);
        con_A.registrarAlojamiento(a);
        a = new Apartamento("0987654321", "APARTAMENTO PEQUEÑO PISO 4, TORRE 6", "Carrera 45 # 53-12", 
                2, 1_250_000, "Apartamento", Alojamiento.Ciudad.MEDELLIN, Alojamiento.EstadoAlojamiento.ACTIVO);
        con_A.registrarAlojamiento(a);
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
                break;
            case 4:
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
        
    public static void alojamientos_BUSCAR(int respuesta) {
        respuesta = ventana.LeerInt(menu.menu_ALOJAMIENTOS_CIUDADES()); 
        respuesta = ventana.LeerInt(menu.menu_ALOJAMIENTOS_TIPOS());    
        respuesta = ventana.LeerInt("¿Capacidad Minima?");
        respuesta = ventana.LeerInt("¿Precio Maximo Por Noche?");
    }
        
    public static void alojamientos_CONSULTAR_SINFILTROS(int respuesta) {
        con_A.consultar();
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
}