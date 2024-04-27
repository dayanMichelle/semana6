package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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

  public static long calculateDistanciaDias(String fecha1, String fecha2) {
    LocalDate fechaInicio = LocalDate.parse(fecha1);
    LocalDate fechaFin = LocalDate.parse(fecha2);
    long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    return dias;
  }

}
