package projectss.atm;
import java.util.*;


class user_actions{
    int total_money=0;
    ArrayList<String> transaction = new ArrayList<>();
    public void transactions_history(){
        if(transaction.size()>0){
            for(int i=0;i<transaction.size();i++){
                System.out.println(transaction.get(i));
            }
        }
        else{
            System.out.println(" You don't have any previos transaction");
        }
    }
    
    public void withdraw(){
        Scanner in = new Scanner(System.in);
        System.out.println(" enter total amount you want to withdrwa");
        int amount_withdraw = in.nextInt();
        if(amount_withdraw>total_money){
            System.out.println(" you enetered amount larger than total ");
        }else{
            total_money -= amount_withdraw;
            System.out.println(" withdrwal successfull");
            transaction.add(" withdran " + amount_withdraw + " of money");
        }
        
    }

    public void deposite(){
        Scanner in = new Scanner(System.in);
        System.out.println(" how much you want to deposite");
        int deposite_amount = in.nextInt();
        total_money += deposite_amount;
        System.out.println(" money deposited successfully");
        transaction.add(" deposited " + deposite_amount + " of money");
    }

    public int[] transfer(ArrayList<String> newList){
        Scanner in = new Scanner(System.in);
        int arr[] =  new int[2] , p=0;
        System.out.println(" enter the id of reciever");
        String rec_id = in.next();
        System.out.println(" now enter the money you want to transfer ");
        int tran_amount = in.nextInt();

        if(tran_amount > total_money){
            System.out.println(" out of balance for this money");
        }
        else{
            total_money -= tran_amount;
            System.out.println(" succesfully tranfered the amount " + tran_amount);
            transaction.add(" transfer "+tran_amount + " to the account " +rec_id);
            for(int i=0;i<newList.size();i++){
                if(newList.get(i).equals(rec_id)){
                    p=i;
                    break;
                }
            }
            arr[0]=p;
            arr[1] = tran_amount;
            return arr;
        }
        for(int i=0;i<newList.size();i++){
            if(newList.get(i).equals(rec_id)){
                p=i;
                break;
            }
        }
        arr[0]=p;
        arr[1] =0;
        return arr;

    }

    public void check_balance(){
        System.out.println(" your balance is " +total_money);
    }

}
public class atm{

    public static void login_creds(){
        ArrayList<String> user_id = new ArrayList<>();
        user_id.add("rahul_90");
        user_id.add("ekam_78");
        user_id.add("rah@11");
        ArrayList<String> passwords = new ArrayList<>();
        passwords.add("1234");
        passwords.add("5678");
        passwords.add("0987");

        user_actions[] users = new user_actions[3];
        users[0] = new user_actions();
        users[1] = new user_actions();
        users[2] = new user_actions();
        Scanner in = new Scanner(System.in);
        while(true){
            test_1:
            {
                System.out.println(" login with your account ");
                System.out.println(" enter the user id");
                String id = in.next();
                System.out.println("enter your 4 digit pin");
                int  pins = in.nextInt();
                String str = String.valueOf(pins);
                boolean test = false;
                for(int i=0;i<user_id.size();i++){
                    if(user_id.get(i).equals(id) && passwords.get(i).equals(str)){
                        test = true;
                        while(true){
                            System.out.println(" choose your operations ");
                            System.out.println("choose: 1:Transaction History \n 2:Withdraw \n 3:Deposite \n 4:Transfer Money \n 5:Check balanace \n 6:Quit ");
                            int choice = in.nextInt();
                            switch(choice){
                                case 1: 
                                    users[i].transactions_history();
                                    break;
                                case 2: 
                                    users[i].withdraw();
                                    break;
                                case 3: 
                                    users[i].deposite();
                                    break;
                                case 4: 
                                    users[i].transfer(user_id);
                                    break;
                                case 5: 
                                    users[i].check_balance();
                                    break;
                                case 6:
                                     System.exit(0);
                                     break;
                                case 7:
                                    return;
                                default :
                                    System.out.println(" Not a valid choise ");
                            }
                        }
                    }
                }
                if(!test){
                    System.out.println(" your login credentials did not match");
                    break test_1;
                }
            }
        }
    }
     public static void main(String[] args) {
        
            login_creds();
    }
}

