package clases;

public class Usuario {
  private String nombreCompleto;
  private String run;
  private Genero genero;
  private boolean prestamo;

  // Constructor
  public Usuario(String nombreCompleto, String run, Genero genero, boolean prestamo) {
    this.nombreCompleto = nombreCompleto;
    this.run = run;
    this.genero = genero;
    this.prestamo = prestamo;
  }

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

  public Genero getGenero() {
    return genero;
  }

  public void setGenero(Genero genero) {
    this.genero = genero;
  }

  public boolean getPrestamo() {
    return prestamo;
  }

  public void setPrestamo(boolean prestamo) {
    this.prestamo = prestamo;
  }

  public static boolean esRunValido(String run) {
    if (run == null || !run.matches("\\d{1,8}-[\\dkK]")) {
      return false;
    }
    return true;
  }

}