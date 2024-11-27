package util;

import java.awt.desktop.OpenURIEvent;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;

/**
 * Clase que ayuda a realizar una serie de modificaciones en cadenas
 */
public class Acondicionador {

  public static String acondicionaElementoHtml(String cadena) {
    cadena = cadena.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    return cadena;
  }
  
  public static String acondicionaAtributoHtml(String cadena) {
    cadena = cadena.replace("&", "&amp;").replace("<", "&lt;").replace("\"", "&#34;").replace("'", "&#39;");
    return cadena;
  }

  public static String acondicionaContenidoCss(String cadena) {
    
    cadena = cadena.replace("\\", "\\5c").replace("\"", "\\22 ").replace("'", "\\27").replace("<", "\\3c").replace("&", "\\26").replace("(", "\\28").replace(")", "\\29").replace("/", "\\2f ");
    return cadena;
  }

  public static String acondicionaUrl(String cadena) throws UnsupportedEncodingException {
    cadena = URLEncoder.encode(cadena, "UTF-8");
    cadena = cadena.replace("+", "%20").replace("%40", "@");
    return cadena;
  }

  public static String acondicionaLiteralSql(String cadena) {
    cadena = cadena.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("%", "\\%").replace("_", "\\_");
    
    return cadena;
  }


}
