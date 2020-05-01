package aes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaDecifrar {

	private JFrame frame;
	private JTextField txtChave;
	private JTextField txtMensagemDescript;
	private JTextField txtMensagemPronta;
	private JLabel lblTextoOriginal;
	private JLabel lblTamanhoChave;
	private ArrayList<Integer> tamanhosChavePermitidos;

	/**
	 * Launch the application.
	 */
	public static void mostrarTela() {
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
		tamanhosChavePermitidos = new ArrayList<Integer>();
		tamanhosChavePermitidos.add(32);
		tamanhosChavePermitidos.add(24);
		tamanhosChavePermitidos.add(16);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 623, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblDigiteAChave = new JLabel("Digite a chave:");
		lblDigiteAChave.setBounds(12, 23, 577, 16);
		frame.getContentPane().add(lblDigiteAChave);

		txtChave = new JTextField();
		txtChave.setBounds(12, 52, 577, 22);
		frame.getContentPane().add(txtChave);
		txtChave.setColumns(10);

		txtChave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int tamanhoTextoChave = txtChave.getText().length();
				lblTamanhoChave.setText(tamanhoTextoChave + "");
				
				if (tamanhosChavePermitidos.contains(tamanhoTextoChave)) {
					lblTamanhoChave.setForeground(Color.GREEN);
				} else {
					lblTamanhoChave.setForeground(Color.RED);
				}
			}
		});

		JLabel lblTituloTamanhoChave = new JLabel("Tamanho da chave:");
		lblTituloTamanhoChave.setBounds(15, 80, 160, 16);
		frame.getContentPane().add(lblTituloTamanhoChave);

		lblTamanhoChave = new JLabel("");
		lblTamanhoChave.setBounds(165, 80, 160, 16);
		frame.getContentPane().add(lblTamanhoChave);

		JLabel lblColeAMensagem = new JLabel("Cole a mensagem cifrada:");
		lblColeAMensagem.setBounds(12, 104, 577, 16);
		frame.getContentPane().add(lblColeAMensagem);

		txtMensagemDescript = new JTextField();
		txtMensagemDescript.setBounds(12, 145, 577, 22);
		frame.getContentPane().add(txtMensagemDescript);
		txtMensagemDescript.setColumns(10);

		JButton btnDecifrar = new JButton("Decifrar");
		btnDecifrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String key = txtChave.getText();
				String mensagem = txtMensagemDescript.getText();

				// TODO ordem dos parâmetros foi corrigida ;)
				CriptografiaSimetrica descrip = new CriptografiaSimetrica(mensagem, key);
				txtMensagemPronta.setText(descrip.decifrar(txtMensagemDescript.getText()));
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
