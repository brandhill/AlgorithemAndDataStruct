package Designing.Spreadsheet;

public class Value {
	String string;
	int number;
	String expression;
	
	void addValue(String value) {
		this.string = value;
		this.number = Integer.MIN_VALUE;
	}
	
	void addNumber(int number,String expression) {
		this.number = number;
		this.expression = expression;
		this.string = "";
	}
	
	String getExpression() {
		return this.expression;
	}
	
	String getValue() {
		if(this.number==Integer.MIN_VALUE)
			return this.string;
		return String.valueOf(number);
	}
}
