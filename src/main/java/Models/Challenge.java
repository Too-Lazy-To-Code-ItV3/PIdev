package Models;

import java.util.List;

public class Challenge {
    private int ID_Challenge, niveau;
    private String Title, Description, Date_C, PathIMG;
    private List<AllUsers> Participants;
    private Categorie categorie;
    private AllUsers Creator;

    public Challenge() {
    }

    public Challenge(int ID_Challenge, int niveau, String Title, String Description, String Date_C, String PathIMG, List<AllUsers> Participants, Categorie categorie, AllUsers Creator) {
        this.ID_Challenge = ID_Challenge;
        this.niveau = niveau;
        this.Title = Title;
        this.Description = Description;
        this.Date_C = Date_C;
        this.PathIMG = PathIMG;
        this.Participants = Participants;
        this.categorie = categorie;
        this.Creator = Creator;
    }

    public int getID_Challenge() {
        return ID_Challenge;
    }

    public void setID_Challenge(int ID_Challenge) {
        this.ID_Challenge = ID_Challenge;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDate_C() {
        return Date_C;
    }

    public void setDate_C(String Date_C) {
        this.Date_C = Date_C;
    }

    public String getPathIMG() {
        return PathIMG;
    }

    public void setPathIMG(String PathIMG) {
        this.PathIMG = PathIMG;
    }

    public List<AllUsers> getParticipants() {
        return Participants;
    }

    public void setParticipants(List<AllUsers> Participants) {
        this.Participants = Participants;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public AllUsers getCreator() {
        return Creator;
    }

    public void setCreator(AllUsers Creator) {
        this.Creator = Creator;
    }

    @Override
    public String toString() {
        return "Challenge{" + "ID_Challenge=" + ID_Challenge + ", niveau=" + niveau + ", Title=" + Title + ", Description=" + Description + ", Date_C=" + Date_C + ", PathIMG=" + PathIMG + ", Participants=" + Participants + ", categorie=" + categorie + ", Creator=" + Creator + '}';
    }
}
