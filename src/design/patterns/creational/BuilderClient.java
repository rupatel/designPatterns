package design.patterns.creational;

class Token {
	private String type;
	private char token;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public char getToken() {
		return token;
	}

	public void setToken(char token) {
		this.token = token;
	}
}

public class BuilderClient {
	public static void main(String args[]) {
		AsciConverter ascii = new AsciConverter();
		RTFReader r = new RTFReader(ascii);
		r.parse();
		System.out.println(ascii.getAsci());
	}
}

class RTFReader {
	Builder b;
	Token[] tokens = new Token[10];

	RTFReader(Builder b) {
		this.b = b;
	}

	public void parse() {
		for (Token t : tokens) {
			switch (t.getType()) {
			case "CHAR": {
				b.convertChar(t);
			}
			case "FONT": {
				b.convertFontChange(t);
			}
			case "PARA": {
				b.convertParagraph(t);
			}
			}
		}
	}
}

abstract class Builder {
	public abstract void convertChar(Token c);

	public abstract void convertFontChange(Token c);

	public abstract void convertParagraph(Token c);
}

class AsciConverter extends Builder {
	StringBuffer sb = new StringBuffer();

	@Override
	public void convertChar(Token c) {
		sb.append(c.getToken());
	}

	@Override
	public void convertFontChange(Token c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertParagraph(Token c) {

	}

	public String getAsci() {
		return sb.toString();
	}
}

class Latex extends Builder {
	StringBuffer sb = new StringBuffer();

	@Override
	public void convertChar(Token c) {
		sb.append(c.getToken());
	}

	@Override
	public void convertFontChange(Token c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertParagraph(Token c) {

	}

	public String getAsci() {
		return sb.toString();
	}
}