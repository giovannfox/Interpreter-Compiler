package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class WriteCode extends ByteCode {

    @Override
    public void init(ArrayList<String> args){
    }

    @Override
    public void execute(VirtualMachine vm){
        System.out.println(vm.peekStack());
    }
    public String print(){
        return ("WRITE");
    }
}
