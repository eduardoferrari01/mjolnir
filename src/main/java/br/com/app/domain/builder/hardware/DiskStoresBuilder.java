package br.com.app.domain.builder.hardware;

import java.util.List;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.hardware.DiskStore;
import br.com.app.domain.hardware.Disks;
import br.com.app.util.DomainBuilder;

public class DiskStoresBuilder {

	private ColetaResultado coletaResultado;

	public DiskStoresBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}

	public Disks builder() {

		Disks disks = new Disks();
		disks.setId(coletaResultado.getId());
		List<DiskStore> diskStores = new DomainBuilder().collectionBuilder(coletaResultado.getJson(), DiskStore.class);
		disks.setDiskStores(diskStores);
		return disks;
	}
}
