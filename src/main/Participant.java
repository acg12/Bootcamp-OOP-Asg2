package main;

public class Participant implements Comparable<Participant> {
	
	String username;
	int share;

	public Participant(String username, int share) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.share = share;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	@Override
	public int compareTo(Participant o) {
		// TODO Auto-generated method stub
		return this.getUsername().compareTo(o.getUsername());
	}
}
