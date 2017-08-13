/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescrituraarchivos.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jd45
 */
public class Archivo {

    BufferedReader reader;
    File file;
    ArrayList<Registro> registros;

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
    
    public Archivo() {
        this.registros = new ArrayList<>();
    }

    public ArrayList<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<Registro> Registros) {
        this.registros = Registros;
    }

    public void Seleccionar(JFrame parent) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("txt", ".txt"));
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
                    if (line.equals("") == false) {
                        this.registros.add(new Registro(line));
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
                return null;
            }
        }
        System.out.println("Archivo no seleccionado.");
        return null;
    }

    public void cerrar() {
        try {
            registros = new ArrayList<>();
            this.reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
