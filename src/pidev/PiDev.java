
package pidev;

import interfaces.offreTravailInterface;
import models.Categorie;
import models.demandeTravail;
import models.grosMots;

import models.offreTravail;
import service.CategoryService;
import service.demandeTravailService;
import service.grosMotsService;

import service.offreTravailService;

/**
 *
 * @author nour2
 */
public class PiDev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //received from token 
        int idStudio=5;
        //create 3 categories
     Categorie c1 = new Categorie();
     c1.setNomCategorie("3d art");
     c1.setIdCategorie(1);
      Categorie c2 = new Categorie();
     c2.setNomCategorie("2d art");
     c2.setIdCategorie(2);
      Categorie c3 = new Categorie();
     c3.setNomCategorie("photograph");
     c3.setIdCategorie(3);
        // TODO code application logic 
        // service init
offreTravailInterface offreserv= new offreTravailService();
//offre1 initialisation
offreTravail offre1 = new offreTravail();
        offre1.setTitreOffre("3d designer");
        offre1.setDescriptionOffre("designer bac+3 experience pas necessaire");
        offre1.setCategorieOffre(c1);
        offre1.setTypeOffre("freelance");
        offre1.setLocalisationOffre("ariana");
       offre1.setIdStudio(2);//njibouh ml token mt3 lstudio conencté
       
        
        //offre 2 initialisation
        offreTravail offre2 = new offreTravail();
        offre2.setTitreOffre("bhim");
        offre2.setDescriptionOffre(" photographer bac plus three  experience needed ");
        offre2.setCategorieOffre(c3);
       offre2.setIdStudio(2);
         offre2.setTypeOffre("freelance");
        offre2.setLocalisationOffre("ariana");
  
                //offre3 initialisation
  offreTravail offre3 = new offreTravail();
        offre3.setTitreOffre("2d designer");
        offre3.setDescriptionOffre(" designer bac +3 ");
        offre3.setCategorieOffre(c2);
       offre3.setIdStudio(3);
          offre3.setTypeOffre("freelance");
          offre3.setLocalisationOffre("tunis");
        


        //add initialisation
     //  offreserv.addOffre(offre1);
      offreserv.addOffre(offre2);
    // offreserv.addOffre(offre3);
        //select
       //System.out.println(offreserv.fetchOffresPerDate());
       // System.out.println(offreserv.fetchOffresPerIdDate(2));
     // System.out.println(offreserv.fetchOffresPerCategorieDate(offreserv.fetchOffresPerDate(),c1));
   //  System.out.println(offreserv.fetchOffresPerType(offreserv.fetchOffresPerDate(), "freelance"));
         //modifier offre
         // offre2.setTitreOffre("titre modifier");
         // offre2.setDescriptionOffre("description modifier");
        //  offre2.setCategorieOffre("categorie modifier");
          //onclick va prendre lid li nzelna alih wthotou fi hehdi 
        // offre2.setIdOffre(5);
       // offreserv.modifierOffre(offre2);
      //  offre1.setIdOffre(4);
         // offreserv.Supprimer(offre1);
         // System.out.println (offreserv. chercherOffres("avaxia description "));
        //get from onclick bch yekhou id loffre wyb3thou fl mail 
    
       // offre2.setIdOffre(8);
      //  offre3.setIdOffre(6);
     //  offre1.setIdOffre(7);
       //  offre3.setNomStudio("avaxia");
        //offreserv. postuleViaMail(4,offre2);
           //   System.out.println(   offreserv.affichernotifications(2));
                
                
          /* ********************* afichage demande de travail************************* */          

 demandeTravailService demandeserv = new demandeTravailService();
//demande1 initialisation
demandeTravail demande1 = new demandeTravail();
       demande1.setTitreDemande("3d 4designer ");
       demande1.setDescriptionDemande("designer bac+3 experience pas necessaire");
        demande1.setCategorieDemande(c1);
       demande1.setIdArtiste(1);//njibouh ml token mt3 lstudio conencté
       //demande1 initialisation
demandeTravail demande2 = new demandeTravail();
//System.out.println (demandeserv.chercherDemande("2d"));

      // demande2.setTitreDemande("test ");
      // demande2.setDescriptionDemande("test");
     //   demande2.setCategorieDemande(c2);
     //  demande2.setIdArtiste(4);
     // demandeserv.addDemande(demande2);
     // demandeserv.addDemande(demande1);
     // demande2.setIdDemande(1);
    //  demande1.setIdDemande(2);
          //modifier demande1
        // demande1.setTitreDemande("titre modifier");
        //  demande1.setDescriptionDemande("description modifier");
        // demande1.setCategorieDemande(c3);
          //onclick va prendre lid li nzelna alih wthotou fi hehdi 
      
        // demandeserv.modifierDemande(demande1);
         
          //select
       // System.out.println(demandeserv.fetchDemandesPerDate());
        // System.out.println(demandeserv.fetchDemandesPerIdDate(1));
        
          //demandeserv. contacterViaMail(2,demande2 );
         // CategoryService cc = new CategoryService();
    // System.out.println(cc.fetchCategories());
   // CategoryService s =  new CategoryService();
   // System.out.println(s.fetchCategoryByNom("2d art"));
 //  grosMots g = new grosMots();
   //g.setMot("stupid");
   //grosMotsService s = new grosMotsService ();
  // s.ajoutGrosMot(g);
    }
    
    
}
