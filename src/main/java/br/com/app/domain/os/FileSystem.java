package br.com.app.domain.operatingsystem;

import java.util.List;

public class FileSystem {

	private List<FileStore> fileStores;
	
	private Long openFileDescriptors;
	 
	private Long maxFileDescriptors;

	public Long getOpenFileDescriptors() {
		return openFileDescriptors;
	}

	public void setOpenFileDescriptors(Long openFileDescriptors) {
		this.openFileDescriptors = openFileDescriptors;
	}

	public Long getMaxFileDescriptors() {
		return maxFileDescriptors;
	}

	public void setMaxFileDescriptors(Long maxFileDescriptors) {
		this.maxFileDescriptors = maxFileDescriptors;
	}

	public List<FileStore> getFileStores() {
		return fileStores;
	}

	public void setFileStores(List<FileStore> fileStores) {
		this.fileStores = fileStores;
	}
	
	
	
}
