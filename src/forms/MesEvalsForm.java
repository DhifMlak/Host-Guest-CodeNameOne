/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Services.ServiceEvaluation;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import entity.Evaluation;
import pi.util.Statics;

/**
 *
 * @author ahmed
 */
public class MesEvalsForm extends Form{
/*private final Label l1,l2,l3,l5,l6;
    private final TextField descrIiption,idm;
   // private final Picker date_achat;
    private final Container mainContainer;
    private final Button addBtn,backBtn,proposerBtn;
private Resources theme,theme1;

*/
    
      private final Label l1,l2,l3,l4;
    private  TextField titre,comment;
   // private final Picker date_achat;
    private final Container mainContainer;
    private Resources theme = UIManager.initFirstTheme("/theme");
  
//private Resources theme,theme1;
    
    
    public MesEvalsForm(Evaluation e) {
          //Container ctnTitre = new Container(new BoxLayout(BoxLayout.X_AXIS));
         this.setLayout(new BorderLayout(BoxLayout.Y_AXIS));
        mainContainer = new Container();
        mainContainer.setLayout(new GridLayout(8,2));
        l1 = new Label("evaluation");
        l1.setAlignment(CENTER);
        l1.getUnselectedStyle().setAlignment(Component.CENTER);
        l1.getUnselectedStyle().setFgColor(-16777216);
        Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        l1.getUnselectedStyle().setFont(l1_font);
       
        l2 = new Label("titre");
        titre = new TextField(e.getTitre());
        
        l4 = new Label("commentaire:");
        comment = new TextField(e.getCommentaire()); 
        
        
        //
        l3 = new Label("facility");
        TextField ttt= new TextField(e.getFacility().toString());
        
        Label l5 = new Label("service");
        TextField t1= new TextField(e.getService().toString());
        
        Label l6 = new Label("interesting");  
        TextField in= new TextField(e.getInteresting().toString());
        
        Label l7 = new Label("human");
        TextField hu= new TextField(e.getHuman().toString());
        
   
        mainContainer.add(l1);
        mainContainer.add(new Label());
        
        Statics.setLabelStyle(l2);
        mainContainer.add(l2);
        Statics.setLabelStyle(l3);
        mainContainer.add(l3);
        Statics.setLabelStyle(l5);
        mainContainer.add(l5);
        Statics.setLabelStyle(l6);
        mainContainer.add(l6);
        Statics.setLabelStyle(l7);
        mainContainer.add(l7);
            
        
       mainContainer.add(titre);
       // mainContainer.add(ttt);
       mainContainer.add(comment);
       mainContainer.add(ttt);
       mainContainer.add(t1);
       mainContainer.add(in);
       mainContainer.add(hu);
       
       
       
        
       
            
        
       Button modBtn=new Button("modifier");
        mainContainer.add(modBtn);
      modBtn.addActionListener((ActionListener) (ActionEvent evt) -> {
            // add a bookr
            //Echange echange = new Echange(description.getText(),prix.getText(),prixm.getText(),cat.getText(),img.getText());
          // Echange echange=new Echange(description.getText(),Integer.parseInt(prix.getText()),Integer.parseInt(prixm.getText()),Integer.parseInt(cat.getText()),img.getText());
          Evaluation evaluation= new Evaluation(e.getId(),titre.getText(),comment.getText(),Float.parseFloat(ttt.getText()),Float.parseFloat(t1.getText()),Float.parseFloat(in.getText()),Float.parseFloat(hu.getText()));
          
     new  ServiceEvaluation().updateEval(evaluation);
            });

       
        //Statics.setLabelStyle(l5);
        //mainContainer.add(l5);
        //mainContainer.add(date_achat);
        //mainContainer.add(typeReclamation);
   
        
        
        
        this.add(BorderLayout.NORTH, mainContainer);
        
        this.getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeForm homeForm = new HomeForm(theme);
                homeForm.getF().showBack();
         
            }
        });
       
      
        
        
    }
    


   
    
}

