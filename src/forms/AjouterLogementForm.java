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
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.NumericSpinner;
import com.codename1.ui.spinner.TimeSpinner;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import entity.*;
import Services.ServiceRandonnee;
import com.codename1.messaging.Message;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;




/**
 *
 * @author mehdi
 */
public class AjouterLogementForm {
    
    private Form f;
    private TextField TfTitre;
    private TextField Tfadresse;
    private TextField TfVille;
    private TextField TfPays;
    private TextField TfPrix;
    private TextField TfType;
   
   
    private Button BtnAjouterLog;
    
    
    public AjouterLogementForm(Resources theme){
         UIBuilder ui = new UIBuilder();
        
        Container ctn = ui.createContainer(theme, "AjouterLogement").getComponentForm();
        TfTitre= (TextField) ui.findByName("TfTitre", ctn);
        Tfadresse= (TextField) ui.findByName("Tfadresse", ctn);
        TfVille= (TextField) ui.findByName("TfVille", ctn);
        TfPays= (TextField) ui.findByName("TfPays", ctn);
        TfPrix= (TextField) ui.findByName("TfPrix", ctn);
        TfType=(TextField) ui.findByName("TfType", ctn);
         
         
        

        
        BtnAjouterLog = (Button) ui.findByName("BtnAjouterLog", ctn);
        BtnAjouterLog.addActionListener((evt) -> {
                Hote hote = new Hote();
                hote.setId(1);
              
                
                Logement logement = new Logement(TfTitre.getText(),Tfadresse.getText(),TfVille.getText(),TfPays.getText(),Float.parseFloat(TfPrix.getText()),TfType.getText(),"logement",hote);
                ServiceLogement serviceLogement=ServiceLogement.GetInstance();
                serviceLogement.ajouterLogement(logement);
                System.out.println("inside ajouter logForm");
//                Mail.send("mehdi.benaissa26@gmail.com", "matensech", "mehdi.benaissa1@esprit.tn", "subject", "txtmail");
                
                
              
                
           
                
                
//                System.out.println(txtTitre.getText()+"\t"+txtLieu.getText()+"\t"+txtLieuRencontre.getText()
//                        +"\t"+txtPrix.getText()+"\t"+txtDesc.getText()+"\t"+HeureRencontreSpinner.getCurrentHour()+":"+HeureRencontreSpinner.getCurrentMinute()+" "+HeureRencontreSpinner.isCurrentMeridiem()+"heure :"+heur+"\t"
//                        +(int)nbMaxSpinner.getValue());
            });
        
        f = (Form)ctn;
        f.getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeForm homeForm = new HomeForm(theme);
                homeForm.getF().showBack();
         
            }
        });
        
    }
     public Form getF() {
        return f;
    }
}
