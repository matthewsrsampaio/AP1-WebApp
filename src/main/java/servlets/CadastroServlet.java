package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import entidades.Pessoas;

import util.Utilities;

@WebServlet(urlPatterns = "/cadastro")
public class CadastroServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Pessoas pessoa = new Pessoas();
		
		pessoa.setNome(req.getParameter("nome"));
		String numero = req.getParameter("idade");
		pessoa.setIdade(Integer.parseInt(numero));
		
		Database.insert(pessoa);
				
		PrintWriter writer = resp.getWriter();
		writer.write(
				  "<html>"
				+ "<head>"
				+ "<meta charset=\"ISO-8859-1\">"
				+ "<title>Pagina inicial</title>"
				+ "</head>"
				+ "<body>"
				+ "<a href=\"index.html\">Home</a><br>"
				+ "<a href=\"cadastro.html\">Cadastrar outro</a><br>"
				+ "<h2>Cadastrado com sucesso!</h2>"
				+ "<table>"
				+ "<tr>"
				+ "<th>Nome</th><th>Idade</th>"
				+ "</tr>"
				+ "<tbody>"
				+ "<ol>"
				+ Utilities.retorneBDPessoas()
				+ "</ol>"
				+ "</tbody>"
				+ "</table>"
				+ "</body>"
				+ "</html>"
				);
	}	
}
