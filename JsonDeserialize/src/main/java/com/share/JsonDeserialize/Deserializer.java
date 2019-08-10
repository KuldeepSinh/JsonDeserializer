package com.share.JsonDeserialize;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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

	public ArrayList<T> getListOfBeans() throws Exception {
		final ArrayList<T> listOfBeans = new ArrayList<T>();
		for (final JsonElement jsonElement : getJsonArray(getJsonReader())) {
			final T aBean = new Gson().fromJson(jsonElement, this.typeOfT);
			listOfBeans.add(aBean);
		}
		return listOfBeans;

	}

	private JsonArray getJsonArray(final JsonReader reader) {
		return new JsonParser().parse(reader).getAsJsonArray();
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
