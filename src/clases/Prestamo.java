package clases;

public class Prestamo {
  private String isbnLibro;
  private String runUsuario;
  private String fechaPrestamo;
  private int diasPrestamo;
  private String fechaDevolucion;

  // getters y setters
  public String getIsbnLibro() {
    return isbnLibro;
  }

  public void setIsbnLibro(String isbnLibro) {
    this.isbnLibro = isbnLibro;
  }

  public String getRunUsuario() {
    return runUsuario;
  }

  public void setRunUsuario(String runUsuario) {
    this.runUsuario = runUsuario;
  }

  public String getFechaPrestamo() {
    return fechaPrestamo;
  }

  public void setFechaPrestamo(String fechaPrestamo) {
    this.fechaPrestamo = fechaPrestamo;
  }

  public int getDiasPrestamo() {
    return diasPrestamo;
  }

  public void setDiasPrestamo(int diasPrestamo) {
    this.diasPrestamo = diasPrestamo;
  }

  public String getFechaDevolucion() {
    return fechaDevolucion;
  }

  public void setFechaDevolucion(String fechaDevolucion) {
    this.fechaDevolucion = fechaDevolucion;
  }
}