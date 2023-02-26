/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.app;

import Interfaces.CategoriesInterface;
import Interfaces.PanierInterface;
import Interfaces.ProduitInterface;
import Models.Categories;
import Models.LignePanier;

import Models.Panier;
import Models.Produits;
import services.CategoriesService;
import services.LignePanierService;
import services.PanierService;
import services.ProduitService;


/**
 *
 * @author aouad
 */
public class PidevApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
           // service init
         // service init
        ProduitInterface prodserv = new ProduitService();
        CategoriesInterface   categserv = new CategoriesService() {};
        PanierInterface panierserv = new PanierService();
        LignePanierService lignepanierserv = new LignePanierService();
     
        
  //*********************************Ajout des produits****************************//
      Categories cat1=new Categories();
       cat1.setNomCategorie("3D");
       cat1.setIdCategorie(2);
       
      Categories cat2=new Categories();
      cat2.setNomCategorie("2D");
      cat2.setIdCategorie(1);
   // produit init;
   
    Produits p1 = new Produits();
       p1.setIdProduit(1);
       p1.setNom("Monaliza");
       p1.setDescription("Monaliza est la fameuse image situé à louver à Paris , j'ai décidé d'utiliser le photoshop pour une nouvelle réalisation digitalisée");
       p1.setCategorieProduit(cat2);
       p1.setImage("monaliza.jpg");
       p1.setPrix(1000);
        //prodserv.addProduit(p1);
//        prodserv.modifierProduit(p1);
   // produit 2ème init;
    Produits p2 = new Produits();
       p2.setIdProduit(2);
       p2.setNom(" LA CRÉATION D'ADAM PAR MICHEL-ANGE");
       p2.setDescription(" La création d'Adam » est une fresque de Michel-Ange, peinte en 1508-1512. Elle fait partie du plafond de la chapelle Sixtine.J'ai décidé d'utiliser l'adobe illustrator pour une nouvelle réalisation digitalisée");
       p2.setCategorieProduit(cat2);
       p2.setImage("le création d'adam.jpg");
       p2.setPrix(1500);
        //prodserv.addProduit(p2);*
//        prodserv.modifierProduit(p2);
        
   // produit 3ème init;
    Produits p3 = new Produits();
       p3.setNom(" LA JEUNE FILLE À LA PERLE PAR JOHANNES VERMEER");
       p3.setDescription(" La peinture à l'huile sur toile « La Jeune Fille à la perle » est l’une des œuvres les plus connues faites par l'artiste hollandais Johannes Vermeer. Le tableau représente une jeune femme imaginaire en robe avec une très grande boucle d'oreille en perle dans un espace sombre peu profond ce qui attire l'attention du spectateur exclusivement sur la femme. J'ai décidé d'utiliser l'adobe illustrator pour une nouvelle réalisation digitalisée");
       p2.setCategorieProduit(cat2);
       p3.setImage("la jeune fille à la perle.jpg");
       p3.setPrix(3000);
      // prodserv.addProduit(p3);
  
  
   // produit 4ème init;
   
    Produits p4 = new Produits();
       p4.setIdProduit(19);
       p4.setNom(" LA NUIT ÉTOILÉE PAR VAN GOGH");
       p4.setDescription("Cette peinture de l'artiste néerlandais Van Gogh a été peinte en 1889. Le Musée d'art moderne de New York la possède depuis 1941. Cette œuvre est considérée comme l'une des meilleures oeuvres de Van Gogh et l'une des œuvres les plus importantes de la peinture occidentale. J'ai décidé d'utiliser l'adobe illustrator pour une nouvelle réalisation digitalisée");
       p4.setCategorieProduit(cat1);
       p4.setImage("la nuit étoilée.jpg");
       p4.setQuantiteDispo(4);
       p4.setPrix(1200);
//       prodserv.addProduit(p4);
        
    // produit 5ème init  avec catégorie;
      
      Produits p5 = new Produits();
       p5.setIdProduit(23);
       p5.setNom(" Joker");
       p5.setDescription(" LA CRÉATION Joker liée au film JOKER et au personnage Joker , ce travail a été réaliser à l'aide de l'Ai ");
       p5.setCategorieProduit(cat1);
       p5.setImage(" Joker.jpg***");
       p5.setPrix(3000);
//     prodserv.addProduit(p5);
       
    // produit 6ème init  avec catégorie;
    
     
     Produits p6 = new Produits();
      p6.setIdProduit(9);
      p6.setNom(" Joker");
      p6.setDescription(" LA CRÉATION Joker liée au film JOKER et au personnage Joker , ce travail a été réaliser à l'aide de l'Ai ");
      p6.setCategorieProduit(cat2);
      p6.setImage(" Joker.jpg***");
      p6.setPrix(3000); 
      // prodserv.addProduit(p6);
       
 // produit 7ème init  avec catégorie;
    
     Categories cat3=new Categories();
      cat3.setNomCategorie("2D");
      cat3.setIdCategorie(1);
     Produits p9 = new Produits();
      p9.setIdProduit(18);
      p9.setNom(" Joki");
      p9.setDescription("Joker liée au film JOKER et au personnage Joker , ce travail a été réaliser à l'aide de l'Ai ");
      p9.setCategorieProduit(cat3);
      p9.setImage(" Jok.jpg***");
      p9.setPrix(1500); 
     //prodserv.addProduit(p7);
        //produit 7ème init  avec catégorie;
    
     Categories cat4=new Categories();
      cat4.setNomCategorie("3D");
      cat4.setIdCategorie(1);
     Produits p8 = new Produits();
      p8.setIdProduit(15);
      p8.setNom(" cube ");
      p8.setDescription("un cube en 3D avec des couleurs en harmonie , ce travail a été réaliser à l'aide de l'Ai ");
      p8.setCategorieProduit(cat4);
      p8.setImage(" cube.jpg***");
      p8.setQuantiteDispo(6);
      p8.setPrix(500); 
//      prodserv.addProduit(p8);

//          // UPDATE 4ème produit 
//    Produits p4 = new Produits();
//       p4.setNom(" LA NUIT ");
//       p4.setDescription("moderne de New York la possède depuis 1941. Cette œuvre est considérée comme l'une des meilleures oeuvres de Van Gogh et l'une des œuvres les plus importantes de la peinture occidentale. J'ai décidé d'utiliser l'adobe illustrator pour une nouvelle réalisation digitalisée");
//       p4.setCatégorie("2D");
//       p4.setImage("la nuit étoilée.jpg");
//       p4.setPrix(1200);
     
  //*********************************Modifier les produits****************************//
       //Modifier le 1er produit 
        
//        prodserv.modifierProduit(p4,19);
         
      //Modifier le 2ème produit 
      
//       Produits p2 = new Produits();
//        p2.setIdProduit(2);
//        p2.setNom(" LA CRÉATION D'ADAM ***");
//        p2.setDescription(" LA CRÉATION D'ADAM");
//        p2.setCategorieProduit(cat2);
//        p2.setImage(" création.jpg***");
//        p2.setPrix(1400);
//        prodserv.modifierProduit(p2);

  //*********************************Supprimer les produits****************************//

      //supprimer Produit par id 
//          prodserv.spprimerProduit(" Joki");
        
           
   //*********************************Chercher des produits*****************************************//
   //chercher par nom
//       prodserv.chercherProduitParNom(p8,"cube");
   //chercher par categorie
//       prodserv.chercherProduitParCategorie(p8,cat4);
       
//       prodserv.chercherProduitParNom(p8,"cube");
       
  //*********************************Afficher les produits****************************//    
       //affichage d'un produit d'id 7 
//        p2.setIdProduit(7);
//      prodserv.afficherProduit(p2,7);

      
    //************************************gestion catégories**************************//  
   
//      categserv.addCategorie(c2);
      
     
//intégration catégories avec produits
//     Categories c2= new Categories();
//        c2.setIdCategorie(2);
//        c2.setNomCategorie("3D");
//        p2.setIdProduit(2);
//        prodserv.ImportcategorieProduit();
        
//******************************* afficher catégorie par id***********************************************// 
   
//       categserv.readByNom("2D");

//         categserv.readByName("2D");
       
//***************************************** gestion ligne panier *****************************//
           Panier pan= new Panier();
           pan.setIdPanier(8);
//           pan.setNbr_produits(5);
//           pan.setMontant_total(2400);
   LignePanier lp = new  LignePanier(); 
   lp.setIdLignePanier(19);
   lp.setPanier(pan);
   lp.setProduit(p8);
   lp.setPrix_unitaire(p8.getPrix());
   lp.setQuantite(4);

   Panier pan2= new Panier();
           pan2.setIdPanier(9);
//           pan2.setNbr_produits(2);
//           pan2.setMontant_total(3000);
   LignePanier lp2 = new  LignePanier(); 
   lp2.setIdLignePanier(18);
   lp2.setPanier(pan2);
   lp2.setProduit(p2);
   lp2.setPrix_unitaire(p2.getPrix());
   lp2.setQuantite(3);
//   lp2.setSous_montant(9000);
 
// LignePanier lp7 = new  LignePanier(); 
//   lp7.setProduit(p7);
//   lp7.setPrix_unitaire(p7.getPrix());
//   lp7.setQuantite(5);

        //ajouter 
//         lignepanierserv.ajouterLignePanier(lp);
 
       //modifier
//             lignepanierserv.modifierlLignePanier(lp8,7);
//             lignepanierserv.modifierQuantite(5,4,13 );
//  lignepanierserv.modifierQuantite(3,8,20);
 
      //supprimer
 
             // lignepanierserv.supprimerLignePanier(0);
             


     //afficher
         
//   System.out.println(lignepanierserv.afficherTous());
//calcul sous montant 
//    
//   double nvmontant = lignepanierserv.calculerSousMontant(lp,19);
//////   System.out.print(nvmontant);
//
////////////mis à jour  sous montant
//   lignepanierserv.MisàjourSousMontant(lp,19,nvmontant);

//afficher par id 
//     panierserv.afficherPanierParId(5);
//     lignepanierserv.getLignePanierparIdPanier(12);
//***************************************** gestion panier *****************************//
       //Ajout d'un 1er panier

//         panierserv.ajouterPanier(pan2);
       
       //Ajout d'un 2ème panier
//           Panier pan2= new Panier();
//           pan2.setNbr_produits(2);
//           pan2.setMontant_total(1500);
//           panierserv.ajouterPanier(pan2);
       //Vider panier 
//           panierserv.viderPanier(7);
       //Affiche panier 
       
//      panierserv.afficherPanier(pan,5);
       
 
      //Calcul montant total 
//        Double montant_tot=panierserv.calculerMontantTotal(8);
////       //mis à jour montant total 
//        panierserv.MisàjourMontantTotal(pan,8,montant_tot );
//        //Calcul nombre de produits 
//        panierserv.calculerNombreProduits(8);
//    
//*************************************************** SELECT ******************************************************************//
        //select pour produits
//      System.out.println(panierserv.fetchPanier());

        
        
//        System.out.println(prodserv.fetchProduits());
//System.out.println(prodserv.readById(19));
//System.out.println(prodserv.chercherProduitParNom("cube2"));

//        //select pour categories  
//     System.out.println(categserv.fetchCategories());
     
    }

  
    
}
 