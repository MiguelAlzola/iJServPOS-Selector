/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquetePrincipal;
import java.net.*;
import java.util.Enumeration;
/**
 *
 * @author Miguel Alzola
 */
public class interfacesRed {
    String ipTerminal;

    public String ipTerminal(){
     try {
            // Obtener todas las interfaces de red disponibles
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();

                // Solo trabajar con interfaces activas y que no sean loopback
                if (ni.isUp() && !ni.isLoopback()) {
                    // Obtener todas las direcciones IP de la interfaz
                    Enumeration<InetAddress> addresses = ni.getInetAddresses();

                    while (addresses.hasMoreElements()) {
                        InetAddress ip = addresses.nextElement();
                        
                        // Solo mostrar direcciones IPv4 (omitimos IPv6 si no es necesario)
                        if (ip instanceof Inet4Address) {
                            
                            ipTerminal=ip.getHostAddress();
                            
                        }
                    }
                }
            }

        } catch (SocketException e) {
            e.printStackTrace();
        }
    
    
    
    
    
    return ipTerminal;
    }

 }   
    
    
    
    

