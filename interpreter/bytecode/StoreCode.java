package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class StoreCode extends ByteCode {
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
        vm.storeStack(value);
    }
    @Override
    public String print(){
        return ("STORE" + value + " " + variableName);
    }
}
