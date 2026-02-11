# Ultimate-Tic-Tac-Toe
Zaawansowana wersja klasycznej gry w kółko i krzyżyk, zrealizowana w języku Java przy użyciu frameworka Swing. W odróżnieniu od standardowej wersji, Ultimate Tic-Tac-Toe wprowadza dodatkową warstwę strategiczną: gra toczy się na dziewięciu małych planszach ułożonych w jedną wielką deskę, gdzie ruch gracza w małym polu determinuje, na której planszy musi zagrać przeciwnik.

Kluczowe funkcjonalności
  Złożona Logika Gry: Implementacja zasad "Ultimate", w tym obsługa wygrywania poszczególnych małych plansz oraz blokowania pól w oparciu o ruchy przeciwnika.
  Tryb Singleplayer (AI): Możliwość gry przeciwko algorytmowi z opcjami wyboru trudności, co wymagało implementacji logiki automatycznych ruchów bota.
  System Historii Ruchów: Dynamiczna tabela (JTable), która w czasie rzeczywistym rejestruje każde zagranie (L.p., gracz, współrzędne planszy i pola).
  Architektura GUI: Modułowa budowa interfejsu oparta na CardLayout, co pozwala na płynne przechodzenie między menu głównym a różnymi trybami gry.
  Obsługa Eventów: Zaawansowane wykorzystanie ActionListener oraz autorskiego KeyListener do zarządzania interakcją użytkownika z interfejsem.
