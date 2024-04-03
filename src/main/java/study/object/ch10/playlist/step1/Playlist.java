package study.object.ch10.playlist.step1;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> tracks = new ArrayList<>();

    public List<Song> getTracks() {
        return tracks;
    }

    public void append(Song song) {
        getTracks().add(song);
    }
}
