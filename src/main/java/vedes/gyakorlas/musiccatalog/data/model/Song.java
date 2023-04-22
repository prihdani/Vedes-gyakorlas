package vedes.gyakorlas.musiccatalog.data.model;

import java.util.Objects;
import java.util.StringJoiner;

/**
*Model class for songs.
 */
public class Song {

    private Long id;
    private String title;
    private String artist;
    private String album;
    private Genre genre;

    public Song(){

    }

    public Song(Long id, String title, String artist, String album, Genre genre) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song song)) return false;
        return Objects.equals(getId(), song.getId()) && Objects.equals(getTitle(), song.getTitle()) && Objects.equals(getArtist(), song.getArtist()) && Objects.equals(getAlbum(), song.getAlbum()) && getGenre() == song.getGenre();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getArtist(), getAlbum(), getGenre());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Song.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("artist='" + artist + "'")
                .add("album='" + album + "'")
                .add("genre=" + genre)
                .toString();
    }
}
