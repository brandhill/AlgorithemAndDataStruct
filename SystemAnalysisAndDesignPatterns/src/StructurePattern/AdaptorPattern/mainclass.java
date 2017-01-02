package StructurePattern.AdaptorPattern;

public class mainclass {
	public static void main(String[] args) {
		MediaPlayerAdaptor adaptor = new MediaPlayerAdaptor("vlc");
		adaptor.play("mp4", "Dangerous.mp4");
		adaptor.play("vlc", "Dangerous.vlc");
		MediaPlayerAdaptor adaptor1 = new MediaPlayerAdaptor("mp4");
		adaptor1.play("mp4", "Dangerous.mp4");
		adaptor1.play("vlc", "Dangerous.vlc");
	}
}
