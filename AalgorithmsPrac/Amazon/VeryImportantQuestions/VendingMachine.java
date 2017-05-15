package VeryImportantQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    
    List<Coins> machine;
    Map<Integer, Coins> machineCount;
    VendingMachine() {
    	machine = new ArrayList<Coins>();
    	machine.add(new Coins(25,4));
    	machine.add(new Coins(20,10));
    	machine.add(new Coins(10,10));
    	machine.add(new Coins(5,3));
    	machine.add(new Coins(1,10));
    	machineCount = new HashMap<Integer, Coins>();
    	machineCount.put(25, machine.get(0));
    	machineCount.put(20, machine.get(1));
    	machineCount.put(10, machine.get(2));
    	machineCount.put(5, machine.get(3));
    	machineCount.put(1, machine.get(4));
    }
    
    List<Integer> getChange(int money) {
    	System.out.println("Started");
        List<Integer> change = new ArrayList<Integer>();    
        getChangeHelper(money, change, 0, new ArrayList<Integer>());
        for(int i=0; i<change.size(); i++) {
        	machineCount.get(change.get(i)).count -= 1;
        }
        return change;
    }
    
    void getChangeHelper(int money, List<Integer> change, int index, List<Integer> tempList) {
    	
        if(money<0 || (change.size()!=0 && change.size()<tempList.size()))
            return;
        if(money==0 && (change.size()==0 || change.size()>tempList.size())) {
        	System.out.println(tempList);
            change.clear();
            change.addAll(tempList);
        }
        for(int i = index; i< machine.size(); i++) {
        	Coins coin = machine.get(i);
            List<Integer> tempList1 = new ArrayList<Integer>(tempList);
            int tempMoney = money;
            int count = 0;
            while(tempMoney>=coin.coin && coin.count>count) {
                tempList1.add(coin.coin);
                tempMoney -= coin.coin;
                count++;
            }
            getChangeHelper(tempMoney, change, index+1, tempList1);
        }
    }
    
    public static void main(String[] args) {
    	VendingMachine vendingMachine = new VendingMachine();
    	System.out.println("ANs "+ vendingMachine.getChange(130));
//    	System.out.println("ANs "+ vendingMachine.getChange(105));
//    	System.out.println("ANs "+ vendingMachine.getChange(105));
	}
  
}


class Coins {
    int coin;
    int count;
    
    Coins(int coin,int count) {
        this.coin = coin;
        this.count = count;
    }
}
