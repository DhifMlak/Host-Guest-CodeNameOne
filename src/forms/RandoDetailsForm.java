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
public class RandoDetailsForm {
    private Form f;
    public RandoDetailsForm(Randonnee rd, Resources theme) {
        UIBuilder ui = new UIBuilder();
        Container ctn = ui.createContainer(theme, "RandoDetails").getComponentForm();
        ctn.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        Container ctnTitre = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labTitre = new Label("Titre ");
        TextField txtTitre = new TextField(rd.getTitre());
        txtTitre.setEnabled(false);
        ctnTitre.add(labTitre);
        ctnTitre.add(txtTitre);
        
        Container ctnLieu = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labLieu = new Label("Lieu ");
        TextField txtLieu = new TextField(rd.getLieu());
        txtLieu.setEnabled(false);
        ctnLieu.add(labLieu);
        ctnLieu.add(txtLieu);
        
        Container ctnLieuRenc = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labLieuRenc = new Label("Lieu de Rencontre ");
        TextField txtLieuRenc = new TextField(rd.getLieuRencontre());
        txtLieuRenc.setEnabled(false);
        ctnLieuRenc.add(labLieuRenc);
        ctnLieuRenc.add(txtLieuRenc);
        
        Container ctnPrix = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labPrix = new Label("Prix ");
        TextField txtPrix = new TextField(String.valueOf(rd.getPrix()));
        txtPrix.setEnabled(false);
        ctnPrix.add(labPrix);
        ctnPrix.add(txtPrix);
        
        Container ctnDesc = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labDesc = new Label("Description ");
        TextArea txtDesc = new TextArea(rd.getDescription());
        txtDesc.setEnabled(false);
        ctnDesc.add(labDesc);
        ctnDesc.add(txtDesc);
        
        Container ctnTime = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labTime = new Label("Temp de Rencontre ");
        TextArea txtTime = new TextArea(rd.getHeureRencontre());
        txtDesc.setEnabled(false);
        ctnTime.add(labTime);
        ctnTime.add(txtTime);
        
        Container ctnNbMax = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label labNbMax = new Label("Nombre Max ");
        TextArea txtNbMax = new TextArea(String.valueOf(rd.getNbMax()));
        txtDesc.setEnabled(false);
        ctnNbMax.add(labNbMax);
        ctnNbMax.add(txtNbMax);
        

       Container ctnBtn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       Button btnReserver = new Button("Reserver");
       Button btnMap = new Button("Voir sur Carte");
       Button btneval = new Button("Evaluer");
       Button btnGetEvals = new Button("Voir Evaluation");
       ctnBtn.add(btnReserver);
       ctnBtn.add(btneval);
       ctnBtn.add(btnGetEvals);
       ctnBtn.add(btnMap);
       
       ctn.add(ctnTitre);
       ctn.add(ctnLieu);
       ctn.add(ctnLieuRenc);
       ctn.add(ctnPrix);
       ctn.add(ctnTime);
       ctn.add(ctnNbMax);
       ctn.add(ctnDesc);
       ctn.add(ctnBtn);
       
       f=(Form)ctn;
       f.getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeForm homeForm = new HomeForm(theme);
                homeForm.getF().showBack();
         
            }
        });
       btnMap.addActionListener(evt-> {
           MapsDemo mp = new MapsDemo(theme, rd);
           mp.showMeOnMap();
       });
       btneval.addActionListener(new ActionListener (){ 
          
            @Override
            public void actionPerformed(ActionEvent evt) {
                int idd = rd.getId();
                System.out.println(idd);
                
                 AjouterEvaluationForm AjEva = new AjouterEvaluationForm(theme,idd);
                 AjEva.getF().show();
                 
            }
            
        });
       btnGetEvals.addActionListener(new ActionListener (){ 
           
            ServiceEvaluation se = new ServiceEvaluation();
        
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                int idd = rd.getId();
                
                System.out.println(idd);
            
                EvalDetailsForm det = new EvalDetailsForm(idd, theme);
//                 EvalDetailsForm det = new EvalDetailsForm(e,idd,theme);
                 det.getF().show();
                 
            }
            
        });
       
        
        
    }

    public Form getF() {
        return f;
    }
    
    
}
