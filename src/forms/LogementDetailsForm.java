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
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import entity.Logement;
import entity.Randonnee;


/**
 *
 * @author mehdi
 */
public class LogementDetailsForm {
    
     private Form f;
    public LogementDetailsForm(Logement lg, Resources theme) {
        UIBuilder ui = new UIBuilder();
        Container ctn = ui.createContainer(theme, "LogementDetails").getComponentForm();
        ctn.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        Container ctnTitre = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labTitre = new Label("Titre ");
        TextField txtTitre = new TextField(lg.getTitre());
        txtTitre.setEnabled(false);
        ctnTitre.add(labTitre);
        ctnTitre.add(txtTitre);
        
        Container ctnAdresse = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labAdresse = new Label("Adresse ");
        TextField txtAdresse = new TextField(lg.getAddress());
        txtAdresse.setEnabled(false);
        ctnAdresse.add(labAdresse);
        ctnAdresse.add(txtAdresse);
        
        Container ctnVille = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labVille = new Label("Ville ");
        TextField txtVille = new TextField(lg.getVille());
        txtVille.setEnabled(false);
        ctnVille.add(labVille);
        ctnVille.add(txtVille);
        
        Container ctnPays = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labPays = new Label("Pays ");
        TextField txtPays = new TextField(String.valueOf(lg.getPaye()));
        txtPays.setEnabled(false);
        ctnPays.add(labPays);
        ctnPays.add(txtPays);
        
        
        Container ctnPrix = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labPrix = new Label("Prix ");
        TextField txtPrix = new TextField(String.valueOf(lg.getPrix()));
        txtPrix.setEnabled(false);
        ctnPrix.add(labPrix);
        ctnPrix.add(txtPrix);
        
        
        Container ctnType = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labType = new Label("Type ");
        TextArea txtType = new TextArea(lg.getTypeOffre());
        txtType.setEnabled(false);
        ctnType.add(labType);
        ctnType.add(txtType);
        
     
        
      
        
//       Container ctnSpiner = new Container(new BoxLayout(BoxLayout.X_AXIS));
//       TimeSpinner temp = new TimeSpinner();
//       temp.setEnabled(false);
//       NumericSpinner nbMax = new NumericSpinner();
//       nbMax.setMax(20); nbMax.setMin(1); nbMax.setEnabled(false);
//       ctnSpiner.add(temp);
//       ctnSpiner.add(nbMax);
       
       Button btnModifier = new Button("Modifier");
       
       ctn.add(ctnTitre);
       ctn.add(ctnAdresse);
       ctn.add(ctnVille);
        ctn.add(ctnPays);
       ctn.add(ctnPrix);
      
       ctn.add(ctnType);
       
       
       f=(Form)ctn;
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
