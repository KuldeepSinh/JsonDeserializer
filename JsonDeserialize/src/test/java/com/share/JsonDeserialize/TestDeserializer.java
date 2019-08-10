package com.share.JsonDeserialize;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

public class TestDeserializer {
	@Test
	public void shouldDeserializeAListOfJsonObjectsTest() {
		try {
			final List<Person> personList = new Deserializer<Person>(Person.class,
					JsonFilePathHelper.getAListOfPersonsJsonFilePath()).getListOfBeans();
			assertEquals(2, personList.size());
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void shouldDeserializeASingleJsonObjectTest() {
		try {
			final Person alice = new Deserializer<Person>(Person.class, JsonFilePathHelper.getAPersonJsonFilePath())
					.getABean();
			assertTrue("Alice".equals(alice.getFirstName()));
			assertTrue("Wonderland".equals(alice.getLastName()));

		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test(expected = FileNotFoundException.class)
	public void shouldThrowExceptionTest() throws Exception {
		try {
			new Deserializer<Person>(Person.class, "dummyFile").getABean();
		} finally {

		}
	}

}
