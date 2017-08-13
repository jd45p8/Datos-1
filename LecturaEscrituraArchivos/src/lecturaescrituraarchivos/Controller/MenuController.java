/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescrituraarchivos.Controller;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import lecturaescrituraarchivos.Model.Archivo;
import lecturaescrituraarchivos.Model.Registro;

/**
 *
 * @author jd45
 */
public class MenuController {
    public static void Explorar(JTextField dirField, JLabel status, Archivo archivo){
        if(archivo.getFile() != null){
            dirField.setText(archivo.getFile().getAbsolutePath());
            status.setText("Cargado");
        }else{
            status.setText("No cargado");
        }
    }
    
    public static void Cargar(JList jlist, ArrayList<Registro> registros){
        DefaultListModel model = new DefaultListModel();
        jlist.setModel(model);
        for (Registro registro : registros){            
            model.addElement(registro.getInfo());
        }
    }
            
}

