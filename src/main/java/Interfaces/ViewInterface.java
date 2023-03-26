package Interfaces;

import Models.Video;

import java.util.List;

public interface ViewInterface {
    public void addVue(Video v);

    public boolean vued(Video v);

    public int fetchNumViewsByVideo(Video v);

    public List<Video> fetchHistory();
}
