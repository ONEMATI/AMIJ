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
    
    public Library() {
        this.id = idNum;
        idNum++;
        this.songs = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }


    public List<Song> getSongs() {
        return songs;
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
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    
    public Song getSongById(Long id){
        return this.songs.stream().filter(s->s.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new SongNotFoundException("No se encontro la cancion"));
    }
}
