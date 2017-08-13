/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescrituraarchivos.Controller;

import javax.swing.JLabel;
import javax.swing.JTextField;
import lecturaescrituraarchivos.Model.Archivo;

/**
 *
 * @author jd45
 */
public class MenuController {
    public static void Abrir(JTextField dirField, JLabel status, Archivo archivo){
        if(archivo.getFile() != null){
            dirField.setText(archivo.getFile().getAbsolutePath());
            status.setText("Cargado");
        }else{
            status.setText("No caragado");
        }
    }
            
}

