package br.com.app.domain;

import java.io.Serializable;

public class ColetaResultado implements Serializable{

	private static final long serialVersionUID = -655168851977741174L;

	private String id;

	private String json;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
//	@JsonSerialize(using = LocalDateTimeSerializer.class)
//	private LocalDateTime scanDateTime;

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

//	public LocalDateTime getScanDateTime() {
//		return scanDateTime;
//	}
//
//	public void setScanDateTime(LocalDateTime scanDateTime) {
//		this.scanDateTime = scanDateTime;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColetaResultado other = (ColetaResultado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
