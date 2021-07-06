package br.com.app.domain.hardware;

import java.util.Collections;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Disks {

	@Id
	private String id;

	private List<DiskStore> diskStores;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<DiskStore> getDiskStores() {

		if (diskStores != null) {

			return diskStores;
		}

		return Collections.emptyList();
	}

	public void setDiskStores(List<DiskStore> diskStores) {
		this.diskStores = diskStores;
	}

}
