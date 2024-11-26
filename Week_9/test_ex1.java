class test_ex1 {
    public static void main(String[] args) {
        Song song1 = new Song("ia ma du ma");
        Song song2 = new Song("vreay sa beau");
        Song song3 = new Song("zodiac");

        Playlist playlist1 = new Playlist();
        Playlist playlist2 = new Playlist();
        Playlist playlist3 = new Playlist();

        playlist1.add_song_playlist(song1);
        playlist1.add_song_playlist(song2);
        playlist2.add_song_playlist(song3);
        playlist2.add_song_playlist(song3);
        playlist3.add_song_playlist(playlist2);

        System.out.println("First playlist: " + playlist1.play() + "\n");
        System.out.println("Second playlist: " + playlist2.play() + "\n");
        System.out.println("Third playlist: " + playlist3.play() + "\n");

        //playlist2.remove_song_playlist(song3);
        System.out.println("Updated Second playlist: " + playlist2.play() + "\n");
    }

}

interface Playable {
    String play();
}

class Song implements Playable {
    private String title;

    public Song(String title) {
        this.title = title;
    }

    @Override
    public String play() {
        return this.title;
    }
}

class Playlist implements Playable {
    Playable[] items;
    private static int no_of_items;

    public Playlist() {
        items = new Playable[0];
        no_of_items = 0;
    }

    public void add_song_playlist(Playable item) {
        for (Playable i : items) {
            if (i.play().equals(item.play())) {
                System.out.println("item is already added");
                return;
            }
        }
        Playable[] new_items = new Playable[no_of_items + 1];
        for (int i = 0; i < no_of_items; i++) {
            new_items[i] = items[i];
        }
        new_items[no_of_items] = item;
        items = new_items;
        no_of_items++;
    }
   /* public void remove_song_playlist(Playable item) {
        // Check if the item exists in the playlist
        boolean found = false;
        for (Playable i : items) {
            if (i.play().equals(item.play())) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("item is not in playlist");
            return;
        }

        // Create a new array for the updated playlist
        Playable[] temp = new Playable[no_of_items - 1];
        int tempIndex = 0;

        // Copy all items except the one to be removed
        for (Playable i : items) {
            if (!i.play().equals(item.play())) {
                temp[tempIndex++] = i;
            }
        }

        // Update items and count
        items = temp;
        no_of_items--;
    }
    */


    @Override
    public boolean equals(Object o) {
        if (o instanceof Playable) {
            Playlist other = (Playlist) o;
            return other.play().equals(this.play());
        }
        return false;
    }

    @Override
    public String play() {
        String result = "";
        for (Playable i : items) {
            if (i instanceof Song) {
                result += i.play();
                result += " ";
            } else {
                result += "( ";
                result += i.play();
                result += " )";
                result += " ";
            }
        }
        return result;
    }
}