/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

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
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;

/**
 *
 * @author Firas
 */
public class AjouterRandoForm {
    private Form f;
    private TextField txtTitre;
    private TextField txtLieu;
    private TextField txtLieuRencontre;
    private TextField txtPrix;
    private TextArea txtDesc;
    private TimeSpinner HeureRencontreSpinner;
    private NumericSpinner nbMaxSpinner;
    private Button btnAjouter;
    
    
    
    public AjouterRandoForm(Resources theme) {
        UIBuilder ui = new UIBuilder();
        UIBuilder.registerCustomComponent("NumericSpinner", NumericSpinner.class);
        UIBuilder.registerCustomComponent("TimeSpinner", TimeSpinner.class);
        Container ctn = ui.createContainer(theme, "AjouterRando").getComponentForm();
        txtTitre= (TextField) ui.findByName("txtTitre", ctn);
        txtLieu= (TextField) ui.findByName("txtLieu", ctn);
        txtLieuRencontre= (TextField) ui.findByName("txtLieuRencontre", ctn);
        txtPrix= (TextField) ui.findByName("txtPrix", ctn);
        txtDesc= (TextArea) ui.findByName("txtDesc", ctn);
        HeureRencontreSpinner =(TimeSpinner) ui.findByName("HeureRencontreSpinner", ctn);
        nbMaxSpinner = (NumericSpinner) ui.findByName("nbMaxSpinner", ctn);
        HeureRencontreSpinner.setCurrentMeridiem(true);
        btnAjouter = (Button) ui.findByName("btnAjouter", ctn);
        btnAjouter.addActionListener((evt) -> {
            if (controleSaisie()) {
                if (prixFormat()) {
                    
            
                Hote hote = new Hote();
                hote.setId(1);
                int h=HeureRencontreSpinner.getCurrentHour();
                int m=HeureRencontreSpinner.getCurrentMinute();
                
                String heur;
                if (HeureRencontreSpinner.isCurrentMeridiem())
                    heur=String.valueOf(h+12);
                else
                    heur="0"+h;
                heur=heur+":"+m;
                
                
                Randonnee randonnee = new Randonnee(txtTitre.getText(),txtLieu.getText(),(int)nbMaxSpinner.getValue(),txtDesc.getText(),txtLieuRencontre.getText(),heur,Integer.parseInt(txtPrix.getText()),"randonnee",hote);
                ServiceRandonnee serviceRandonnee=ServiceRandonnee.GetInstance();
                serviceRandonnee.ajouterRando(randonnee);
                MesRandoForm mrf = new MesRandoForm(theme);
                mrf.getF().show();
                     
                
                
                System.out.println(txtTitre.getText()+"\t"+txtLieu.getText()+"\t"+txtLieuRencontre.getText()
                        +"\t"+txtPrix.getText()+"\t"+txtDesc.getText()+"\t"+HeureRencontreSpinner.getCurrentHour()+":"+HeureRencontreSpinner.getCurrentMinute()+" "+HeureRencontreSpinner.isCurrentMeridiem()+"heure :"+heur+"\t"
                        +(int)nbMaxSpinner.getValue());
                }
                
            }else {
                 Dialog.show("Erreur", "Veuillez remplir tous les champs !", "Ok", null);
                
            }
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
    private boolean controleSaisie(){
        boolean ok=true;
        if ("".equals(txtTitre.getText()) )
            ok=false;
        if ("".equals(txtLieu.getText()) )
            ok=false;
        if ("".equals(txtLieuRencontre.getText()) )
            ok=false;
        if ("".equals(txtDesc.getText()) )
            ok=false;
        if ("".equals(txtPrix.getText()) )
            ok=false;
        return ok;
    }
    private boolean prixFormat(){
        boolean ok = true;
        try {
            int a = Integer.parseInt(txtPrix.getText());
            if (a <=0) {
                ok=false;
                Dialog.show("Erreur", "Veuillez Saisir un prix supérieur à zéro", "Ok", null);
               
            }
            
        }catch (Exception e){
            Dialog.show("Erreur", "Veuillez saisir un numero dans le champ prix !", "Ok", null);
            ok = false;
            
        }
        
        
        
        return ok;
    }

    public Form getF() {
        return f;
    }
    
    
    
}
