/**
 * Created by Michal on 2015-03-07.
 */
public class Osoba {
    public String imie;
    public int wiek;

    public Osoba (String imie, int wiek){
        this.imie = imie;
        this.wiek = wiek;
    }

    public int zwróćWiek(){
        return wiek;
    }

    public String zwróćImie(){
        return imie;
    }


}
