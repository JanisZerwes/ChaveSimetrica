package aes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.crypto.Cipher;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtChave;
	private JTextField txtMensagem;
	private JTextField txtMensagemEncriptada;
	private JTextField MensagemDescriptada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblChaveCom = new JLabel("Chave com 32 ou 24 ou 16 caracteres:");
		lblChaveCom.setBounds(12, 27, 512, 16);
		contentPane.add(lblChaveCom);

		txtChave = new JTextField();
		txtChave.setBounds(12, 56, 512, 22);
		contentPane.add(txtChave);
		txtChave.setColumns(10);

		JLabel lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setBounds(12, 104, 512, 16);
		contentPane.add(lblMensagem);

		txtMensagem = new JTextField();
		txtMensagem.setBounds(12, 133, 512, 22);
		contentPane.add(txtMensagem);
		txtMensagem.setColumns(10);

		JLabel lblMensagemEncriptada = new JLabel("Mensagem Encriptada:");
		lblMensagemEncriptada.setBounds(12, 179, 512, 16);
		contentPane.add(lblMensagemEncriptada);

		txtMensagemEncriptada = new JTextField();
		txtMensagemEncriptada.setBounds(12, 220, 512, 22);
		contentPane.add(txtMensagemEncriptada);
		txtMensagemEncriptada.setColumns(10);

		JLabel lblMensgaemDescriptada = new JLabel("Mensgaem Descriptada:");
		lblMensgaemDescriptada.setBounds(12, 271, 512, 16);
		contentPane.add(lblMensgaemDescriptada);

		MensagemDescriptada = new JTextField();
		MensagemDescriptada.setBounds(12, 317, 512, 22);
		contentPane.add(MensagemDescriptada);
		MensagemDescriptada.setColumns(10);

		JButton btnEncriptar = new JButton("Encriptar");
		btnEncriptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CriptografiaSimetrica crip = new CriptografiaSimetrica(key, mensagem);
				txtMensagem.setText(Cipher.DECRYPT_MODE());

			}
		});
		btnEncriptar.setBounds(232, 366, 97, 25);
		contentPane.add(btnEncriptar);

		JButton btnDescriptar = new JButton("Descriptar");
		btnDescriptar.setBounds(378, 366, 97, 25);
		contentPane.add(btnDescriptar);
	}

}
