import java.util.ArrayList;
import java.util.Scanner;

public class Regexp {
    public static void main(String[] args) {

        String[] regex = {  "(a(bc)?de)", "(a(bc)+de)", "((A*KB|AC)D)", "((A*|B))", "((A*B*c*|MIB))" };
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        NFA n = new NFA(regex[4]);
        if (n.matched(t)) { System.out.println("YES"); }
    }
}