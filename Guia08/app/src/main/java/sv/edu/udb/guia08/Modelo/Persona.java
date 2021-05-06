package sv.edu.udb.guia08.Modelo;

public class Persona {
    private String dui;
    private String nombre;
    private Double peso;
    private Double altura;
    private String fecha;
    private String Genero;
    String key;

    public Persona() {
    }

    public Persona(String dui, String nombre, Double peso, Double altura, String fecha, String Genero) {
        this.dui = dui;
        this.nombre = nombre;
        this.peso=peso;
        this.altura=altura;
        this.fecha=fecha;
        this.Genero=Genero;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Double getPeso() { return peso; }

    public void setPeso(Double peso) { this.peso = peso;    }

    public Double getAltura() {  return altura; }

    public void setAltura(Double altura) { this.altura = altura;  }

    public String getFecha() {  return fecha;  }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getGenero() {  return Genero; }

    public void setGenero(String genero) {  Genero = genero;  }
}
