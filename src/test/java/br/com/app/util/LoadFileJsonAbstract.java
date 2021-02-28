package br.com.app.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class LoadFileJsonAbstract {

	protected String readFile(String file) {

		String json = "";

		try {
			json = Files.readString(Paths.get(getPath() + file)).trim();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return json;

	}

	protected abstract String getPath();
}
