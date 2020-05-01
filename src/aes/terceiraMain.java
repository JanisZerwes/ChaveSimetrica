package aes;

public class terceiraMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String mensagemOriginal = "Mensagem Original\n";
		String chave = "1234567890123456"; // tem que ter 16 chars

		CriptografiaSimetrica cripto = new CriptografiaSimetrica(mensagemOriginal, chave);

		System.out.println("mensagem criptografada eh:" + cripto.cifrar());

		String stringCripto = new String(cripto.cifrar());

		System.out.println("Mensagem descriptografada" + cripto.decifrar(stringCripto.getBytes()));
	}

}
