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
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import entity.Evaluation;

/**
 *
 * @author ahmed
 */
public class AjouterEvaluationForm {
     private Form f;
    private TextField txtTitre;
    private TextField txtCom;
    private TextField txtFac;
    private TextField txtSer;
    private TextField txtInter;
    private TextField txtHum;
     
     public AjouterEvaluationForm (Resources theme, int id){
         UIBuilder ui = new UIBuilder();
          Container ctn = ui.createContainer(theme, "AjouterEvaluation").getComponentForm();
          txtTitre= (TextField) ui.findByName("txtTitre", ctn);
        txtCom= (TextField) ui.findByName("txtCom", ctn);
        txtFac= (TextField) ui.findByName("txtFac", ctn);
        txtSer= (TextField) ui.findByName("txtSer", ctn);
        txtInter= (TextField) ui.findByName("txtInter", ctn);
        txtHum= (TextField) ui.findByName("txtHum", ctn);
        Button BtnAjouterEv = new Button("Ajouter");
        ctn.add(BtnAjouterEv);
        BtnAjouterEv.addActionListener((evt) -> {
            Evaluation evaluation = new Evaluation(txtTitre.getText(),txtCom.getText(),Float.parseFloat(txtFac.getText()),Float.parseFloat(txtSer.getText()),Float.parseFloat(txtInter.getText()),Float.parseFloat(txtHum.getText()),id);
            System.out.println(id);
            ServiceEvaluation serviceEvaluation = ServiceEvaluation.GetInstance();
            serviceEvaluation.ajouterEval(evaluation);
            System.out.println(txtTitre.getText()+"\t"+txtCom.getText()+"\t"+txtFac.getText()
                        +"\t"+txtSer.getText()+"\t"+txtInter.getText()+"\t"+txtHum.getText()+id);
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
    
            
       
    
    
    
   // String idd=String.valueOf(MesRandoForm.id);
}
