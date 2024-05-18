package Modelo;


public class Usuarios {
    
    private int IDUsuarios;
    private String NombreUsuarios;
    private String ApellidosUsuarios;
    private String DNIUsuarios;
    private String EmailUsuarios;
    private String DireccionUsuarios;

    public Usuarios() {
    }

    public Usuarios(int IDUsuarios, String NombreUsuarios, String ApellidosUsuarios, String DNIUsuarios, String EmailUsuarios, String DireccionUsuarios) {
        this.IDUsuarios = IDUsuarios;
        this.NombreUsuarios = NombreUsuarios;
        this.ApellidosUsuarios = ApellidosUsuarios;
        this.DNIUsuarios = DNIUsuarios;
        this.EmailUsuarios = EmailUsuarios;
        this.DireccionUsuarios = DireccionUsuarios;
    }

    public int getIDUsuarios() {
        return IDUsuarios;
    }

    public void setIDUsuarios(int IDUsuarios) {
        this.IDUsuarios = IDUsuarios;
    }

    public String getNombreUsuarios() {
        return NombreUsuarios;
    }

    public void setNombreUsuarios(String NombreUsuarios) {
        this.NombreUsuarios = NombreUsuarios;
    }

    public String getApellidosUsuarios() {
        return ApellidosUsuarios;
    }

    public void setApellidosUsuarios(String ApellidosUsuarios) {
        this.ApellidosUsuarios = ApellidosUsuarios;
    }

    public String getDNIUsuarios() {
        return DNIUsuarios;
    }

    public void setDNIUsuarios(String DNIUsuarios) {
        this.DNIUsuarios = DNIUsuarios;
    }

    public String getEmailUsuarios() {
        return EmailUsuarios;
    }

    public void setEmailUsuarios(String EmailUsuarios) {
        this.EmailUsuarios = EmailUsuarios;
    }

    public String getDireccionUsuarios() {
        return DireccionUsuarios;
    }

    public void setDireccionUsuarios(String DireccionUsuarios) {
        this.DireccionUsuarios = DireccionUsuarios;
    }
    
    

}
