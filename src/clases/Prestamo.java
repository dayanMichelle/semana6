package clases;

public class Prestamo {
  private Libro libro;
  private Usuario usuario;
  private String fechaPrestamo;
  private String fechaDevolucion;
  private int duracion;

  public Prestamo(Libro libro, Usuario usuario, String fechaPrestamo, String fechaDevolucion, int duracion) {
    usuario.setPrestamo(libro.getIsbn());
    this.libro = libro;
    this.usuario = usuario;
    this.fechaPrestamo = fechaPrestamo;
    this.fechaDevolucion = fechaDevolucion;
    this.duracion = duracion;
  }

  public Libro getLibro() {
    return libro;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public String getFechaPrestamo() {
    return fechaPrestamo;
  }

  public String getFechaDevolucion() {
    return fechaDevolucion;
  }

  public int getDuracion() {
    return duracion;
  }

  // Setters
  public void setLibro(Libro libro) {
    this.libro = libro;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public void setFechaPrestamo(String fechaPrestamo) {
    this.fechaPrestamo = fechaPrestamo;
  }

  public void setFechaDevolucion(String fechaDevolucion) {
    this.fechaDevolucion = fechaDevolucion;
  }

  public void setDuracion(int duracion) {
    this.duracion = duracion;
  }

  @Override
  public String toString() {
    return "Prestamo [libro=" + libro + ", usuario=" + usuario + ", fechaPrestamo=" + fechaPrestamo
        + ", fechaDevolucion=" + fechaDevolucion + ", duracion=" + duracion + "]";
  }

}