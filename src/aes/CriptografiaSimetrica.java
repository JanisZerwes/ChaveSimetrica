package aes;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaSimetrica {

	private String mensagem;
	private SecretKeySpec chave;
	private byte[] conteudo;

	private static final String ALGORITMO_AES = "AES";

	public CriptografiaSimetrica(String mensagem, String chaveSimetrica) {
		this.mensagem = mensagem;
		this.chave = new SecretKeySpec(chaveSimetrica.getBytes(), ALGORITMO_AES);
	}

	/**
	 * Cifra uma string, usando a chave simétrica e o algoritmo AES
	 * 
	 * @return a mensagem cifrada, convertida em notação Base64
	 */
	public String cifrar() {
		try {
			Cipher cipher = Cipher.getInstance(ALGORITMO_AES);
			cipher.init(Cipher.ENCRYPT_MODE, chave);
			conteudo = cipher.doFinal(mensagem.getBytes());
		} catch (Exception e) {
			System.out.println("Erro ao cifrar mensagem. Causa: " + e.getMessage());
		}
		return Base64.getEncoder().encodeToString(conteudo);
	}

	// TODO chamar este método?
	private void salvarMensagemCifradaNoArquivo(String caminhoArquivo) throws IOException {
		this.cifrar(); // vai cifrar e atualizar a atributo 'conteudo'

		File f = new File(caminhoArquivo + ".txt");
		FileOutputStream fos = new FileOutputStream(f);
		DataOutputStream dos = new DataOutputStream(fos);
		dos.write(conteudo);
		dos.close();
		fos.close();
	}

	/**
	 * Decifra uma mensagem, usando a chave simétrica e o algoritmo AES
	 * 
	 * @param a mensagem cifrada, convertida em notação Base64
	 * 
	 * @return a mensagem decifrada, decodificada considerando a notação Base64
	 */
	public String decifrar(String mensagemCodificada) {
		byte[] mensagemDecifrada = Base64.getDecoder().decode(mensagemCodificada);
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, chave);
			mensagemDecifrada = cipher.doFinal(mensagemDecifrada);
		} catch (Exception e) {
			System.out.println("Erro ao decifrar mensagem. Causa: " + e.getMessage());
		}
		String mensagemOriginal = new String(mensagemDecifrada);
		return "Mensagem decifrada: " + mensagemOriginal;
	}

	/**
	 * Apenas para testes, pode remover este método
	 */
	public static void main(String[] args) {

		String textoOriginal = "teste";
		String chave = "1111111111111111";
		CriptografiaSimetrica cripto = new CriptografiaSimetrica("teste", chave);

		String textoCifrado = cripto.cifrar();
		String textoDecifrado = cripto.decifrar(textoCifrado);
		System.out.println("Texto original: " + textoOriginal);
		System.out.println("Texto decifrado: " + textoDecifrado);
	}

}
