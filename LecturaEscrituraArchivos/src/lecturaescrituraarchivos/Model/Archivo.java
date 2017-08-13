/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescrituraarchivos.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import lecturaescrituraarchivos.View.Menu;

/**
 *
 * @author jd45archivo
 */
public class Archivo {

    BufferedReader reader;
    File file;    

    public Archivo() {
        
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    public void Seleccionar(JFrame parent) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter(".txt","txt"));
        int response = chooser.showOpenDialog(parent);

        if (response == JFileChooser.APPROVE_OPTION) {
            this.file = chooser.getSelectedFile();   
        } else {
            this.file = null;
        }
    }

    public void Abrir() {
        if (this.file != null) {
            try {
                this.reader = new BufferedReader(new FileReader(this.file));  
                System.out.println("Archivo abierto.");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("Archivo no seleccionado.");
        } 
    }

    public String Leer() {
        if (file != null) {
            if (this.reader != null) {
                try {
                    String line = this.reader.readLine();
                    if (line != null) {                        
                        return line;
                    } else {
                        return "EOF";
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            } else {
                System.out.println("Archivo no abierto.");
                return "EOF";
            }
        }
        System.out.println("Archivo no seleccionado.");
        return "EOF";
    }

    public void cerrar() {
        try {      
            if(reader != null)
                this.reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escribir(ArrayList<Registro> registros, String input){
        if (this.file != null) {
            registros.add(new Registro(input));            
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(this.file.getAbsolutePath()));
                for (Registro registro : registros) {
                    writer.write(registro.getInfo());
                    writer.newLine();
                }
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
            System.out.println("Archivo no seleccionado");
    }
}
