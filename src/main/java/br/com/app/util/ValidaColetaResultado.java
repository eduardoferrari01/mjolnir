package br.com.app.util;

import java.util.Objects;

import br.com.app.domain.ColetaResultado;

public class ValidaColetaResultado {

	public void isValid(ColetaResultado coleteColetaResultado) {

		if(Objects.isNull(coleteColetaResultado)) {

			throw new IllegalArgumentException("Coleta resultado não pode ser null");
		}

		if(Objects.isNull(coleteColetaResultado)) {

			throw new IllegalArgumentException("Id do coleta resultado não pode ser null");
		}

		if (coleteColetaResultado.getId().isBlank()) {

			throw new IllegalArgumentException("Id do coleta resultado não pode ser vazio");
		}

		if (Objects.isNull(coleteColetaResultado.getJson())) {

			throw new IllegalArgumentException("Json do coleta resultado não pode ser null");
		}

		if (coleteColetaResultado.getJson().isBlank()) {

			throw new IllegalArgumentException("Json do coleta resultado não pode ser vazio");
		}

	}
}
