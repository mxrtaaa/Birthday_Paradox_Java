import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Wpisz nazwę planety, dla której przeprowadzić test: ");
        Scanner in  = new Scanner(System.in);

        int planetNumber = -1;
        try{
            String planetName =  in.nextLine();
            SolarSystem solarSystem = new SolarSystem();

            for (int i = 0; i < solarSystem.planetNames.length; i++){
                if(planetName.compareToIgnoreCase(solarSystem.planetNames[i])==0){
                    planetNumber = i;
                    break;
                }
            }
            if(planetNumber == -1){
                System.out.println("Taka planeta nie istnieje!");
                return;
            }
        } catch(Exception e){
            System.out.println("Wystąpił błąd!");
            return;
        }

        Planet planet = new Planet(planetNumber);
        Birthdays birthdays = new Birthdays(planet);

        System.out.println("Najmniejsza liczba osób, które spełniają warunek: " + birthdays.birthdayParadox());
    }
}
class SolarSystem {
    protected String [] planetNames = new String [] {"Merkury", "Wenus", "Ziemia", "Mars", "Jowisz", "Saturn", "Uran", "Neptun"};
    protected int [] planetsDaysInYear = new int [] {88, 225, 365, 687, 4333, 10756, 30708, 60223};

    SolarSystem(){}
}

class Planet extends SolarSystem {
    protected String planetName;
    protected int planetNumber;
    protected int daysInYear;

    Planet(){}
    Planet(int planetNumber){
        this.planetNumber = planetNumber;
        if (planetNumber >= 0 && planetNumber < planetNames.length) {
            this.planetName = this.planetNames[planetNumber];
            this.daysInYear = this.planetsDaysInYear[planetNumber];
        }
    }
}

class Birthdays{
    private Planet planet;

    public int[] generateRandomBirthdays(int n) {
        int[] birthdays = new int[n];

        for(int i = 0; i < n; ++i) {
            birthdays[i] = (int)((double)this.planet.daysInYear * Math.random()) + 1;
        }

        return birthdays;
    }

    private double sameBirthdayChances(int n) {
        int tests = 20000;
        int areSame = 0;

        for(int i = 0; i < tests; ++i) {
            int[] birthdays = this.generateRandomBirthdays(n);

            for(int j = 0; j < n - 1; ++j) {
                int k;
                for(k = j + 1; k < n; ++k) {
                    if (birthdays[k] == birthdays[j]) {
                        areSame++;
                        break;
                    }
                }
                if (k < n)
                    break;
            }
        }

        return (double)areSame / (double)tests;
    }

    public int birthdayParadox() {
        int n = 2;

        double chances;
        do {
            chances = this.sameBirthdayChances(n);
            n++;
        } while(chances < 0.5);

        return n - 1;
    }

    Birthdays() {}

    Birthdays(Planet planet) {
        this.planet = planet;
    }
}