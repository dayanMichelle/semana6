package clases;

public class Libro {
  private String isbn;
  private String titulo;
  private String autor;
  private int cantidadBiblioteca;
  private int cantidadDisponible;
  private String imagen;

  public Libro(String isbn, String titulo, String autor, int cantidadBiblioteca, int cantidadDisponible,
      String imagen) {
    this.isbn = isbn;
    this.titulo = titulo;
    this.autor = autor;
    this.imagen = imagen;
    setCantidadBiblioteca(cantidadBiblioteca);
    setCantidadDisponible(cantidadDisponible);
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public int getCantidadBiblioteca() {
    return cantidadBiblioteca;
  }

  public void setCantidadBiblioteca(int cantidadBiblioteca) {
    throwErrorWhenCantidadBibliotecaIsLessThanZero(cantidadBiblioteca); // idadBiblioteca);
    this.cantidadBiblioteca = cantidadBiblioteca;
  }

  static void throwErrorWhenCantidadBibliotecaIsLessThanZero(int cantidadBiblioteca) {
    if (cantidadBiblioteca <= 0)
      throw new IllegalArgumentException("cantidadBiblioteca debe ser mayor a 0");
  }

  static void throwErrorWhenCantidadDisponibleIsLessThanZeroOrMoreThanCantidadBiblioteca(int cantidadDisponible,
      int cantidadBiblioteca) {
    if (cantidadDisponible < 0)
      throw new IllegalArgumentException("cantidadDisponible debe ser mayor a 0");

    if (cantidadDisponible > cantidadBiblioteca)
      throw new IllegalArgumentException("cantidadDisponible debe ser menor o igual de la cantidadBiblioteca");
  }

  public int getCantidadDisponible() {
    return cantidadDisponible;
  }

  public void setCantidadDisponible(int cantidadDisponible) {
    throwErrorWhenCantidadDisponibleIsLessThanZeroOrMoreThanCantidadBiblioteca(cantidadDisponible,
        cantidadBiblioteca);
    this.cantidadDisponible = cantidadDisponible;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  @Override
  public String toString() {
    return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", cantidadBiblioteca="
        + cantidadBiblioteca + ", cantidadDisponible=" + cantidadDisponible + ", imagen=" + imagen + "]";
  }
}