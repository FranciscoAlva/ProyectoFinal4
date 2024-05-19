package Modelo;


public class Sedes {
    
    private int IDSedes;
    private String DireccionSedes;
    private String EmailSedes;
    private String TelefonoSedes;
    private String ResponsableSedes;

    public Sedes() {
    }

    public Sedes(int IDSedes, String DireccionSedes, String EmailSedes, String TelefonoSedes, String ResponsableSedes) {
        this.IDSedes = IDSedes;
        this.DireccionSedes = DireccionSedes;
        this.EmailSedes = EmailSedes;
        this.TelefonoSedes = TelefonoSedes;
        this.ResponsableSedes = ResponsableSedes;
    }

    public int getIDSedes() {
        return IDSedes;
    }

    public void setIDSedes(int IDSedes) {
        this.IDSedes = IDSedes;
    }

    public String getDireccionSedes() {
        return DireccionSedes;
    }

    public void setDireccionSedes(String DireccionSedes) {
        this.DireccionSedes = DireccionSedes;
    }

    public String getEmailSedes() {
        return EmailSedes;
    }

    public void setEmailSedes(String EmailSedes) {
        this.EmailSedes = EmailSedes;
    }

    public String getTelefonoSedes() {
        return TelefonoSedes;
    }

    public void setTelefonoSedes(String TelefonoSedes) {
        this.TelefonoSedes = TelefonoSedes;
    }

    public String getResponsableSedes() {
        return ResponsableSedes;
    }

    public void setResponsableSedes(String ResponsableSedes) {
        this.ResponsableSedes = ResponsableSedes;
    }
    
    

}
