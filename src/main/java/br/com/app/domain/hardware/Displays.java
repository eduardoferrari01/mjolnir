package br.com.app.domain.hardware;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document	
public class Displays {

	@Id
	private String id;
	
	private List<Display> displays;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public List<Display> getDisplays() {
		return displays;
	}

	public void setDisplays(List<Display> displays) {
		this.displays = displays;
	}

	public void add(Display display) {
		
		if(displays == null) {
			
			displays = new ArrayList<Display>();
		}
		displays.add(display);
		
	}
	
}
