package Interfaces;

import Models.offreTravailarchive;

import java.util.List;

public interface offreTravailArchiveInterface {
    public void recupererOffre(offreTravailarchive o);

    public void SupprimerDefinitivement(offreTravailarchive o);

    public List<offreTravailarchive> fetchOffresarchiverPerIdDate(int id);

    public offreTravailarchive fetchOffrearchiveParId(int id);
}
