import java.util.*;

class MyMap
{  
    LinkedList<Integer> arr=new LinkedList<>();
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
        int ch,index,value;
        System.out.print("\n1)Add\n2)Add at Begining\n3)Add at Specific index\nEnter your choice Number:- ");
        ch=integerInput();
        System.out.print("\nEnter the Value to be Added:- ");
        value=integerInput();
        switch(ch)
        {
            case 1:
            arr.add(value);
            break;
            case 2:
            arr.add(0,value);
            break;
            case 3:
            System.out.print("\nEnter the index to be inserted at:-  ");
            index=integerInput();
            if(index-1 >=arr.size())
            {
                System.out.print("\nInvalid index");
                return;
            }
            arr.add(index,value);
            break;
            default:
            System.out.print("Invalid Input");
        }
    }
    public void addList()
    {
        int ch,index;
        List<Integer> arr1=new LinkedList<>();
        arr1=returnList();
        System.out.print("\n1)Add\n2)Add at begining\n3)Add at specific Index\nEnter the choice Number:- ");
        ch=integerInput();
        switch(ch)
        {
            case 1:
            arr.addAll(arr1);
            break;
            case 2:
            arr.addAll(0,arr1);
            break;
            case 3:
            System.out.print("\n Enter the index to be inserted at :- ");
            index=integerInput();
            if(index-1 >=arr.size())
            {
                System.out.print("\nInvalid index");
                return;
            }
            arr.addAll(index,arr1);
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
    public int sizeReturn()
    {
        return arr.size();
    }
    public void remove()
    {
        int index,value,ch,ch2;
        if(listEmpty())
        { return;

        }
        
        System.out.print("\n1)Remove by value\n2)Remove by index\n3)Remove at end\n4)Remove at Begining\n5)Clear List\nEnter the choice number:- ");
        ch=integerInput();
        switch(ch)
        {
            case 1:
            System.out.print("\nEnter the value to be deleted:- ");
            value=integerInput();
            System.out.print("\n1)Remove first instance\n2)Remove all instance");
            ch2=integerInput();
            switch(ch2)
            {
                case 1:
                arr.remove(Integer.valueOf(value));
                break;
                case 2:
                List<Integer> list= new ArrayList<>();
                list.add(value);
                arr.removeAll(list);
                break;
                default:
                System.out.print("Invalid input");
            }
            break;
            case 2:
                System.out.print("\nEnter the index to be deleted:-");
                index=integerInput();
                if(index-1 >=arr.size())
                {
                    System.out.print("\nInvalid index");
                    return;
                }
                arr.remove(index);
                break;
            case 3:
                arr.removeLast();
                break;
            case 4:
                arr.remove(0);
                break;
            case 5:
                arr.clear();
                break;
            default:
                System.out.print("Invalid input");
        }

    }
    public void removeList()
    {
        if(listEmpty())
        {
            return;
        }
        int ch;
        List<Integer> arr1=returnList();
        System.out.print("\n1)Remove List \n2)Retain List\nEnter the Choice Number:- ");
        ch=integerInput();
        switch(ch)
        {
            case 1:
                arr.removeAll(arr1);
                break;
            case 2:
                arr.retainAll(arr1);
        }

    } 
    public String search(int value)
    {   if(listEmpty())
        {
            return "-1";
        }
        int ch,index;
        String indexes="";
        System.out.print("1) First occurence\n2)Last occurence\n3)All Occurence\nEnter your choice number :- ");
        ch=integerInput();
        switch(ch)
        {
            case 1:
                indexes=indexes+arr.indexOf(value);
                break;
            case 2:
                indexes=indexes+arr.lastIndexOf(value);
                break;
            case 3:
                for (int i = 0; i < arr.size(); i++) 
                {
                    if (Objects.equals(arr.get(i), value)) 
                    {
                        indexes=indexes+" "+i;
                    }
                }
            default:
            System.out.print("\nInvalid input");
        }
        return indexes;
    }
    public int searchIndex(int a)
    {   if(listEmpty())
        {
            return -1;
        } if(a >=arr.size())
        {
            System.out.print("\nInvalid index");
            return -1;
        }

        return arr.get(a);
    }
    public void print()
    {   if(!listEmpty())
        {
            for(Integer x:arr)
            {
                System.out.print(x+" ");
            }
        }
    }
    public boolean listEmpty()
    {
        if(arr.isEmpty())
        {
            System.out.print("\nList is empty");
            return true;
        }
        return false;
    }
    public  void    clearScreen()
{
    System.out.print("\033[H\033[2J");
    System.out.flush();

}
    public void  shallowClone()
    {
        // LinkedList<Integer> arr1= (LinkedList<Integer>) arr.clone() ;
        //new LinkedList<>(arr);
        LinkedList <Integer> arr1 = arr;
        System.out.print("Old Orginal list:- "+arr+"\n");
        arr1.add(10);
        System.out.print("Adding 10 to last in cloned list.........");
        System.out.print("\nOrginal List:- "+arr);
        System.out.print("\nCloned list:- "+arr1);
        arr1.remove();
    }
    public void replace()
    {   int index,value;
        System.out.print("\nEnter the index to be Replaced:- ");
        index=integerInput();
        if(index-1 >=arr.size())
        {
            System.out.print("\nIndex out of bond");
            return;
        }
        //System.out.print("\nInvalid index");
        System.out.print("\nEnter the value :- ");
        value=integerInput();
        arr.set(index,value);

    }
    public void sublistPrint(int si,int fi)
    {
        List<Integer> arr1= arr.subList(si,fi);
        System.out.print(arr1);
    }
    public void deepClone()
    {    LinkedList<Integer> arr1= (LinkedList<Integer>) arr.clone() ;
        //new LinkedList<>(arr);
        //LinkedList <Integer> arr1 = arr;
        System.out.print("Old Orginal list:- "+arr+"\n");
        arr1.add(10);
        System.out.print("Adding 10 to last in cloned list.........");
        System.out.print("\nOrginal List:- "+arr);
        System.out.print("\nCloned list:- "+arr1);
        arr1.remove();

    }
}

 class MainList
 {
     public static void main(String [] args)
     {  //System.out.println("ONLY INTEGER VALUES!!!!");
        int ch;
        MyMap test= new MyMap();
        Scanner sc=new Scanner(System.in);
        do
        {   System.out.println("\nONLY INTEGER VALUES!!!!");
            System.out.print("\n1)Add\n2)Remove\n3)addList\n4)removeList\n5)Search by value\n6)Search by index\n7)Print List\n8)clearScreen\n9)Shallow clone\n10)deepClone\n11)Replace\n12)Sublist_print\n13)Exit\nEnter your choice number:- ");
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
                    test.addList();
                    break;
                case 4:
                    test.removeList();
                    break;
                case 5:
                    System.out.print("\nEnter the value to be searched:- ");
                    int value=sc.nextInt();
                    System.out.print("\n"+test.search(value));
                    break;
                case 6:
                    System.out.print("\nEnter the index to be searched:- ");
                    int index=sc.nextInt();
                    System.out.print("\n"+test.searchIndex(index));
                    break;
                case 7:
                    test.print();
                    break;
                case 8:
                    test.clearScreen();
                    break;
                case 9: 
                    test.shallowClone();
                    break;
                case 10:
                    test.deepClone();
                    break;
                case 11:
                    test.replace();
                    break;
                case 12:
                    System.out.print("Starting index :-");
                    int si=sc.nextInt();
                    System.out.print("Ending Index:- ");
                    int fi=sc.nextInt();
                    test.sublistPrint(si,fi); 
                    break;   
                case 13:
                    System.out.print("\n++++++++++++CLOSING+++++++++++++");
                    break;
                default:
                    System.out.print("Invalid input");
            }
        }while(ch!=13);
     }
 }