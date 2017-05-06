package Designing.FileSystem;

public class System1 {
	private Directory root;
	
	public System1() {
		root = new Directory(null,"MyComputer",1);
	}
	
	Directory OpenDirectory() {
		return root;
	}
	
	public static void main(String[] args) {
		System1 system = new System1();
		Directory root = system.OpenDirectory();
		root.createNewDirectory("Folder1", 2);
		root.createNewDirectory("Folder2", 3);
		root.createNewFile("File1",4);
		System.out.println(root);
		System.out.println(root.openContent());
	}
}
