import java.nio.channels.ClosedSelectorException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MyMap 
{
    HashMap<Integer,Integer> map=new HashMap<>();
    

    public int integerInput()
    {
        Scanner sc=new Scanner(System.in);
        int value =sc.nextInt();
        return value;
    }
    public void add()
    {
        System.out.print("\n1)ADD\n2)AddMap\n3)Update \n Enter your choice:- ");
        int ch=integerInput();
        switch(ch)
        {
            case 1:
                System.out.print("\nEnter the key:- ");
                int key=integerInput();
                System.out.print("\nEnter the Value:- ");
                int value=integerInput();
                map.put(key, value);
                break;
            case 2:
                HashMap<Integer,Integer> map2= returnMap();
                map.putAll(map2);
                break;
            case 3:
                System.out.print("\nEnter the key to be updated:- ");
                int key3=integerInput();
                if(map.containsKey(key3))
                {   System.out.print("Enter the value to be updated:- ");
                    int value2=integerInput();
                    map.put(key3, value2);
                }
                else
                {
                    System.out.print("KEY NOT FOUND!!!");
                }
                break;
            default:
                System.out.print("\n INVALID INPUT");
        }
    }
    public HashMap<Integer,Integer> returnMap()
    {
        HashMap<Integer,Integer> map1=new HashMap<>();
        System.out.print("\nEnter number of keys:- ");
        int no=integerInput();
        for(int i=0;i<no;i++)
        {
            System.out.print("\nEnter key:- ");
            int key=integerInput();
            System.out.print("\nEnter Value :- ");
            int value=integerInput();
            map1.put(key,value);
        }
        return map1;

    }
    public void print()
    {   if(isMapEmpty())
        {
            return;
        }
        for (Integer key: map.keySet()) {
            System.out.println(key+"="+map.get(key));
        }

    }
    public void remove()
    {   if(isMapEmpty())
        {
            return;
        }
        print();
        System.out.print("\n1)Remove by key\n2)Remove by value\n3) Remove by key and value\nEnter your choice :- ");
        int ch= integerInput();
        switch(ch)
        {
            case 1:
                System.out.print("\nEnter the key:- ");
                int key=integerInput();
                if(map.containsKey(key))
                {
                    map.remove(key);
                }
                else 
                {
                    System.out.print("KEY NOT FOUND!!!");
                }
                break;
            case 2:
                System.out.print("\nEnter the value :- ");
                int value=integerInput();
                int key1=returnKey(value);
                map.remove(key1);
                break;
            case 3:
                System.out.print("\nEnter the key:- ");
                int key2=integerInput();
                System.out.print("\nEnter the value :- ");
                int value1=integerInput();
                map.remove(key2,value1);
                break;
            default:
                System.out.print("\nINVALID INPU!!");
        }


    }
    public void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public int returnKey(int value)
    {   

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if (value==entry.getValue()) 
            {
                return entry.getKey();
            }
        }
        return -1;        
    }        
    public void search()
    {   if(isMapEmpty())
        {
            return ;
        }
        System.out.print("\n1)Search key\n2)Search value\nEnter the choice ");
        int ch=integerInput();
        switch(ch)
        {
            case 1:
                System.out.print("\nEnter the key:- ");
                int key=integerInput();
                if(map.containsKey(key))
                {
                    System.out.print("\nKey Found ||Key Value "+map.get(key)+" Key");
                }
                else
                {
                    System.out.print("\nKey not Found");
                }
                break;
            case 2:
                System.out.print("\nEnter the Value:- ");
                int value=integerInput();
                if(returnKey(value)==-1)
                {
                    System.out.print("\nValue not found");

                }
                else 
                {
                    System.out.print("Value found at "+returnKey(value));
                }
                break;
            default:
                System.out.print("INVALID INPUT!!!!");
        }

    }
    public boolean isMapEmpty()
    {
        if(map.isEmpty())
        {
            System.out.print("Map is Empty!!!");
            return true;
        }
        return false;
    }    
}

class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyMap map = new MyMap();
        int ch;
        System.out.print("ONLY INTEGERS!!!!");
        do {
            System.out.print("\n1:Add\n2)Print\n3)Remove\n4)Search\n5)clearScreen\n6)Exit\nEnter the choice:- ");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    map.add();
                    break;
                case 2:
                    map.print();
                    break;
                case 3:
                    map.remove();
                    break;
                case 4:
                    map.search();
                    break;
                case 5:
                    map.clearScreen();
                    break;
                case 6:
                    System.out.print("+++++++++++++++++CLOSING++++++++++++++");
                    break;
                default:
                    System.out.print("Invalid input");
            }
        }while(ch!=6);
    }
}