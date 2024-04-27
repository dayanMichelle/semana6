import java.util.Scanner;
import clases.*;

public class Main {
  public static void main(String[] args) {
    Biblioteca biblioteca = new Biblioteca();
    Scanner scanner = new Scanner(System.in);
    boolean continuar = true;
    while (continuar) {
      // Display menu options
      System.out.println("Welcome to the Library Management System!");
      System.out.println("1. Agregar usuario");
      System.out.println("2. Editar usuario");
      System.out.println("3. Eliminar usuario");
      System.out.println("4. Añadir libro");
      System.out.println("5. Editar libro");
      System.out.println("6. Eliminar libro");
      System.out.println("7. Realizar préstamo");
      System.out.println("8. Devolver préstamo");
      System.out.println("0. Exit");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Ingrese el tipo de usuario a crear (1 para Estudiante, 2 para Docente):");
          int tipoUsuario = scanner.nextInt();
          System.out.println("Ingrese el nombre completo:");
          String nombreCompleto = scanner.next();
          System.out.println("Ingrese el RUN:");
          String run = scanner.next();
          System.out.println("Ingrese el género (M o F):");
          char genero = scanner.next().charAt(0);
          String prestamo = "0";
          switch (tipoUsuario) {
            case 1:
              System.out.println("Ingrese la carrera:");
              String carrera = scanner.next();
              biblioteca
                  .agregarUsuario(new Estudiante(nombreCompleto, run, Genero.fromChar(genero), prestamo, carrera));
              break;
            case 2:
              System.out.println("Ingrese la profesión:");
              String profesion = scanner.next();
              biblioteca.agregarUsuario(new Docente(nombreCompleto, run, Genero.fromChar(genero), prestamo, profesion));
              break;
            default:
              System.out.println("Tipo de usuario no válido.");
          }
          System.out.println("Usuario agregado correctamente.");
          break;
        case 2:
          System.out.println("Ingrese el RUN del usuario a editar:");
          String runEditar = scanner.next();

          Usuario usuarioEditar = biblioteca.buscarUsuarioPorRun(runEditar);

          if (usuarioEditar != null) {
            System.out.println("Ingrese el nuevo nombre completo:");
            String nuevoNombreCompleto = scanner.next();
            System.out.println("Ingrese el nuevo género (M o F):");
            char nuevoGenero = scanner.next().charAt(0);

            usuarioEditar.setNombreCompleto(nuevoNombreCompleto);
            usuarioEditar.setGenero(Genero.fromChar(nuevoGenero));

            System.out.println("Usuario editado correctamente.");
          } else {
            System.out.println("Usuario no encontrado.");
          }
          break;
        case 3:
          System.out.println("Ingrese el RUN del usuario a eliminar:");
          String runEliminar = scanner.next();
          biblioteca.eliminarUsuarioPorRun(runEliminar);
          break;
        case 4:
          System.out.println("Ingrese el ISBN del libro:");
          String isbn = scanner.next();
          // Verificar si el ISBN ya existe
          Libro libroExistente = biblioteca.buscarLibroPorIsbn(isbn);
          if (libroExistente != null) {
            System.out.println("El ISBN ingresado ya existe. Por favor, ingrese un ISBN único.");
            break;
          }
          System.out.println("Ingrese el título del libro:");
          String titulo = scanner.next();
          System.out.println("Ingrese el autor del libro:");
          String autor = scanner.next();
          System.out.println("Ingrese la cantidad de este libro en la biblioteca:");
          int cantidadBiblioteca = scanner.nextInt();

          System.out.println("Ingrese la cantidad disponible de este libro:");
          int cantidadDisponible = scanner.nextInt();

          System.out.println("Ingrese la URL de la imagen del libro:");
          String imagen = scanner.next();

          Libro nuevoLibro = new Libro(isbn, titulo, autor, cantidadBiblioteca, cantidadDisponible, imagen);
          biblioteca.agregarLibro(nuevoLibro);

          System.out.println("Libro añadido correctamente.");
          break;
        case 5:
          System.out.println("Ingrese el ISBN del libro a editar:");
          String isbnEditar = scanner.next();

          Libro libroEditar = biblioteca.buscarLibroPorIsbn(isbnEditar);

          if (libroEditar != null) {
            System.out.println("Ingrese el nuevo ISBN del libro:");
            String nuevoIsbn = scanner.next();
            if (biblioteca.buscarLibroPorIsbn(nuevoIsbn) != null) {
              System.out.println("El ISBN ya existe. Por favor, ingrese un ISBN único.");
              break;
            }

            System.out.println("Ingrese la nueva cantidad de este libro en la biblioteca:");
            int nuevaCantidadBiblioteca = scanner.nextInt();

            System.out.println("Ingrese la nueva cantidad disponible de este libro:");
            int nuevaCantidadDisponible = scanner.nextInt();

            System.out.println("Ingrese el nuevo título del libro:");
            String nuevoTitulo = scanner.next();

            System.out.println("Ingrese el nuevo autor del libro:");
            String nuevoAutor = scanner.next();

            System.out.println("Ingrese la nueva URL de la imagen del libro:");
            String nuevaImagen = scanner.next();

            libroEditar.setIsbn(nuevoIsbn);
            libroEditar.setTitulo(nuevoTitulo);
            libroEditar.setAutor(nuevoAutor);
            libroEditar.setCantidadBiblioteca(nuevaCantidadBiblioteca);
            libroEditar.setCantidadDisponible(nuevaCantidadDisponible);
            libroEditar.setImagen(nuevaImagen);

            System.out.println("Libro editado correctamente.");
          } else {
            System.out.println("No se encontró ningún libro con el ISBN especificado.");
          }
          break;
        case 6:
          System.out.println("Ingrese el ISBN del libro a eliminar:");
          String isbnEliminar = scanner.next();

          Libro libroEliminar = biblioteca.buscarLibroPorIsbn(isbnEliminar);

          if (libroEliminar != null) {
            biblioteca.getLibros().remove(libroEliminar);
            System.out.println("Libro eliminado correctamente.");
          } else {
            System.out.println("No se encontró ningún libro con el ISBN especificado.");
          }
          break;
        case 7:
          System.out.println("Ingrese el RUN del usuario:");
          String RUNUsuario = scanner.next();

          Usuario usuario = biblioteca.buscarUsuarioPorRun(RUNUsuario);

          if (usuario != null) {
            if (!usuario.getPrestamo().equals("0")) {
              System.out.println("El usuario ya tiene un libro prestado.");
              return;
            }

            System.out.println("Ingrese el ISBN del libro a prestar:");
            String isbnPrestamo = scanner.next();

            Libro libroPrestamo = biblioteca.buscarLibroPorIsbn(isbnPrestamo);

            if (libroPrestamo != null) {
              System.out.println("Ingrese la cantidad de libros a prestar:");
              int cantidadPrestamo = scanner.nextInt();

              if (libroPrestamo.getCantidadDisponible() >= cantidadPrestamo) {
                String fechaPrestamo = Fecha.getFechaActual();
                int diasPrestamo = usuario instanceof Docente ? DiasPrestamo.DOCENTE.getDays()
                    : DiasPrestamo.ESTUDIANTE.getDays();

                String fechaDevolucion = Fecha.getFechaActual(diasPrestamo);

                Prestamo nuevoPrestamo = new Prestamo(libroPrestamo, usuario, fechaPrestamo, fechaDevolucion,
                    diasPrestamo);

                biblioteca.getPrestamos().add(nuevoPrestamo);

                libroPrestamo.setCantidadDisponible(libroPrestamo.getCantidadDisponible() - cantidadPrestamo);

                System.out.println("Préstamo realizado correctamente.");
                System.out.println(nuevoPrestamo.toString());
              } else {
                System.out.println("No hay suficientes libros disponibles para prestar.");
              }
            } else {
              System.out.println("No se encontró ningún libro con el ISBN especificado.");
            }
          } else {
            System.out.println("No se encontró ningún usuario con el RUN especificado.");
          }
          break;
        case 8:
          // Return Loan logic
          break;
        case 0:
          continuar = false;
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }

      // Close the scanner
    }
  }
}
