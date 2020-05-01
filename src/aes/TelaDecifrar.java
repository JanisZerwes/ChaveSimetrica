package aes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaDecifrar {

	private JFrame frame;
	private JTextField txtChaveDescrip;
	private JTextField txtMensagemDescript;
	private JTextField txtMensagemPronta;
	private JLabel lblTextoOriginal;

	/**
	 * Launch the application.
	 */
	public static void NovaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDecifrar window = new TelaDecifrar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaDecifrar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 623, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblDigiteAChave = new JLabel("Digite a chave:");
		lblDigiteAChave.setBounds(12, 23, 577, 16);
		frame.getContentPane().add(lblDigiteAChave);

		txtChaveDescrip = new JTextField();
		txtChaveDescrip.setBounds(12, 52, 577, 22);
		frame.getContentPane().add(txtChaveDescrip);
		txtChaveDescrip.setColumns(10);

		JLabel lblColeAMensagem = new JLabel("Cole a mensagem encriptada:");
		lblColeAMensagem.setBounds(12, 104, 577, 16);
		frame.getContentPane().add(lblColeAMensagem);

		txtMensagemDescript = new JTextField();
		txtMensagemDescript.setBounds(12, 145, 577, 22);
		frame.getContentPane().add(txtMensagemDescript);
		txtMensagemDescript.setColumns(10);

		JButton btnDecifrar = new JButton("Decifrar");
		btnDecifrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String key = txtChaveDescrip.getText();
				String mensagem = txtMensagemDescript.getText();
				CriptografiaSimetrica descrip = new CriptografiaSimetrica(key, mensagem);
				CriptografiaSimetrica crip = new CriptografiaSimetrica(mensagem, key);
				String stringCripto = new String(crip.cifrar());
				txtMensagemPronta.setText(descrip.decifrar(txtMensagemDescript.getText().getBytes()));

			}
		});
		btnDecifrar.setBounds(496, 264, 97, 25);
		frame.getContentPane().add(btnDecifrar);

		txtMensagemPronta = new JTextField();
		txtMensagemPronta.setBounds(12, 229, 581, 22);
		frame.getContentPane().add(txtMensagemPronta);
		txtMensagemPronta.setColumns(10);

		lblTextoOriginal = new JLabel("Texto Original:");
		lblTextoOriginal.setBounds(12, 200, 577, 16);
		frame.getContentPane().add(lblTextoOriginal);
	}
}
