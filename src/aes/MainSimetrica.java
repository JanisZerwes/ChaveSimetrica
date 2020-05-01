package aes;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MainSimetrica {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// em aes s� s�o suportadas chaves com esses tr�s tamanhos, 32, 24 ou 16
		// caracteres.

		// AQUI esta a logica para gerar a SecretKey
		System.out.println("32 caracteres = chave com 256 bits" + "\n 24 caracteres = chave com 192 bits"
				+ "\n 16 caracteres = chave com 128 bits" + "\n informe a chave");
		String chaveSimetrica = sc.nextLine();
		// Objeto da classe Key criado
		// Key, implementa a interface da chave simetrica
		// � passado para o usu�rio os byres da chave identificadora e um atributo,
		// chamado aes
		SecretKeySpec key = null;
		try {
			key = new SecretKeySpec(chaveSimetrica.getBytes("UTF-8"), "AES");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			// O objeto da classe Chiper, vai capturar a chave
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			System.out.println("Informe sua mensagem para ser encriptada");
			String mensagem = sc.nextLine();
			// procedimento de cifragem com o m�todo doFinal, atraves do objeto chiper que
			// inicializei
			// ele vai encriptar a mensagem e guardar na vari�vel
			byte[] mensagemEncriptada = cipher.doFinal(mensagem.getBytes("UTF-8"));
			// mostro na tela a mensagem encriptada
			System.out.println(new String("Mensagem Encriptada: " + mensagemEncriptada));
			// reinializo o mesmo objeto, agora em modo decrypt, passando a mesma chave
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] mensagemDescriptada = cipher.doFinal(mensagemEncriptada);
			// convertendo para string a mensagem que est� em bytes
			String mensagemOriginal = new String(mensagemDescriptada);
			System.out.println("Mensagem Descriptada: " + mensagemOriginal);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public String Encriptar() {
//		Cipher cipher = Cipher.getInstance("AES");
//		cipher.init(Cipher.ENCRYPT_MODE, this.Key);
//		String mensagemEncriptada = cipher.doFinal(this.mensagem.getBytes());
//		return mensagemEncriptada;
//	}
//
//	public void CriptografiaSimetrica(String key, String mensagem) {
//		this.Key = new SecretKeySpec(key.getBytes(), "AES");
	// this.mensagem = mensagem;
//	}

}
