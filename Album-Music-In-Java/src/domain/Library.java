/*
Clase Biblioteca 
 */
package domain;

import exceptions.SongNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author MatiasVeraLima
 */

public class Library {
    private static Long idNum=0L;
    private Long id;
    private String libraryName;
    private List<Song> songs;
    /**
     * Constructor vacio
     */
    public Library() {
        this.id = idNum;
        idNum++;
        this.songs = new ArrayList<>();
    }
/**
 * get and set 
 */
    public String getLibraryName() {
        return this.libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }


    public List<Song> getSongs() {
        return this.songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public static Long getIdNum() {
        return idNum;
    }

    public static void setIdNum(Long idNum) {
        Library.idNum = idNum;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/**
 * Constructor con 
 * @param nameSong nombre de la cancion
 * @param songs lista de canciones 
 */
    public Library(String nameSong, List<Song> songs) {
        this.libraryName = nameSong;
        this.songs = songs;
        this.id = idNum;
        idNum++;
    }

    @Override
    public String toString() {
        return "Library{" + "id=" + id + ", libraryName=" + libraryName + ", songs=" + songs + '}';
    }
    /**
     * Metodo envio de cancion por identificador.
     * Uso API de stream para buscar el id de la cancion para filtrar si existe en la 
     * biblioteca
     * @param id identificador de la cancion
     * @return cancion o mensaje excepcion
     */
    
    public Song getSongById(Long id){
        return this.songs.stream().filter(s->s.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new SongNotFoundException("No se encontro la cancion"));
    }
}
