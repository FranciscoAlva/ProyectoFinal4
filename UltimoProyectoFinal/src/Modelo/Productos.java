package Modelo;


public class Productos {
    private int IDProductos;
    private String NombreProductos;
    private String TipodeProductos;
    private String DescripcionProductos;
    private int CantidadProductos;
    private int IDDonante;
    private String NombreONG2;

    public Productos() {
    }

    public Productos(int IDProductos, String NombreProductos, String TipodeProductos, String DescripcionProductos, int CantidadProductos, int IDDonante, String NombreONG2) {
        this.IDProductos = IDProductos;
        this.NombreProductos = NombreProductos;
        this.TipodeProductos = TipodeProductos;
        this.DescripcionProductos = DescripcionProductos;
        this.CantidadProductos = CantidadProductos;
        this.IDDonante = IDDonante;
        this.NombreONG2 = NombreONG2;
    }

    public int getIDProductos() {
        return IDProductos;
    }

    public void setIDProductos(int IDProductos) {
        this.IDProductos = IDProductos;
    }

    public String getNombreProductos() {
        return NombreProductos;
    }

    public void setNombreProductos(String NombreProductos) {
        this.NombreProductos = NombreProductos;
    }

    public String getTipodeProductos() {
        return TipodeProductos;
    }

    public void setTipodeProductos(String TipodeProductos) {
        this.TipodeProductos = TipodeProductos;
    }

    public String getDescripcionProductos() {
        return DescripcionProductos;
    }

    public void setDescripcionProductos(String DescripcionProductos) {
        this.DescripcionProductos = DescripcionProductos;
    }

    public int getCantidadProductos() {
        return CantidadProductos;
    }

    public void setCantidadProductos(int CantidadProductos) {
        this.CantidadProductos = CantidadProductos;
    }

    public int getIDDonante() {
        return IDDonante;
    }

    public void setIDDonante(int IDDonante) {
        this.IDDonante = IDDonante;
    }

    public String getNombreONG2() {
        return NombreONG2;
    }

    public void setNombreONG2(String NombreONG2) {
        this.NombreONG2 = NombreONG2;
    }
    
    
    
    

}
