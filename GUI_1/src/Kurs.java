/**
 * Created by Michal on 2015-03-07.
 */
public class Kurs {
    public String NazwaKursu;
    public int limitWiekowy;
    public int limitUczestników;
    public int pozostałeMiejsca;
    public int ilośćUczestników;
    public Osoba[] uczestnicy = new Osoba[limitUczestników];

    public Kurs(String NazwaKursu, int limitWiekowy, int limitUczestników){
        this.NazwaKursu = NazwaKursu;
        this.limitWiekowy = limitWiekowy;
        this.limitUczestników = limitUczestników;
        this.pozostałeMiejsca = limitUczestników;
        this.ilośćUczestników = 0;
    }



    public int czyMożnaZapisać(Osoba uczestnik){
        for(int i = 0; i <= uczestnicy.length; i++){
            if(uczestnicy[i] == uczestnik)
                return 1;
        }

        if(pozostałeMiejsca == 0)
            return 2;

        if(uczestnik.zwróćWiek() < limitWiekowy)
            return 3;

        return 4;
    }

    public Kurs dodajUczestnika(Osoba uczestnik)throws NullArgumentDodawaniaException{
        if (uczestnik == null)
            throw new NullArgumentDodawaniaException();

        switch(this.czyMożnaZapisać(uczestnik)){
            case 1:
                System.out.println(uczestnik.zwróćImie() + " jest już zapisany do kursu " + this.NazwaKursu);
                break;
            case 2:
                System.out.println("Kurs " + this.NazwaKursu + ": brak miejsc!");
                break;
            case 3:
                System.out.println(uczestnik.zwróćImie() + " nie spełnia kryterium wiekowego do kursu " + this.NazwaKursu);
                break;
            case 4:
                uczestnicy[ilośćUczestników] = uczestnik;
                ilośćUczestników++;
                System.out.println("Dodano uczestnika " + uczestnik.zwróćImie() + " do kursu " + this.NazwaKursu);
                break;


        }
        return this;
    }


    public int czyMożnaUsunąć(Osoba uczestnik){
        for (int i = 0; i <= uczestnicy.length; i++){
            if(uczestnicy[i] == uczestnik) {
                return 1; //dobry do skasowania
            }
        }
        return 2; //nie ma uczestnika, ktorego chcesz skasowac w kursie
    }

    public void usunUczetnika(Osoba uczestnik) throws NullArgumentUsuwaniaException {
        if (uczestnik == null)
            throw new NullArgumentUsuwaniaException();
        if(uczestnicy.length == 0) {
            return; // nie ma z czego kasowac
        }
        int indexUczestnika = -1;
        for(int i=0; i<uczestnicy.length; i++) {
            if(uczestnicy[i] == uczestnik) {
                indexUczestnika = i;
                break;
            }
        }
        if(indexUczestnika == -1) {
            System.out.println("Kurs " + this.NazwaKursu + " nie ma uczestnika " + uczestnik.zwróćImie());
            return; //nie ma obiektu do skasowania
        }
        Osoba[] newArray = new Osoba[uczestnicy.length - 1];
        int newArrayIterator = 0;
        for(int i=0; i<uczestnicy.length; i++) {
            if(i == indexUczestnika) {
                continue; //skip (kasowanie)
            }
            newArray[newArrayIterator++] = uczestnicy[i];

        }
        uczestnicy = newArray;
    }

    public String getNazwaKursu(){
        return NazwaKursu;
    }
}
