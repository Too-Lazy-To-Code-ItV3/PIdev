/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.LignePanier;
import Models.Panier;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import services.LignePanierService;
import services.PanierService;


import javafx.scene.input.MouseEvent;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfTable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 * FXML Controller class
 *
 * @author aouad
 */
public class FXML_AfficherPanierController implements Initializable {
    LignePanierService lp = new LignePanierService();
    PanierService ps=new PanierService();
    Panier pan=new Panier();
    
     private FXML_AfficherPanierController afficherPanierController;
    private int idPanier;
   

    @FXML
    private TableColumn<?, ?> prixUn;

    @FXML
    private TableView<LignePanier> tablePanier;
    @FXML
    private Button vider;
    @FXML
    private Label montant_total;
    private Button modifier;
    @FXML
    private AnchorPane dateajout;
    @FXML
    private Label nbr_prod;
    @FXML
    private Button retour;
    @FXML
    private Button imprimer;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> nom;
   

 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      idPanier=8;
      showLignePanier();

    }    
    
  public void setIdPanier(int idPanier) {
       this.idPanier = idPanier;
       showLignePanier();
    }
    
    public void showLignePanier() {
        List<LignePanier> lignePanierList = lp.getLignePanierparIdPanier(idPanier);
        ObservableList<LignePanier> observableList = FXCollections.observableArrayList(lignePanierList);
        if (lignePanierList.isEmpty()) {
        System.out.println("La liste des lignes de panier est vide.");
        return;
}
        nom.setCellValueFactory(new PropertyValueFactory<>("NomProd"));
        date.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));
        prixUn.setCellValueFactory(new PropertyValueFactory<>("prix_unitaire"));
   

        
        tablePanier.setItems(observableList);

        double montantTotal = ps.calculerMontantTotal(idPanier);
        montant_total.setText(String.valueOf(montantTotal));
        int nbrProd = ps.calculerNombreProduits(idPanier);
        nbr_prod.setText(String.valueOf(nbrProd));
    }
        public void  Mtotal(String total) {
          this.montant_total.setText(total);
        } 

    public void initializePanier(int idPanier) {
      this.idPanier = idPanier;
      showLignePanier();
   }

    @FXML
    private void vider(ActionEvent event) {
        ps.viderPanier();
    }

  

    @FXML
    private void GotoAccueil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Acceuil.fxml"));
        Parent root = loader.load();
        retour.getScene().setRoot(root);
    }

    @FXML
private void imprimer(ActionEvent event) throws FileNotFoundException, DocumentException {
    String file_fact = ("C:\\Users\\aouad\\Desktop\\Pidev\\FacturePaiement.pdf");
    Document doc = new Document();
    PdfWriter.getInstance(doc, new FileOutputStream(file_fact));
    doc.open();
    PdfPTable table = new PdfPTable(3);
    PdfPCell cell;
    cell = new PdfPCell(new Paragraph("NomProd"));
    table.addCell(cell);
    cell = new PdfPCell(new Paragraph("Date d' Ajout"));
    table.addCell(cell);
    cell = new PdfPCell(new Paragraph("Prix_unitaire"));
    table.addCell(cell);
    List<LignePanier> lignePanierList = lp.getLignePanierparIdPanier(idPanier);
    for (LignePanier lignePanier : lignePanierList) {
        cell = new PdfPCell(new Paragraph(lignePanier.getNomProd()));
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph(String.valueOf(lignePanier.getDateAjout())));
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph(String.valueOf(lignePanier.getPrix_unitaire())));
        table.addCell(cell);
    }
    doc.add(table);
    doc.add(new Paragraph("Le nombre des produits commandés : " + ps.calculerNombreProduits(idPanier)));
    doc.add(new Paragraph("Montant total à payer en DT : " + ps.calculerMontantTotal(idPanier)));
    doc.close();
}
    
   
    }
    
      
    

