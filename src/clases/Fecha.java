package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {

  public static String getFechaActual() {
    LocalDate fechaActual = LocalDate.now();
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return fechaActual.format(formateador);
  }

  public static String getFechaActual(int dias) {
    LocalDate fechaActual = LocalDate.now();
    LocalDate nuevaFecha = fechaActual.plusDays(dias);
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return nuevaFecha.format(formateador);
  }

}
