/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itz.edu.ejercicios.controles;

import itz.edu.ejercicios.vistas.Vistas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Guillermo
 */
public class Control {

    Vistas v;

    public Control(Vistas v) {
        this.v = v;
    }

    public void abrirArchivo() {
        limpiar();
        // v.getTxtContenido().setText("Hola Mundo");
        String path = null;
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(v);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().getAbsolutePath();
            v.getLblArchivo().setText(path);

        }
        if (path == null) {
            JOptionPane.showMessageDialog(v, "Le diste a cancelar");
            return;

        }
        leerArchivo(path);
    }

    public void limpiar() {
        v.getTxtContenido().setText("");
        v.getLblArchivo().setText("");
        v.getTxtSalida().setText("");
    }

    public void leerArchivo(String archivo) {
        String texto = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                texto += linea + "\n";
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        v.getTxtContenido().append(texto + "\n");
    }

    public void contar() {
        int letras = 0, numeros = 0, otros = 0;
        String palabra = v.getTxtContenido().getText();
        
        
        String c = v.getTxtContenido().getText();
        v.getTxtSalida().setText(c.length() + "\n");
        char a = c.charAt(0);
        v.getTxtSalida().append("Tu primer letra es:"+ a+ "\n");
        for (int i = 0; i <c.length(); i++) {
            a  = c.charAt(i);
            if(Character.isLetter(a)){
                letras++;
            } else if (Character.isDigit(a)){
                numeros++;
            }else {
                otros++;
            }
        }
       v.getTxtSalida().append("Número de letras: " +letras+"\n");
       v.getTxtSalida().append("Número de números: " +numeros+ "\n");
       v.getTxtSalida().append("Número de signos: " +otros+ "\n");
       
        if(palabra.matches("at")){
            v.getTxtSalida().append("si se hace match\n");
        }else{
            v.getTxtSalida().append("no match\n");
        }
        }
    }
