package StackAndQueue;

public class Animal {
String name;
String category;

Animal(String name,String category){
	this.name = name;
	this.category = category;
}

void display(){
	System.out.println(category+" : "+name);
}

public boolean equals(Object obj){
	Animal animal = (Animal) obj;
	if(this.name.equalsIgnoreCase(animal.name) && this.category.equalsIgnoreCase(animal.category))
		return true;
	return false;
}
}
