package study.object.ch10.playlist.step2;

public class PersonalPlaylist extends Playlist {
    public void remove(Song song) {
        getTracks().remove(song);
        getSingers().remove(song.getSinger()); // 부모 변화가 자식에서도 영향을 끼침
    }
}
