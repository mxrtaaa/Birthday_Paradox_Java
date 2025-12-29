//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Objects;

final class Main {
    void main(String[] args) {
        Birthdays birthdays = new Birthdays(2);
        System.out.println("Najmniejsza liczba osób, które spełniają warunek: " + birthdays.birthdayParadox());
    }

    class Birthdays {
        int planet;
        int daysInYear;

        int[] generateRandomBirthdays(int n) {
            int[] birthdays = new int[n];

            for(int i = 0; i < n; ++i) {
                birthdays[i] = (int)((double)this.daysInYear * Math.random()) + 1;
            }

            return birthdays;
        }

        double sameBirthdayChances(int n) {
            int tests = 20000;
            int areSame = 0;

            for(int i = 0; i < tests; ++i) {
                int[] birthdays = this.generateRandomBirthdays(n);

                for(int j = 0; j < n - 1; ++j) {
                    int k;
                    for(k = j + 1; k < n; ++k) {
                        if (birthdays[k] == birthdays[j]) {
                            ++areSame;
                            break;
                        }
                    }

                    if (k < n) {
                        break;
                    }
                }
            }

            return (double)areSame / (double)tests;
        }

        int birthdayParadox() {
            int n = 2;

            double chances;
            do {
                chances = this.sameBirthdayChances(n);
                ++n;
            } while(chances < (double)0.5F);

            return n - 1;
        }

        Birthdays() {
            this.planet = 2;
            this.daysInYear = 365;
        }

        Birthdays(int planet) {
            this.planet = planet;
            switch (planet) {
                case 0 -> this.daysInYear = 88;
                case 1 -> this.daysInYear = 225;
                case 2 -> this.daysInYear = 365;
                case 3 -> this.daysInYear = 687;
                case 4 -> this.daysInYear = 4333;
                case 5 -> this.daysInYear = 10756;
                case 6 -> this.daysInYear = 30708;
                case 7 -> this.daysInYear = 60223;
                default -> this.daysInYear = 365;
            }

        }
    }
}
