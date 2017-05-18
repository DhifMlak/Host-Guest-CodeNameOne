/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Services.ServiceEvaluation;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import entity.Evaluation;
import java.util.ArrayList;

/**
 *
 * @author ahmed
 */
public class EvalDetailsForm extends Form {
   
//     private final Label labTitre,labCom,labNote;
    private Form f;
    ServiceEvaluation se = new ServiceEvaluation();
   
    public EvalDetailsForm(int idd, Resources theme){
         
       se.AfficherEval(idd);
       
        Evaluation e = new Evaluation();
        UIBuilder ui = new UIBuilder();
        Container ctn = ui.createContainer(theme, "EvaluationDetail").getComponentForm();
        ctn.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        Container ctnTitre = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labTitre = new Label("Titre   ");
        TextField txtTitre = new TextField(e.getTitre());
        txtTitre.setEnabled(false);
      
        ctnTitre.add(labTitre);
        ctnTitre.add(txtTitre);
        
        Container ctnCom = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labCom = new Label("Commentaire    ");
        TextField txtCom = new TextField(e.getCommentaire());
        txtCom.setEnabled(false);
        ctnCom.add(labCom);
        ctnCom.add(txtCom);
        
        Container ctnNote = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labNote = new Label("Note   ");
        TextField txtNote = new TextField(String.valueOf(e.getNote()));
        
        txtNote.setEnabled(false);
        ctnNote.add(labNote);
        ctnNote.add(txtNote);
        
         Button btnModifier = new Button("Modifier");
         
        ctn.add(ctnTitre);
       ctn.add(ctnCom);
       ctn.add(ctnNote);
       ctn.add(btnModifier);
       
       
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
