package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class GoToCode extends JumpCode{
    private String label;
    private int branchAddress;

    @Override
    public void init(ArrayList<String> args){
        label = args.get(0);
    }
    @Override
    public void execute(VirtualMachine vm){
        vm.setProgramCounter(branchAddress);
    }
    @Override
    public String getLabel(){
        return label;
    }
    @Override
    public void setAddress(int resolvedAddress) {
        branchAddress = resolvedAddress;
    }
    @Override
    public String print(){
        return ("GOTO " + label);
    }
}