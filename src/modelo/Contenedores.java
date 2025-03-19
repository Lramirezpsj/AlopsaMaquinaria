package modelo;

import java.time.LocalDate;

/**
 *
 * @author ramir
 */
public class Contenedores {
    
    private int id_contenedor;
    private LocalDate fecha;
    private String maquina;
    private String contenedor;
    private String medida;
    private String movimiento;
    private String comentarios;
    private String operador;

    public Contenedores() {
    }

    public Contenedores(int id_contenedor, LocalDate fecha, String maquina, String contenedor, String medida, String movimiento, String comentarios, String operador) {
        this.id_contenedor = id_contenedor;
        this.fecha = fecha;
        this.maquina = maquina;
        this.contenedor = contenedor;
        this.medida = medida;
        this.movimiento = movimiento;
        this.comentarios = comentarios;
        this.operador = operador;
    }

    public int getId_contenedor() {
        return id_contenedor;
    }

    public void setId_contenedor(int id_contenedor) {
        this.id_contenedor = id_contenedor;
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

    public String getContenedor() {
        return contenedor;
    }

    public void setContenedor(String contenedor) {
        this.contenedor = contenedor;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
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
