package Designing.TextEditor;

import java.util.List;

public abstract class Content {
	Content next;
	Content prev;
	Border border;
	Properties  properties;
	abstract void updateBorder(Border border);
	abstract void addNext(Content content);
	abstract void updateProperties(Properties prop);
}

class Text extends Content {
	char c;
	@Override
	void updateBorder(Border border) {
	}
	@Override
	void addNext(Content content) {
	}
	@Override
	void updateProperties(Properties prop) {
	}
}

class Image extends Content {
	
	@Override
	void updateBorder(Border border) {
	}
	@Override
	void addNext(Content content) {
	}
	@Override
	void updateProperties(Properties prop) {
	}
}

class Table extends Content {
	List<List<Content>> table;
	@Override
	void updateBorder(Border border) {
	}
	@Override
	void addNext(Content content) {
	}
	@Override
	void updateProperties(Properties prop) {
	}
}
