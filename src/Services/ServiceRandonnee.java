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
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entity.*;
import forms.MesRandoForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.codename1.ui.util.Resources;
import forms.ModifierRandoForm;
import forms.RandoDetailsForm;
import java.lang.String;

/**
 *
 * @author Firas
 */
public class ServiceRandonnee {
    private static ServiceRandonnee rs;
    private ArrayList<Randonnee> Randos;
    
    private ServiceRandonnee() {
        Randos = new ArrayList<Randonnee>();
        
    }
    public static ServiceRandonnee GetInstance(){
        if (rs==null)
            rs=new ServiceRandonnee();
            
        return rs;
    }
    
    public void ajouterRando(Randonnee r){
        ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://localhost/HostGuest/insertRando.php?titre="+r.getTitre()+"&lieu="+r.getLieu()
                        +"&nbMax="+r.getNbMax()+"&description="+r.getDescription()+"&lieu_rencontre="+r.getLieuRencontre()
                                +"&heure_rencontre="+r.getHeureRencontre()+"&prix="+r.getPrix()+"&id_hote="+r.getHote().getId() + "");

                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);

                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "Randonnée ajouté avec succée", "Ok", null);
                        }
                    }
                });
                
                NetworkManager.getInstance().addToQueue(req);
    }
    
    public void ModifierRando(Randonnee r) {
        ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://localhost/HostGuest/modifierRando.php?titre="+r.getTitre()+"&lieu="+r.getLieu()
                        +"&nbMax="+r.getNbMax()+"&description="+r.getDescription()+"&lieu_rencontre="+r.getLieuRencontre()
                                +"&heure_rencontre="+r.getHeureRencontre()+"&prix="+r.getPrix()+"&id="+r.getId()+ "");

                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);

                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "Randonnée Modifié", "Ok", null);
                           
                        }
                    }
                });
                
                NetworkManager.getInstance().addToQueue(req);
        
    }
    public void SupprimerRando(Randonnee r) {
        ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://localhost/HostGuest/supprimerRando.php?id="+r.getId());

                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);

                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "Randonnée Supprimé", "Ok", null);
                           
                        }
                    }
                });
                
                NetworkManager.getInstance().addToQueue(req);
        
    }
    
    
    public void GetAllRandos(Container f, Resources theme){
//        Hote hote = new Hote();
//        hote.setId(1);
        //ArrayList<Randonnee> Randos = new ArrayList<Randonnee>();
         ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/HostGuest/getAllRando.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
               Randos = getListRandos(new String(con.getResponseData()));
                            
                
                for(Randonnee rd : Randos){
                   
                     f.add(GetItemList(rd, theme));
                }
                //sp.setText(getListEtudiant(new String(con.getResponseData())) + "");
                f.refreshTheme();

            }
        });
        NetworkManager.getInstance().addToQueue(con);
        
        
        
        
//        return Randos;
    }
     public void CherherAllRandos(Container f,String lieu, Resources theme){
             ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/HostGuest/rechercherAllRando.php?lieu="+lieu);
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);
                System.out.println("-----------------Begin S--------- :\n"+s);
                System.out.println("-----------------End S----------------------");
                if (!s.equals("0 results{}")) {
                    Randos = getListRandos(new String(con.getResponseData()));
                            
                    f.removeAll();
                     for(Randonnee rd : Randos){
                        f.add(GetItemList(rd, theme));
                     }
               
                    f.refreshTheme();       
                           
                } else {
                    f.removeAll();
                }
               

            }
        });
        NetworkManager.getInstance().addToQueue(con);
        

    }
     
    public void GetMesRandos(Container f, Resources theme){
        Hote hote = new Hote();
        hote.setId(1);
        //ArrayList<Randonnee> Randos = new ArrayList<Randonnee>();
         ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/HostGuest/getMesRando.php?id_hote="+hote.getId());
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
               Randos = getListRandos(new String(con.getResponseData()));
                            
                
                for(Randonnee rd : Randos){
                   
                     f.add(GetMyItemList(rd, theme));
                }
               
                f.refreshTheme();

            }
        });
        NetworkManager.getInstance().addToQueue(con);
        
        
        
        
//        return Randos;
    }
    public void chercherMesRandos(Container f,String lieu, Resources theme){
        Hote hote = new Hote();
        hote.setId(1);
        //ArrayList<Randonnee> Randos = new ArrayList<Randonnee>();
         ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/HostGuest/rechercheMesRando.php?id_hote="+hote.getId()+"&lieu="+lieu);
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                byte[] data = (byte[]) evt.getMetaData();
                String s = new String(data);
               
                if (!s.equals("0 results{}")) {
                    Randos = getListRandos(new String(con.getResponseData()));
                            
                    f.removeAll();
                     for(Randonnee rd : Randos){
                        f.add(GetMyItemList(rd, theme));
                     }
               
                    f.refreshTheme();       
                           
                } else {
                    f.removeAll();
                }
               

            }
        });
        NetworkManager.getInstance().addToQueue(con);
        
        
        
        
//        return Randos;
    }
    
    
private ArrayList<Randonnee> getListRandos(String json) {
    System.out.println("inside getListRandos OK!");
        ArrayList<Randonnee> listRandos = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
           try {
               List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("rando");

            for (Map<String, Object> obj : list) {
                Randonnee r = new Randonnee();
                r.setId(Integer.parseInt(obj.get("id").toString()));
                r.setTitre(obj.get("titre").toString());
                r.setLieu(obj.get("lieu").toString());
                r.setNbMax(Integer.parseInt(obj.get("nbMax").toString()));
                r.setDescription(obj.get("description").toString());
                r.setLieuRencontre(obj.get("lieu_rencontre").toString());
                r.setHeureRencontre(obj.get("heure_rencontre").toString());//heure_rencontre
                r.setPrix(Integer.parseInt(obj.get("prix").toString()));
                listRandos.add(r);

            }
               
           }catch(ClassCastException e){
                Map<String, Object> objt = (Map<String, Object>) etudiants.get("rando");
                Randonnee r = new Randonnee();
                r.setId(Integer.parseInt(objt.get("id").toString()));
                r.setTitre(objt.get("titre").toString());
                r.setLieu(objt.get("lieu").toString());
                r.setNbMax(Integer.parseInt(objt.get("nbMax").toString()));
                r.setDescription(objt.get("description").toString());
                r.setLieuRencontre(objt.get("lieu_rencontre").toString());
                r.setHeureRencontre(objt.get("heure_rencontre").toString());//heure_rencontre
                r.setPrix(Integer.parseInt(objt.get("prix").toString()));
                listRandos.add(r);

               
           }
                      
            

        } catch (IOException ex) {
         }
       
        
        return listRandos;

    }

    private Container GetItemList(Randonnee r,Resources theme) {
        Label labelNom = new Label("Titre :"+r.getTitre());
        Label labelMail = new Label("Lieu :"+r.getLieu());
        Button btn = new Button("Detail");
        //String imageName = c.getImage();
        Label labelImage = new Label(theme.getImage("a.png"));
        
        Container ctn = new Container();
        ctn.setLayout(new BorderLayout());
        Container ctn1 = new Container();
        ctn1.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        ctn1.addComponent(labelNom);
        ctn1.addComponent(labelMail);
        ctn1.addComponent(btn);
        ctn.addComponent(BorderLayout.CENTER, ctn1);
       
        ctn.addComponent(BorderLayout.EAST, labelImage);
        btn.addActionListener((evt) -> {
            System.out.println("Prix :"+r.getPrix()+"\tTemp :"+r.getHeureRencontre() );
            RandoDetailsForm detailsForm = new RandoDetailsForm(r,theme);
            detailsForm.getF().show();
        });
        //ctn.setLeadComponent(btn);
        
        return ctn;
    }
    private Container GetMyItemList(Randonnee r,Resources theme) {
        Label labelNom = new Label("Titre :"+r.getTitre());
        Label labelMail = new Label("Lieu :"+r.getLieu());
        Button btnDel = new Button("Supprimer");
        Button btnModif = new Button("Modifier");
        
        
        //String imageName = c.getImage();
        Label labelImage = new Label(theme.getImage("a.png"));
        
        Container ctnBtn = new Container(new BoxLayout(BoxLayout.X_AXIS));
        ctnBtn.add(btnModif);
        ctnBtn.add(btnDel);
                
        
        Container ctn = new Container();
        ctn.setLayout(new BorderLayout());
        Container ctn1 = new Container();
        ctn1.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        ctn1.addComponent(labelNom);
        ctn1.addComponent(labelMail);
        ctn1.addComponent(ctnBtn);
        ctn.addComponent(BorderLayout.CENTER, ctn1);
       
        ctn.addComponent(BorderLayout.EAST, labelImage);
        btnDel.addActionListener((evt) -> {
            System.out.println("------btnDel----");
//            System.out.println("Prix :"+r.getPrix()+"\tTemp :"+r.getHeureRencontre() );
//            RandoDetailsForm detailsForm = new RandoDetailsForm(r,theme);
//            detailsForm.getF().show();
        });
         btnModif.addActionListener((evt) -> {
            
             ModifierRandoForm mrf = new ModifierRandoForm(r, theme);
             mrf.getF().show();
        });
        btnDel.addActionListener((evt) -> {
            
             this.SupprimerRando(r);
             MesRandoForm mrf = new MesRandoForm(theme);
             mrf.getF().show();
        });
        //ctn.setLeadComponent(btn);
        
        return ctn;
    }
    
    
}
