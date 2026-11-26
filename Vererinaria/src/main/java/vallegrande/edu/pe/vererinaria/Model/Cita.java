package vallegrande.edu.pe.gestionveterinaria.Model;

import java.sql.Timestamp;

public class Cita {

    private int idCita;
    private int idMascota;
    private int idVeterinario;
    private Timestamp fechaCita;
    private String estado;

    public Cita() {
    }

    public Cita(int idCita, int idMascota, int idVeterinario, Timestamp fechaCita, String estado) {
        this.idCita = idCita;
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
        this.fechaCita = fechaCita;
        this.estado = estado;
    }

    public Cita(int idMascota, int idVeterinario, String estado) {
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
        this.estado = estado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public Timestamp getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Timestamp fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}