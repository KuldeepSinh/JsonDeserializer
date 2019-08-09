package com.share.JsonDeserialize;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class Deserializer<T> {
	protected Class<T> typeOfT;
	private ArrayList<T> listOfBeans;
	private T bean;
	private String jsonFile;

	public Deserializer() {
	}

	public Deserializer(final Class<T> typeOfT, final String jsonFile) {
		this.typeOfT = typeOfT;
		this.jsonFile = jsonFile;
	}

	public T getBean() throws Exception {
		makeABean(getJsonObject(getJsonReader()));
		return this.bean;
	}

	private void makeABean(final JsonObject jsonObject) {
		this.bean = new Gson().fromJson(jsonObject, this.typeOfT);
	}

	public ArrayList<T> getListOfBeans() throws Exception {
		makeAListOfBeans(getJsonArray(getJsonReader()));
		return this.listOfBeans;
	}

	private void makeAListOfBeans(final JsonArray jsonArray) {
		final Gson gson = new Gson();
		this.listOfBeans = new ArrayList<T>();
		for (final JsonElement jsonElement : jsonArray) {
			final T aBean = gson.fromJson(jsonElement, this.typeOfT);
			this.listOfBeans.add(aBean);
		}
	}

	private JsonArray getJsonArray(final JsonReader reader) {
		return new JsonParser().parse(reader).getAsJsonArray();
	}

	private JsonObject getJsonObject(final JsonReader reader) {
		return new JsonParser().parse(reader).getAsJsonObject();
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
