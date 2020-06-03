package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class CallCode extends JumpCode {

    private String label;
    private String cleanedLabel;
    private Integer[] args;
    private int address;



    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }


    @Override
    public String getLabel(){
        return label;
    }

    @Override
    public void setAddress(int settledAddress){
        address = settledAddress;
    }


    @Override
    public void execute(VirtualMachine vm){
        vm.pushReturnAddress(vm.getProgramCounter());
        vm.setProgramCounter(address);
        args = vm.getTopFrame();
    }
    public String print(){
        return (" ");
    }
}
