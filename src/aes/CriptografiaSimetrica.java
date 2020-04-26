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

	public CriptografiaSimetrica(String mensagem, String chaveSimetrica) {
		this.mensagem = mensagem;
		this.chaveSimetrica = chaveSimetrica;
	}

	public static void main(String args[]) {
		System.out.println("32 caracteres = chave com 256 bits" + "\n 24 caracteres = chave com 192 bits"
				+ "\n 16 caracteres = chave com 128 bits" + "\n informe a chave");
		chaveSimetrica = sc.nextLine();
		Key = new SecretKeySpec(chaveSimetrica.getBytes(), "AES");
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, Key);
			System.out.println("Informe sua mensagem para ser encriptada");
			mensagem = sc.nextLine();
			mensagemEncriptada = cipher.doFinal(mensagem.getBytes());
			System.out.println(new String("Mensagem Encriptada: " + mensagemEncriptada));
			cipher.init(Cipher.DECRYPT_MODE, Key);
			mensagemDescriptada = cipher.doFinal(mensagemEncriptada);
			String mensagemOriginal = new String(mensagemDescriptada);
			System.out.println("Mensagem Descriptada: " + mensagemOriginal);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
