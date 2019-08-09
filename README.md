# JsonDeserializer
A simple JSON deserializer from File. Reading JSON data from file into Java Beans (also, known as entity/model classes) is a very common task for me. The taks involves following simple steps. 
1. Read input file into a JsonReader
2. Parse the reader with JsonParser and retrieve JsonObject/JsonArray
3. Prepare Jave Bean/List of Jave Beans and return it

This project will serve as a utility class, just to save from the repeatations. Under the hood, it uses Gson library, and some Java generics and reflection tricks. The utility assumes that the input file is having well-formed JSON object or JSON array of objects. It does not handle extensive exception handling. 

# Usage
Please refer JUnit Tests provided with project.
