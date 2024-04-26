package clases;

public class Docente extends Usuario {
  private String profesion;

  public Docente(String nombreCompleto, String run, Genero genero, boolean prestamo, String profesion) {
    super(nombreCompleto, run, genero, prestamo);
    this.profesion = profesion;
  }

  public String getProfesion() {
    return profesion;
  }

  public void setProfesion(String profesion) {
    this.profesion = profesion;
  }
}