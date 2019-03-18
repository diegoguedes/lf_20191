import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static final String EXAMPLE_TEST = "Esse esse esse esse é um texto da disciplina de SD1 e LFA. A ideia é substituir SD1 e LFA por AP1. Ademais, tirar as palavras que estão repetidas repetidas";

	public static void main(String[] args) {
		Pattern replace = Pattern.compile("\\b(\\w+)(\\s+\\1\\b)+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = replace.matcher(EXAMPLE_TEST);

		String novoTexto = EXAMPLE_TEST;
		while (matcher.find()) {
			novoTexto = novoTexto.replaceAll(matcher.group(), matcher.group(1));
		}

		replace = Pattern.compile("(SD1|LFA)");
		matcher = replace.matcher(novoTexto);
		matcher.replaceAll("AP1");
		System.out.println("Original:");
		System.out.println(EXAMPLE_TEST);
		System.out.println("Modificado:");
		System.out.println(matcher.replaceAll("AP1"));
	}
}