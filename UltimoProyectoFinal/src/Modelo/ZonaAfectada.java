package Modelo;


public class ZonaAfectada {
    
    private int IDZona;
    private String NombreZona;
    private String PaisZona;
    private String CiudadZona;
    private String NombreONG3;

    public ZonaAfectada() {
    }

    public ZonaAfectada(int IDZona, String NombreZona, String PaisZona, String CiudadZona, String NombreONG3) {
        this.IDZona = IDZona;
        this.NombreZona = NombreZona;
        this.PaisZona = PaisZona;
        this.CiudadZona = CiudadZona;
        this.NombreONG3 = NombreONG3;
    }

    public int getIDZona() {
        return IDZona;
    }

    public void setIDZona(int IDZona) {
        this.IDZona = IDZona;
    }

    public String getNombreZona() {
        return NombreZona;
    }

    public void setNombreZona(String NombreZona) {
        this.NombreZona = NombreZona;
    }

    public String getPaisZona() {
        return PaisZona;
    }

    public void setPaisZona(String PaisZona) {
        this.PaisZona = PaisZona;
    }

    public String getCiudadZona() {
        return CiudadZona;
    }

    public void setCiudadZona(String CiudadZona) {
        this.CiudadZona = CiudadZona;
    }

    public String getNombreONG3() {
        return NombreONG3;
    }

    public void setNombreONG3(String NombreONG3) {
        this.NombreONG3 = NombreONG3;
    }

    
}
