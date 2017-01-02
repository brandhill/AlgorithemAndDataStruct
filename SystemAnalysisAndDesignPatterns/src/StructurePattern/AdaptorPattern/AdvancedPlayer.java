package StructurePattern.AdaptorPattern;

public interface AdvancedPlayer {

	public void playVlc(String fileName);
	public void playMp4(String fileName);
}

class VlcPlayer implements AdvancedPlayer{
	public void playVlc(String fileName) {
		System.out.println(fileName+" is played in vlcplayer");
	}
	public void playMp4(String fileName) {
		System.out.println(fileName+" cannot played in vlcplayer");
	}
}

class Mp4Player implements AdvancedPlayer{
	public void playVlc(String fileName) {
		System.out.println(fileName+" cannot played in MP4");
	}
	public void playMp4(String fileName) {
		System.out.println(fileName+" is played in MP4");
	}
}