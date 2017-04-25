package Designing.FileSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Content {
	int id;
	Directory parent;
	String path;
	Date creationDate;
	String name;
	AccessRoles userAccessRoles;
	
	Content(Directory parent, String name, int id) {
		this.id = id;
		this.parent = parent;
		this.name = name;
		this.path = (parent.path==null?"":parent.path)+"/"+name;
	}
	
	@Override
	public String toString() {
		String s = "Content [id=" + id + ", path=" + path + "]";
		return s;
	}
	
}

class Directory extends Content {
	Map<Integer, Directory> childDirectories = new HashMap<Integer,Directory>();
	Map<Integer, File> childFiles = new HashMap<Integer,File>();
	
	Directory(Directory parent, String name, int id) {
		super(parent,name,id);
	}
	
	Directory createNewDirectory(String name, int id) {
		Directory direc = new Directory(this, name, id);
		childDirectories.put(id, direc);
		return direc;
	}
	
	File createNewFile(String name, int id) {
		File file = new File(this,name,id);
		childFiles.put(id, file);
		return file;
	}
	
	List<Content> openContent() {
		List<Content> list = new ArrayList<Content>();
		list.addAll(childDirectories.values());
		list.addAll(childFiles.values());
		return list;
	}
	
	Directory openDirectory(int directoryId) {
		return childDirectories.get(directoryId);
	}
	
	File openFile(int fileId) {
		return childFiles.get(fileId);
	}
	
	boolean delete(Content content) {
		if(content instanceof File)
			childFiles.remove(content);
		else {
			
		}
		return false;
	}
	
	List<Content> sortBy(String soryBy) {
		
		return null;
	}
}

class File extends Content {
	File(Directory parent, String name, int id) {
		super(parent, name, id);
	}
	String format;
	double size;
	
}

enum AccessRoles {
	Admin, Normal
}