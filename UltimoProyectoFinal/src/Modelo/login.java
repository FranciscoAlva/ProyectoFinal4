package Modelo;


public class login {

    private int IDLogin;
    private String NombreLogin;
    private String EmailLogin;
    private String Password;

    public login() {
    }

    public login(int IDLogin, String NombreLogin, String EmailLogin, String Password) {
        this.IDLogin = IDLogin;
        this.NombreLogin = NombreLogin;
        this.EmailLogin = EmailLogin;
        this.Password = Password;
    }

    public int getIDLogin() {
        return IDLogin;
    }

    public void setIDLogin(int IDLogin) {
        this.IDLogin = IDLogin;
    }

    public String getNombreLogin() {
        return NombreLogin;
    }

    public void setNombreLogin(String NombreLogin) {
        this.NombreLogin = NombreLogin;
    }

    public String getEmailLogin() {
        return EmailLogin;
    }

    public void setEmailLogin(String EmailLogin) {
        this.EmailLogin = EmailLogin;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
