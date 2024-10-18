/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquetePrincipal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Alzola
 */
public class conexion {
  private String url,tipo,urlNueva;
  private int puerto;
 
  
  
  public conexion(String url,String tipo,int puerto,String urlNueva){
  this.url=url;
  this.tipo=tipo;
  this.puerto=puerto;
  this.urlNueva=urlNueva;
 
  }
  
  // Metodo para validar IP y puerto ingresados
  public boolean validarConexion(){
  String formatoIp="^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";
  boolean validarIp;
     
 

  
      if (url.matches(formatoIp) && (puerto > 0 && puerto <= 9999)) {
        validarIp=true;
    } else if (tipo=="dns") {
        validarIp=true;
    }else
        validarIp=false;
  
  return validarIp;
  
  }//FIN MODIFICAR VALIDAR IP
  
  
  
  //Metodo para modificar el archivo Server
  public void modificarServer() throws FileNotFoundException{
         String rutaArchivo = "C:/ISAltda/iJServPOS/server.properties";
         String nuevoTexto=this.urlNueva;
        // Usamos Path de la librería java.nio para mayor compatibilidad de rutas
        Path ruta = Paths.get(rutaArchivo);
        
        // Crear una lista de líneas para guardar el contenido del archivo
        try {
            // Leer todas las líneas del archivo
            BufferedReader reader = Files.newBufferedReader(ruta);
            StringBuilder contenidoModificado = new StringBuilder();
            String linea;

            // Leer cada línea y verificar si contiene el texto a buscar
            while ((linea = reader.readLine()) != null) {
                // Si la línea contiene el texto buscado, la reemplazamos
                if (linea.contains("ijserv_server_url=")) {
                    linea = "ijserv_server_url="+nuevoTexto;  // Reemplazar la línea
                }
                // Agregar la línea (modificada o no) al contenido modificado
                contenidoModificado.append(linea).append(System.lineSeparator());
            }

            // Cerrar el lector de archivos
            reader.close();

            // Escribir el contenido modificado de nuevo en el archivo
            BufferedWriter writer = Files.newBufferedWriter(ruta);
            writer.write(contenidoModificado.toString());
            writer.close();



        } catch (IOException e) {
            System.out.println("Ocurrió un error al modificar el archivo.");
            e.printStackTrace();
        }
    }// FIN MODIFICAR SERVER


  


    public  void abrirPos() {
        try {
            // Ruta completa al archivo .bat
            String rutaBat = "C:/ISAltda/iJServPOS/iJServ.bat";
            
            // Ejecutar el archivo .bat
            Process proceso = Runtime.getRuntime().exec(rutaBat);
            
            // Esperar a que el proceso termine
            proceso.waitFor();
            
            System.out.println("Archivo .bat ejecutado correctamente.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    
    }
      
      
      
      
 
  
        
  
    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the puerto
     */
    public int getPuerto() {
        return puerto;
    }

    /**
     * @param puerto the puerto to set
     */
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the urlNueva
     */
    public String getUrlNueva() {
        return urlNueva;
    }

    /**
     * @param urlNueva the urlNueva to set
     */
    public void setUrlNueva(String urlNueva) {
        this.urlNueva = urlNueva;
    }
  
  
}
