package Modelo;


public class ONG {

    private int IDONG;
    private String NombreONG;
    private String CIFONG;
    private String DireccionONG;
    private String TelefonoONG;
    private String EmailONG;

    public ONG() {
    }

    public ONG(int IDONG, String NombreONG, String CIFONG, String DireccionONG, String TelefonoONG, String EmailONG) {
        this.IDONG = IDONG;
        this.NombreONG = NombreONG;
        this.CIFONG = CIFONG;
        this.DireccionONG = DireccionONG;
        this.TelefonoONG = TelefonoONG;
        this.EmailONG = EmailONG;
    }

    public int getIDONG() {
        return IDONG;
    }

    public void setIDONG(int IDONG) {
        this.IDONG = IDONG;
    }

    public String getNombreONG() {
        return NombreONG;
    }

    public void setNombreONG(String NombreONG) {
        this.NombreONG = NombreONG;
    }

    public String getCIFONG() {
        return CIFONG;
    }

    public void setCIFONG(String CIFONG) {
        this.CIFONG = CIFONG;
    }

    public String getDireccionONG() {
        return DireccionONG;
    }

    public void setDireccionONG(String DireccionONG) {
        this.DireccionONG = DireccionONG;
    }

    public String getTelefonoONG() {
        return TelefonoONG;
    }

    public void setTelefonoONG(String TelefonoONG) {
        this.TelefonoONG = TelefonoONG;
    }

    public String getEmailONG() {
        return EmailONG;
    }

    public void setEmailONG(String EmailONG) {
        this.EmailONG = EmailONG;
    }
    
    
    
    
}
