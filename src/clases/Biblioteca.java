package clases;

import java.util.*;

public class Biblioteca {
  private List<Usuario> usuarios;
  private List<Libro> libros;
  private List<Prestamo> prestamos;

  public Biblioteca() {
    this.usuarios = new ArrayList<>();
    this.libros = new ArrayList<>();
    this.prestamos = new ArrayList<>();
  }

  public void agregarUsuario(Usuario usuario) {

    if (!Usuario.esRunValido(usuario.getRun()))
      throw new IllegalStateException("El formato del run no es correcto.");

    if (!isValidRun(usuario.getRun()))
      throw new IllegalStateException("Run ya existe.");

    usuarios.add(usuario);

  }

  private boolean isValidRun(String run) {
    for (Usuario usuario : usuarios) {
      if (usuario.getRun().equals(run)) {
        return false;
      }
    }
    return true;
  }

  public Usuario buscarUsuarioPorRun(String run) {
    for (Usuario usuario : usuarios) {
      if (usuario.getRun().equals(run)) {
        return usuario;
      }
    }
    return null;
  }

  public void editarUsuario(String run, Usuario usuarioNuevo) {
    Usuario usuarioExistente = buscarUsuarioPorRun(run);

    if (usuarioExistente != null) {
      int index = usuarios.indexOf(usuarioExistente);
      usuarios.set(index, usuarioNuevo);
    } else {
      System.out.println("No se encontró ningún usuario con el RUN especificado.");
    }
  }

  public void eliminarUsuarioPorRun(String run) {
    Usuario usuarioAEliminar = buscarUsuarioPorRun(run);

    if (usuarioAEliminar != null) {
      usuarios.remove(usuarioAEliminar);
      System.out.println("Usuario eliminado correctamente.");
    } else {
      System.out.println("No se encontró ningún usuario con el RUN especificado.");
    }
  }

  public void agregarLibro(Libro libro) {
    throwExceptionWhenISBNIsDuplicate(libro.getIsbn());
    libros.add(libro);
  }

  private void throwExceptionWhenISBNIsDuplicate(String isbn) {
    if (buscarLibroPorIsbn(isbn) != null)
      throw new IllegalStateException("Código de ISBN repetido");
  }

  public Libro buscarLibroPorIsbn(String isbn) {
    for (Libro libro : libros) {
      if (libro.getIsbn().equals(isbn)) {
        return libro;
      }
    }
    return null;
  }

  public void editarLibro(String isbn, Libro libro) {
    throwExceptionWhenISBNIsDuplicate(libro.getIsbn());

    for (int i = 0; i < libros.size(); i++) {
      if (libros.get(i).getIsbn().equals(isbn)) {
        libros.set(i, libro);
        break;
      }
    }
  }

  public void eliminarLibro(String isbn) {
    for (int i = 0; i < libros.size(); i++) {
      if (libros.get(i).getIsbn().equals(isbn)) {
        libros.remove(i);
        break;
      }
    }
  }

  public void realizarPrestamo(Prestamo prestamo) {
    prestamos.add(prestamo);
  }

  public void devolverPrestamo(Prestamo prestamo) {
    prestamos.remove(prestamo);
  }

  public List<Libro> getLibros() {
    return libros;
  }

  public List<Prestamo> getPrestamos() {
    return prestamos;
  }

  public void setLibros(List<Libro> libros) {
    this.libros = libros;
  }

  public void setPrestamos(List<Prestamo> prestamos) {
    this.prestamos = prestamos;
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }

  public Prestamo obtenerPrestamoPorRunYIsbn(String run, String isbn) {
    for (Prestamo prestamo : prestamos) {
      if (prestamo.getUsuario().getRun().equals(run) && prestamo.getLibro().getIsbn().equals(isbn)) {
        return prestamo;
      }
    }
    return null;
  }

}