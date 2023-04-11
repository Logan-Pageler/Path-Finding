package test;

import structures.ArithmeticSolver;
import structures.Stack;

public class ArtTest {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        stack.push(15);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println(ArithmeticSolver.evaluate("((5*10)+5)*"));
    }
}
