/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Services.ServiceRandonnee;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.NumericSpinner;
import com.codename1.ui.spinner.TimeSpinner;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import entity.Randonnee;

/**
 *
 * @author Firas
 */
public class ModifierRandoForm {
    private Form f;
    private TextField txtTitre;
    private TextField txtLieu;
    private TextField txtLieuRenc;
    private TextArea txtDesc;
    private TextField txtPrix;
    public  ModifierRandoForm(Randonnee rd, Resources theme){
        UIBuilder ui = new UIBuilder();
        Container ctn = ui.createContainer(theme, "ModifierRando").getComponentForm();
        ctn.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        Container ctnTitre = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labTitre = new Label("Titre ");
         txtTitre = new TextField(rd.getTitre());
        
        ctnTitre.add(labTitre);
        ctnTitre.add(txtTitre);
        
        Container ctnLieu = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labLieu = new Label("Lieu ");
         txtLieu = new TextField(rd.getLieu());
        
        ctnLieu.add(labLieu);
        ctnLieu.add(txtLieu);
        
        Container ctnLieuRenc = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labLieuRenc = new Label("Lieu de Rencontre ");
         txtLieuRenc = new TextField(rd.getLieuRencontre());
        
        ctnLieuRenc.add(labLieuRenc);
        ctnLieuRenc.add(txtLieuRenc);
        
        Container ctnPrix = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labPrix = new Label("Prix ");
         txtPrix = new TextField(String.valueOf(rd.getPrix()));
        
        ctnPrix.add(labPrix);
        ctnPrix.add(txtPrix);
        
        Container ctnDesc = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labDesc = new Label("Description ");
        txtDesc = new TextArea(rd.getDescription());
        
        ctnDesc.add(labDesc);
        ctnDesc.add(txtDesc);
        System.out.println("time "+rd.getHeureRencontre()+"length :"+rd.getHeureRencontre().length());
        String time = rd.getHeureRencontre();
        int heur =Integer.parseInt(time.substring(0, 2)) ;
        int minut =Integer.parseInt(time.substring(3, 5)) ;
        System.out.println("heur "+ heur);
        System.out.println("minut "+ minut);
        
        Container ctnSpiner = new Container(new BoxLayout(BoxLayout.X_AXIS));
        TimeSpinner temp = new TimeSpinner();
        temp.setCurrentMinute(minut);
         if(heur >12) {
            heur=heur-12;
            temp.setCurrentMeridiem(true);
        }
        temp.setCurrentHour(heur);
        
        NumericSpinner nbMax = new NumericSpinner();
        nbMax.setValue(rd.getNbMax());
        nbMax.setMax(20); nbMax.setMin(1);
        ctnSpiner.add(temp);
        ctnSpiner.add(nbMax);
        
        Button btnModifier = new Button("Modifier");

        
        
       ctn.add(ctnTitre);
       ctn.add(ctnLieu);
       ctn.add(ctnLieuRenc);
       ctn.add(ctnPrix);
       ctn.add(ctnDesc);
       ctn.add(ctnSpiner);
       ctn.add(btnModifier);
       
       f=(Form)ctn;
       f.getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                MesRandoForm mrf = new MesRandoForm(theme);
                mrf.getF().showBack();
         
            }
        });
       btnModifier.addActionListener((evt) -> {
           if(controleSaisie()) {
               if (prixFormat()) {
                   rd.setTitre(txtTitre.getText());
                   rd.setLieu(txtLieu.getText());
                     rd.setLieuRencontre(txtLieuRenc.getText());
                    rd.setNbMax((int)nbMax.getValue());
                    rd.setDescription(txtDesc.getText());
                     rd.setPrix(Integer.parseInt(txtPrix.getText()));
                     int h=temp.getCurrentHour();
                         int m =temp.getCurrentMinute();
                         if (temp.isCurrentMeridiem())
                    h=h+12;
                String times=h+":"+m;
           rd.setHeureRencontre(times);
           System.out.println("avant appel aux service modifier :"+rd.toString());
           ServiceRandonnee.GetInstance().ModifierRando(rd);
           MesRandoForm mrf = new MesRandoForm(theme);
           mrf.getF().showBack();
               }
           }else {
                Dialog.show("Erreur", "Veuillez remplir tous les champs !", "Ok", null);
           }
            
        });
    
}
    private boolean controleSaisie(){
        boolean ok=true;
        if ("".equals(txtTitre.getText()) )
            ok=false;
        if ("".equals(txtLieu.getText()) )
            ok=false;
        if ("".equals(txtLieuRenc.getText()) )
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
