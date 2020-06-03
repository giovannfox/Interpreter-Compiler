package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class DumpCode extends ByteCode {

    private boolean dumpState;

    @Override
    public void init(ArrayList<String> args){
        if(args.get(0).equals("on")){
            dumpState = true;
        }
        else{
            dumpState = false;
        }

    }

    @Override
    public void execute(VirtualMachine vm){
        vm.setDump(dumpState);
    }

    public String print(){
        return (" ");
    }

}
