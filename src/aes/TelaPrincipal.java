package aes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
	private JLabel lblTamanhoChave;
	private ArrayList<Integer> tamanhosChavePermitidos;

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
		tamanhosChavePermitidos = new ArrayList<Integer>();
		tamanhosChavePermitidos.add(32);
		tamanhosChavePermitidos.add(24);
		tamanhosChavePermitidos.add(16);

		setTitle("Cifrar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblChaveCom = new JLabel("Chave com 32, 24 ou 16 caracteres:");
		lblChaveCom.setBounds(12, 27, 512, 16);
		contentPane.add(lblChaveCom);

		txtChave = new JTextField();
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
		txtChave.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtChave.setBounds(12, 56, 512, 22);
		contentPane.add(txtChave);
		txtChave.setColumns(10);

		JLabel lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setBounds(12, 104, 512, 16);
		contentPane.add(lblMensagem);

		txtMensagem = new JTextField();
		txtMensagem.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtMensagem.setBounds(12, 133, 512, 22);
		contentPane.add(txtMensagem);
		txtMensagem.setColumns(10);

		JButton btnCifrar = new JButton("Cifrar");
		btnCifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String key = txtChave.getText();
				String mensagem = txtMensagem.getText();
				CriptografiaSimetrica crip = new CriptografiaSimetrica(mensagem, key);
				txtMensagem.setText(crip.cifrar());
			}
		});
		btnCifrar.setBounds(286, 196, 97, 25);
		contentPane.add(btnCifrar);

		JButton btnDecifrar = new JButton("Decifrar");
		btnDecifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaDecifrar.mostrarTela();
			}
		});
		btnDecifrar.setBounds(398, 196, 97, 25);
		contentPane.add(btnDecifrar);

		JLabel lblTituloTamanhoChave = new JLabel("Tamanho da chave:");
		lblTituloTamanhoChave.setBounds(15, 80, 160, 16);
		contentPane.add(lblTituloTamanhoChave);

		lblTamanhoChave = new JLabel("");
		lblTamanhoChave.setBounds(165, 80, 160, 16);
		contentPane.add(lblTamanhoChave);
	}
}
