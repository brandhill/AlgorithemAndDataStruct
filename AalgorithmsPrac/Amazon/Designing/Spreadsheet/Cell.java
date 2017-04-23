package Designing.Spreadsheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cell {
	
	Value value;
	SpreadSheet sheet;
	List<Cell> cellsUsingMyReference = new ArrayList<Cell>();
	Map<String, Cell> expressionReferences = new HashMap<String, Cell>();
	String addValue(String value) {
		this.value.addValue(value);
		return this.value.getValue();
	}
	
	String getValue() {
		return this.value.getValue();
	}
	
	String getOnlyNumber() throws Exception {
		if(this.value.number==Integer.MIN_VALUE)
			throw new Exception("Contains String");
		return this.value.getValue();
	}
	String getExpression() {
		return this.value.getExpression();
	}
	
	void reCalculateAsReferenceChanged() {
		evaluateNumbers(getExpression());
	}
	
	String evaluateNumbers(String value) {
		List<Integer> numbers = new ArrayList<Integer>();
		List<Character> operations = new ArrayList<Character>();
		int number = 0;
		try {
		genarateNumbersFromString(value.toLowerCase(), numbers, operations);
		if(numbers.size()==0 || numbers.size()-operations.size()>1)
			throw new Exception("Invalid Format");
		} catch(Exception e) {
			this.addValue("#Value");
			return "#Value";
		} 
		number = numbers.get(0);
		for(int i=1; i< numbers.size(); i++) {
			number = performArithmeticOperation(number,numbers.get(i),operations.get(i));
		}
		this.value.addNumber(number,value);
		UpdateReferences();
		return this.value.getValue();
	}
	
	
	private void UpdateReferences() {
		for(Cell cell:cellsUsingMyReference) {
			cell.reCalculateAsReferenceChanged();
		}
	}

	private int performArithmeticOperation(int number1,int number2, char c) {
		if(c=='+')
			return number1+number2;
		else
			return number1-number2;
	}
	
	private void genarateNumbersFromString(String value, List<Integer> numbers, List<Character> operations) throws Exception {
		int j = 1;
		while(j<value.length()) {
			boolean expressionCheck = false;
			int expressionIndex = -1;
			for(int i = j; i<value.length(); i++) {
				if(value.charAt(i)>='a' && value.charAt(i)<='z')
					throw new Exception("Invalid Format");
				
				if(value.charAt(i)>='A' && value.charAt(i)<='Z') {
					expressionCheck = true;
					expressionIndex = i;
				}
				
				if(value.charAt(i)=='+' || value.charAt(i)=='-' || i==value.length()-1) {
					if(i!=value.length()-1)
						operations.add(value.charAt(i));

					if(expressionCheck) {
						String s = value.substring(expressionIndex,i);
						Cell cell = null;
						if(!expressionReferences.containsKey(s)) {
							cell = this.sheet.getCellReference(s);
							expressionReferences.put(s, cell);
							cell.cellsUsingMyReference.add(this);
						} else {
							cell = expressionReferences.get(s);
						}
						expressionCheck = false;
						numbers.add(Integer.valueOf(cell.getValue()));
					}
					else
						numbers.add(Integer.valueOf(value.substring(j, i+1)));
					j = i+1;
					break;
				}
			}
		}
	}
}


class Value {
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