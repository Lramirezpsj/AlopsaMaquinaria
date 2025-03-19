package modelo;

/**
 *
 * @author ramir
 */
public class Medidas {
    
    private int id_medida;
    private String medida;

    public Medidas() {
    }

    public Medidas(int id_medida, String medida) {
        this.id_medida = id_medida;
        this.medida = medida;
    }

    public int getId_medida() {
        return id_medida;
    }

    public void setId_medida(int id_medida) {
        this.id_medida = id_medida;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
    
    
}
