/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescrituraarchivos;

import lecturaescrituraarchivos.Model.Archivo;
import lecturaescrituraarchivos.View.Menu;

/**
 *
 * @author jd45
 */
public class main {
    static Archivo file;
    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        file = new Archivo();
        new Menu(file).setVisible(true);
    }
    
}
