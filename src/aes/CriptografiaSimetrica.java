package aes;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaSimetrica {

//	public static String chaveSimetrica; 
	private String mensagem;
	private SecretKeySpec key; // Secret Key x SecretKeySpec .
	private String chaveSimetrica;
	private byte[] conteudo;
//	private byte[] mensagemEncriptada;
//	private byte[] mensagemDescriptada;

	// olha
	public CriptografiaSimetrica(String mensagem, String chaveSimetrica) {
		this.mensagem = mensagem;
		this.key = new SecretKeySpec(chaveSimetrica.getBytes(), "AES");
		// aqui esse getBytes converte o texto string para bytes,

	}
// agora um metodo para cada coisa

	public byte[] cifrar() {
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] mensagemEncriptada = cipher.doFinal(mensagem.getBytes());

			return mensagemEncriptada;

		} catch (Exception e) {

			return "Error ao cifrar".getBytes();
		}
	}

	private void salvarMensagemCriptografadaNoArquivo() throws IOException {

		File f = new File("arquivo_criptografico.txt");
		FileOutputStream fos = new FileOutputStream(f);
		DataOutputStream dos = new DataOutputStream(fos);
		dos.write(conteudo);
		dos.close();
		fos.close();
	}

	public String decifrar(byte[] mensagemCodificada) {
		byte[] mensagemDescriptada = "".getBytes();
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			mensagemDescriptada = cipher.doFinal(mensagemCodificada);
		} catch (Exception e) {
			System.out.println("Ta entrando erro aqui");
		}

		// System.out.println(" \n " + mensagemDescriptada);
		String mensagemOriginal = new String(mensagemDescriptada);
		return "Mensagem Descriptada: " + mensagemOriginal;

	}

}
