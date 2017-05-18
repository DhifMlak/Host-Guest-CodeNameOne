/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import entity.Randonnee;
import Services.ServiceRandonnee;
import com.codename1.io.Util;
import com.codename1.ui.TextField;
import java.util.ArrayList;

/**
 *
 * @author Firas
 */
public class MesRandoForm {
    Form f;
    TextField txtFind;
    public static ArrayList<Randonnee> MesRandos;
    public MesRandoForm(Resources theme) {
        UIBuilder ui = new UIBuilder();
        Container ctn = ui.createContainer(theme, "MesRandos").getComponentForm();
        txtFind= (TextField) ui.findByName("txtfind", ctn);
        Container ctnlist = (Container)ui.findByName("ctnMesRandos", ctn);
        
        f = (Form)ctn;
        f.getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeForm homeForm = new HomeForm(theme);
                homeForm.getF().showBack();
         
            }
        });
        
        f.setTitle("Mes Randonnées");
        ServiceRandonnee serviceRandonnee = ServiceRandonnee.GetInstance();
        txtFind.addDataChangedListener((type, index) -> {
            System.out.println(txtFind.getText());
            if ("".equals(txtFind.getText().trim())) {
                ctnlist.removeAll();
                serviceRandonnee.GetMesRandos(ctnlist, theme);
            }else {
                serviceRandonnee.chercherMesRandos(ctnlist, txtFind.getText().trim(), theme);
            }
            
            
    
        });

       
        serviceRandonnee.GetMesRandos(ctnlist,theme);
        
        

        
    }
   

    public Form getF() {
        return f;
    }

    
    
    
    
    
}
