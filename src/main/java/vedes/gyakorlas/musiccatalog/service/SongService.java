package vedes.gyakorlas.musiccatalog.service;

import vedes.gyakorlas.musiccatalog.data.model.Song;

import java.util.List;

/**
 * TODO.
 * */
public interface SongService {

    /**
     * TODO.
     * @param song TODO.
     * @return TODO.
     * */

    Song createSong(Song song);

    Song retrieveSongById(Long id);

    List<Song> retrieveAllSong();

    Song updateSong(Song song);

    void deleteSongById(Long id);
}
