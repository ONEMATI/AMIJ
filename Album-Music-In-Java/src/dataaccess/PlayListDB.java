/*
Clase Base de datos de Lista de Reproduccion
 */
package dataaccess;

import domain.PlayList;
import domain.Song;
import exceptions.PlayListNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MatiasVeraLima
 */
public class PlayListDB implements DataAccess<PlayList> {

    private List<PlayList> playL;

    public PlayListDB() {
        this.playL= new ArrayList<>();
    }

    @Override
    public void insert(PlayList objet) {
        if (objet != null) {
            this.playL.add(objet);
        }
    }

    @Override
    public void list() {
        if (playL.size() > 0) {
            this.playL.forEach(playL -> {
                System.out.print("Id:" + playL.getId());
                System.out.print("Nombre de cancion: " + playL.getName());
                System.out.print("Numero de canciones:" + playL.getNumSong());
                System.out.println("Fecha de creacio: " + new SimpleDateFormat("dd-MM-yyyy").format(playL.getCreateAt()));
            });
        } else {
            System.out.println("No se creo niguna Playlist!");
        }
    }

    @Override
    public void update(PlayList objet) {
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public PlayList getById(Long id) {
        return playL.stream().filter(p -> p.getId().equals(id)).findAny().orElseThrow(()->new PlayListNotFoundException("No se encontro Playlist"));
    }

}
