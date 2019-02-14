package br.com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.app.domain.SystemInfo;
import br.com.app.repository.SystemInfoRepository;

@RestController
@RequestMapping("/rest/json")
public class SystemInfoController {

  @Autowired
  private SystemInfoRepository systemInfoRepository;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public void salvar(@RequestBody SystemInfo systemInfo) {
    systemInfoRepository.save(systemInfo);
  }

}
