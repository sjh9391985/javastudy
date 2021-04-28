package chapter03;

public class SongTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Song song = new Song();
		
		song.setAlbum("Real");
		song.setArtist("IU");
		song.setComposer("이민수");
		song.setTitle("좋은날");
		song.setTrack(3);
		song.setYear(2010);

		song.show();
		
		Song song2 = new Song("롤린", "브레이브걸스");
		song2.show();
	}

}
