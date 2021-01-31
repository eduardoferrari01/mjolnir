package br.com.app.controller.hardware;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.DiskStore;
import br.com.app.domain.hardware.Disks;
import br.com.app.service.hardware.DisksService;
import br.com.app.util.ConvertJson;

@RestController
@RequestMapping("/api/diskstores")
public class DiskStoresController {

	private Logger logger = LoggerFactory.getLogger(DiskStoresController.class);
	
	@Autowired
	private DisksService disksService;
	
	@PostMapping
	public void post(@RequestBody ColetaResultado coletaResultado) {

		ConvertJson convertJson = new ConvertJson();

		List<Object> objects = convertJson.jsonToListObject(coletaResultado.getJson(), DiskStore.class);

		Disks disks = new Disks();
		disks.setId(coletaResultado.getId());
		for (Object obj : objects) {

			DiskStore diskStore = (DiskStore) obj;
			disks.add(diskStore);

		}
		
		disksService.save(disks);
	}
}
