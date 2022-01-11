package ExFinalEjServidor;
//
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//++ respuesta a la tarea +++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//+++++++++++++++++++++++++++++++++++++++++++++++++++++ respuesta a la tarea ++

/**
 * *****************************************************************************
 * Servidor HTTP que atiende peticiones de tipo 'GET' recibidas por el puerto
 * 8066
 *
 * NOTA: para probar este código, comprueba primero de que no tienes ningún otro
 * servicio por el puerto 8066 (por ejemplo, con el comando 'netstat' si estás
 * utilizando Windows)
 *
 * @author IMCG
 */
class ServidorHTTP extends Thread {

  /**
   * **************************************************************************
   * procedimiento principal que asigna a cada petición entrante un socket
   * cliente, por donde se enviará la respuesta una vez procesada
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException, Exception {
    //Asociamos al servidor el puerto 8066
    ServerSocket socServidor = new ServerSocket(8066);
    imprimeDisponible();
    //ante una petición entrante, procesa la petición por el socket cliente
    //por donde la recibe
    while (true) {
      new ServidorHTTP(socServidor.accept()).start();
    }
  }

  Socket socketCliente;
  
  public ServidorHTTP(Socket socketCliente) {
      this.socketCliente = socketCliente;
  }
  
  /**
   *****************************************************************************
   * procesa la petición recibida
   *
   * @throws IOException
   */
  @Override
  public void run() {
    //variables locales
    String peticion;
    String html;

      System.out.println("Cliente conectado");
    
    try {
    //Flujo de entrada
    InputStreamReader inSR = new InputStreamReader(
            socketCliente.getInputStream());
    //espacio en memoria para la entrada de peticiones
    BufferedReader bufLeer = new BufferedReader(inSR);

    //objeto de java.io que entre otras características, permite escribir 
    //'línea a línea' en un flujo de salida
    PrintWriter printWriter = new PrintWriter(
            socketCliente.getOutputStream(), true);

    //mensaje petición cliente
    peticion = bufLeer.readLine();

    //para compactar la petición y facilitar así su análisis, suprimimos todos 
    //los espacios en blanco que contenga
    peticion = peticion.replaceAll(" ", "");

    //si realmente se trata de una petición 'GET' (que es la única que vamos a
    //implementar en nuestro Servidor)
    if (peticion.startsWith("GET")) {
      //extrae la subcadena entre 'GET' y 'HTTP/1.1'
      peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));

      //si corresponde a la página de inicio
      if (peticion.length() == 0 || peticion.equals("/")) {
        //sirve la página
        html = Paginas.html_index;
        printWriter.println(Mensajes.lineaInicial_OK);
        printWriter.println(Paginas.primeraCabecera);
        printWriter.println("Content-Length:" + html.length() );
        //++ respuesta a la tarea +++++++++++++++++++++++++++++++++++++++++++++
        printWriter.println("Date:" + getAhoraGMTFormat());
        //+++++++++++++++++++++++++++++++++++++++++++++ respuesta a la tarea ++
        printWriter.println("\n");
        printWriter.println(html);
      } //si corresponde a la página del Quijote
      else if (peticion.equals("/quijote")) {
        //sirve la página
        
          System.out.println("Entro en quijor");
        html = Paginas.html_quijote;
        printWriter.println(Mensajes.lineaInicial_OK);
        printWriter.println(Paginas.primeraCabecera);
          System.out.println("PAginas primera cabera" + Paginas.primeraCabecera);
        printWriter.println("Content-Length: " + html.length() );
        
        //++ respuesta a la tarea +++++++++++++++++++++++++++++++++++++++++++++
        printWriter.println("Date:" + getAhoraGMTFormat());
        //+++++++++++++++++++++++++++++++++++++++++++++ respuesta a la tarea ++
        printWriter.println("\n");
        printWriter.println(html);
      } //en cualquier otro caso
      else {
        //sirve la página
        html = Paginas.html_noEncontrado;
        printWriter.println(Mensajes.lineaInicial_NotFound);
        printWriter.println(Paginas.primeraCabecera);
        printWriter.println("Content-Length: " + html.length() );
        //++ respuesta a la tarea +++++++++++++++++++++++++++++++++++++++++++++
        printWriter.println("Date:" + getAhoraGMTFormat());
        //+++++++++++++++++++++++++++++++++++++++++++++ respuesta a la tarea ++
        printWriter.println("\n");
        printWriter.println(html);
      }
    }
    } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
    }
    
    System.out.println("Cliente desconectado");
  }

  /**
   * ++ respuesta a la tarea ++++++++++++++++++++++++++++++++++++++++++++++++++
   * función que devuelve el instante en que se ejecuta, como una cadena con el
   * formato correcto para el encabezado Date de un servidor HTTP
   *
   * @return
   */
  private static String getAhoraGMTFormat() {
    //
    DateFormat df = new SimpleDateFormat(
            "EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
    df.setTimeZone(TimeZone.getTimeZone("GMT"));
    return df.format(new Date());
  }//++++++++++++++++++++++++++++++++++++++++++++++++++ respuesta a la tarea ++

  /**
   * **************************************************************************
   * muestra un mensaje en la Salida que confirma el arranque, y da algunas
   * indicaciones posteriores
   */
  private static void imprimeDisponible() {

    System.out.println("El Servidor WEB se está ejecutando y permanece a la "
            + "escucha por el puerto 8066.\nEscribe en la barra de direcciones "
            + "de tu explorador preferido:\n\nhttp://localhost:8066\npara "
            + "solicitar la página de bienvenida\n\nhttp://localhost:8066/"
            + "quijote\npara solicitar una página del Quijote,\n\nhttp://"
            + "localhost:8066/q\npara simular un error");
  }
}
