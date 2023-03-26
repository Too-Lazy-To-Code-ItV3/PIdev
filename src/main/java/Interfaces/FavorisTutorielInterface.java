package Interfaces;

import Models.Tutoriel;

import java.util.List;

public interface FavorisTutorielInterface {
    public void addFavoris(Tutoriel t);

    public void removeFavoris(Tutoriel t);

    public boolean favorated(Tutoriel t);

    public List<Tutoriel> fetchFavorisTutorials();
}
