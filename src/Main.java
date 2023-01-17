import java.util.*;

public class Main {
    public static void main(String[] args) {
        Album a1 = new Album("Moosa","Sidhu Mosewala");
        a1.addSongToAlbum("295",4.05);
        a1.addSongToAlbum("Last ride",4.5);
        a1.addSongToAlbum("So high",3.00);
        a1.addSongToAlbum("Same beaf",5.00);
        a1.addSongToAlbum("Landlord",3.40);

        Album a2 = new Album("Arijit","Arijit Singh");
        a2.addSongToAlbum("Kesariya",4.05);
        a2.addSongToAlbum("Gerua",4.5);
        a2.addSongToAlbum("Tum hi ho",3.00);

        LinkedList<Song> myPlaylist = new LinkedList<>();
        a1.addToPlaylistFromAlbum("295", myPlaylist);
        a1.addToPlaylistFromAlbum("Same beaf", myPlaylist);
        a2.addToPlaylistFromAlbum(2,myPlaylist);
        a1.addToPlaylistFromAlbum(5, myPlaylist);
        a2.addToPlaylistFromAlbum("Kesariya",myPlaylist);

        play(myPlaylist);
    }
    public static void play(LinkedList<Song> playlist){
        Scanner sc= new Scanner(System.in);
        ListIterator<Song> itr = playlist.listIterator();
        boolean isForward = false;
        if(playlist.size() > 0){
            System.out.print("Currently play: ");
            System.out.println(itr.next());
            isForward = true;
        }
        else{
            System.out.println("Playlist is empty");
        }
        System.out.println("Enter your choice");
        printMenu();

        boolean quit = false;

        while(!quit){
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    if(!isForward ){
                        itr.next();
                        isForward = true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else {
                        System.out.println("You reached at the end of the playlist");
                        isForward = false;
                    }
                    break;
                case 2:
                    if(isForward){
                        itr.previous();
                        isForward = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else {
                        System.out.println("You are at the start of playlist");
                        isForward = true;
                    }
                    break;
                case 3:
                    if(isForward && itr.hasPrevious()){
                        System.out.println(itr.previous());
                        isForward = false;
                    }
                    else {
                        if (itr.hasNext()){
                            System.out.println(itr.next());
                        }
                    }

                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    itr.remove();
                    break;
                case 6:
                    printPlaylist(playlist);
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }
    public static void printPlaylist(LinkedList<Song>playlist){
        for (Song song:playlist){
            System.out.println(song);
        }
    }
    public static void printMenu(){
        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu song");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all");
        System.out.println("7 - Exit");
    }
}