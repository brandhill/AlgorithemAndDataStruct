package Designing.TextEditor;

public class Properties {
	Size size;
	
}

class TextProperties extends Properties{
	FontWeight fontWeight;
	FontStyle style;
}

class ImageProperties extends Properties {
	
}
enum Size {
	Small, Medium, Large
}

enum FontWeight {
	Bold, Normal
	
}

enum FontStyle {
	Italic, Normal
}