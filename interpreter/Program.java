package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.JumpCode;
import java.util.ArrayList;
import java.util.HashMap;
import interpreter.bytecode.LabelCode;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> addresses;

    public Program() {
        program = new ArrayList<>();
        addresses = new HashMap<>();
    }
    public int getSize() {
        return this.program.size();
    }
    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }
    public void addCode(ByteCode newByteCode) {
        if (newByteCode instanceof LabelCode)
            addresses.put(((LabelCode) newByteCode).getLabel(), program.size());

        program.add(newByteCode);
    }
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress() {
        for(ByteCode currentByteCode : program) {
            if(currentByteCode instanceof JumpCode) {
            }
        }

    }

    protected void addByteCode(ByteCode code) {
        program.add(code);
    }
}









