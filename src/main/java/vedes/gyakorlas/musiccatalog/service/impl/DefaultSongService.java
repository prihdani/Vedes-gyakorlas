package vedes.gyakorlas.musiccatalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vedes.gyakorlas.musiccatalog.data.model.Song;
import vedes.gyakorlas.musiccatalog.data.repository.Repository;
import vedes.gyakorlas.musiccatalog.service.SongService;

import java.util.List;

@Service
public class DefaultSongService implements SongService {

    private final Repository<Song, Long> songRepository;//Mivel a létrehozott SongService repositoryt fogjuk használni, ezért lesz egy dependenciánk
//inicializáljuk a konstruktorral
    @Autowired
    public DefaultSongService(Repository<Song, Long> songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song retrieveSongById(Long id) {
        return songRepository.getById(id);
    }

    @Override
    public List<Song> retrieveAllSong() {
        return songRepository.getAll();
    }

    @Override
    public Song updateSong(Song song) {
        return songRepository.update(song);
    }

    @Override
    public void deleteSongById(Long id) {
        songRepository.deleteById(id);
    }
}
