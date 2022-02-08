
package rzutowaniewdol.latebinding;
/**
 * 
 * @author pawelstradomski
 */

public class RzutowanieWdolLateBinding {

    
    public static void main(String[] args) {
        
        Osoba[] person = new Osoba[4];
        person[0] = new Pracownik("Pawel", "Gawel", 50000);
        person[1] = new Student("Mietek", "Brzuchomowca");
        

//            for(Osoba czlowiek: person) // ulepszona petla for - enhanced for
//            {
//               if(czlowiek instanceof Osoba) // sprawdzenie czy person(pracownik i student)naleza do kl.Osoba
//                   czlowiek.pobierzOpis();
//                                            //np tutaj bez rzutowania nie wywola sie instrukcja czlowiek.pracuj
//               else
//                   break;
//               
//            }
            // przyklad z rzutowaniem
            for(Osoba czlowiek: person)
            {
                if(czlowiek instanceof Pracownik) // zamieniamy Osoba na Pracownik lub Student
                {
                    ((Pracownik)czlowiek).pracuj();    //rzutowanie w dol do klasy Pracownik lub Student
                                                       // teraz mamy dostep do kl.pracuj
                }
                    
            }
            
    }
    
}
abstract class Osoba
{
    String imie;
    String nazwisko;
    
    Osoba(String imie, String nazwisko)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    abstract void pobierzOpis();
    
}
class Pracownik extends Osoba
{
    double wynagrodzenie;
    
    Pracownik(String imie, String nazwisko, double wynagrodzenie)
    {
        super(imie, nazwisko);
        this.wynagrodzenie = wynagrodzenie;
    }

    @Override
    void pobierzOpis() 
    {
        System.out.println("Jestem pracownikiem");
        System.out.println("Imie: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Wynagrodzenie: " + wynagrodzenie);
    }
    void pracuj()
    {
        System.out.println("ja pracuje"); // aby ta instrukcja zadzialala nalezy dokonac rzutowania w dol
    }
    
}
class Student extends Osoba
{
    Student(String imie, String nazwisko)
    {
        super(imie, nazwisko);
        
    }

    @Override
    void pobierzOpis() 
    {
        System.out.println("Jestem studentem");
        System.out.println("Imie: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        
    }
    
}