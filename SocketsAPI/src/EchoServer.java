
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.lang.System;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class EchoServer {
    public static void main(String[] args) throws IOException {
         
          
        int portNumber = 4000;
         
        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();     
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            
            out.println("Established");
            
            while ((inputLine = in.readLine()) != null) {
            	
                
                if(inputLine.equalsIgnoreCase(("date")) || inputLine.equalsIgnoreCase("Date")) {
                	
                	 java.util.Date date = new java.util.Date();    
                	    out.println("Date: " + date);   
            }
                if(inputLine.equalsIgnoreCase("memory") ||inputLine.equalsIgnoreCase("Memory") || inputLine.equalsIgnoreCase("free")) {
                
                	 out.println("Available Memory: " + Runtime.getRuntime().freeMemory() + " bytes");
                }
                
                if(inputLine.equalsIgnoreCase("uptime") ||inputLine.equalsIgnoreCase("Uptime")) {
                	
                RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();

                out.println("Up time: " + rb.getUptime() + " ms");
             
                
                 }
              
                }   
        }
    catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
