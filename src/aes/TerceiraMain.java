package aes;

public class TerceiraMain {

	public static void main(String[] args) {
		String mensagemOriginal = "Mensagem Original";
		String chave = "1234567890123456";

		CriptografiaSimetrica cripto = new CriptografiaSimetrica(mensagemOriginal, chave);

		String textoCifradoString = cripto.cifrar();
		System.out.println("Mensagem cifrada: " + textoCifradoString);
		System.out.println("Mensagem decifrada: " + cripto.decifrar(textoCifradoString));
	}
}
