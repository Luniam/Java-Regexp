import java.util.ArrayList;
import java.util.Scanner;

public class Regexp {
    public static void main(String[] args) {

        String[] regex = { "((A*KB|AC)D)", "(A*|B)" };
        Scanner sc = new Scanner(System.in);
        for (String reg : regex) {
            NFA n = new NFA(reg);
            System.out.println(reg);
            while (true) {
                System.out.println("Enter a string");
                String text = sc.nextLine();
                if (n.matched(text)) { System.out.println("Matched"); break; }
                else { System.out.println("Not matched"); }
            }
        }
    }
}