/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquetePrincipal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Miguel Alzola
 */
public class dnsEstacion {
 private String estacion,sello,url;
 private int puerto;    
 
 
 public dnsEstacion(String estacion,String sello,String url,int puerto){
 this.estacion=estacion;
 this.sello=sello;
 this.url=url;
 this.puerto=puerto; 
 }//Fin constructor  


 
    /**
     * @return the estacion
     */
    public String getEstacion() {
        return estacion;
    }

    /**
     * @param estacion the estacion to set
     */
    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    /**
     * @return the sello
     */
    public String getSello() {
        return sello;
    }

    /**
     * @param sello the sello to set
     */
    public void setSello(String sello) {
        this.sello = sello;
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
 
    
    @Override
    public String toString() {
        return "dns{" +
                "estacion='" + estacion + '\'' +
                ", sello='" + sello + '\'' +
                ", url='" + url + '\'' +
                ", puerto=" + puerto +
                '}';
    }
 
    
    
    // Método para cargar los datos del archivo en una lista de objetos dns
    public static List<dnsEstacion> cargarDNS(String fileName) {
        List<dnsEstacion> servidoresDNS = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Separar los datos usando punto y coma
                String[] partes = linea.split(";");
                String estacion = partes[0];
                String sello = partes[1];
                String url = partes[2];
                int puerto = Integer.parseInt(partes[3]);

                // Crear un nuevo objeto dns y agregarlo a la lista
                dnsEstacion servidor = new dnsEstacion(estacion, sello, url, puerto);
                servidoresDNS.add(servidor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return servidoresDNS;
    }   
 
 
 
 

 }//Fin Clase



 
 
 

