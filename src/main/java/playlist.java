import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class playlist {
    String title;
    List<Song> Songs;

    private ListIterator<Song> itr;
    boolean wasnext = false;

    public playlist(String title) {
        this.title = title;
        this.Songs = new ArrayList<>();
        itr = Songs.listIterator();
    }

    public Optional<String>searchsong(String s){
        for(Song song : Songs){
            if(song.title.equals(s)){
                return Optional.empty();
            }
        }
        return Optional.of(s);
    }
    public String addSongFromAlbum(album A, String songname){
        Optional<Song> songop = A.searchSong(songname);

        if(songop.isPresent()){
            Song s = songop.get();
            Optional<String> sop =  searchsong(s.title);
            if(sop.isPresent()){
                return "Song already exist in your playlist.";
            }
            Songs.add(s);
            itr = Songs.listIterator() ;
            return "Song added in the playlist";
        }
        else{
            return "Song does not exist";
        }
    }

    public String addSongFromAlbum(album A, int n){
        if(n-1 < A.Songs.size()){
            Song s = A.Songs.get(n-1);
            Songs.add(s);
            itr = Songs.listIterator() ;
            return "Song added in the playlist";
        }
        else{
            return "Song does not exist";
        }
    }

    public String deleteSongfromPlaylist(){
        if(Songs.size() == 0)return "there is no song in playlist to remove";
        itr.remove();
        return "song is removed from playlist";
    }

    public String playNext(){
        if(wasnext){
            //do nothing
        }

        if(!wasnext){
            if(itr.hasNext()) {
                itr.next();
            }
        }
        if(itr.hasNext()){
            Song s = itr.next();
            wasnext = true;
            return "next song is: " + s.getTitle();
        }

        return "You've reached the end of the playlist go back";
    }

    public String playPrevious(){
        if(!wasnext){
            //do nothing
        }

        if(wasnext){
            if(itr.hasPrevious()) {
                itr.previous();
            }
        }
        if(itr.hasPrevious()){
            Song s = itr.previous();
            return "previous song is: " + s.getTitle();
        }

        return "You've reached the start of the playlist go forward";
    }


    public String currentSong(){
        if(wasnext){
            wasnext = false;
            return "Now playing: " + itr.previous();
        }

        wasnext = true;
        return "Now playing: " + itr.next();
    }


}
