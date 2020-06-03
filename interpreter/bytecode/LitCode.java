package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;


public class LitCode extends ByteCode{
    private int value;
    private String variableName;

    @Override
    public void init(ArrayList<String> args){
        value = Integer.parseInt(args.get(0));
        if(args.size() > 1){
            variableName = args.get(1);
        }
    }
    @Override
    public void execute(VirtualMachine vm){
        vm.pushStack(value);
    }

    @Override
    public String print() {
        String base = "LIT" + value;
        if(variableName != null){
            base = base + " " + variableName + "       int " + variableName;
        }
        return base;
    }

}
