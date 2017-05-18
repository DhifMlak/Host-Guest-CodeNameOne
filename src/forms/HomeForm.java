/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Services.ServiceLogement;
import Services.ServiceRandonnee;
import Services.SortieService;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
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
public class HomeForm {
    Form f ;

    
    
    public HomeForm(Resources theme){
        UIBuilder ui = new UIBuilder();
        Container ctn = ui.createContainer(theme, "Home").getComponentForm();
        Container ctnRando = (Container) ui.findByName("ctnRando", ctn);
        Container ctnRandoList = (Container) ui.findByName("ctnRandoList", ctnRando);
        TextField txtFind= (TextField) ui.findByName("txtfind", ctnRando);
        Container ctnLogement1 = (Container) ui.findByName("ctnLogement1", ctn);
        Container ctnSortie = (Container) ui.findByName("ctnSortie", ctn);
        f = (Form)ctn;
        ServiceRandonnee.GetInstance().GetAllRandos(ctnRandoList, theme);
        ServiceLogement.GetInstance().GetAllLogement(ctnLogement1, theme);
        new SortieService().findAllSortie(ctnSortie);
        
        f.getToolbar().addCommandToSideMenu("Ajouter Randonnée", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                AjouterRandoForm ajouterRandoForm = new AjouterRandoForm(theme);
                ajouterRandoForm.getF().show();
                
            }
        });
         f.getToolbar().addCommandToSideMenu("Ajouter logement", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                AjouterLogementForm ajouterLogementForm = new AjouterLogementForm(theme);
                ajouterLogementForm.getF().show();
                
            }
        });
         f.getToolbar().addCommandToSideMenu("Ajouter Sortie", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                AddSortie addSorUi = new AddSortie();
                addSorUi.show();
                
            }
        });
         f.getToolbar().addCommandToSideMenu("Mes Randonnées", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                MesRandoForm mesRandoForm = new MesRandoForm(theme);
                mesRandoForm.getF().show();
                
            }
        });
          f.getToolbar().addCommandToSideMenu("Mes Logements", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                MesLogementForm mesLogementForm = new MesLogementForm(theme);
                mesLogementForm.getF().show();
                
            }
        });
        ServiceRandonnee serviceRandonnee = ServiceRandonnee.GetInstance();
        txtFind.addDataChangedListener((type, index) -> {
            System.out.println(txtFind.getText());
            System.out.println(txtFind.getText());
            if ("".equals(txtFind.getText().trim())) {
                ctnRandoList.removeAll();
                serviceRandonnee.GetAllRandos(ctnRandoList, theme);
            }else {
                serviceRandonnee.CherherAllRandos(ctnRandoList, txtFind.getText().trim(), theme);
            }
            
            
    
        }); 
         
        
    }
    

    public Form getF() {
        return f;
    }
    
    
}
