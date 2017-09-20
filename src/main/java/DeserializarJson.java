import controller.Controller;

public class DeserializarJson {

	private static String url = "https://dadosabertos.camara.leg.br/api/v2/deputados?ordem=ASC&ordenarPor=nome";

	public static void main(String[] args) {
		Controller c = new Controller();
		c.deserializarJson(url);
	}
}
