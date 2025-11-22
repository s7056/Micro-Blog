# 📄 Specyfikacja wymagań funkcjonalnych dla projektu Micro Blog: 

## 1. Rejestracja 

|  ID |   Nazwa   |   Aktorzy  |    Przypadek użycia   | Priorytet |
| :-: | :-------: | :--------: | :-------------------: | :-------: |
|  MB-001  | Rejestracja użytkownika | Użytkownik, System | Niezbędny |   Wysoki  |
 
### Opis 

System umożliwia niezalogowanemu użytkownikowi utworzenie konta poprzez podanie unikalnego loginu/nicku, adresu e-mail, hasła oraz potwierdzenia hasła. Po poprawnej rejestracji użytkownik jest automatycznie logowany i przenoszony na swoją linię czasu.

### Warunki początkowe: 

- Użytkownik nie posiada konta. 

### Kryteria akceptacji: 

- Formularz poprawnie waliduje pola. 
- System tworzy konto po poprawnym wypełnieniu formularza. 

### Scenariusz główny: 

1. Użytkownik otwiera stronę rejestracji. 
2. Wprowadza wymagane dane. 
3. System weryfikuje formularz. 
4. Konto zostaje utworzone i użytkownik otrzymuje możliwość logowania. 

### Scenariusze alternatywne i rozszerzenia: 

- System wyświetla komunikat o zajętej nazwie użytkownika lub emailu. 
- Użytkownik wprowadza niepoprawne dane → system wyświetla błędy walidacji. 

## 2. Logowanie 

|  ID |   Nazwa   |   Aktorzy  |    Przypadek użycia   | Priorytet |
| :-: | :-------: | :--------: | :-------------------: | :-------: |
|  MB-002  | Logowanie | Użytkownik, System | Niezbędny |   Wysoki  |
 
### Opis 
 
Użytkownik podaje login/e-mail i hasło. Po poprawnej weryfikacji zostaje przeniesiony na swoją linię czasu. System obsługuje zapamiętywanie sesji (np. przez cookie).

### Warunki początkowe: 

- Użytkownik posiada aktywne konto w systemie. 

### Kryteria akceptacji: 

- Formularz poprawnie waliduje pola login/e-mail i hasło. 
- Użytkownik po poprawnym zalogowaniu zostaje przeniesiony na swoją stronę główną - "linia czasu". 
- System informuje użytkownika o błędach logowania w przypadku niepoprawnych danych. 

### Scenariusz główny: 

1. Użytkownik otwiera stronę logowania. 
2. Wprowadza login/e-mail i hasło. 
3. System weryfikuje poprawność danych. 
4. Użytkownik zostaje zalogowany i przekierowany na swoją linię czasu. 

### Scenariusze alternatywne i rozszerzenia: 

- Użytkownik wprowadza niepoprawny login lub hasło → system wyświetla komunikat o błędzie. 
- System pozwala użytkownikowi odzyskać hasło w przypadku jego zapomnienia.
- System automatycznie kończy sesję po zbyt długim braku aktywności.

## 3. Wylogowanie 

|  ID |   Nazwa   |   Aktorzy  |    Przypadek użycia   | Priorytet |
| :-: | :-------: | :--------: | :-------------------: | :-------: |
|  MB-003  | Wylogowanie | Użytkownik, System | Niezbędny |   Wysoki  |
 
### Opis 
 
Zalogowany użytkownik może wylogować się z systemu. Po wylogowaniu sesja jest niszczona i użytkownik wraca na stronę logowania.

### Warunki początkowe: 

- Użytkownik jest zalogowany w systemie. 

### Kryteria akceptacji

- Sesja użytkownika zostaje poprawnie zakończona.  
- Po wylogowaniu użytkownik nie ma dostępu do zasobów wymagających logowania.  
- System przekierowuje użytkownika na stronę logowania.  

### Scenariusz główny

1. Użytkownik klika przycisk "Wyloguj".  
2. System kończy sesję użytkownika.  
3. Użytkownik zostaje przekierowany na stronę logowania.  

### Scenariusze alternatywne i rozszerzenia

- Jeśli sesja użytkownika wygasła przed wylogowaniem → system i tak przekierowuje na stronę logowania.  
- System może zapamiętać preferencje użytkownika (np. język) nawet po wylogowaniu.

## 4. Reset hasła

|  ID |   Nazwa   |   Aktorzy  |    Przypadek użycia   | Priorytet |
| :-: | :-------: | :--------: | :-------------------: | :-------: |
|  MB-004  | Reset hasła  | Użytkownik, System | Niezbędny |   Wysoki  |

### Opis

Użytkownik, który zapomniał hasła, może je zresetować, otrzymując link resetujący na e-mail powiązany z kontem.

### Warunki początkowe

- Użytkownik posiada konto w systemie i dostęp do zarejestrowanego e-maila.

### Kryteria akceptacji

- System wysyła poprawny link resetujący hasło na adres e-mail użytkownika.  
- Link resetujący wygasa po określonym czasie lub po użyciu.  
- Użytkownik może ustawić nowe hasło spełniające wymagania systemu.  

### Scenariusz główny

1. Użytkownik wybiera opcję "Zapomniałem hasła".  
2. Wprowadza swój login lub e-mail.  
3. System wysyła e-mail z linkiem resetującym hasło.  
4. Użytkownik klika link i ustawia nowe hasło.  
5. System potwierdza zmianę hasła i umożliwia logowanie nowym hasłem.  

### Scenariusze alternatywne i rozszerzenia

- Użytkownik wprowadza nieistniejący e-mail → system wyświetla komunikat o błędzie.  
- Link resetujący wygasł → system umożliwia ponowne wysłanie linku.  
- System wymaga, aby nowe hasło spełniało określone kryteria bezpieczeństwa (np. minimalna długość, znaki specjalne).

## 5. Tworzenie nowego posta

|  ID |   Nazwa   |   Aktorzy  |    Przypadek użycia   | Priorytet |
| :-: | :-------: | :--------: | :-------------------: | :-------: |
|  MB-005  | Tworzenie posta  | Użytkownik, System | Niezbędny |   Wysoki  |

### Opis

Użytkownik może tworzyć nowe posty, które będą widoczne na jego linii czasu i dla obserwujących.

### Warunki początkowe

- Użytkownik jest zalogowany.  

### Kryteria akceptacji

- System pozwala na wprowadzenie treści posta.  
- Post zostaje zapisany w systemie i wyświetlony na linii czasu.  
- System waliduje długość i zawartość posta.

### Scenariusz główny

1. Użytkownik otwiera formularz tworzenia posta.  
2. Wprowadza treść posta.  
3. System zapisuje post i wyświetla go na linii czasu.

### Scenariusze alternatywne i rozszerzenia

- Post zawiera niedozwolone słowa lub zbyt długi tekst → system wyświetla komunikat o błędzie.  
- Użytkownik dodaje zdjęcia lub multimedia → system je zapisuje i wyświetla w poście.

## 6. Wyświetlanie linii czasu

|  ID |   Nazwa   |   Aktorzy  |    Przypadek użycia   | Priorytet |
| :-: | :-------: | :--------: | :-------------------: | :-------: |
|  MB-006  |  Wyświetlanie linii czasu  | Użytkownik, System | Niezbędny |   Wysoki  |

### Opis

System wyświetla posty użytkownika oraz posty obserwowanych osób w kolejności chronologicznej.

### Warunki początkowe

- Użytkownik jest zalogowany.  

### Kryteria akceptacji

- Posty wyświetlane są w odpowiedniej kolejności.  
- System pokazuje wszystkie dostępne informacje (autor, treść, czas publikacji).

### Scenariusz główny

1. Użytkownik otwiera swoją linię czasu.  
2. System pobiera i wyświetla posty.

### Scenariusze alternatywne i rozszerzenia

- Brak postów → system wyświetla komunikat „Brak postów do wyświetlenia”.  
- System umożliwia przewijanie historii postów (scroll, stronicowanie).

## 7. Wyświetlanie publicznych postów dla niezalogowanych

|  ID |   Nazwa   |   Aktorzy  |    Przypadek użycia   | Priorytet |
| :-: | :-------: | :--------: | :-------------------: | :-------: |
|  MB-007  |  Publiczne posty  | Użytkownik, System | Niezbędny |   Średni  |

### Opis
Niezalogowani użytkownicy mogą przeglądać wybrane publiczne posty.

### Warunki początkowe
- Użytkownik nie jest zalogowany.  

### Kryteria akceptacji
- Publiczne posty są widoczne.  
- Brak możliwości komentowania lub polubienia postów.  

### Scenariusz główny
1. Gość otwiera stronę z publicznymi postami.  
2. System wyświetla listę postów publicznych.

### Scenariusze alternatywne i rozszerzenia
- Brak publicznych postów → komunikat „Brak publicznych postów do wyświetlenia”.

## 8. Przeglądanie profilu innego użytkownika

|  ID |   Nazwa   |   Aktorzy  |    Przypadek użycia   | Priorytet |
| :-: | :-------: | :--------: | :-------------------: | :-------: |
|  MB-008  |  Przeglądanie profilu  | Użytkownik, System | Niezbędny |   Wysoki  |

### Opis

Użytkownik może przeglądać profil innego użytkownika, w tym jego posty i informacje publiczne.

### Warunki początkowe

- Użytkownik jest zalogowany.  

### Kryteria akceptacji

- System wyświetla wszystkie dostępne informacje o profilu.  
- Posty i dane zgodnie z ustawieniami prywatności.

### Scenariusz główny

1. Użytkownik otwiera profil innego użytkownika.  
2. System wyświetla profil, posty i informacje publiczne.

### Scenariusze alternatywne i rozszerzenia

- Profil prywatny → system wyświetla komunikat „Profil prywatny”.  
- Możliwość obserwowania użytkownika z poziomu profilu.

## 9. Obserwowanie użytkownika (Follow)

|  ID |   Nazwa   |   Aktorzy  |    Przypadek użycia   | Priorytet |
| :-: | :-------: | :--------: | :-------------------: | :-------: |
|  MB-009  |  Follow  | Użytkownik, System | Niezbędny |   Wysoki  |

### Opis

Użytkownik może obserwować innych użytkowników, aby widzieć ich posty w swojej linii czasu.

### Warunki początkowe

- Użytkownik jest zalogowany.  
- Obserwowany użytkownik istnieje w systemie.

### Kryteria akceptacji

- System rejestruje obserwowanie.  
- Posty obserwowanego użytkownika pojawiają się w linii czasu obserwującego.

### Scenariusz główny

1. Użytkownik klika przycisk „Obserwuj” na profilu innego użytkownika.  
2. System zapisuje obserwowanie i aktualizuje listę obserwowanych.

### Scenariusze alternatywne i rozszerzenia

- Użytkownik już obserwuje → przycisk zmienia się na „Obserwowany”.  
- System wysyła powiadomienie obserwowanemu użytkownikowi.

## 10. Przestanie obserwowania (Unfollow)

|  ID |   Nazwa   |   Aktorzy  |    Przypadek użycia   | Priorytet |
| :-: | :-------: | :--------: | :-------------------: | :-------: |
|  MB-010  |  Unfollow  | Użytkownik, System | Niezbędny |   Wysoki  |

### Opis

Użytkownik może przestać obserwować innego użytkownika, aby jego posty nie pojawiały się w linii czasu.

### Warunki początkowe

- Użytkownik jest zalogowany.  
- Użytkownik aktualnie obserwuje wybranego użytkownika.

### Kryteria akceptacji

- System usuwa obserwowanie.  
- Posty przestają pojawiać się w linii czasu.

### Scenariusz główny

1. Użytkownik klika przycisk „Przestań obserwować” na profilu użytkownika.  
2. System usuwa obserwowanie i aktualizuje listę obserwowanych.

### Scenariusze alternatywne i rozszerzenia

- Użytkownik nie obserwuje wybranego użytkownika → przycisk nieaktywny.  

## 11. Wyświetlanie listy obserwowanych (Following)

|  ID |   Nazwa   |   Aktorzy  |    Przypadek użycia   | Priorytet |
| :-: | :-------: | :--------: | :-------------------: | :-------: |
|  MB-011  |  Lista Following  | Użytkownik, System | Niezbędny |   Średni  |

### Opis

Użytkownik może przeglądać listę osób, które obserwuje.

### Warunki początkowe

- Użytkownik jest zalogowany.

### Kryteria akceptacji

- System wyświetla aktualną listę obserwowanych użytkowników.  
- Możliwość wejścia na profil obserwowanego użytkownika.

### Scenariusz główny

1. Użytkownik otwiera zakładkę „Following”.  
2. System wyświetla listę obserwowanych użytkowników.

### Scenariusze alternatywne i rozszerzenia

- Brak obserwowanych użytkowników → komunikat „Nie obserwujesz nikogo”.

## 12. Wyświetlanie listy obserwujących (Followers)

|  ID |   Nazwa   |   Aktorzy  |    Przypadek użycia   | Priorytet |
| :-: | :-------: | :--------: | :-------------------: | :-------: |
|  MB-012  |  Lista Followers  | Użytkownik, System | Niezbędny |   Średni  |

### Opis

Użytkownik może przeglądać listę osób, które go obserwują.

### Warunki początkowe

- Użytkownik jest zalogowany.

### Kryteria akceptacji

- System wyświetla aktualną listę obserwujących użytkowników.  
- Możliwość wejścia na profil obserwującego użytkownika.

### Scenariusz główny

1. Użytkownik otwiera zakładkę „Followers”.  
2. System wyświetla listę obserwujących.

### Scenariusze alternatywne i rozszerzenia

- Brak obserwujących użytkowników → komunikat „Nikt Cię jeszcze nie obserwuje”.
