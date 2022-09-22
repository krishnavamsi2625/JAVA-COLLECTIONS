//import java.rmi.Remote;
import java.util.*;
class MySet
{
    HashSet<Integer> arr=new HashSet<>();
    public int integerInput()
    {
        Scanner sc=new Scanner(System.in);
        int value;
        value=sc.nextInt();
        //sc.close();
        return value;
    }
    public void add()
    {
        int ch ;
        System.out.print("\n1)AddList 2)Add \nEnter choice :- ");
        ch=integerInput();
        switch(ch)
        {
            case 1:
                List<Integer> arr1=returnList();
                arr.addAll(arr1);
                print();
                break; 
            case 2:
                System.out.print("Enter the value:- ");
                int value=integerInput();
                arr.add(value);
                print();
                break;  
            default:
                System.out.print("Invalid input");

        }
    }
    public List<Integer> returnList()
    {
        int no_of_values,value,i;
        List<Integer> arr1=new LinkedList<>();
        System.out.print("\n Enter the no of elements:- ");
        no_of_values=integerInput();
        for(i=0;i<no_of_values;i++)
        {
            System.out.print("Enter the "+i+" element:- ");
            value=integerInput();
            arr1.add(value);
        }
        return arr1;

    }
    public void print()
    {   if(!isSetEmpty())
        {
            for(Integer x:arr)
            {
                System.out.print(x+" ");
            }
        }
    }
    public boolean isSetEmpty()
    {
        if(arr.isEmpty())
        {
            System.out.print("\nList is empty");
            return true;
        }
        return false;
    }
    public void remove()
    {
        if(isSetEmpty())
        {
            return;
        }
        int ch;
        System.out.print("\n1)Remove 2)Remove List\n3)Retain List\n4)Clear\nEnter your choice:- ");
        ch=integerInput();
        switch(ch)
        {
            case 1:
            System.out.print("\nEnter the value to be deleted:- ");
            int value=integerInput();
            arr.remove(Integer.valueOf(value));
            break;
            case 2:
                List<Integer> arr1=returnList();
                arr.removeAll(arr1);
                print();
                break;
            case 3:
                List<Integer> arr2=returnList();
                arr.retainAll(arr2);
                break;
            case 4:
                arr.clear();
                break;

        }
    }
    public void search()
    {   if(isSetEmpty())
        {
            return;
        }
        System.out.print("\n1)Search\n2)SearchList\nEnter your choice");
        int ch =integerInput();
        switch(ch)
        {
            case 1:
                System.out.print("\nEnter the value to be searched:- ");
                int value=integerInput();
                if(arr.contains(value))
                {
                    System.out.print("\nFound!!");
                }
                else 
                {
                    System.out.print("\nNot Found");
                }
                break;
            case 2:
                List<Integer> arr2=returnList();
                if(arr.containsAll(arr2))
                {
                    System.out.print("\nFound!!");
                }
                else 
                {
                    System.out.print("\nNot Found");
                }
                break;
            default:
            System.out.print("\nInvalid Input");

        }
    }
    public  void    clearScreen()
{
    System.out.print("\033[H\033[2J");
    System.out.flush();

}
    public void deepClone()
    {    HashSet<Integer> arr1= (HashSet<Integer>) arr.clone() ;
        //new LinkedList<>(arr);
        //LinkedList <Integer> arr1 = arr;
        System.out.print("Old Orginal set:- "+arr+"\n");
        arr1.add(10);
        System.out.print("Adding 10 to last in cloned set.........");
        System.out.print("\nOrginal set:- "+arr);
        System.out.print("\nCloned set:- "+arr1);
        arr1.remove(10);

    }    
    public void  shallowClone()
    {
        // LinkedList<Integer> arr1= (LinkedList<Integer>) arr.clone() ;
        //new LinkedList<>(arr);
        HashSet<Integer> arr1 = arr;
        System.out.print("Old Orginal list:- "+arr+"\n");
        arr1.add(10);
        System.out.print("Adding 10 to last in cloned list.........");
        System.out.print("\nOrginal List:- "+arr);
        System.out.print("\nCloned list:- "+arr1);
        arr1.remove(10);
    }
}

class MainProg
{
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        MySet test= new MySet();
        int ch;
        do
        {
            System.out.print("\n1)Add\n2)Remove\n3) search\n4)Print\n5)clear\n6)deepClone \n7)Shallow clone\n8)Exit \nEnter your choice:- ");
            
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    test.add();
                    break;
                case 2:
                    test.remove();
                    break;
                case 3:
                    test.search();
                    break;
                case 4:
                    test.print();
                    break;
                case 5:
                    test.clearScreen();
                    break;
                case 6:
                    test.deepClone();
                    break;
                case 7:
                    test.shallowClone();
                    break;
                case 8:
                    System.out.print("\n++++++++++++++++closing++++++++++++++");
                    break;
                default:
                    System.out.print("\nInvalid input ");
            }

        }while(ch!=8);
    }
}

