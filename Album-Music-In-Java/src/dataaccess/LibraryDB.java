/*
Clase Base de datos de Biblioteca 
 */
package dataaccess;

import domain.Library;
import domain.Song;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author MatiasVeraLima
 */
public class LibraryDB implements DataAccess<Library> {
    private List<Library> libraries;
    public LibraryDB() throws ParseException {
        this.libraries = new ArrayList<>();
        List<Song> defaultLibrary = Arrays.asList(
                new Song("Pepe", new SimpleDateFormat("dd-MM-yyyy").parse("10-01-2000"), 300, "Rock", "Album.jpg", "Primer Album de Pepe Rock"),
                new Song("Hulk", new SimpleDateFormat("dd-MM-yyyy").parse("12-01-2022"), 300, "Latino", "Cap.jpg", "Primer Album de Hulk"),
                new Song("Thor", new SimpleDateFormat("dd-MM-yyyy").parse("13-01-2000"), 300, "Pop", "Album.jpg", "Primer Album de thor"),
                new Song("Capitan America", new SimpleDateFormat("dd-MM-yyyy").parse("11-01-2000"), 300, "Regaee", "Album.jpg", "Primer Album de Cap"),
                new Song("Loki", new SimpleDateFormat("dd-MM-yyyy").parse("15-01-2000"), 300, "Lok", "Album.jpg", "Primer Album de Loki")
        );
        Library library = new Library("Bibloteca por defecto", defaultLibrary);
        this.libraries.add(library);
    }
    
    @Override
    public void insert(Library objet) {
        if (objet !=  null){
            this.libraries.add(objet);
        }
    }

    @Override
    public void list() {
        this.libraries.forEach(lib->{
            System.out.println("Nombre: " + lib.getLibraryName());
        });
    }

    @Override
    public void update(Library objet) {
        
    }

    @Override
    public void delete(Long id) {
        
    }

    @Override
    public Library getById(Long id) {
        return libraries.stream().filter(l->l.getId().equals(id)).findAny().orElse(null);
    }
    
}
