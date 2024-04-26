package clases;

public enum Genero {
  M, F;

  public static Genero fromChar(char c) {
    switch (c) {
      case 'M':
      case 'm':
        return M;
      case 'F':
      case 'f':
        return F;
      default:
        throw new IllegalArgumentException("Código inválido: " + c);
    }
  }
}
