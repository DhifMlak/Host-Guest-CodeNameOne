/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import entity.Hote;
import entity.Sortie;
import Services.SortieService;
import Utils.Statics;
import com.codename1.charts.util.ColorUtil;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridBagLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import java.util.Date;
import java.text.ParseException;

/**
 *
 * @author Joey Badass
 */
public class AddSortie extends Form {
    private final Label l1,l2,l3,l4,l5,l6,l7;
    private final TextField titre,typeSortie,lieu,description,conditions,nbMax;
    private final Picker date_achat;
    private final Container mainContainer;
    private final Button addBtn;//backBtn;
    public Hote usr;
    private BorderLayout bly;
    private Picker datePicker ;
     private Resources theme = UIManager.initFirstTheme("/theme");

    

public AddSortie(){
    usr=new Hote(14, "zalleg", "bairem", "12804082");
    bly=new BorderLayout();
    this.setLayout(bly);
        datePicker = new Picker();
        datePicker.setType(Display.PICKER_TYPE_DATE);
        datePicker.setDate(new Date());
        mainContainer = new Container();
        mainContainer.setLayout(new GridLayout(6,2));
        l1 = new Label("Ajouter sortie ");
        l1.setAlignment(CENTER);
        //l1.getUnselectedStyle().setAlignment(Component.CENTER);
        l1.getUnselectedStyle().setFgColor(ColorUtil.CYAN);
        Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        l1.getUnselectedStyle().setFont(l1_font);
        l2 = new Label("Titre");
        titre = new TextField(""); 
        l3 = new Label("TypeSortie");
        typeSortie = new TextField(""); 
        l4 = new Label("Lieu");
        lieu = new TextField(""); 
        l5 = new Label("Description");
        description = new TextField(""); 
         date_achat= new Picker();
        l6 = new Label("Conditions");
        conditions = new TextField(""); 
        l7 = new Label("nbMax");
        nbMax = new TextField(""); 
        addBtn= new Button("Ajouter");
        addBtn.getUnselectedStyle().setFgColor(5542241);
        mainContainer.add(l1);
        mainContainer.add(new Label());
        mainContainer.add(l2);
        mainContainer.add(l3);
        mainContainer.add(titre);
        mainContainer.add(typeSortie);
        mainContainer.add(l4);
        mainContainer.add(l5);
        mainContainer.add(lieu);
        mainContainer.add(description);
        mainContainer.add(l6);
        mainContainer.add(l7);
        mainContainer.add(conditions);
        mainContainer.add(nbMax);
        mainContainer.add(datePicker);
        mainContainer.add(addBtn);
       
//        backBtn = Statics.createBackBtn();
//        Container box = BoxLayout.encloseX(addBtn 
////       
//        );
//       
//       this.add(BorderLayout.SOUTH, box);
        this.getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeForm homeForm = new HomeForm(theme);
                homeForm.getF().showBack();
         
            }
        });
        

        addBtn.addActionListener((ActionListener) (ActionEvent evt) -> {
                 
           //Sortie sortie =new Sortie(titre.getText(), lieu.getText(), Integer.parseInt(nbMax.getText()), description.getText(), conditions.getText(), typeSortie.getText(), "sortie", usr);
           Date dts = datePicker.getDate();
            String a = new SimpleDateFormat("yyyy-MM-dd").format(dts);
            //datePicker.setFormatter(d);
            
            System.out.println("ddate:: "+a);
           //String s= ""+datePicker.getDate().getYear()+"-"+datePicker.getDate().getMonth()+"-"+datePicker.getDate().getDay();
  
           Sortie sortie=new Sortie(titre.getText(), lieu.getText(),  Integer.parseInt(nbMax.getText()), description.getText(), conditions.getText(), typeSortie.getText(), a, 0,  "sortie", usr);
            new  SortieService().AddSortie(sortie);
            });
        this.add(BorderLayout.NORTH, mainContainer);

}}