package StructurePattern.AdaptorPattern;

public class MediaPlayerAdaptor implements MediaPlayer {
	
	private AdvancedPlayer advancedPlayer;
	
	MediaPlayerAdaptor(String audioType){
		if(audioType.equalsIgnoreCase("vlc"))
			advancedPlayer = new VlcPlayer();
		else if(audioType.equalsIgnoreCase("mp4"))
			advancedPlayer = new Mp4Player();
	}
	
	@Override
	public void play(String audioType, String fileName) {
		
		if(audioType.equalsIgnoreCase("vlc"))
			advancedPlayer.playVlc(fileName);
		else if(audioType.equalsIgnoreCase("mp4"))
			advancedPlayer.playMp4(fileName);
		else
			System.out.println(fileName+ " is not compatable format");
	}

	
}
