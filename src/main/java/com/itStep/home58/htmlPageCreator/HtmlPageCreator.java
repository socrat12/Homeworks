/**
 * ДЗ1. Маленькое. Написать класс, объект которого хранит массив строк (или лист).
 *  И в нем должен быть объектный метод saveAsHtmlPage(File f). Этот метод должен
 *   сохранить все строки из листа в виде корректного HTML документа. Каждая строка 
 *   (в объекте) с новой строки (в браузере) Строки должны чередоваться по принципу
 *    жирная-курсивная-жирная-курсивная.
 */
package com.itStep.home58.htmlPageCreator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HtmlPageCreator {

    private List<String> text;

    public HtmlPageCreator (List<String> text) {
	this.text = text;
    }

    public void saveAsHtmlPage (File f) {
	String[] meta = { "<!DOCTYPE html>", "<head>", "<title>Noname</title>", "</head>", "<body>" };
	String[] meta2 = { "</body>", "</html>" };
	WriterToFile html = new WriterToFile(f);
	metaWrite(html, meta);

	for (int i = 0; i < text.size(); i++) {
	    if (i % 2 == 0) html.writeLine("<b>" + text.get(i) + "</b><br/>");
	    else html.writeLine("<i>" + text.get(i) + "</i><br/>");
	}

	metaWrite(html, meta2);
	html.close();
    }

    /**
     * @param html
     * @param meta
     */
    private void metaWrite (WriterToFile html, String[] meta) {
	for (int i = 0; i < meta.length; i++) {
	    html.writeLine(meta[i]);
	}
    }

    public static void main (String[] args) {
	File html = new File("C://generated.html");
	List<String> text = new ArrayList<String>();
	text.add("Для дома:");
	text.add("git config --global --add user.name ИмяФамилия");
	text.add("git config --global --add user.email АдресПочты");
	text.add("Для шага(Находясь в выбраном репозитории):");
	text.add("git config --local --add user.name ИмяФамилия");
	text.add("git config --local --add user.email АдресПочты");
	text.add("ДЗ1. Маленькое. Написать класс, объект которого хранит массив строк (или лист). И в нем должен быть объектный метод saveAsHtmlPage(File f). Этот метод должен сохранить все строки из листа в виде корректного HTML документа. Каждая строка (в объекте) с новой строки (в браузере) Строки должны чередоваться по принципу жирная-курсивная-жирная-курсивная.");
	HtmlPageCreator creator = new HtmlPageCreator(text);
	creator.saveAsHtmlPage(html);
	System.out.println("Done");
    }

}
