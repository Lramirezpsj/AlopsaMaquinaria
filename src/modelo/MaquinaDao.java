
package modelo;


public class MaquinaDao {
    
    private int id_maquina;
    private String maquina;

    public MaquinaDao() {
    }

    public MaquinaDao(int id_maquina, String maquina) {
        this.id_maquina = id_maquina;
        this.maquina = maquina;
    }

    public int getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(int id_maquina) {
        this.id_maquina = id_maquina;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }
    
}
