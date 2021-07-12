### Wymagane 
JAVA 11  
Maven  
Uruchomiona baza danych z folderu "mysql" położonego wyżej.

### Sprawdzone na:
Intellij IDEA 2020+

### Dodatkowo (opcjonalne)
Folder .run dla uruchomienia aplikacji z IntelliJ IDEA.


# Start  
W folderze "experience" nalezy uruchomić:  
 mvn clean install

A gdy już zakończy to uruchomić spring boota:  
 mvn spring-boot:run
 
## RESTy
 localhost:8080/api/users/{name}
