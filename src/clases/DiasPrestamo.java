package clases;

public enum DiasPrestamo {
  ESTUDIANTE(10),
  DOCENTE(20);

  private int days;

  DiasPrestamo(int days) {
    this.days = days;
  }

  public int getDays() {
    return days;
  }
}
