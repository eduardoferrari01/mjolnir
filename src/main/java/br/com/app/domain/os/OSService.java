package br.com.app.domain.os;

public class OSService {

	private String name;
    private Integer processID;
    private State state;
    
    public enum State {
        RUNNING, STOPPED, OTHER
    }

	public String getName() {
		return name;
	}

	public int getProcessID() {
		return processID;
	}

	public State getState() {
		return state;
	}
    
    
}
