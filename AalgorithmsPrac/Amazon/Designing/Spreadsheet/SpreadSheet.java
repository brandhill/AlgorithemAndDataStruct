package Designing.Spreadsheet;

import java.util.ArrayList;
import java.util.List;

public class SpreadSheet {
	
	List<List<Cell>> cells;
	
	SpreadSheet() {
		cells = new ArrayList<List<Cell>>(50);
		for(int i=0; i<50; i++) {
			cells.add(new ArrayList<Cell>(50));
		}
	}
	
	String evaluateInput(String value, int row, int column) throws Exception {
		List<Cell> rows = cells.get(row);
		if(rows==null) {
			rows = new ArrayList<Cell>();
			cells.add(row, rows);
		}
		Cell cell = rows.get(column);
		if(cell==null) {
			cell = new Cell();
			cell.sheet = this;
			rows.set(column, cell);
		}
		if(value.charAt(0)=='=') {
			return EvaluateNumbers(value,cell);
		}
		return cell.addValue(value);
	}
	
	String EvaluateNumbers(String value,Cell cell) {
		
		return cell.evaluateNumbers(value);
	}
	
	Cell getCellReference(String reference) {
		int row = reference.charAt(0);
		int column = Integer.valueOf(reference.substring(1));
		return cells.get(row).get(column);
	}
	
}
