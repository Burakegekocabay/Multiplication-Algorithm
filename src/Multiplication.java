import java.util.*;
public class Multiplication
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> linked1 = new LinkedList<>();
        LinkedList<Integer> linked2 = new LinkedList<>();
        LinkedList<Integer> result_multiplication = new LinkedList<>();
        LinkedList<Integer> result_sum = new LinkedList<>();
        
        System.out.print("Enter the first number: ");
        String num1=sc.nextLine();
        System.out.print("Enter the second number: ");
        String num2=sc.nextLine();
        sc.close();
        
        for (int i = 0; i < num1.length(); i++) 
            linked1.add(Integer.parseInt(num1.charAt(i)+"")); //parseInt string input to Integer Object

        for (int j = 0; j < num2.length(); j++) 
            linked2.add(Integer.parseInt(num2.charAt(j)+"")); //parseInt string input to Integer Object

        for (int k = 0; k <linked1.size() + linked2.size(); k++) 
        {
            result_sum.add(0); //adding 0 to result linked list
        }
        //------------------------------------------------
        for (int i = linked2.size()-1; i!=-1; i--) 
        {
            
            result_multiplication.clear();
            result_multiplication=multiply(linked1, linked2,i);
            /*We created multiplication linkedlist here example: 232X685 
            i=0 : 1160
            i=1 : 1856
            i=2 : 1392
            */


            for (int addLast = i; addLast !=linked2.size()-1; addLast++) 
            {
                result_multiplication.add(0);
            }
            /* in multiplication
             *    123
             *    23
             *    1 
             * +
             * -------
             * means 
             * 123
             * 230
             * 100
             * 
             * 1+2+1 , 2+3+0 , 3+0+0 = 4,5,3
             */


            while(result_multiplication.size()!=result_sum.size())
            {
                if(result_multiplication.size()>result_sum.size())
                    result_sum.addFirst(0);
                                                //if sum linkedlist and new multiplication linkedlist dont have same length , add 0 to equeal the length
                else
                    result_multiplication.addFirst(0);

            } 
            int d_extra=0;
            
            for (int digit = result_sum.size()-1; digit!=-1; digit--) 
            {
                int d_sum=result_sum.get(digit)+result_multiplication.get(digit)+d_extra;
                d_extra=0;
                if(digit!=0)
                {
                    if (d_sum<10)
                        result_sum.set(digit, d_sum);
                    else
                    {
                        d_extra=d_sum/10;
                        result_sum.set(digit, d_sum%10);
                    }
                }
                else
                {
                    if(d_sum>10)
                    {
                    result_sum.set(0,d_sum%10);
                    result_sum.addFirst(d_sum/10);
                    }
                    else
                        result_sum.set(0, d_sum);
                }
            }     
            
        }

        System.out.println("     "+num1);
        System.out.println("     "+num2);
        //First spaces are 5unit others oto.

        System.out.println("x");
        System.out.println("------------");
        LinkedList<String> temporary =new LinkedList<>();
        int step=0;
        for (int i = linked2.size()-1; i !=-1 ; i--) 
        {
            String s =multiply(linked1, linked2, i).toString();
            s=s.substring(1, s.length()-1);
            s=s.replace(",","");
            s=s.replace(" ","");
            for (int j = 0; j < linked2.size()-step; j++)
                s=" "+s; //align steps
            
            step++;
            temporary.add(s);
            
        }

            
        for (int i = 0; i < temporary.size(); i++) 
            System.out.println(temporary.get(i));
    

        
        System.out.println("+");
        System.out.println("------------");
        if(result_sum.get(0)==0)
            result_sum.remove(0);


        for (int i = 0; i < result_sum.size(); i++) 
            System.out.print(result_sum.get(i));
            
        
    }

     static LinkedList<Integer> multiply(LinkedList<Integer> linked1,LinkedList<Integer> linked2,int i) 
    {
            LinkedList<Integer> result_multiplication = new LinkedList<>();
        
            int extra=0;
            result_multiplication.clear();
            for (int j = linked1.size()-1; j!=-1 ; j--) 
            {
                int x=linked1.get(j); 
                int y=linked2.get(i);

                int number=x*y+extra;
                extra=0;

                if(j!=0)
                {
                    if(number>=10)
                    {
                        extra=number/10;
                        number=number%10;
                    }
                    result_multiplication.addFirst(number);
                }
                else
                {
                    if(number>=10)
                    {
                    int n1=number/10;
                    int n2=number%10;
                    result_multiplication.addFirst(n2);
                    result_multiplication.addFirst(n1);
                    }
                    else
                        result_multiplication.addFirst(number);
                    
                }
                
            
            }       
            return result_multiplication;
    
    }

    
}