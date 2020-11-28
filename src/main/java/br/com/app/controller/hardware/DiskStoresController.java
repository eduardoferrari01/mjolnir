package br.com.app.controller.hardware;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.DiskStore;
import br.com.app.util.ConvertJson;

@RestController
@RequestMapping("/api/diskstores")
public class DiskStoresController {
	 
	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {
	  
		 // System.out.println(coletaResultado.getJson());
		 
		  ConvertJson convertJson = new ConvertJson();
		   
		  List<Object> diskStores =   convertJson.jsonToListObject(coletaResultado.getJson(), DiskStore.class);
		  
	  }
}
