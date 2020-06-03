package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class PopCode extends ByteCode {
    private int value;

    @Override
    public void init(ArrayList<String> args){
        value = Integer.parseInt(args.get(0));
    }
    @Override
    public void execute(VirtualMachine vm){
        for(int i = 1; i < value; i++){
            vm.popStack();
        }
    }

    @Override
    public String print() {
        return ("POP " + value);
    }
}
