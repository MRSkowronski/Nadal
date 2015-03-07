public class KursTest {

    public static Kurs najliczniejszy(Kurs []kursy){
        int liczbaKursu = 0;
        Kurs kursnajliczniejszy = kursy[0];
        for(int i = 0; i <= kursy.length; i++){
            if (kursy[i].ilośćUczestników > liczbaKursu){
                liczbaKursu = kursy[i].ilośćUczestników;
                kursnajliczniejszy = kursy[i];
            }
        }
        return kursnajliczniejszy;
    }

    public static void main(String[] args) {

        // utworzenie kursu z nazwą, dolnym limitem wiekowym (np. 3), górnym limitem uczestników (np. 4)
        Kurs java = new Kurs("Java", 3, 4), cpp = new Kurs("C++", 2, 2);

        // tablica kursów
        Kurs[] kursy = {java, cpp};

        // utworzenie potencjalnych uczestników kursów z imieniem i wiekiem
        Osoba janek = new Osoba("Janek", 6), adas = new Osoba("Adaś", 3), aleks = new Osoba("Aleks", 2), zosia = new Osoba("Zosia", 4), lenka = new Osoba("Lenka", 5);

        try {
            java.dodajUczestnika(adas);    // próba zapisywania osoby (np. adas) na kurs (np. java)
            java.dodajUczestnika(janek);
            java.dodajUczestnika(aleks);
            java.dodajUczestnika(zosia);
            java.dodajUczestnika(lenka);
            java.dodajUczestnika(lenka).dodajUczestnika(aleks);

            System.out.println();

            cpp.dodajUczestnika(aleks);    // próba zapisywania osoby (np. aleks) na inny kurs (np. cpp)
            cpp.dodajUczestnika(janek);

            System.out.println();

            java.dodajUczestnika(null);    // błędnie podana osoba przy zapisywaniu na kurs
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n" + java + "\n");

        try {
            java.usunUczetnika(aleks);        // próba usunięcia uczestnika z kursu
            java.usunUczetnika(janek);

            System.out.println();

            java.usunUczetnika(null);         // błędnie podana osoba przy usunięciu z kursu
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n" + java);
        System.out.println(cpp + "\n");

        // najliczniejszy(...) jest metodą statyczną klasy KursTest, zwracającą kurs z największą liczbą uczestników
        // trzeba dopisać tę metodę
        System.out.println("Kurs z największą liczbą uczestników: " + najliczniejszy(kursy).getNazwaKursu());
    }
}