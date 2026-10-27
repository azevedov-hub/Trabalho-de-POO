package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.Banco;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopAdicionarFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField Data;
	private JTextField cpf;
	private JTextField sexo;
	private JLabel lblSexo;
	private JTextField funcao;
	private JLabel lblFuno;
	private JTextField salario;
	private JLabel lblSal;
	private JTextField cep;
	private JLabel lblCep;
	private JButton btnNewButton;
	private JTextField enderço;
	private JLabel lblEndereo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopAdicionarFuncionario frame = new PopAdicionarFuncionario();
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
	public PopAdicionarFuncionario() {
		setTitle("Novo funcionário");
		setBounds(100, 100, 363, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel x = new JLabel("Nome:");
		x.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		nome = new JTextField();
		nome.setColumns(10);
		
		Data = new JTextField();
		Data.setColumns(10);
		
		JLabel zzzzzz = new JLabel("Data de nascimento:");
		zzzzzz.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		cpf = new JTextField();
		cpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		sexo = new JTextField();
		sexo.setColumns(10);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		funcao = new JTextField();
		funcao.setColumns(10);
		
		lblFuno = new JLabel("Função:");
		lblFuno.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		salario = new JTextField();
		salario.setColumns(10);
		
		lblSal = new JLabel("Salário:");
		lblSal.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		cep = new JTextField();
		cep.setColumns(10);
		
		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		btnNewButton = new JButton("Finalizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(sexo.getText().isEmpty()||
						nome.getText().isEmpty()||
						Data.getText().isEmpty()||
						cpf.getText().isEmpty()||
						sexo.getText().isEmpty()||
						enderço.getText().isEmpty()||
						salario.getText().isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "Preencha todos os campos","Aviso",JOptionPane.WARNING_MESSAGE);
					
				}else {
					Banco banco = new Banco();
					banco.conexao();
					
					double sal = Double.parseDouble(salario.getText());
					
					if(banco.cadastraFuncionario(nome.getText(),funcao.getText(), cpf.getText(), Data.getText(), enderço.getText(), sal, sexo.getText(), cep.getText())){
						dispose();
						JOptionPane.showMessageDialog(null, "Novo funcionário cadastrado","Sucesso",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null,"Cadastro já existente","Falha",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			
			}
		});
		
		enderço = new JTextField();
		enderço.setColumns(10);
		
		lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(x))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(zzzzzz, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(Data, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(cpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(sexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblFuno, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(funcao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblSal, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(salario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(cep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(126, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(110))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(enderço, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(223, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEndereo, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(265, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(x)
					.addGap(1)
					.addComponent(nome, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(zzzzzz)
					.addGap(3)
					.addComponent(Data, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(lblCpf)
					.addGap(4)
					.addComponent(cpf, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(lblSexo)
					.addGap(4)
					.addComponent(sexo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(lblFuno)
					.addGap(3)
					.addComponent(funcao, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(lblSal)
					.addGap(2)
					.addComponent(salario, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(lblCep)
					.addGap(1)
					.addComponent(cep, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEndereo)
					.addGap(2)
					.addComponent(enderço, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addGap(18))
		);
		contentPane.setLayout(gl_contentPane);

	}
}
