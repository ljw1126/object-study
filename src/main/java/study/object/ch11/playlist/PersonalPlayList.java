package study.object.ch11.playlist;

public class PersonalPlayList {
    private PlayList playList = new PlayList(); // 합성

    public void append(Song song) { // 포워딩 메소드
        playList.append(song);
    }

    public void remove(Song song) {
        playList.getTracks().remove(song);
        playList.getSingers().remove(song.getSinger());
    }
}
