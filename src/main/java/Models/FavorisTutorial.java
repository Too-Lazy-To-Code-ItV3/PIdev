package Models;

public class FavorisTutorial {
    AllUsers user;
    Tutoriel tutoriel;

    public FavorisTutorial() {
    }

    public FavorisTutorial(AllUsers user, Tutoriel tutoriel) {
        this.user = user;
        this.tutoriel = tutoriel;
    }

    public AllUsers getUser() {
        return user;
    }

    public void setUser(AllUsers user) {
        this.user = user;
    }

    public Tutoriel getTutoriel() {
        return tutoriel;
    }

    public void setTutoriel(Tutoriel tutoriel) {
        this.tutoriel = tutoriel;
    }

    @Override
    public String toString() {
        return "FavorisTutorial{" + "user=" + user + ", tutoriel=" + tutoriel + '}';
    }

}
