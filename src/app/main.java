package app;

import stack.Stack;
import stack.StackEmptyException;
import stack.StackFullException;

public class main {
    public static void main(String[] args) {
        Stack<String> names = new Stack<String>(String.class, 5);
        try {
            names.push("Kike");
            names.push("Gustavito");
            names.push("Ana Gabriela");
            names.push("Andrik");
            names.push("Ricardo 2");
            System.out.println(names.pop());
            names.push("Mr. Bean");
            System.out.println("el peek:"+names.peek());
            System.out.println(names.size());
            System.out.println(names.search("Gustavito"));
            System.out.println("imprimiendo:");
            for (String string : names){
                System.out.println(string);
            }
        }
        catch (StackEmptyException | StackFullException f){
            f.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
