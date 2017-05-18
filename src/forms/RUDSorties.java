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
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
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
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Joey Badass
 */
public class RUDSorties extends Form {
    private Resources theme = UIManager.initFirstTheme("/theme");
    private final Label l1,l2,l3,l4,l5,l6,l7;
    private final TextField Ttitre,TtypeSortie,Tlieu,Tdescription,Tconditions,TnbMax;
    private final Container mainContainer;
    private final Button editBtn,deleteBtn;//,backBtn;
    private Sortie sortie;
    public Hote usr;
    
    
    public RUDSorties(int id,String titre,String typeSortie,String lieu,String description, String conditions,int nbMax){

        
        
        usr=new Hote(14, "zalleg", "bairem", "12804082");
         this.setLayout(new BorderLayout());
        mainContainer = new Container();
        mainContainer.setLayout(new GridLayout(8,2));
        l1 = new Label("Modifier sortie ");
        l1.setAlignment(CENTER);
        //l1.getUnselectedStyle().setAlignment(Component.CENTER);
        l1.getUnselectedStyle().setFgColor(ColorUtil.GREEN);
        Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        l1.getUnselectedStyle().setFont(l1_font);
        l2 = new Label("Titre");
        Ttitre = new TextField(titre); 
        l3 = new Label("TypeSortie");
        TtypeSortie = new TextField(typeSortie); 
        l4 = new Label("Lieu");
        Tlieu = new TextField(lieu); 
        l5 = new Label("Description");
        Tdescription = new TextField(description); 
        l6 = new Label("Conditions");
        Tconditions = new TextField(conditions); 
        l7 = new Label("nbMax");
        TnbMax = new TextField(Integer.toString(nbMax)); 
        //addBtn= new Button("Ajouter");
        editBtn= new Button("Modifier");
        editBtn.getUnselectedStyle().setFgColor(5542241);
        deleteBtn= new Button("Supprimer");
        deleteBtn.getUnselectedStyle().setFgColor(5542241);
        mainContainer.add(l1);
        mainContainer.add(new Label());
       
        mainContainer.add(l2);
        
        mainContainer.add(l3);
        mainContainer.add(Ttitre);
        mainContainer.add(TtypeSortie);
        
        mainContainer.add(l4);
        
        mainContainer.add(l5);
        mainContainer.add(Tlieu);
        mainContainer.add(Tdescription);
        
        mainContainer.add(l6);
        mainContainer.add(l7);
        mainContainer.add(Tconditions);
        mainContainer.add(TnbMax);
       
//        backBtn = Statics.createBackBtn(); 
        mainContainer.add(new Label());
        mainContainer.add(new Label());
        mainContainer.add(editBtn);
        mainContainer.add(deleteBtn);

//         this.add(BorderLayout.SOUTH, backBtn);
        System.out.println("ttitre ::"+Ttitre.getText());
        sortie=new Sortie(titre, lieu, nbMax, description, conditions, typeSortie,id, typeSortie, usr);
       // sortie = new Sortie (Ttitre.getText(),Tlieu.getText() ,Integer.parseInt(TnbMax.getText()),Tdescription.getText(),Tconditions.getText(), TtypeSortie.getText(),"sortie",usr) ;
        editBtn.addActionListener((ActionListener) (ActionEvent evt) -> {
        sortie =new Sortie (Ttitre.getText(),Tlieu.getText() ,Integer.parseInt(TnbMax.getText()),Tdescription.getText(),Tconditions.getText(), TtypeSortie.getText(),id,"sortie",usr) ;
            new SortieService().updateSortie(sortie);
            //new SortieService().findAllSortie();
            });
        deleteBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new SortieService().deleteSortie(sortie);
                 
            }
        });
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


    
    
