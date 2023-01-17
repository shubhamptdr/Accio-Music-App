import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    void addSongToAlbum(String title, double duration){
        Song s = new Song(title, duration);
        if(!findSong(s.getTitle())){
            songs.add(s);
            System.out.println("New song has been added");
        }
        else{
            System.out.println("Song is already added");
        }
    }
    public boolean findSong(String title){
        for(Song s : songs){
            if(Objects.equals(s.getTitle(), title)){
                return true;
            }
        }
        return false;
    }
    public void addToPlaylistFromAlbum(String title, LinkedList<Song>playlist){

        if(findSong(title)){
            for(Song s : songs){
                if(s.getTitle().equals(title)){
                    playlist.add(s);
                    System.out.println("Song is add to playlist");
                    break;
                }
            }
        }
        else{
            System.out.println("Song is note present in your album");
        }
    }
    public void addToPlaylistFromAlbum(int trackNo, LinkedList<Song>playlist){
        int index = trackNo-1;
        if(index>=0 && index<songs.size()){
            playlist.add(songs.get(index));
            System.out.println("Song is add to playlist");
        }
        else{
            System.out.println("Song is note present in your album");
        }
    }

}
