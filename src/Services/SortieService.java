/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entity.Hote;
import entity.Rating;
import entity.Sortie;
import static Services.SortieService.listSortie;
import Utils.Statics;
import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
//import com.mycompany.myapp.RUDSorties;
//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.codename1.ui.Font;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.table.TableLayout;
import forms.HomeForm;
import forms.RUDSorties;
import java.util.LinkedList;

/**
 *
 * @author Joey Badass
 */
public class SortieService extends Form{
    
    private Resources theme = UIManager.initFirstTheme("/theme");
    private ConnectionRequest connectionRequest;
    public static Form listSortie;
    public Hote usr;
    private Button noteBtn;
          
     /////////// ADD ITEM SORTIE ////////////
    public void addItem(Sortie sortie , Container c) {
       

        System.out.println("sortie item :: \n"+sortie.toString());
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        noteBtn= new Button ("Rate");
        noteBtn.getUnselectedStyle().setFgColor(5542241);
        Label tit  =new Label(sortie.getTitre());
        //Label ts   =new Label("TypeSortie: "+sortie.getTypeSortie());
        Label des  = new Label("Description: "+sortie.getDescription());
        Label lieu = new Label ("Lieu: "+sortie.getLieu());
        Label cond = new Label ("Conditions: "+sortie.getConditions());
        Label nbMax= new Label( "Nb Max: "+Integer.toString((int)sortie.getNbMax()));
        Label dte=new Label("Date: "+sortie.getDate());
        Slider rat=createStarRankSlider();
        
        rat.setProgress(3);
         
        tit.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
           
           new RUDSorties(sortie.getId(),sortie.getTitre(),sortie.getTypeSortie(),sortie.getLieu(),sortie.getDescription(),sortie.getConditions(),sortie.getNbMax()).show();
             
                
            }
        });
             noteBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
                  Form f=getRatInterface(sortie);
                  f.show();
                 ;
             }
                 
         });
         Statics.setLabelStyle(tit);
         Container c3=new Container(new BoxLayout(BoxLayout.X_AXIS));
         c3.add(rat);
         
         C2.add(tit);
         C2.add(c3);
         C2.add(dte);
         C2.add(lieu);
         C2.add(des);
         C2.add(cond);
         C2.add(nbMax);
         C2.add(noteBtn);
         
         
         c.add(C2);
//         System.out.println("liste sortie :: "+listSortie.getComponentCount());
        // listSortie.show();
         
    }
                   ///////// AJOUTER SORTIE /////////////
//     public void AddSortie(Sortie sortie ){
//      
//        connectionRequest=new ConnectionRequest(){
//            @Override
//            protected void postResponse() {
//            Dialog d = new Dialog("Ajouter Sortie");
//            TextArea popupBody = new TextArea(" Sortie ajouté");
//            popupBody.setUIID("PopupBody");
//            popupBody.setEditable(false);
//            d.setLayout(new BorderLayout());
//            d.add(BorderLayout.CENTER, popupBody);
//            
//           // d.showDialog();
//            boolean b =Dialog.show("Confirmation", " Sortie ajouté", "Ok", null);
//             if(b){
//                    new SortieService().findAllSortie();
//                }
//            }
//        };
//        connectionRequest.setUrl("http://localhost/pidev2017/insert.php?titre=" + sortie.getTitre()+"&type_sortie="+ sortie.getTypeSortie()+"&lieu="+ sortie.getLieu()+"&description="+ sortie.getDescription()+"&conditions="+sortie.getConditions()+"&nbMax="+sortie.getNbMax()+"&datep="+sortie.getDate());
//        NetworkManager.getInstance().addToQueue(connectionRequest);
//    }
      public void AddSortie(Sortie sortie ){
       ConnectionRequest req = new ConnectionRequest();
          System.out.println("INSIDE ADD SORTIE FIRAS");
                  req.setUrl("http://localhost/pidev2017/insert.php?titre=" + sortie.getTitre()+"&type_sortie="+ sortie.getTypeSortie()+"&lieu="+ sortie.getLieu()+"&description="+ sortie.getDescription()+"&conditions="+sortie.getConditions()+"&nbMax="+sortie.getNbMax()+"&datep="+sortie.getDate());
                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                         System.out.println("INSIDE ACTION PERFORMED");

                        if (s.equals("success")) {
                             System.out.println("INSIDE SUCCEE");
                               Dialog d = new Dialog("Ajouter Sortie");
                               TextArea popupBody = new TextArea(" Sortie ajouté");
                               popupBody.setUIID("PopupBody");
                               popupBody.setEditable(false);
                               d.setLayout(new BorderLayout());
                               d.add(BorderLayout.CENTER, popupBody);
                               boolean b = Dialog.show("Confirmation", " Sortie ajouté", "Ok", null);
                               if (b) {
                                   new HomeForm(theme).getF().showBack();
                               }
//                           
                        }
                    }
                });
                
                NetworkManager.getInstance().addToQueue(req);
    }
     
                        /////////// SUPPRIMER SORTIE //////////////
        public void deleteSortie(Sortie sortie){   
        connectionRequest = new ConnectionRequest() {
            @Override
            protected void postResponse() {
            Dialog d = new Dialog("Supprimer Sortie");
            TextArea popupBody = new TextArea("Sortie supprimeé");
            popupBody.setUIID("PopupBody");
            popupBody.setEditable(false);
            d.setLayout(new BorderLayout());
            d.add(BorderLayout.CENTER, popupBody);
           // d.showDialog();
            boolean b=Dialog.show("Confirmation", " Sortie supprimé", "Ok", null);
                if(b){
//                    new SortieService().findAllSortie();
                    new HomeForm(theme).getF().showBack();
                }
            }           
        };
        connectionRequest.setUrl("http://localhost/pidev2017/remove.php?id="+sortie.getId());
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }
        ///////////// AFFICHER SORTIE FIRAS ///////////////
          public void findAllSortie(Container c){
//        Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
        //BoxLayout bx=new BoxLayout(BoxLayout.Y_AXIS);
        usr=new Hote(14, "zalleg", "bairem", "12804082");
        connectionRequest = new ConnectionRequest() {
        List<Sortie> srt = new ArrayList<>();
            @Override
            protected void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");
                    
                    Map<String, Object> data = json.parseJSON(reader);
                    
                    List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("sorties");
                    srt.clear();
                    for (Map<String, Object> obj : content) {
                        
                      System.out.println("type : :: "+(String)obj.get("typeSortie"));
                      srt.add(new Sortie((String)obj.get("titre"), (String)obj.get("lieu"), Integer.parseInt((String)obj.get("nbMax").toString()), (String)obj.get("description"), (String)obj.get("conditions"), (String)obj.get("typeSortie"),(String)obj.get("date"), Integer.parseInt((String)obj.get("id").toString()), "sortie", usr));
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
            }
            @Override
            protected void postResponse() {
                
                //System.out.println(libs.size());
                
//                listSortie=new Form(new BoxLayout(BoxLayout.Y_AXIS));
                
                
                ArrayList<String> libsNoms = new ArrayList<>();
                System.out.println("str :: \n"+srt.toString());
                for(Sortie sortie :srt){
                    addItem(sortie,c);
                }
               
//                    listSortie.setLayout(new BorderLayout());
//                    listSortie.add(BorderLayout.NORTH,c);
////                    listSortie.add(BorderLayout.SOUTH,Statics.createBackBtn());
//                    c.setScrollableY(true);
//                    listSortie.show();             
            }
               
        };
        connectionRequest.setUrl("http://localhost/pidev2017/select.php");
        NetworkManager.getInstance().addToQueue(connectionRequest);
                }
                    //////////// AFFICHER SORTIE /////////////
    public void findAllSortie(){
        Container c =new Container(new BoxLayout(BoxLayout.Y_AXIS));
        //BoxLayout bx=new BoxLayout(BoxLayout.Y_AXIS);
        usr=new Hote(14, "zalleg", "bairem", "12804082");
        connectionRequest = new ConnectionRequest() {
        List<Sortie> srt = new ArrayList<>();
            @Override
            protected void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");
                    
                    Map<String, Object> data = json.parseJSON(reader);
                    
                    List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("sorties");
                    srt.clear();
                    for (Map<String, Object> obj : content) {
                        
                      System.out.println("type : :: "+(String)obj.get("typeSortie"));
                      srt.add(new Sortie((String)obj.get("titre"), (String)obj.get("lieu"), Integer.parseInt((String)obj.get("nbMax").toString()), (String)obj.get("description"), (String)obj.get("conditions"), (String)obj.get("typeSortie"),(String)obj.get("date"), Integer.parseInt((String)obj.get("id").toString()), "sortie", usr));
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
            }
            @Override
            protected void postResponse() {
                
                //System.out.println(libs.size());
                
                listSortie=new Form(new BoxLayout(BoxLayout.Y_AXIS));
                
                
                ArrayList<String> libsNoms = new ArrayList<>();
                System.out.println("str :: \n"+srt.toString());
                for(Sortie sortie :srt){
                    addItem(sortie,c);
                }
               
                    listSortie.setLayout(new BorderLayout());
                    listSortie.add(BorderLayout.NORTH,c);
//                    listSortie.add(BorderLayout.SOUTH,Statics.createBackBtn());
                    c.setScrollableY(true);
                    listSortie.show();             
            }
               
        };
        connectionRequest.setUrl("http://localhost/pidev2017/select.php");
        NetworkManager.getInstance().addToQueue(connectionRequest);
                }
    
                /////// MODIFIER SORTIE ////////
    public void updateSortie(Sortie sortie){
        connectionRequest = new ConnectionRequest() {
            
            @Override
            protected void postResponse() { 
                Dialog d = new Dialog("Popup Title");
                TextArea popupBody = new TextArea("Sortie updated");
                popupBody.setUIID("PopupBody");
                popupBody.setEditable(false);
                d.setLayout(new BorderLayout());
                d.add(BorderLayout.CENTER, popupBody);
                //d.show();
                boolean b=Dialog.show("Confirmation", "Sortie modifiée", "Ok", null);
                if(b){
                    new HomeForm(theme).getF().showBack();
                }
                
                
            }
        };
        System.out.println("id= "+sortie.getId());
        connectionRequest.setUrl("http://localhost/pidev2017/update.php?titre="+sortie.getTitre()+"&description="+sortie.getDescription()+"&lieu="+sortie.getLieu()+"&conditions="+sortie.getConditions()+"&type_sortie="+sortie.getTypeSortie()+"&nbMax="+Integer.toString(sortie.getNbMax())+"&id="+Integer.toString(sortie.getId()));
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }
    
                // ******///////// API RATING /////////*****//////
    private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}

private Slider createStarRankSlider() {
    Slider starRank = new Slider();
    starRank.setEditable(true);
    starRank.setMinValue(0);
    starRank.setMaxValue(5);
    Font fnt = Font.createTrueTypeFont("native:MainRegular", "native:MainRegular").
          derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
    Style s = new Style(0xffff33, 0, fnt, (byte)0);
    Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    s.setOpacity(100);
    s.setFgColor(0);
    Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
    initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
    starRank.setPreferredSize(new Dimension(fullStar.getWidth()*5 , fullStar.getHeight()));
   
    return starRank;
}
                   ///////////  INTERFACE RATE ///////////////////
    private Form getRatInterface (Sortie s){
    Form f =new Form(new BoxLayout(BoxLayout.X_AXIS));
    
    Container c =new Container(new TableLayout(5,2));
    Font largePlainSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD,100);
    Label t =new Label(s.getTitre());
    
    t.setAlignment(CENTER);
    t.getUnselectedStyle().setFont(largePlainSystemFont);
    t.getUnselectedStyle().setFgColor(ColorUtil.CYAN);
    Slider rat=createStarRankSlider();
    Label result =new Label("0 / 5");
    
    rat.setAlignment(CENTER);
    result.getUnselectedStyle().setFont(largePlainSystemFont);
    result.getUnselectedStyle().setFgColor(ColorUtil.YELLOW);
    result.setHeight(200);
    result.setAlignment(CENTER);
    Button btn_valid=new Button("Valider");
    Button btn_back=new Button("Back");
    btn_valid.setAlignment(CENTER);
    btn_back.setAlignment(CENTER);
    c.add(new Label());
    c.add(t);
    c.add(new Label());
    c.add(rat);
    c.add(new Label());
    c.add(result);
    c.add(new Label());
    c.add(btn_valid);
    c.add(new Label());
//    c.add(Statics.createBackBtn());
    f.add(c);
    rat.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            System.out.println("rate= "+rat.getProgress());
            result.setText(rat.getProgress()+" / 5");
        }
    });
    
    btn_valid.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
           Rating r =new Rating(0, s.getId(), rat.getProgress());
            AddRate(r);
           
        }
    });
    f.getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeForm homeForm = new HomeForm(theme);
                homeForm.getF().showBack();
         
            }
        });
    
    
    
    return f;
}
////////           ADD RATE 
 public void AddRate(Rating rt ){
      
        connectionRequest=new ConnectionRequest(){
            @Override
            protected void postResponse() {
            Dialog d = new Dialog("Rate");
            TextArea popupBody = new TextArea(" Sortie evalué");
            popupBody.setUIID("PopupBody");
            popupBody.setEditable(false);
            d.setLayout(new BorderLayout());
            d.add(BorderLayout.CENTER, popupBody);
            
           
            boolean b =Dialog.show("Confirmation", " Sortie evalué", "Ok", null);
//             if(b){
////                    new SortieService().findAllSortie();
//                    new HomeForm(theme).getF().showBack();
//                }
            }
        };
        connectionRequest.setUrl("http://localhost/pidev2017/insertrate.php?idsortie=" + rt.getIdSortie()+"&rate="+ rt.getRate());
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }
 
 
 
 
 
 
    
}