package com.share.JsonDeserialize;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class Deserializer<T> {
	private final Class<T> typeOfT;
	private final String jsonFile;

	public Deserializer(final Class<T> typeOfT, final String jsonFile) {
		this.typeOfT = typeOfT;
		this.jsonFile = jsonFile;
	}

	public T getABean() throws Exception {
		return new Gson().fromJson(getJsonReader(), this.typeOfT);
	}

	public List<T> getListOfBeans() throws Exception {
		final Type listType = new TypeToken<List<T>>() {
		}.getType();

		return new Gson().fromJson(getJsonReader(), listType);
	}

	private JsonReader getJsonReader() throws Exception {
		if (this.jsonFile != null && !this.jsonFile.isEmpty()) {
			try {
				return new JsonReader(new InputStreamReader(new FileInputStream(this.jsonFile)));
			} catch (final Exception e) {
				throw e;
			}
		}
		return null;
	}
}
