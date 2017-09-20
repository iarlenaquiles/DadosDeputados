package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Dados;

public class Controller {

	private ObjectMapper mapper;
	private String json_file = "deputados.json";
	private String json_formatado = "deputados_formatado.json";
	private String file_serializado = "deputados.ser";
	private String file_serializado_formatado = "deputados_formatado.ser";
	private String file_deserializado = "deserializado.json";

	public Controller() {
		mapper = new ObjectMapper();
	}

	public void deserializarJson(String url) {
		Dados d = new Dados();

		try {
			d = mapper.readValue(new URL(url), Dados.class);
			mapper.writeValue(new File(json_file), d);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void serializar() {
		Dados d = new Dados();

		try {
			d = mapper.readValue(new File(json_file), Dados.class);
			ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(file_serializado));
			obj.writeObject(d);
			obj.close();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void serializarJsonFormatado() {
		Dados d = new Dados();

		try {
			d = mapper.readValue(new File(json_file), Dados.class);
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(json_formatado), d);
			d = mapper.readValue(new File(json_formatado), Dados.class);
			ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(file_serializado_formatado));
			obj.writeObject(d);
			obj.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deserializar() {
		ObjectInputStream obj;
		Dados d;
		try {
			obj = new ObjectInputStream(new FileInputStream(file_serializado));
			d = (Dados) obj.readObject();
			mapper.writeValue(new File(file_deserializado), d);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
