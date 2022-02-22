/*
Clase Lista de Reproduccion 
 */
package domain;

import exceptions.SongNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MatiasVeraLima
 */
public class PlayList {

    private static Long idNum;
    private Long id;
    private List<Song> playlist;
    private String name;
    private int numSong;
    private Date createAt;
/**
 * constructo vacio
 */
    public PlayList() {
        this.id = idNum;
        idNum++;
    }
/**
 * get and set 
 */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getPlaylist() {
        return this.playlist;
    }

    public void setPlaylist(List<Song> playlist) {
        this.playlist = playlist;
    }

    public int getNumSong() {
        return this.numSong;
    }

    public void setNumSong(int numSong) {
        this.numSong = numSong;
    }

    public Date getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public static Long getIdNum() {
        return idNum;
    }

    public static void setIdNum(Long idNum) {
        PlayList.idNum = idNum;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PlayList{" + "id=" + id + " ,Nombre=" + name + ", playlist=" + playlist + ", numSong=" + numSong + ", createAt=" + createAt + '}';
    }
/**
 * Constructor agrega cancion a la playlist
 * @param song tipo Song 
 */
    public void addSong(Song song) {
        if (song != null) {
            this.playlist.add(song);
        }
    }
/**
 * Metodo que agrega cancion con todos los argumentos de la Clase Song
 */
    public void showSongs() {
        this.playlist.forEach(song -> {
            System.out.print("Id: " + song.getId());
            System.out.print(" - Titulo: " + song.getTitle());
            System.out.print(" - Album: " + song.getCover());
            System.out.print(" - Genero: " + song.getGender());
            System.out.print(" - Fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(song.getDate()));
            System.out.print(" - Descripcion: " + song.getDescription());
            System.out.println();
        });
    }
/**
 * Metodo elimina cancion de la playlist
 * @param songId identificador de la cancion tipo Long
 */
    public void deleteSong(Long songId) {
        if (songId != null) {
            Song song = this.playlist.stream().filter(s -> s.getId().equals(songId))
                    .findFirst().orElseThrow(() -> new SongNotFoundException("No existe la Cancion"));
            this.playlist.remove(song);
        }
    }
}
