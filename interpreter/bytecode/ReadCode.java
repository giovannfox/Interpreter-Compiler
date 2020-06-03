package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    private String input;

    @Override
    public void init(ArrayList<String> args){
    }

    @Override
    public void execute(VirtualMachine vm){
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter number");
        input = stdin.nextLine();
        try{
            int value = Integer.parseInt(input);
            vm.pushStack(value);
        }
        catch(Exception A){
            System.out.println("Must be a number");
        }
        }
    @Override
    public String print(){
        return ("READ");
    }
}
