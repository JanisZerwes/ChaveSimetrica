package aes;

import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaSimetrica {

	public static String chaveSimetrica;
	private static String mensagem;
	private static SecretKey Key;
	private static byte[] mensagemEncriptada;
	private static byte[] mensagemDescriptada;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		// em aes só são suportadas chaves com esses três tamanhos, 32, 24 ou 16
		// caracteres.
		System.out.println("32 caracteres = chave com 256 bits" + "\n 24 caracteres = chave com 192 bits"
				+ "\n 16 caracteres = chave com 128 bits" + "\n informe a chave");
		chaveSimetrica = sc.nextLine();
		// Objeto da classe Key criado
		// Key, implementa a interface da chave simetrica
		// é passado para o usuário os byres da chave identificadora e um atributo,
		// chamado aes
		Key = new SecretKeySpec(chaveSimetrica.getBytes(), "AES");
		try {
			// O objeto da classe Chiper, vai capturar a chave
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, Key);
			System.out.println("Informe sua mensagem para ser encriptada");
			mensagem = sc.nextLine();
			// procedimento de cifragem com o método doFinal, atraves do objeto chiper que
			// inicializei
			// ele vai encriptar a mensagem e guardar na variável
			mensagemEncriptada = cipher.doFinal(mensagem.getBytes());
			// mostro na tela a mensagem encriptada
			System.out.println(new String("Mensagem Encriptada: " + mensagemEncriptada));
			// reinializo o mesmo objeto, agora em modo decrypt, passando a mesma chave
			cipher.init(Cipher.DECRYPT_MODE, Key);
			mensagemDescriptada = cipher.doFinal(mensagemEncriptada);
			// convertendo para string a mensagem que está em bytes
			String mensagemOriginal = new String(mensagemDescriptada);
			System.out.println("Mensagem Descriptada: " + mensagemOriginal);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public CriptografiaSimetrica(String key, String mensagem) {
		this.Key = Key;
		this.mensagem = mensagem;
	}
}
