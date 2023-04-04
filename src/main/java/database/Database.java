package database;

import java.util.ArrayList;
import java.util.List;

import entidades.Jogar;
import entidades.Pessoas;

public class Database {
	
	public static List<Pessoas> db = new ArrayList<Pessoas>();
	
	public static void insert(Pessoas p) {
		db.add(p);
	}
	
	public static List<Pessoas> selectAll(){
		return db;
	}
	
	public static List<String> dbNumeros = new ArrayList<String>();
	
	public static void insertNumeros(Integer menor, Integer maior) {
		String menorString = Integer.toString(menor);
		String maiorString = Integer.toString(maior);
		dbNumeros.add("<tr><td>" + menorString + "</td>" + "<td>" + maiorString + "</td></tr>");
	}
	
	public static List<String> selectAllNumeros(){
		return dbNumeros;
	}
	
}
