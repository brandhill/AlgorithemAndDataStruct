package StackAndQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class AnimalAdoption7 {
final String dog = "dog";
final String cat = "cat";

LinkedList<Animal> list = new LinkedList<Animal>();

void enqueue(String name,String cat){
	Animal animal = new Animal(name,cat);
	list.add(animal);
}

Animal DequeueAny(){
	if(list.isEmpty())
		return null;
	return list.remove(0);
}

Animal DequeueDog(){
	return deque(dog);
}

Animal DequeueCat(){
	return deque(cat);
}

private Animal deque(String cat){
	if(list.isEmpty())
	{
		return null;
	}
	
	ListIterator<Animal> it = list.listIterator();
	while(it.hasNext()){
		Animal animal = it.next();
		if(animal.category.equals(cat))
		{
			list.remove(animal);
			return animal;
		}
	}
	return null;
}

public static void main(String[] args) {
	AnimalAdoption7 q7 = new AnimalAdoption7();
	q7.enqueue("dog1",q7.dog);
	q7.enqueue("cat1",q7.cat);
	q7.enqueue("cat2",q7.cat);
	q7.enqueue("dog2",q7.dog);
	q7.enqueue("cat3",q7.cat);
	System.out.println(q7.DequeueCat().name);
	System.out.println(q7.DequeueAny().name);
	System.out.println(q7.DequeueDog().name);
	
}
}
