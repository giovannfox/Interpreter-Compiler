package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LabelCode extends JumpCode {
    private String label;

    @Override
    public void init(ArrayList<String> args){
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm){

    }
    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String print() {
        return ("LABEL " + label);
    }

}
