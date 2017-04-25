package Designing.TextEditor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TextEditor {
	Content pointer;
	Content head;
	Stack<UndoRedo> undo = new Stack<UndoRedo>();
	Stack<UndoRedo> redo = new Stack<UndoRedo>();
	Content insertContent(Content content) {
		if(head==null) {
			head = content;
			pointer = content;
		} else {
			pointer.next = content;
			content.prev = pointer;
			pointer = content;
		}
		undo.push(new UndoRedo(content,true));
		return pointer;
	}
	
	void undo() {
		UndoRedo obj = undo.pop();
		undoRedoHelper(obj);
		redo.add(obj);
	}
	
	void redo() {
		UndoRedo obj = redo.pop();
		undoRedoHelper(obj);
		undo.add(obj);
	}

	void undoRedoHelper(UndoRedo obj) {
		Content content = obj.content;
		if(obj.isAdded) {
			content.prev.next = content.next;
			content.next.prev = content.prev;
			obj.isAdded = false;
		} else {
			content.prev.next = content;
			content.next.prev = content;
			obj.isAdded = true;
		}
	}
	
	void backSpace() {
		if(pointer==null)
			return;
		undo.push(new UndoRedo(pointer,false));
		Content next = pointer.next;
		pointer = pointer.prev;
		if(pointer==null) {
			head = null;
		} else {
			pointer.next = next;
			next.prev = pointer;
		}
	}
	
	void moveForward() {
		if(pointer.next==null)
			return;
		pointer = pointer.next;
	}
	
}

class UndoRedo {
	Content content;
	boolean isAdded;
	UndoRedo(Content content, boolean isAdded) {
		this.content = content;
		this.isAdded = isAdded;
	}
}
