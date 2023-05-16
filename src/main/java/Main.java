public class Main {
    public static void main(String[] args) {
        album album1 = new album("Gloria","Sam Smith");
        album1.addSong(new Song("Unholy","Sam Smith", 2));
        album1.addSong(new Song("Perfect","Sam Smith", 3));
        album1.addSong(new Song("Gloria", "Sam Smith",2));

        album album2 = new album("Honestly, Nevermind", "Drake");
        album2.addSong(new Song("Her Loss","Drake", 1));
        album2.addSong(new Song("Views","Drake", 1));
        album2.addSong(new Song("Take Care", "Drake",2));

        playlist myPlaylist = new playlist("myPlaylist");
        myPlaylist.addSongFromAlbum(album1, "Unholy"); //unholy
        myPlaylist.addSongFromAlbum(album1,"Gloria"); //gloria
        myPlaylist.addSongFromAlbum(album2, "Her Loss"); //her loss
        myPlaylist.addSongFromAlbum(album2, "Take Care"); //take care

        System.out.println(myPlaylist.currentSong()); //unholy

        System.out.println(myPlaylist.playPrevious()); // nothing

        System.out.println(myPlaylist.playNext()); //gloria

        System.out.println(myPlaylist.playNext()); //her loss

        System.out.println(myPlaylist.playPrevious()); //gloria

        System.out.println(myPlaylist.playNext());

        System.out.println(myPlaylist.currentSong()); //unholy



        //HomeWork
        // addSongByTrackNumber in playlist from album - keep both checks - Album & PLaylist
        // add check if song in playlist already, don't add it and return relevant information - USE OPTIONAL PLS
        // deleteSongFromPlayList
    }
}
