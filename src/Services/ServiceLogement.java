/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entity.Logement;
import forms.LogementDetailsForm;
import forms.ModifierLogementForm;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author mehdi
 */
public class ServiceLogement {
    private ConnectionRequest connectionRequest;
     private static ServiceLogement lg;
    private ArrayList<Logement> logs ;
    
    private ServiceLogement() {
        logs = new ArrayList<Logement>();
        
    }
    public static ServiceLogement GetInstance(){
        if (lg==null)
            lg=new ServiceLogement();
            
        return lg;
    }
    public void ajouterLogement(Logement l){
         ConnectionRequest req = new ConnectionRequest();
               
                req.setUrl("http://localhost/HostGuest/insertLogement.php?titre=" + l.getTitre() + "&adresse=" + l.getAddress() + "&ville=" + l.getVille() + "&pays=" + l.getPaye() + "&prix=" + l.getPrix() + "&type=" + l.getType() +"&id_hote="+l.getHote().getId() + "");

                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        

                        if (s.equals("success")) {
                            
                            Dialog.show("Confirmation", "logement ajouter", "Ok", null);
                        }
                    }
                });
                
                NetworkManager.getInstance().addToQueue(req);
       
    }
    public void GetAllLogement(Container f,Resources theme){
         ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/HostGuest/getAllLogement.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                 logs = getListLogements(new String(con.getResponseData()));
                            
                
                for(Logement lg : logs){
                   
                     f.add(GetItemList(lg, theme));
                }
                //sp.setText(getListEtudiant(new String(con.getResponseData())) + "");
                f.refreshTheme();

            }
        });
        NetworkManager.getInstance().addToQueue(con);
        
    }
    
    public ArrayList<Logement> getListLogements(String json) {
        ArrayList<Logement> listLogements = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));

            System.out.println();
            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("logement");

            for (Map<String, Object> obj : list) {
                Logement e = new Logement();
               e.setId(Integer.parseInt(obj.get("id").toString()));
                e.setTitre(obj.get("titre").toString());
                e.setAddress(obj.get("adresse").toString());
                e.setVille(obj.get("ville").toString());
                e.setPaye(obj.get("pays").toString());               
                 e.setPrix(Float.parseFloat(obj.get("prix").toString()));
                 e.setType(obj.get("type").toString());
                 
                 
                 
                listLogements.add(e);
                
                          
            }

        } catch (IOException ex) {
         }
        return listLogements;

    }
    
    private Container GetItemList(Logement l,Resources theme) {
        Label labelTitre = new Label("Titre :"+l.getTitre());
        Label labelPrix = new Label("prix :"+l.getPrix());
        Button btn = new Button("Detail");
         Button btnModif = new Button("modifier");
        //String imageName = c.getImage();
        Label labelImage = new Label(theme.getImage("a.png"));
        
        Container ctn = new Container();
        ctn.setLayout(new BorderLayout());
        Container ctn1 = new Container();
        ctn1.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        ctn1.addComponent(labelTitre);
        ctn1.addComponent(labelPrix);
        ctn1.addComponent(btn);
        ctn1.addComponent(btnModif);
        ctn.addComponent(BorderLayout.CENTER, ctn1);
       
        ctn.addComponent(BorderLayout.EAST, labelImage);
        btn.addActionListener((evt) -> {
            System.out.println("ville :"+l.getVille()+"\tadresse :"+l.getAddress() );
            LogementDetailsForm LogdetailsForm = new LogementDetailsForm(l,theme);
            LogdetailsForm.getF().show();
        });
        
        btnModif.addActionListener((evt) -> {
            System.out.println("modifi");
            
            
            
            
             ModifierLogementForm modifierLogement = new ModifierLogementForm(l,theme);
            modifierLogement.getF().show();
            
        });
        //ctn.setLeadComponent(btn);
        
        return ctn;
    }
    
     public void modifierLogement(Logement l){
        ConnectionRequest req = new ConnectionRequest();
      
                req.setUrl("http://localhost/HostGuest/modifierLogement.php?titre=" + l.getTitre() + "&adresse=" + l.getAddress() + "&ville=" + l.getVille() + "&pays=" + l.getPaye() + "&prix=" + l.getPrix() + "&type=" + l.getType() +"&id="+l.getId() + "");

                
               req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);

                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "logement modifier", "Ok", null);
                        }
                    }
                });
                
                NetworkManager.getInstance().addToQueue(req);
    }
    
    
    
}
