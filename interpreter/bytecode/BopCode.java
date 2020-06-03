package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class BopCode extends ByteCode {

    private String operator;

    @Override
    public void init(ArrayList<String> args) {
        operator = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm){
        int operatorOne = vm.popStack();
        int operatorTwo = vm.popStack();

        if(operator.equals("+"))
            vm.pushStack(operatorOne + operatorTwo);
        else if(operator.equals("-"))
            vm.pushStack(operatorTwo - operatorOne);
        else if(operator.equals("/"))
            vm.pushStack(operatorTwo / operatorOne);
        else if(operator.equals("*"))
            vm.pushStack(operatorTwo * operatorOne);
        else if(operator.equals("==")) {
            if(operatorTwo == operatorOne)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
        else if(operator.equals("!=")) {
            if(operatorTwo == operatorOne)
                vm.pushStack(0);
            else
                vm.pushStack(1);
        }
        else if(operator.equals("<")) {
            if(operatorTwo < operatorOne)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
        else if(operator.equals(">")) {
            if(operatorTwo > operatorOne)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
        else if(operator.equals("&")) {
            if(operatorTwo * operatorOne == 1)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
        else if(operator.equals("<=")) {
            if (operatorTwo <= operatorOne)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
        else if(operator.equals(">=")) {
            if(operatorTwo >= operatorOne)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
        else if(operator.equals("|")) {
            if(operatorTwo == 1 || operatorOne == 1)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
    }
    public String print(){
        return ("BOP " + operator);
    }
}


