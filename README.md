### Opis programu
W klasycznym ujęciu, rozwiązanie problemu urodzin polega na znalezieniu najmniejszej liczby osób takiej, żeby prawdopodobieństwo znalezienia dwóch osób obchodzących urodziny tego samego dnia było równe co najmniej ½. Daty urodzin wybierane są 
z rozkładem jednostajnym, nie uwzględnia się również lat przestępnych – urodzin 
29 lutego. Paradoks polega na tym, że ta liczba jest zaskakująco mała – potrzeba jedynie 23 osób, aby spełniony był ten warunek.
Przygotowany przeze mnie program rozszerza ten problem na wszystkie planety Układu Słonecznego – gdzie liczba dni w roku jest różna, a zatem najmniejsza liczba takich osób także się zmienia.
Problem ma oczywiście dokładne rozwiązanie opisane wzorem, jednak program ma je przetestować metodą eksperymentalną – generuje daty urodzin i sprawdza zgodność 
z warunkami.
Projekt zrealizowany jest w pełni w języku Java, a interakcja z użytkownikiem odbywa się przez konsolę.

### Wejście programu
Przy starcie program prosi użytkownika o wpisanie nazwy planety, dla której ma zostać obliczony problem urodzin. Użytkownik podaje polską nazwę dowolnej planety 
w Układzie Słonecznym, przy czym wielkość liter nie ma znaczenia.

### Wynik programu
Program dla wybranej planety oblicza najmniejszą liczbę osób spełniającą warunek problemu i wypisuje ją na ekran.
