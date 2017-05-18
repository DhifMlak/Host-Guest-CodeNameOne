/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import entity.Evaluation;
import entity.Randonnee;
import forms.HomeForm;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pi.util.Statics;
import forms.MesEvalsForm;
/**
 *
 * @author ahmed
 */
public class ServiceEvaluation extends Form{
    public static int id;
    private static ServiceEvaluation rs;
private Resources theme=UIManager.initFirstTheme("/theme");;
    
 private ConnectionRequest connectionRequest;
    public static Form listEval;
    private ArrayList<Evaluation> Eval;
    
    public ServiceEvaluation(){
        Eval = new ArrayList<Evaluation>();
    }
    public static ServiceEvaluation GetInstance(){
          if (rs==null)
            rs=new ServiceEvaluation();
            
        return rs;
    }
    
    public void ajouterEval(Evaluation e){
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl("http://localhost/HostGuest/inserteva.php?titre=" + e.getTitre()+ "&commentaire=" + e.getCommentaire()+ "&facility=" + e.getFacility() + "&service=" + e.getService()+ "&interesting=" + e.getInteresting() + "&human=" + e.getHuman() + "&id_offre="+e.getId_offre());

                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);

                        if (s.equals("success")) {
                            boolean b =Dialog.show("Confirmation", "Evaluation ajouté avec succée", "Ok", null);
                            if (b) {
                                new HomeForm(theme).getF().show();
                            }
                        }
                    }
                });
                
                NetworkManager.getInstance().addToQueue(req);
    }
    
   
    
    public void addItem(Evaluation evaluation) {
       
        Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
   
        Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label sp = new Label();
        sp.setText(evaluation.getTitre() + " : "+evaluation.getCommentaire());
       
        
        
        Container C22 = new Container(new BoxLayout(BoxLayout.X_AXIS));
//        Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        Label t =new Label(evaluation.getTitre());
       
        Label ttt = new Label(Float.toString((Float) evaluation.getFacility()));
        Label sep = new Label("    ");
        Label t1 = new Label(Float.toString((Float) evaluation.getService()));
        Label sep1 = new Label("    ");
        Label in = new Label(Float.toString((Float) evaluation.getInteresting()));
        Label sep11 = new Label("        ");
        Label hu = new Label(Float.toString((Float) evaluation.getHuman()));
       
//        TextField ttt = new TextField(Float.toString((Float) evaluation.getFacility()));
//        
//        TextField t1 = new TextField(Float.toString((Float) evaluation.getService()));
//        TextField in = new TextField(Float.toString((Float) evaluation.getInteresting()));
//        TextField hu = new TextField(Float.toString((Float) evaluation.getHuman()));
       // Label c =new Label(evaluation.getCommentaire());
        
       // Label t2 =new Label("Titre");
        Label ttt2 = new Label("Facility");
        Label t12 = new Label("Service");
        Label in2 = new Label("Interesting");
        Label hu2 = new Label("Human");
        //Label c2 =new Label("Commentaire");
      
       
     sp.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                                
             //new les(echange.getId(),echange.getDescription(),echange.getPrix(),echange.getE_id(),echange.getId_cat(),echange.getImage_name()).show();
           new MesEvalsForm(evaluation).show();
            }
        });
        
        // C2.add(t);
        //C2.add(c);
        C2.add(ttt);
        C2.add(sep);
        C2.add(t1);
        C2.add(sep1);
        C2.add(in);
        C2.add(sep11);
        C2.add(hu);
        
        //C22.add(t2);
       // C22.add(c2);
        C22.add(ttt2);
        C22.add(t12);
        C22.add(in2);
        C22.add(hu2);
       
 
        C2.setLeadComponent(sp);
//        C3.add(C22);
//        C3.add(C2);
        
        C1.add(sp);
        C1.add(C22);
        C1.add(C2);
        
//        C1.add(C3);
        
        listEval.add(C1);
        
        
    }
    
     public void findAllEval(){
    
        connectionRequest = new ConnectionRequest() {
        List<Evaluation> evaluation = new ArrayList<>();
            @Override
            protected void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");

                    Map<String, Object> data = json.parseJSON(reader);
                    List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("evaluation");
                    evaluation.clear();
                  
                    for (Map<String, Object> obj : content) {
                        
                        evaluation.add(new Evaluation(Integer.parseInt((String) obj.get("id")),(String) obj.get("titre"),(String) obj.get("commentaire"),Float.parseFloat((String) obj.get("facility")),Float.parseFloat((String) obj.get("service")),Float.parseFloat((String) obj.get("interesting")),Float.parseFloat((String) obj.get("human"))));
                      //evaluation.add(new Evaluation(titre, Float.NaN, commentaire))
                    }
                } catch (IOException err) {
                    Log.e(err);
                }
            }

            @Override
            protected void postResponse() {
                listEval=new Form(new BoxLayout(BoxLayout.Y_AXIS));
                //System.out.println(libs.size());
                //listEval = new Form();
                com.codename1.ui.List uiLibsList = new com.codename1.ui.List();
                ArrayList<String> libsNoms = new ArrayList<>();
                for(Evaluation l :evaluation){
                  
                    addItem(l);
                }
                com.codename1.ui.list.DefaultListModel<String> listModel = new com.codename1.ui.list.DefaultListModel<>(libsNoms);
                uiLibsList.setModel(listModel);
                uiLibsList.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Evaluation e = evaluation.get(uiLibsList.getCurrentSelected());
                       new MesEvalsForm(e).show();
                    }
               });
                //  listEchange.setLayout(new BorderLayout());
               // listEchange.add(BorderLayout.NORTH,uiLibsList);
                //listEchange.add(BorderLayout.SOUTH,Statics.createBackBtn());
                listEval.show();             
            }
        };
        connectionRequest.setUrl("http://localhost/HostGuest/selectEva.php");
        NetworkManager.getInstance().addToQueue(connectionRequest);
    }
    
      public void updateEval(Evaluation e){
        connectionRequest = new ConnectionRequest() {
            
            @Override
            protected void postResponse() { 
                Dialog d = new Dialog("Title");
                TextArea popupBody = new TextArea("Evaluation updated");
                popupBody.setUIID("PopupBody");
                popupBody.setEditable(false);
                d.setLayout(new BorderLayout());
                d.add(BorderLayout.CENTER, popupBody);
                //d.show();
                 Dialog.show("Confirmation", "evaluation modifiee", "Ok", null);
            }
        };
        //connectionRequest.setUrl("http://localhost/echange/insert.php?description=" +echange.getDescription()+"&prix="+echange.getPrix()+"&e_id="+9+"&id_cat="+echange.getId_cat()+"&image_name="+fullnameimage+"&path="+imagepath);
       
       connectionRequest.setUrl("http://localhost/HostGuest/update.php?id="+e.getId()+"&titre="+ e.getTitre()+"&commentaire="+e.getCommentaire()+"&fas="+e.getFacility()+"&ser="+e.getService()+"&inter"+e.getInteresting()+"&human="+e.getHuman());
          System.out.println("titre : "+e.getTitre()); 
       NetworkManager.getInstance().addToQueue(connectionRequest);
          }
      
      
      
      
      
      //affichage
      
      public void AfficherEval(int id){
     ArrayList<Evaluation> evaluation = new ArrayList<>();
        connectionRequest = new ConnectionRequest() {
       
            @Override
            protected void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");

                    Map<String, Object> data = json.parseJSON(reader);
                    List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("evaluation");
                    evaluation.clear();
                  
                    for (Map<String, Object> obj : content) {
                        
                        evaluation.add(new Evaluation(Integer.parseInt((String) obj.get("id")),(String) obj.get("titre"),(String) obj.get("commentaire"),Float.parseFloat((String) obj.get("facility")),Float.parseFloat((String) obj.get("service")),Float.parseFloat((String) obj.get("interesting")),Float.parseFloat((String) obj.get("human"))));
                      //evaluation.add(new Evaluation(titre, Float.NaN, commentaire))
                    }
                } catch (IOException err) {
                    Log.e(err);
                } catch (NullPointerException e) {
                    boolean b = Dialog.show("warning", "pas d'evaluation", "Ok", null);
                    if( b ){
                        new HomeForm(theme).getF().show();
                    }
                    
                }
            }

            @Override
            protected void postResponse() {
                listEval=new Form(new BoxLayout(BoxLayout.Y_AXIS));
                listEval.getToolbar().addCommandToLeftBar("Back", theme.getImage("back-command.png"), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeForm homeForm = new HomeForm(theme);
                homeForm.getF().showBack();
         
            }
        });
                //System.out.println(libs.size());
                //listEval = new Form();
                com.codename1.ui.List uiLibsList = new com.codename1.ui.List();
                ArrayList<String> libsNoms = new ArrayList<>();
                for(Evaluation l :evaluation){
                  
                    addItem(l);
                }
                com.codename1.ui.list.DefaultListModel<String> listModel = new com.codename1.ui.list.DefaultListModel<>(libsNoms);
                uiLibsList.setModel(listModel);
                uiLibsList.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Evaluation e = evaluation.get(uiLibsList.getCurrentSelected());
                       new MesEvalsForm(e).show();
                    }
               });
                //  listEchange.setLayout(new BorderLayout());
                // listEchange.add(BorderLayout.NORTH,uiLibsList);
                //listEchange.add(BorderLayout.SOUTH,Statics.createBackBtn());
                listEval.show();             
            }
        };
        connectionRequest.setUrl("http://localhost/HostGuest/afficheEval.php?id="+id);
        NetworkManager.getInstance().addToQueue(connectionRequest);
       
    }
    
    
    
}
