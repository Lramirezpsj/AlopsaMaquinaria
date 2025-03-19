package modelo;

import java.time.LocalDate;

/**
 *
 * @author ramir
 */
public class Suministros {
    
    private int id_suministro;
    private LocalDate fecha;
    private String maquina;
    private Double horometro;
    private Double total;
    private String comentarios;
    private String operador;

    public Suministros() {
    }

    public Suministros(int id_suministro, LocalDate fecha, String maquina, Double horometro, Double total, String comentarios, String operador) {
        this.id_suministro = id_suministro;
        this.fecha = fecha;
        this.maquina = maquina;
        this.horometro = horometro;
        this.total = total;
        this.comentarios = comentarios;
        this.operador = operador;
    }

    public int getId_suministro() {
        return id_suministro;
    }

    public void setId_suministro(int id_suministro) {
        this.id_suministro = id_suministro;
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

    public Double getHorometro() {
        return horometro;
    }

    public void setHorometro(Double horometro) {
        this.horometro = horometro;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
