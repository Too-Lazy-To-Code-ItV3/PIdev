package Interfaces;

import Models.Tutoriel;
import Models.Video;

import java.util.List;

public interface VideoInterface {
    public void addVideo(Video v);

    //modification
    public void modifyVideo(Video v);

    //suppression
    public void deleteVideo(int id);


    //list : select
    public List<Video> fetchVideos();

    public List<Video> fetchVideosByTutoriel(int ID_Tutoriel);

    public List<Video> fetchVideoByID(int ID_Video);

    public List<Video> fetchVideosByName(String Name);

    //affectation

    //affectation
    public void affecterVideo(Video v, Tutoriel t);
}
