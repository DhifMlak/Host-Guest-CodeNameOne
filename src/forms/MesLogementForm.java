/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Services.ServiceLogement;
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
import entity.Logement;
import java.util.ArrayList;
/**
 *
 * @author mehdi
 */
public class MesLogementForm {
    
    Form f;
    public static ArrayList<Randonnee> MesLogements;
    public MesLogementForm(Resources theme) {
        UIBuilder ui = new UIBuilder();
        Container ctn = ui.createContainer(theme, "MesLogements").getComponentForm();
        f = (Form)ctn;
        f.getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeForm homeForm = new HomeForm(theme);
                homeForm.getF().showBack();
         
            }
        });
        
        f.setTitle("Mes Logements");
        ServiceLogement serviceLogement = ServiceLogement.GetInstance();

       
        serviceLogement.GetAllLogement(f,theme);
        

        
    }
    private Container GetItemList(Logement l,Resources theme) {
        Label labelTitre = new Label("Titre :"+l.getTitre());
        Label labelAdresse = new Label("Adresse :"+l.getAddress());
        Button btn = new Button("Detail");
       
        //String imageName = c.getImage();
        Label labelImage = new Label(theme.getImage("a.png"));
        
        Container ctn = new Container();
        ctn.setLayout(new BorderLayout());
        Container ctn1 = new Container();
        ctn1.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        ctn1.addComponent(labelTitre);
        ctn1.addComponent(labelAdresse);
        ctn1.addComponent(btn);
         
        ctn.addComponent(BorderLayout.CENTER, ctn1);
       
        ctn.addComponent(BorderLayout.EAST, labelImage);
        btn.addActionListener((evt) -> {
            System.out.println("titre :"+l.getTitre()
                    +"\tadresse :"+l.getAddress() );
        });
       
        
        ctn.setLeadComponent(btn);
        
        return ctn;
    }

    public Form getF() {
        return f;
    }

    
    
    
}
