package StackAndQueue;

import java.util.ArrayList;
import java.util.List;

public class Tower {
public Stack Disks;
int index;

Tower(int i){
	index = i;
	Disks = new Stack();
}

void add(int num){
	if(!Disks.isEmpty()&&num>=Disks.peek().id){
		System.out.println("Error in placing disk "+num);
	}
	else{
	Disks.push("", num);
	System.out.println(num+" is added to Tower "+index);
	}
}

void moveTopTo(Tower t){
	int n = Disks.pop().id;
	t.add(n);
}

void moveDisks(int n,Tower destination,Tower buffer){
	if(n>0){
		System.out.println("Start: "+ n );
		moveDisks(n-1,buffer,destination);
		moveTopTo(destination);
		buffer.moveDisks(n-1,destination,this);
		System.out.println("End: "+ n );
	}
}

public static void main(String[] args) {
	int n=3;
	List<Tower> towers = new ArrayList<Tower>();
	towers.add(new Tower(0));
	towers.add(new Tower(1));
	towers.add(new Tower(2));
	for(int i=n;i>0;i--){
		towers.get(0).add(i);
	}
	towers.get(0).moveDisks(n, towers.get(2), towers.get(1));
	for(int i=1;i<=n;i++){
		System.out.println(towers.get(2).Disks.pop().id);
	}
}
}
