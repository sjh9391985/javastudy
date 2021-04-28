package tv;

public class Tv {
	private int channel; // 1~255
	private int volume; // 0~100
	private boolean power; //

	public Tv(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	}

	public void power(boolean on) {
		if (on == true) {
			System.out.println("TV를 켰습니다.");
		} else {
			System.out.println("TV를 껐습니다.");
		}
	}

	public void channel(int channel) {
		
	}

	public void channel(boolean up) {

	}

	public void volume(int channel) { // 1~255유지

	}
	
	public void volume(boolean up) {

	}

	public void status() {
		System.out.println(" TV[channel]: " + channel + " TV[volume]: " + volume + " TV[power]: " + power);
	}

}
