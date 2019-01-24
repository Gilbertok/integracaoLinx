package br.com.wadvice.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class XmlUtils {
	
	public static String getXml(String caminho) throws IOException {
		StringBuilder xml = new StringBuilder();
		String path = new File("").getAbsolutePath().concat("/").concat(caminho);
		FileReader arq;
		try {
			arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) {
				xml.append(linha);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de xml Linx nao encontrado! "+ path);
			e.printStackTrace();
		}
		return xml.toString();
	}

}
