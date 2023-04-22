package vedes.gyakorlas.musiccatalog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import vedes.gyakorlas.musiccatalog.data.model.Song;
import vedes.gyakorlas.musiccatalog.service.SongService;

import java.util.List;

@RequestMapping("/api/v1/song")//ezzel megmondom, hogy milyen útvonalon lesz majd a kontroller és a metódusai elérhetőek
public class MusicCatalogRestController {

    private final SongService songService;//fuggoseg
    @Autowired
    public MusicCatalogRestController(SongService songService) {
        this.songService = songService;
    }

    //CRUD create read update delete műveleteket kell csinálnia, ezért hozzuk létre a következőket

    @GetMapping("/{id}")//egyetlen 1 zenét vissza tudjon adni, ezért szeretnénk hogy legyen egy id ami megmondja hogy melyik az
    public Song getSongById(@PathVariable Long id){
        return songService.retrieveSongById(id); // ezzel a servicetől elkérjük id alapján a zenét
    }

    @GetMapping // összes elemet vissza adjuk
    public List<Song> getAllSongs(){ //listát ad vissza a zenékből
        return songService.retrieveAllSong();
    }
    @PostMapping
    public Song createSong(@RequestBody Song song){ //a kérésnek a tartalmában lesz benne az a json ami lekéri a zenét amit el szeretnénk menteni
        return songService.createSong(song);
    }

    @PutMapping //meglévőt frissítünk (a Post inkább egy új létrehozására van használva)
    public Song updateSong(@RequestBody Song song){
        return songService.updateSong(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSongById(@PathVariable Long id){
        songService.deleteSongById(id);
    }

}
