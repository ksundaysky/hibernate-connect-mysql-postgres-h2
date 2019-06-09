# Install and start database servers

Zadanie:
Stwórz generator wartości typu TABLE, użyj go dla encji Autor i Bookstore.
Skonfiguruj go następująco:
nazwa tabeli z generatorem = tabela_generator_wartosci,
początkowa wartośc dla generatora = 50,
rozmiar rezerowany dla pojedynczej sesji = 100,
nazwa kolumny, która wskazuje na dany generator - tabele,
nazwa generatora - id_tabela_autor,
nazwa kolumny z kolejnymi wartościami dla generowania id - wartosc_id,
wykonaj program i zaobserwuj, co się zmieniło w bazie danych


Stwórz generator wartości typu SEQUENCE, użyj go dla encji Book.
Skonfiguruj go następująco:
nazwa generatora - "moja_sekwencja",
nazwa sekwencji - superSekwencja,
początkowa wartośc dla generatora = 10,
rozmiar rezerowany dla pojedynczej sesji = 5,
wykonaj program i zaobserwuj, co się zmieniło w bazie danych

