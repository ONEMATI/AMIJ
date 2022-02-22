/*
Metodo Main
 */
package album.music.in.java;

import dataaccess.*;
import domain.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author MatiasVeraLima
 */
public class AlbumMusicInJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        int option;
        Scanner input = new Scanner(System.in);
        /*
        Se utiliza Estructura "Switch", se realizando un menu de Opciones en primera insrtancia,
        se realizando al lectura de los case segun "option" y al final con el While se evalua
        si el numero ingresado es distinto de 4 (opcion para salir de menu).
        Tambien se utiliza SimpleDateFormat para dar formato deseado a la fecha 
         */
        DataAccess<Library> libraryData = new LibraryDB();
        DataAccess<PlayList> playlistData = new PlayListDB();
        do {
            System.out.println("1. Mostrar musica de la Bibliteca: ");
            System.out.println("2. Agregar cancion de la Biblioteca ");
            System.out.println("3. Crear Playlist ");
            System.out.println("4. Lista de Playlist: ");
            System.out.println("5. Agregar cancion a Playlist ");
            System.out.println("6. Listar canciones de la Playlist ");
            System.out.println("7. Eliminar cancion de la Playlist ");
            System.out.println("0. Salir");
            System.out.print("Ingrese Opcion: ");
            option = input.nextInt();
            switch (option) {
                case 1: {
                    Library library = libraryData.getById(0L);
                    library.getSongs().forEach(song -> {
                        System.out.print("Id: " + song.getId());
                        System.out.print(" - Titulo: " + song.getTitle());
                        System.out.print(" - Album: " + song.getCover());
                        System.out.print(" - Genero: " + song.getGender());
                        System.out.print(" - Fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(song.getDate()));
                        System.out.print(" - Descripcion: " + song.getDescription());
                        System.out.println();
                    });
                    break;
                }
                case 2: {
                    System.out.println("Ingrese titulo:  ");
                    String title = input.next();
                    System.out.println("Ingrese genero: ");
                    String gender = input.next();
                    System.out.println("Ingrese album:  ");
                    String cover = input.next();
                    System.out.println("Ingrese fecha (dd-MM-yyyy): ");
                    Date date = new SimpleDateFormat("dd-MM-yyyy").parse(input.next());
                    System.out.println("Ingrese descripcion: ");
                    String desc = input.next();
                    System.out.println("Ingrese duracion en milisegundos: ");
                    int duration = input.nextInt();
                    Song song = new Song(title, date, duration, gender, cover, desc);
                    libraryData.getById(0L).getSongs().add(song);
                    break;
                }
                case 3: {
                    System.out.println("Ingrese Nombre: ");
                    String name = input.next();
                    System.out.println("Ingrese Fecha de creacion: ");
                    Date d = new SimpleDateFormat("dd-MM-yyyy").parse(input.next());
                    PlayList playList = new PlayList();
                    playList.setName(name);
                    playList.setCreateAt(d);
                    playlistData.insert(playList);
                    break;
                }
                case 4: {
                    playlistData.list();
                    break;
                }
                case 5: {
                    System.out.println("Ingrese Id de la cancion: ");
                    Long id = input.nextLong();
                    Library library = libraryData.getById(0L);
                    Song song = library.getSongById(id);
                    if (song != null) {
                        System.out.println("Ingrese id de la Playlist: ");
                        Long playListId = input.nextLong();
                        playlistData.getById(playListId).addSong(song);
                    }
                    break;
                }
                case 6: {
                    System.out.println("Ingrese id de la Playlist: ");
                    Long playListId = input.nextLong();
                    playlistData.getById(playListId).showSongs();
                    break;
                }
                case 7: {
                    System.out.println("Ingrese id de la Playlist: ");
                    Long playListId = input.nextLong();
                    System.out.println("Ingrese id de la cancion para eliminar: ");
                    Long songId = input.nextLong();
                    playlistData.getById(playListId).deleteSong(songId);
                    break;
                }
                default: {
                    System.out.println("La opcion ingresada no es valida");
                    break;
                }
            }
        } while (option != 0);
    }

}
