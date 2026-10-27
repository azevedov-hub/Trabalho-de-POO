package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Banco {

	static final String URL = "jdbc:sqlite:sistema.db";
	public Connection conn;
	
	public void conexao(){
		try  {      
			conn = DriverManager.getConnection(URL);
			System.out.println("Conectado ao SQLite!"); }
		catch(SQLException e) {
			System.err.println("Falha ao Conectar com o banco");
		}
	}
	
	public void iniciarBanco() {  
		try  {      
			conn = DriverManager.getConnection(URL);
			System.out.println("Conectado ao SQLite!"); 
			
			// os próximos trechos entram aqui 
			
					String sqlTabela = "CREATE TABLE IF NOT EXISTS logins ("
										+"id INTEGER PRIMARY KEY AUTOINCREMENT,"
										+"nome TEXT NOT NULL,"
										+"usuario TEXT NOT NULL,"
										+"senha TEXT NOT NULL,"
										+"restricao INT)";
					try(Statement st = conn.createStatement()){
						st.executeUpdate(sqlTabela);
						System.out.println("Tabela Logins criada");
					}
					
					String sqlTabela2 = "CREATE TABLE IF NOT EXISTS funcionarios ("
							+"id INTEGER PRIMARY KEY AUTOINCREMENT,"
							+"nome TEXT NOT NULL,"
							+"funcao TEXT NOT NULL,"
							+"cpf TEXT NOT NULL,"
							+"endereco TEXT NOT NULL,"
							+"datNascimento TEXT NOT NULL,"
							+"salario DOUBLE,"
							+"sexo TEXT NOT NULL,"
							+"cep TEXT NOT NULL)";
					
					try(Statement st = conn.createStatement()){
						st.executeUpdate(sqlTabela2);
						System.out.println("Tabela Funcionários criada");
					}
					
					String sqlInsert = "INSERT INTO logins (nome, usuario, senha, restricao) VALUES (?, ?, ?, ?)" ;
					
					try(PreparedStatement ps = conn.prepareStatement(sqlInsert)){
						
						ps.setString(1,"Admin");
						ps.setString(2, "Admin");
						ps.setString(3,"6767");
						ps.setString(4, "0");
						ps.executeUpdate();
						
					}
			
			
		  } catch (SQLException e) { 
		            System.out.println("Erro: " + e.getMessage());
		  } 	    
	}
	
	public int  verificacaoDeLogin(String usuario,String senha) {
		
		String sqlog = "SELECT usuario, senha, restricao FROM logins WHERE senha = ? AND usuario = ?";
		//int verificar;
	
		try(PreparedStatement ps = conn.prepareStatement(sqlog)){
			
			ps.setString(1, senha);
			ps.setString(2, usuario);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt("restricao") == 0) {
					return 1;
				}else if(rs.getInt("restricao") == 1) {
					return 2;
				}
			}
			
		}catch(SQLException e) {			
			System.err.println("Falha na pesquisa");	
		}
		return 3;
	}
	
	public boolean cadastraFuncionario( String nome,
			String funcao,
			String cpf,
			String endereco,
			String datNascimento,
			double salario,
			String sexo,
			String cep) {
		
		// busca para verificar se o cadastro já existe
		
		String sqlbusca = "SELECT funcao , cpf , endereco, datnascimento, salario, sexo, cep , nome FROM funcionarios"
				+ " WHERE funcao = ? AND cpf = ? AND endereco = ? AND datnascimento = ? AND salario = ? AND sexo = ? AND cep = ? AND nome = ? ";
		
		try(PreparedStatement ps = conn.prepareStatement(sqlbusca)){
			
			ps.setString(1, funcao);
			ps.setString(2, cpf);
			ps.setString(3, endereco);
			ps.setString(4, datNascimento);
			ps.setDouble(5, salario );
			ps.setString(6, sexo);
			ps.setString(7, cep);
			ps.setString(8, nome);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				return false;
			}
			
		}catch(SQLException e){
			System.err.println("Falha na busca de um cadastro existente"+e.getMessage());
		}
		
		String sqlincert = "INSERT INTO funcionarios (funcao , cpf , endereco, datnascimento, salario, sexo, cep , nome) "
						 + "VALUES(? , ? , ? , ? , ? , ? , ? , ?)";
		
		try(PreparedStatement ps = conn.prepareStatement(sqlincert)){
			ps.setString(1, funcao);
			ps.setString(2, cpf);
			ps.setString(3, endereco);
			ps.setString(4, datNascimento);
			ps.setDouble(5, salario );
			ps.setString(6, sexo);
			ps.setString(7, cep);
			ps.setString(8, nome);
			
			
			ps.executeUpdate();
			System.out.println("Novo funcionario cadastrado");
			
			
			String sqlNovoLogin = "INSERT INTO logins (usuario , senha, nome, restricao) VALUES (? , ? , ? , ?)";
			PreparedStatement cs = conn.prepareStatement(sqlNovoLogin);
			
			cs.setString(1, nome);
			cs.setString(2, cpf);
			cs.setString(3, nome);
			cs.setString(4, "1"); 
			cs.executeUpdate();
			
			return true;
			
		}catch(SQLException e){
			 
			System.err.println("Falha ao cadastras novo cliente" + e.getMessage());
			return false;
			
		}
		
	}

}
