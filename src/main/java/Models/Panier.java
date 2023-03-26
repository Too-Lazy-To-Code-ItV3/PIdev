package Models;

public class Panier {
    private int idPanier ;
    private int ID_User ;
    private int nbr_produits;
    private double montant_total;
    private AllUsers User;



    //constructeur

    public Panier(int idPanier,int ID_User,int nbr_produits, double montant_total,AllUsers User ) {
        this.idPanier=idPanier;
        this.ID_User=ID_User;
        this.nbr_produits = nbr_produits;
        this.montant_total = montant_total;
        this.User=User;

    }



    public Panier() {
    }


    //getters

    public int getIdPanier() {
        return idPanier;
    }



    public int getID_User() {
        return ID_User;
    }

    public AllUsers getUser() {
        return User;
    }



    public int getNbr_produits() {
        return nbr_produits;
    }


    public double getMontant_total() {
        return montant_total;
    }




    //setters


    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public void setUser(AllUsers User) {
        this.User = User;
    }


    public void setNbr_produits(int nbr_produits) {
        this.nbr_produits = nbr_produits;
    }

    public void setMontant_total(double montant_total) {
        this.montant_total = montant_total;
    }


    //toString

    @Override
    public String toString() {
        return "Panier{" + "idPanier=" + idPanier + ", ID_User=" + ID_User + ", nbr_produits=" + nbr_produits + ", montant_total=" + montant_total + ", User=" + User + '}';
    }




    public void ajouterLignePanier(LignePanier lignePanier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
