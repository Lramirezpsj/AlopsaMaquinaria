
package modelo;

import java.time.LocalDate;

/**
 *
 * @author ramir
 */
public class Horometros {
    
    private int id_horometro;
    private LocalDate fecha;
    private String maquina;
    private String cliente;
    private double h_inicio;
    private double h_final;
    private int turno;
    private String comentarios;
    private String operador;

    public Horometros() {
    }

    public Horometros(int id_horometro, LocalDate fecha, String maquina, String cliente, double h_inicio, double h_final, int turno, String comentarios, String operador) {
        this.id_horometro = id_horometro;
        this.fecha = fecha;
        this.maquina = maquina;
        this.cliente = cliente;
        this.h_inicio = h_inicio;
        this.h_final = h_final;
        this.turno = turno;
        this.comentarios = comentarios;
        this.operador = operador;
    }

    public int getId_horometro() {
        return id_horometro;
    }

    public void setId_horometro(int id_horometro) {
        this.id_horometro = id_horometro;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getH_inicio() {
        return h_inicio;
    }

    public void setH_inicio(double h_inicio) {
        this.h_inicio = h_inicio;
    }

    public double getH_final() {
        return h_final;
    }

    public void setH_final(double h_final) {
        this.h_final = h_final;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
    
    
}
