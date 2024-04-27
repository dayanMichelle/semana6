package clases;

public class Devolucion {
  private Libro libro;
  private Usuario usuario;
  private String fechaDevolucionReal;

  private static final float MONTO_DEVOLUCION_POR_DIA = 1000;

  public Devolucion(Libro libro, Usuario usuario, String fechaDevolucionReal) {

    if (!usuario.getPrestamo().equals(libro.getIsbn())) {
      throw new IllegalArgumentException("El usuario no tiene este libro prestado.");
    }

    usuario.setPrestamo("0");
    libro.setCantidadDisponible(libro.getCantidadDisponible() + 1);

    this.libro = libro;
    this.usuario = usuario;
    this.fechaDevolucionReal = fechaDevolucionReal;
  }

  public Libro getLibro() {
    return libro;
  }

  public void setLibro(Libro libro) {
    this.libro = libro;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public String getFechaDevolucionReal() {
    return fechaDevolucionReal;
  }

  public void setFechaDevolucionReal(String fechaDevolucionReal) {
    this.fechaDevolucionReal = fechaDevolucionReal;
  }

  public float calculateMulta(String fechaDevolucion) {
    long diasDeAtraso = Fecha.calculateDistanciaDias(fechaDevolucion, this.fechaDevolucionReal);
    return diasDeAtraso * MONTO_DEVOLUCION_POR_DIA;
  }

}
