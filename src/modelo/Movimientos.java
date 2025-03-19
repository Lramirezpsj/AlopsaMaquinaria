package modelo;

/**
 *
 * @author ramir
 */
public class Movimientos {
    
    private int id_movimiento;
    private String movimiento;

    public Movimientos() {
    }

    public Movimientos(int id_movimiento, String movimiento) {
        this.id_movimiento = id_movimiento;
        this.movimiento = movimiento;
    }

    public int getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }
    
}
