package Designing.FileSystem;

public class System {
	private Directory root;
	
	public System() {
		root = new Directory(null,"MyComputer",1);
	}
	
	Directory OpenDirectory() {
		return root;
	}
	
	public static void main(String[] args) {
		System system = new System();
		Directory root = system.OpenDirectory();
		root.createNewDirectory("Folder1", 2);
		root.createNewDirectory("Folder2", 3);
		root.createNewFile("File1",4);
	}

}
