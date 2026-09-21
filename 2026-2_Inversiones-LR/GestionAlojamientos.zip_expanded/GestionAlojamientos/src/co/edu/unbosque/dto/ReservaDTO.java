package co.edu.unbosque.dto;

public class ReservaDTO {

    private String id;
    private String idHuesped;
    private String idAlojamiento;
    private String fechaLlegada; // yyyy-MM-dd
    private String fechaSalida;  // yyyy-MM-dd
    private int numeroHuespedes;
    private long numeroNoches;
    private double valorTotal;
    private String estado; // CONFIRMADA, CANCELADA

    public ReservaDTO() {
    }

    public ReservaDTO(String id, String idHuesped, String idAlojamiento, String fechaLlegada,
                       String fechaSalida, int numeroHuespedes, long numeroNoches,
                       double valorTotal, String estado) {
        this.id = id;
        this.idHuesped = idHuesped;
        this.idAlojamiento = idAlojamiento;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.numeroHuespedes = numeroHuespedes;
        this.numeroNoches = numeroNoches;
        this.valorTotal = valorTotal;
        this.estado = estado;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getIdHuesped() { return idHuesped; }
    public void setIdHuesped(String idHuesped) { this.idHuesped = idHuesped; }

    public String getIdAlojamiento() { return idAlojamiento; }
    public void setIdAlojamiento(String idAlojamiento) { this.idAlojamiento = idAlojamiento; }

    public String getFechaLlegada() { return fechaLlegada; }
    public void setFechaLlegada(String fechaLlegada) { this.fechaLlegada = fechaLlegada; }

    public String getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(String fechaSalida) { this.fechaSalida = fechaSalida; }

    public int getNumeroHuespedes() { return numeroHuespedes; }
    public void setNumeroHuespedes(int numeroHuespedes) { this.numeroHuespedes = numeroHuespedes; }

    public long getNumeroNoches() { return numeroNoches; }
    public void setNumeroNoches(long numeroNoches) { this.numeroNoches = numeroNoches; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
