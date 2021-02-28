package br.com.app.util;

public class LoadFileOSJson extends LoadFileJsonAbstract{

	@Override
	protected String getPath() {
		return "src/test/resources/";
	}
	
	public String loadInternetProtocolStats() {
		return readFile("internetProtocolStats.json");
	}

	public String loadFileSystem() {
		return readFile("fileSystem.json");
	}

	public String loadNetworkParams() {
		return readFile("networkParams.json");
	}
	
	public String loadOperatingSystem() {
		return readFile("operatingSystem.json");
	}
	
	public String loadOSProcess (){
		return readFile("osProcess.json");
	}
	
	public String loadOSService() {
		return readFile("osService.json");
	}
	
	public String loadOSSession() {
		return readFile("osSession.json");
	}
	
	public String loadOSVersionInfo() {
		return readFile("osVersionInfo.json");
	}
}