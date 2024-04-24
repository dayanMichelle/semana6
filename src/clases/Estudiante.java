package clases;


public class Estudiante extends Usuario {
  private String carrera;

  public Estudiante(String nombreCompleto, String run, char genero, boolean prestamo, String carrera) {
    super(nombreCompleto, run, genero, prestamo);
    this.carrera = carrera;
  }

  public String getCarrera() {
    return carrera;
  }

  public void setCarrera(String carrera) {
    this.carrera = carrera;
  }
}