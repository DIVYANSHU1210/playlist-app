import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class album {
    String title;
    List<Song> Songs;
    String artist;

    public album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.Songs = new ArrayList<> ();
    }

    public album(String title, List<Song> Songs, String artist) {
        this.title = title;
        this.Songs = Songs;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return Songs;
    }

    public void setSongs(List<Song> Songs) {
        this.Songs = Songs;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public boolean findSong(Song s){
        for(Song song: Songs){
            if(s.getTitle().equals(song.getTitle()) && s.artist.equals(song.artist)){
                return true;
            }
        }
        return false;
    }

    public Optional<Song> searchSong(String s){
        for(Song song: Songs){
            if(s.equals(song.getTitle())){
                return Optional.of(song);
            }
        }
        return Optional.empty();
    }

    public String addSong(Song s){
        if(findSong(s)){
            return "Song already exist";
        }
        else{
            Songs.add(s);
            return "Song added successfully";
        }
    }

}
