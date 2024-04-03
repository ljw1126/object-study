package study.object.ch10.playlist.step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * p359 부모 클래스와 자식 클래스의 동시 수정 문제
 * 추가 요청사항
 * -가수별 노래의 제목도 함께 관리해주길 원함
 * - Playlist에 자료구조를 추가후 자식 클래스 PersonalPlaylist remove(..) 도 수정해야 함
 */
public class Playlist {
    private List<Song> tracks = new ArrayList<>();
    private Map<String, String> singers = new HashMap<>();

    public List<Song> getTracks() {
        return tracks;
    }

    public Map<String, String> getSingers() {
        return singers;
    }

    public void append(Song song) {
        getTracks().add(song);
        singers.put(song.getSinger(), song.getTitle());
    }
}
