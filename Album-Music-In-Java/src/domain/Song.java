/*
Clase Musica
 */
package domain;

import java.util.Date;

/**
 *
 * @author MatiasVeraLima
 */
public class Song {
    private static Long idNum = 0L;
    private String title;
    private Long id;
    private Date date;
    private int durationInSec;
    private String gender;
    private String cover;
    private String description;
/**
 * Constructor vacio 
 * inicio id 
 * auto incrementable
 */
    public Song() {
        this.id = idNum;
        idNum++;
    }

    /**
     * get and set
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDurationInSec() {
        return durationInSec;
    }

    public void setDurationInSec(int durationInSec) {
        this.durationInSec = durationInSec;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
/**
 * Constructor con todos los elementos
 * @param title titulo de la cancion
 * @param date fecha de creacion
 * @param durationInSec duracion en segundos
 * @param gender genero
 * @param cover portada
 * @param description descripcion corta de la cancion
 */
    public Song(String title, Date date, int durationInSec, String gender, String cover, String description) {
        this.title = title;
        this.date = date;
        this.durationInSec = durationInSec;
        this.gender = gender;
        this.cover = cover;
        this.description = description;
        this.id = idNum;
        idNum++;
    }

    @Override
    public String toString() {
        return "Song{" + "title=" + title + ", id=" + id + ", date=" + date + ", durationInSec=" + durationInSec + ", gender=" + gender + ", cover=" + cover + ", description=" + description + '}';
    }
    
    
}
