package br.com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.app.domain.SystemInfo;
import br.com.app.repository.SystemInfoRepository;

@RestController
@RequestMapping("/rest/json")
public class SystemInfoController {

	@Autowired
	private SystemInfoRepository systemInfoRepository;
	
//	@PostMapping
//	public ResponseEntity<SystemInfo> salvar(@RequestBody SystemInfo systemInfo,UriComponentsBuilder ucBuilder)
//	{
//			systemInfoRepository.save(systemInfo);
//		return new ResponseEntity<SystemInfo>(HttpStatus.CREATED);
//	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public SystemInfo salvar(@RequestBody SystemInfo systemInfo,UriComponentsBuilder ucBuilder)
	{
			systemInfoRepository.save(systemInfo);
		    return systemInfo;
	}
}
