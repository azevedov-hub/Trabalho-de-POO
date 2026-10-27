package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.Banco;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDeLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Usuario;
	private JPasswordField Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeLogin frame = new TelaDeLogin();
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
	public TelaDeLogin() {
		
		Banco banco = new Banco();
		banco.iniciarBanco();
		
		setForeground(Color.DARK_GRAY);
		setBackground(Color.YELLOW);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 552);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(254, 255, 255));
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("SIX SEVEN CONTRUCOES");
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("PT Serif Caption", Font.BOLD | Font.ITALIC, 40));
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		Usuario = new JTextField();
		Usuario.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JLabel lblNewLabel_2 = new JLabel("Bem-vindo");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
		
		Senha = new JPasswordField();
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp1 = new String(Senha.getPassword());
				String temp2 =  Usuario.getText();
				
				if(temp1.isEmpty() || temp2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos","Aviso",JOptionPane.WARNING_MESSAGE);
				}
				else{
					if(banco.verificacaoDeLogin(temp2, temp1) <= 2 ) {			
						JOptionPane.showMessageDialog(null, "Login válido","Bem-vindo",JOptionPane.INFORMATION_MESSAGE);
						if(banco.verificacaoDeLogin(temp2, temp1)==1) {
							TelaSemRestricoes tela = new TelaSemRestricoes();
							dispose();
							tela.setVisible(true);
						}
						if(banco.verificacaoDeLogin(temp2, temp1) == 2) {
							TelaDosfuncionarios tela = new TelaDosfuncionarios();
							dispose();
							tela.setVisible(true);
						}
						
					}else {
						
						JOptionPane.showMessageDialog(null, "Login inválido","Aviso",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(54)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addComponent(Usuario, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
								.addComponent(Senha, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(108)
							.addComponent(lblNewLabel_2)))
					.addGap(69))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(137)
					.addComponent(btnNewButton)
					.addContainerGap(137, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel_2)
					.addGap(27)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Usuario, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Senha, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnNewButton)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(119)
					.addComponent(lblNewLabel))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(213, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
					.addGap(205))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addComponent(lblNewLabel)
					.addGap(44)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
					.addGap(58))
		);
		contentPane.setLayout(gl_contentPane);

	}
}
