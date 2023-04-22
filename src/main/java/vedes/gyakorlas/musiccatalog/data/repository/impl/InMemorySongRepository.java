package vedes.gyakorlas.musiccatalog.data.repository.impl;

import vedes.gyakorlas.musiccatalog.data.model.Song;
import vedes.gyakorlas.musiccatalog.data.repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO.
 */
//Ez az egész osztály a memóriában tárolást végzi el
@org.springframework.stereotype.Repository
public class InMemorySongRepository implements Repository<Song, Long> {

    private static final Map<Long, Song> STORAGE = new HashMap<>();//belső tároló
    @Override
    public Song save(Song song) {
        Long id = STORAGE.size() + 1L;
        song.setId(id);//amikor valami el szeretnenk menteni, elkuldjuk a requestet, de az id-t még nem tudjuk, ezért ezt állítjuk itt be
        STORAGE.put(id,song); //elmenti az aktuális állapotra
        return STORAGE.get(id);//visszatér az újonnan beillesztett zenével

    }

    @Override
    public Song getById(Long id) {
        return STORAGE.get(id);
    }

    @Override
    public List<Song> getAll() { // az összes eltárolt érték kell nekünk innen, listaként kapjuk meg
        return STORAGE.values().stream().toList();
    }

    @Override
    public Song update(Song song) {
        Long id = song.getId();//kiválasztjuk az adatbázisból a megfelelő elemet
        STORAGE.put(id,song);
        return STORAGE.get(id);// a frissen beillesztett értékkel visszatér
    }

    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);
    }
}
