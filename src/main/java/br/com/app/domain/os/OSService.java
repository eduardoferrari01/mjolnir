package br.com.app.domain.os;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OSService {

	@Id
	private String id;
	private String name;
    private Integer processID;
    private State state;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
