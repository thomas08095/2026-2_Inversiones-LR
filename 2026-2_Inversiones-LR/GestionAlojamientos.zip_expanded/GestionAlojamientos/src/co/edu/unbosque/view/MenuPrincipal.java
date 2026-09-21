package co.edu.unbosque.view;

import co.edu.unbosque.controller.*;
import co.edu.unbosque.exception.*;
import co.edu.unbosque.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner scanner;
    private final AlojamientoController alojamientoController;
    private final HuespedController huespedController;
    private final ReservaController reservaController;
    private final ReporteController reporteController;
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public MenuPrincipal(AlojamientoController alojamientoController, HuespedController huespedController,
                          ReservaController reservaController, ReporteController reporteController) {
        this.scanner = new Scanner(System.in);
        this.alojamientoController = alojamientoController;
        this.huespedController = huespedController;
        this.reservaController = reservaController;
        this.reporteController = reporteController;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            String opcion = scanner.nextLine().trim();
            try {
                switch (opcion) {
                    case "1": consultarAlojamientos(); break;
                    case "2": buscarAlojamientos(); break;
                    case "3": consultarDetalleAlojamiento(); break;
                    case "4": registrarAlojamiento(); break;
                    case "5": registrarHuesped(); break;
                    case "6": consultarHuespedes(); break;
                    case "7": crearReserva(); break;
                    case "8": consultarReservas(); break;
                    case "9": cancelarReserva(); break;
                    case "10": mostrarReportes(); break;
                    case "0":
                        salir = true;
                        System.out.println("Los cambios ya fueron guardados. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opcion de menu incorrecta. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE GESTION DE ALOJAMIENTOS - INVERSIONES LR =====");
        System.out.println("1.  Consultar todos los alojamientos");
        System.out.println("2.  Buscar alojamientos (ciudad / tipo / capacidad / precio)");
        System.out.println("3.  Consultar detalle de un alojamiento");
        System.out.println("4.  Registrar un alojamiento");
        System.out.println("5.  Registrar un huesped");
        System.out.println("6.  Consultar huespedes");
        System.out.println("7.  Crear una reserva");
        System.out.println("8.  Consultar reservas");
        System.out.println("9.  Cancelar una reserva");
        System.out.println("10. Ver reportes");
        System.out.println("0.  Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private void consultarAlojamientos() {
        List<Alojamiento> lista = alojamientoController.consultarTodos();
        if (lista.isEmpty()) {
            System.out.println("No hay alojamientos registrados.");
            return;
        }
        lista.forEach(System.out::println);
    }

    private void buscarAlojamientos() {
        System.out.print("Ciudad (enter para omitir): ");
        String ciudad = scanner.nextLine().trim();
        System.out.print("Tipo -APARTAMENTO/CASA/CABANA- (enter para omitir): ");
        String tipo = scanner.nextLine().trim();
        Integer capacidadMinima = leerEnteroOpcional("Capacidad minima (enter para omitir): ");
        Double precioMaximo = leerDoubleOpcional("Precio maximo por noche (enter para omitir): ");

        List<Alojamiento> resultado = alojamientoController.buscar(
                ciudad.isBlank() ? null : ciudad,
                tipo.isBlank() ? null : tipo,
                capacidadMinima, precioMaximo);

        if (resultado.isEmpty()) {
            System.out.println("No se encontraron alojamientos con esos criterios.");
        } else {
            resultado.forEach(System.out::println);
        }
    }

    private void consultarDetalleAlojamiento() throws IdentificadorInexistenteException {
        System.out.print("Id del alojamiento: ");
        String id = scanner.nextLine().trim();
        Alojamiento a = alojamientoController.consultarDetalle(id);
        System.out.println("---- Detalle ----");
        System.out.println("Id: " + a.getId());
        System.out.println("Tipo: " + a.getTipo());
        System.out.println("Nombre: " + a.getNombre());
        System.out.println("Ciudad: " + a.getCiudad());
        System.out.println("Ubicacion: " + a.getUbicacion());
        System.out.println("Capacidad: " + a.getCapacidad());
        System.out.println("Precio base/noche: $" + a.getPrecioBase());
        System.out.println("Estado: " + a.getEstado());
        System.out.println("Descripcion: " + a.getDescripcion());
        System.out.println("Servicios adicionales: " + a.getServiciosAdicionales());
    }

    private void registrarAlojamiento() throws IdentificadorDuplicadoException, DatoObligatorioVacioException,
            EntradaInvalidaException {
        System.out.print("Id: ");
        String id = scanner.nextLine().trim();
        System.out.print("Tipo (APARTAMENTO/CASA/CABANA): ");
        String tipo = scanner.nextLine().trim().toUpperCase();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine().trim();
        System.out.print("Ubicacion: ");
        String ubicacion = scanner.nextLine().trim();
        int capacidad = leerEntero("Capacidad: ");
        double precio = leerDouble("Precio base por noche: ");
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine().trim();

        Alojamiento alojamiento;
        switch (tipo) {
            case "CASA": alojamiento = new Casa(); break;
            case "CABANA": alojamiento = new Cabana(); break;
            case "APARTAMENTO": alojamiento = new Apartamento(); break;
            default:
                System.out.println("Tipo no reconocido, se registrara como APARTAMENTO.");
                alojamiento = new Apartamento();
        }
        alojamiento.setId(id);
        alojamiento.setNombre(nombre);
        alojamiento.setCiudad(ciudad);
        alojamiento.setUbicacion(ubicacion);
        alojamiento.setCapacidad(capacidad);
        alojamiento.setPrecioBase(precio);
        alojamiento.setEstado(EstadoAlojamiento.ACTIVO);
        alojamiento.setDescripcion(descripcion);

        alojamientoController.registrarAlojamiento(alojamiento);
        System.out.println("Alojamiento registrado correctamente.");
    }

    private void registrarHuesped() throws IdentificadorDuplicadoException, DatoObligatorioVacioException {
        System.out.print("Id: ");
        String id = scanner.nextLine().trim();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();
        System.out.print("Correo: ");
        String correo = scanner.nextLine().trim();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine().trim();

        Huesped huesped = new Huesped(id, nombre, apellido, correo, telefono);
        huespedController.registrarHuesped(huesped);
        System.out.println("Huesped registrado correctamente.");
    }

    private void consultarHuespedes() {
        List<Huesped> lista = huespedController.consultarTodos();
        if (lista.isEmpty()) {
            System.out.println("No hay huespedes registrados.");
            return;
        }
        lista.forEach(System.out::println);
    }

    private void crearReserva() throws Exception {
        System.out.print("Id de la reserva: ");
        String id = scanner.nextLine().trim();
        System.out.print("Id del huesped: ");
        String idHuesped = scanner.nextLine().trim();
        System.out.print("Id del alojamiento: ");
        String idAlojamiento = scanner.nextLine().trim();

        LocalDate llegada = leerFecha("Fecha de llegada (yyyy-MM-dd): ");
        LocalDate salida = leerFecha("Fecha de salida (yyyy-MM-dd): ");
        int numeroHuespedes = leerEntero("Numero de huespedes: ");

        Reserva reserva = reservaController.crearReserva(id, idHuesped, idAlojamiento, llegada, salida, numeroHuespedes);
        System.out.println("Reserva creada correctamente:");
        System.out.println(reserva);
    }

    private void consultarReservas() {
        System.out.println("1. Todas  2. Por huesped  3. Por alojamiento");
        String opcion = scanner.nextLine().trim();
        List<Reserva> lista;
        switch (opcion) {
            case "2":
                System.out.print("Id del huesped: ");
                lista = reservaController.consultarPorHuesped(scanner.nextLine().trim());
                break;
            case "3":
                System.out.print("Id del alojamiento: ");
                lista = reservaController.consultarPorAlojamiento(scanner.nextLine().trim());
                break;
            default:
                lista = reservaController.consultarTodas();
        }
        if (lista.isEmpty()) {
            System.out.println("No hay reservas para mostrar.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    private void cancelarReserva() throws IdentificadorInexistenteException, ReglaDeNegocioException {
        System.out.print("Id de la reserva a cancelar: ");
        String id = scanner.nextLine().trim();
        reservaController.cancelarReserva(id);
        System.out.println("Reserva " + id + " cancelada correctamente.");
    }

    private void mostrarReportes() {
        System.out.println("\n--- Alojamientos por ciudad ---");
        Map<String, Integer> porCiudad = reporteController.alojamientosPorCiudad();
        porCiudad.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\n--- Alojamientos disponibles por tipo ---");
        reporteController.alojamientosDisponiblesPorTipo().forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\n--- Cantidad de alojamientos por tipo ---");
        reporteController.cantidadAlojamientosPorTipo().forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\n--- Reservas ---");
        System.out.println("Confirmadas: " + reporteController.totalReservasConfirmadas());
        System.out.println("Canceladas: " + reporteController.totalReservasCanceladas());
        System.out.println("Ingresos estimados (confirmadas): $" + reporteController.ingresosEstimados());
        System.out.println("Alojamiento con mas reservas: " + reporteController.alojamientoConMasReservas());
    }

    // ---------- utilidades de lectura con manejo de errores ----------

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada numerica invalida, intente de nuevo.");
            }
        }
    }

    private Integer leerEnteroOpcional(String mensaje) {
        System.out.print(mensaje);
        String entrada = scanner.nextLine().trim();
        if (entrada.isBlank()) return null;
        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Valor ignorado por ser invalido.");
            return null;
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada numerica invalida, intente de nuevo.");
            }
        }
    }

    private Double leerDoubleOpcional(String mensaje) {
        System.out.print(mensaje);
        String entrada = scanner.nextLine().trim();
        if (entrada.isBlank()) return null;
        try {
            return Double.parseDouble(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Valor ignorado por ser invalido.");
            return null;
        }
    }

    private LocalDate leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return LocalDate.parse(entrada, FORMATO_FECHA);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha invalida, use el formato yyyy-MM-dd.");
            }
        }
    }
}
