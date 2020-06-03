package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ReturnCode extends ByteCode{
    private String label;

    @Override
    public void init(ArrayList<String> args){
        if(args.size() > 0){
            label = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine vm){
        vm.setProgramCounter(vm.popReturnAddress());
        vm.popFrame();
    }
    @Override
    public String print(){
        return ("RETURN" + label);
    }
}
