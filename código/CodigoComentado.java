package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
   public Connection conectarDB() {
      Connection conn = null; // A variável é inicializada aqui apenas para permitir retorno mesmo quando a conexão não ocorre.
      try {
         Class.forName("com.mysql.Driver.Manager").newInstance(); // Tentativa de carregar a classe do driver; se falhar, o método seguirá sem avisar.
         String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123"; 
         conn = DriverManager.getConnection(url); // Cria a conexão utilizando a URL fornecida, sem qualquer validação prévia.
      } catch (Exception e){ }  // Não existe log ou mensagem que indique o motivo da falha, dificultando qualquer diagnóstico posterior.
      return conn; } // O método devolve a conexão aberta (ou null), sem verificar se houve sucesso real.
   
   public String nome = "";
   public boolean result = false;

   public boolean verificarUsuario(String login, String senha) {
      String sql = "";  
      Connection conn = conectarDB();  // A função é chamada diretamente sem verificar se a conexão realmente foi estabelecida.
      
      // Montagem manual da consulta, o que deixa o código vulnerável e dificulta manutenção caso o comando SQL cresça.
      sql += "select nome from usuarios ";
      sql += "where login = " + " ' " + login + " ' ";
      sql += " and senha = " + " ' " + senha + " ' ";
      
      try { 
         Statement st = conn.createStatement(); // Aqui se assume que 'conn' está válido, o que nem sempre é verdade.
         ResultSet rs = st.executeQuery(sql); // A consulta é executada sem qualquer validação do comando gerado.
         
         if (rs.next()) { 
            result = true; 
            nome = rs.getString("nome"); } // Atribuição simples do nome encontrado, porém sem verificar possíveis inconsistências no dado retornado.
         
      } catch (Exception e) { } // Todo erro ocorrido neste trecho será ignorado, podendo mascarar problemas graves em produção.
      
      return result; } // Retorna apenas true ou false, sem indicar qual tipo de falha ocorreu durante o processo.
   } // fim da classe