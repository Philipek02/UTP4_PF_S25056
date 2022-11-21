/**
 *
 *  @author Pańczak Filip S25056
 *
 */

package zad2;


public class Purchase {
   private final String id_klienta;
   private final String nazwisko;
   private final String imie;
   private final String nazwa_towaru;
   private final double cena;
   private final double ilosc;

   public Purchase(String id_klienta, String nazwisko, String imie, String nazwa_towaru, double cena, double ilosc) {
      this.id_klienta = id_klienta;
      this.nazwisko = nazwisko;
      this.imie = imie;
      this.nazwa_towaru = nazwa_towaru;
      this.cena = cena;
      this.ilosc = ilosc;
   }


   public String getId_klienta() {
      return id_klienta;
   }

   public String getImie() {
      return imie;
   }

   public String getNazwa_towaru() {
      return nazwa_towaru;
   }

   public double getCena() {
      return cena;
   }

   public double getIlosc() {
      return ilosc;
   }

   public String getNazwisko() {
      return nazwisko;
   }

   @Override
   public String toString() {
      return "Purchase{" +
              "id_klienta='" + id_klienta + '\'' +
              ", nazwisko='" + nazwisko + '\'' +
              ", imie='" + imie + '\'' +
              ", nazwa_towaru='" + nazwa_towaru + '\'' +
              ", cena=" + cena +
              ", ilosc=" + ilosc +
              '}';
   }
}
