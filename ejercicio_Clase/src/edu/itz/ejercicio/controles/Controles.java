package edu.itz.ejercicio.controles;

import edu.itz.ejercicio.vistas.Ventana;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Almanza
 * 
 */

public class Controles {
    Ventana ventana;

    public Controles(Ventana ventana) {
        this.ventana = ventana;
    }
    public void abrirArchivo(){
        limpiar();
       // ventana.getTxtContenido().setText("hola mundo");
       String path = null;
       JFileChooser filechooser = new JFileChooser();
       int returnValue = filechooser.showOpenDialog(ventana);
       if(returnValue == JFileChooser.APPROVE_OPTION){
           path = filechooser.getSelectedFile().getAbsolutePath();
       }
       if (path == null){
           JOptionPane.showMessageDialog(ventana, "no se selecciono ningun archivo");
           return;
       }
       leerArchivo(path);
    }
    public void limpiar(){
        ventana.getTxtContenido().setText("");
    }
    public void leerArchivo(String archivo){
        String texto="";
         String linea;
        try {
           BufferedReader br = new BufferedReader
                (new FileReader(archivo));
           
            while ((linea = br.readLine()) != null) {
                texto+=linea+"\n";
            }
            
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
       ventana.getTxtContenido().append(texto+"\n");
       
    }
}
