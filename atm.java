package projectss.atm;
import java.util.Scanner;
public class atm {
    public static void auth(){
        String userid = "rahul";
        String pass = "123rahul";
        System.out.println(" enter details to login\n");
        Scanner sc = new Scanner(System.in);
        System.out.println(" enter the id first: ");
        String chkid = sc.next();
        System.out.println(" now the password: ");
        String chkpass = sc.next();

        if(chkid.equals(userid) && chkpass.equals(pass)){
            System.out.println(" login succesfull!");
            operation();
        }
        else{
            System.out.println("sorry ! wrong credentials login again\n");
            auth();
        }
        sc.close();
    }

 public static void operation(){
 
    int  balance =1000, deposit, withdwal;
    try (Scanner sc = new Scanner(System.in)) {
        while(true){
            System.out.println(" what do you want to do? enter your choise\n");
            System.out.println(" press 1 for withdwal \n press 2 for deposit  \n 3 to check your balance \n 4 to quit \n");
            int choice =sc.nextInt();
            switch(choice){
              case 1:
                    System.out.println("you have total of :" +balance);
                    System.out.println(" enter the withdrwal ammount: ");
                    withdwal = sc.nextInt();
                    if(withdwal>balance){
                        System.out.println(" insufficeint balance");
                    }
                    else{
                        balance = balance-withdwal;      
                        System.out.println(" Money withdrawl sucessful ");
                        System.out.println("Balance: "+balance);
                    }
                   // operation();
                    break;
                case 2:     
                    System.out.println(" enter the ammount you want to add");
                    deposit = sc.nextInt();
                    if(deposit<0){
                        System.out.println(" enter positive ammount value");
                    }
                    else{
                        balance = balance+deposit;
                        System.out.println(" Money depositd sucessfully");
                        System.out.println("balance: "+balance);
                    }
                    //operation();
                        break;
                case 3:
                    System.out.println(" Your current balance is : " +balance);
                    System.out.println();
                    break;
                case 4:
                    System.exit(0);
                    break;
                
                default:
                    System.out.println(" invalid input ");
                    break;
            }
        }
    }   
    catch (Exception e) {
           System.out.println( " you have an exception ");
    }
 }

    public static void main(String[] args) {
       // Scanner sc = new Scanner(System.in);
        auth();
        //operation();
    }
}
