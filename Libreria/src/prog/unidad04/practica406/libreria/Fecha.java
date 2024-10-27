package prog.unidad04.practica406.libreria;

/**
 * Clase que representa una fecha a partir del 1/1/1900
 */
public class Fecha implements ConvertibleATexto {
  /**
   * Dia de la fecha. Debe valer entre 1 y la cantidad de días del mes. Tiene en
   * cuenta los años bisiestos
   */
  private int dia;
  /**
   * mes de la fecha. Debe valer entre 1 y 12
   */
  private int mes;
  /**
   * Año de la fecha. Debe ser mayor o igual a 1900
   */
  private int anyo;

  /**
   * Constructor con dia mes y año
   * 
   * @param dia  Dia de la fecha. Debe valer entre 1 y la cantidad de días del
   *             mes. Tiene en cuenta los años bisiestos
   * @param mes  Mes de la fecha. Debe valer entre 1 y 12
   * @param anyo Año de la fecha. Debe ser mayor o igual a 1900
   * @throws IllegalArgumentException Si los parámetros no se corresponden con una
   *                                  fecha válida
   */
  public Fecha(int dia, int mes, int anyo) {
    if (comprobarFecha(dia, mes, anyo) == true) {
      this.anyo = anyo;
      this.dia = dia;
      this.mes = mes;
    } else {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Obtiene el día de la fecha
   * 
   * @return Dia de la fecha
   */
  public int getDia() {
    return dia;
  }

  /**
   * Obtiene el mes de la fecha
   * 
   * @return Mes de la fecha
   */
  public int getMes() {
    return mes;
  }

  /**
   * Obtiene el año de la fecha
   * 
   * @return Año de la fecha
   */
  public int getAnyo() {
    return anyo;
  }

  /**
   * Dice si el año es bisiesto o no
   * 
   * @return Si es bisiesto o no
   */
  public boolean esBisiesto() {
    return (anyo % 4 == 0 && anyo % 100 != 0 || anyo % 400 == 0);

  }

  /**
   * Obtiene una representación de la fecha en formato texto El formato es DDDD de
   * MMMMM de AAAAA donde DDDD es el día del mes (en número), MMMM es el mes (en
   * letra y minúsculas) y AAAA es el año (en número)
   * 
   * @return Cadena con la información del objeto en formato texto
   */
  public String aTexto() {
    return getDia() + " " + numeroAMes(mes) + " " + getAnyo();

  }

  /**
   * Compara esta fecha con otra
   * 
   * @param fecha Fecha con la que se quiere comparar ésta
   * @return Menor que 0 si esta fecha es anterior a la otra, 0 si las dos fechas
   *         son iguales y mayor que cero si esta fecha es posterior a la otra
   */
  public int compara(Fecha fecha) {
    if (fecha.diasTranscurridos() < diasTranscurridos()) {
      return 1;
    } else if (fecha.diasTranscurridos() > diasTranscurridos()) {
      return -1;
    } else {
      return 0;
    }
  }

  /**
   * Obtiene el número de días transcurridos entre esta fecha y otra posterior que
   * se proporciona.
   * 
   * @param fecha Otra fecha posterior a ésta
   * @return Número de días transcurridos entre esta fecha y la proporcionada
   * @throws FechaException Si la fecha proporcionada es anterior a ésta
   */
  public long diasEntre(Fecha fecha) {
    // Pasamos las dos fechas a días
    long fechaActual = pasarADias(dia, mes, anyo);
    long fecha2 = pasarADias(fecha.getDia(), fecha.getMes(), fecha.getAnyo());

    if (fecha2 < fechaActual) {
      throw new FechaException();
    }

    return fecha2 - fechaActual;
  }

  /**
   * Obtiene el número de días transcurridos entre esta fecha y la fecha de inicio
   * del calendario (1/1/1900)
   * 
   * @return Número de días transcurridos entre esta fecha y la fecha de inicio
   *         del calendario
   */
  public long diasTranscurridos() {
    // pasamos las fechas a dias
    long fechaInicio = pasarADias(1, 1, 1900);
    long fechaActual = pasarADias(dia, mes, anyo);
    return fechaActual - fechaInicio;

  }

  //pasa a los dias transcurrido desde el 01/01/1900 hasta la fecha introducida
  private long pasarADias(int dia, int mes, int anyo) {

    long m;
    long a;
    // pasamos los meses y años a dias
    m = mesADias(mes);
    a = anyoADias(anyo);

    return a + m + dia;

  }

  // metodo privado que devuelve si es bisiesto o no de un año concreto
  private boolean esBisiestoAnyo(int anyo) {
    return (anyo % 4 == 0 && anyo % 100 != 0 || anyo % 400 == 0);

  }

  // pasamos de años a dias
  private long anyoADias(int anyo) {
    long a = 0;

    for (int i = 1900; i != anyo; i++) {
      if (esBisiestoAnyo(i)) {
        a += 366;
      } else {
        a += 365;
      }

    }
    return a;

  }

  // Pasa el mes al numero de dias transcurrido desde enero
  private long mesADias(int mes) {
    long m = 0;

    if (mes == 1) {
      m = 0;
    } else if (mes == 2) {
      m = 31;
    } else if (mes == 3) {
      if (esBisiesto()) {
        m = 31 + 29;
      } else {
        m = 31 + 28;
      }
    } else if (mes == 4) {
      if (esBisiesto()) {
        m = 31 + 29 + 31;
      } else {
        m = 31 + 28 + 31;
      }
    } else if (mes == 5) {
      if (esBisiesto()) {
        m = 31 + 29 + 31 + 30;
      } else {
        m = 31 + 28 + 31 + 30;
      }
    } else if (mes == 6) {
      if (esBisiesto()) {
        m = 31 + 29 + 31 + 30 + 31;
      } else {
        m = 31 + 28 + 31 + 30 + 31;
      }
    } else if (mes == 7) {
      if (esBisiesto()) {
        m = 31 + 29 + 31 + 30 + 31 + 30;
      } else {
        m = 31 + 28 + 31 + 30 + 31 + 30;
      }
    } else if (mes == 8) {
      if (esBisiesto()) {
        m = 31 + 29 + 31 + 30 + 31 + 30 + 31;
      } else {
        m = 31 + 28 + 31 + 30 + 31 + 30 + 31;
      }
    } else if (mes == 9) {
      if (esBisiesto()) {
        m = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31;
      } else {
        m = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
      }
    } else if (mes == 10) {
      if (esBisiesto()) {
        m = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
      } else {
        m = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
      }
    } else if (mes == 11) {
      if (esBisiesto()) {
        m = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
      } else {
        m = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
      }
    } else if (mes == 12) {
      if (esBisiesto()) {
        m = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
      } else {
        m = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
      }
    }

    return m;

  }

  // metodo privado que pasa el numero del mes al nombre del mes
  public String numeroAMes(int mes) {
    if (mes == 1) {
      return "de enero de";
    } else if (mes == 2) {
      return "de febrero de";

    } else if (mes == 3) {
      return "de marzo de";

    } else if (mes == 4) {
      return "de abril de";

    } else if (mes == 5) {
      return "de mayo de";

    } else if (mes == 6) {
      return "de junio de";

    } else if (mes == 7) {
      return "de julio de";

    } else if (mes == 8) {
      return "de agosto de";

    } else if (mes == 9) {
      return "de septiembre de";

    } else if (mes == 10) {
      return "de octubre de";

    } else if (mes == 11) {
      return "de noviembre de";

    } else {
      return "de diciembre de";

    }
  }

  // Comprobamos la fecha
  public boolean comprobarFecha(int dia, int mes, int anyo) {
    boolean diaCorrecto;
    boolean mesCorrecto;
    boolean anyoCorrecto;

    // Comprobamos si el año es correcto
    anyoCorrecto = anyo >= 1900;

    // Comprobamos si el mes es correcto
    mesCorrecto = mes >= 1 && mes <= 12;
    switch (mes) {
    case 2:
      if ((esBisiestoAnyo(anyo))) {
        diaCorrecto = dia >= 1 && dia <= 29;
      } else {
        diaCorrecto = dia >= 1 && dia <= 28;
      }
      break;
    case 4:
      diaCorrecto = dia >= 1 && dia <= 30;
      break;
    case 6:
      diaCorrecto = dia >= 1 && dia <= 30;
      break;
    case 9:
      diaCorrecto = dia >= 1 && dia <= 30;
      break;
    case 11:
      diaCorrecto = dia >= 1 && dia <= 30;
      break;
    default:
      diaCorrecto = dia >= 1 && dia <= 31;
    }
    return (diaCorrecto && mesCorrecto && anyoCorrecto);
  }

}
