package br.com.app.domain.builder.os;

import java.util.List;

import br.com.app.domain.ColetaResultado;
import br.com.app.domain.os.OSSession;
import br.com.app.domain.os.Sessions;
import br.com.app.util.DomainBuilder;

public class SessionsBuilder {

	private ColetaResultado coletaResultado;

	public SessionsBuilder(ColetaResultado coletaResultado) {

		this.coletaResultado = coletaResultado;
	}
	
	public Sessions builder() {

		Sessions sessions = new Sessions();
		sessions.setId(coletaResultado.getId());
		List<OSSession> osSession = new DomainBuilder().collectionBuilder(coletaResultado.getJson(), OSSession.class);
		sessions.setOsSession(osSession);
		return sessions;
	}
}
