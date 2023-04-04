package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import entidades.Jogar;
import util.Utilities;


@WebServlet(urlPatterns = "/jogo")
public class JogoServlet extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nAux = "";
				
		Jogar numero = new Jogar();
		
		nAux = req.getParameter("n1");
		numero.setNumero1(Integer.parseInt(nAux));
		nAux = req.getParameter("n2");
		numero.setNumero2(Integer.parseInt(nAux));
		nAux = req.getParameter("n3");
		numero.setNumero3(Integer.parseInt(nAux));
		nAux = req.getParameter("n4");
		numero.setNumero4(Integer.parseInt(nAux));
		nAux = req.getParameter("n5");
		numero.setNumero5(Integer.parseInt(nAux));
		
		Integer[] numArray = {
				numero.getNumero1(), 
				numero.getNumero2(), 
				numero.getNumero3(),
				numero.getNumero4(),
				numero.getNumero5()};
		
		Integer menor = Utilities.retornarNumeroMenor(numArray);
		Integer maior = Utilities.retornarNumeroMaior(numArray);
		Database.insertNumeros(menor, maior);
		String numeros = Utilities.retornarNumeros();
		
		PrintWriter writer = resp.getWriter();
		
		writer.write(
					  "<html>"
					+ "<head>"
					+ "<meta charset=\"ISO-8859-1\">"
					+ "<title>JOGO PAGE</title>"
					+ "</head>"
					+ "<body>"
					+ "<a href=\"index.html\">Home</a><br>"
					+ "<a href=\"jogo.html\">Jogar de novo</a><br>"
					+ "<table>"
					+ "<tr>"
					+ "<th>Menor</th><th>Maior</th>"
					+ "</tr>"
					+ "<tr>"
					+ "<td>" + numeros + "</td>"
					+ "</tr>"
					+ "</table>"
					+ "</body>"
					+ "</html>");
	}
}
