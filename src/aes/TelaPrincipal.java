package aes;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		setTitle("Encriptar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblChaveCom = new JLabel("Chave com 32 ou 24 ou 16 caracteres:");
		lblChaveCom.setBounds(12, 27, 512, 16);
		contentPane.add(lblChaveCom);

		txtChave = new JTextField();
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

		JButton btnEncriptar = new JButton("Encriptar");
		btnEncriptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String key = txtChave.getText();
				String mensagem = txtMensagem.getText();
				CriptografiaSimetrica crip = new CriptografiaSimetrica(mensagem, key);
				txtMensagem.setText(new String(crip.cifrar()));

			}
		});
		btnEncriptar.setBounds(286, 196, 97, 25);
		contentPane.add(btnEncriptar);

		JButton btnDecifrar = new JButton("Decifrar");
		btnDecifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaDecifrar decifrar = new TelaDecifrar();
				decifrar.NovaTela();
			}
		});
		btnDecifrar.setBounds(398, 196, 97, 25);
		contentPane.add(btnDecifrar);
	}
}
