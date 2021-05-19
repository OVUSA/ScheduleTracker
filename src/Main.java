import java.util.Scanner;

public class Main {
    public static void main(String [] args){

        System.out.println("Welcome to schedule tracker. Here you can accurately evaluate" +
                " time spend on certain tasks as well as on breaks throughout the workday.");

        System.out.println("Please, enter you name: ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        Manager mn =new Manager(userName);
        System.out.println("Very well,"+ userName+"!");
        mn.menu();




    }


}
