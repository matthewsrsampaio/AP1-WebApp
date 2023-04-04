package util;

import java.util.ArrayList;
import java.util.List;

import database.Database;
import entidades.Pessoas;

public class Utilities {
	
	public static String retorneBDPessoas() {
		String linhas = "";
		
		List<Pessoas> lista = Database.selectAll();
		
		for(Pessoas p: lista) {
			linhas += "<tr><td>" + p.getNome() + "</td>"
					   +  "<td>" + p.getIdade() + "</td></tr>";
		}
		
		return linhas;
	}
	
	public static Integer retornarNumeroMenor(Integer[] arrayNum) {
		Integer numMenor = arrayNum[0];
		
		for(int i = 0;  i < arrayNum.length; i++) {
			if(arrayNum[i] < numMenor) {
				numMenor = arrayNum[i];
			}
		}
		return numMenor;
	}
	
	public static Integer retornarNumeroMaior(Integer[] arrayNum) {
		Integer numMaior = arrayNum[0];
		
		for(int i = 0;  i < arrayNum.length; i++) {
			if(arrayNum[i] > numMaior) {
				numMaior = arrayNum[i];
			}
		}
		return numMaior;
	}
	
	public static String retornarNumeros() {
		String retorno = "";
		
		List<String> listaN = Database.selectAllNumeros();
		
		for(String l : listaN) {
			retorno += l;
		}
		
		return retorno;
	}
}
