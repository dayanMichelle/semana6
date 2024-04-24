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
    usuarios.add(usuario);
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
    libros.add(libro);
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

}