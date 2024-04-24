package clases;


public class Usuario {
  private String nombreCompleto;
  private String run;
  private char genero;
  private boolean prestamo;

  // Constructor
  public Usuario(String nombreCompleto, String run, char genero, boolean prestamo) {
    this.nombreCompleto = nombreCompleto;
    this.run = run;
    this.genero = genero;
    this.prestamo = prestamo;
  }

  // Getters y Setters
  public String getNombreCompleto() {
    return nombreCompleto;
  }

  public void setNombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
  }

  public String getRun() {
    return run;
  }

  public void setRun(String run) {
    this.run = run;
  }

  public char getGenero() {
    return genero;
  }

  public void setGenero(char genero) {
    this.genero = genero;
  }

  public boolean getPrestamo() {
    return prestamo;
  }

  public void setPrestamo(boolean prestamo) {
    this.prestamo = prestamo;
  }
}