package sk.ics.upjs.hikeapp;

public interface StatistikaDao {
    public void pridaj(Statistika statistika);
    
    public void uprav(Statistika statistika);
    
    public Statistika dajPodlaUzivatela(Long idS);
}
