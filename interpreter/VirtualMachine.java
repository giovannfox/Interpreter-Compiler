package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runTimeStack;
    private Stack<Integer> returnAddress;
    private Program program;
    private int programCounter;
    private boolean isRunning = true;
    private boolean isDump = true;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        isDump = false; //true to test dump

        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            programCounter++;
            if (isDump) {
                System.out.println(code);
                this.runTimeStack.dump();
            }
        }
    }

    public void newFrameStack(int val) {
        runTimeStack.newFrameAt(val);
    }
    public void setDump(boolean boolDumping){
        isDump = boolDumping;
    }


    public int popStack() {
        return runTimeStack.pop();
    }

    public void pushStack(int val) {
        runTimeStack.newFrameAt(val);
    }

    public int getProgramCounter() {
        return programCounter;

    }

    public void pushReturnAddress(int address) {
        returnAddress.push(address);
    }

    public void setProgramCounter(int newProgramCounter) {
        programCounter = newProgramCounter;
    }

    public Integer[] getTopFrame() {
        return runTimeStack.getTopFrame();
    }
    public int getTopFrameSize(){
        return runTimeStack.getTopFrameSize();
    }
    public void setRun(boolean boolRunning) {
        isRunning = boolRunning;
    }
    public int loadRunStack(int offset) {
        return runTimeStack.load(offset);
    }
    public int popReturnAddress() {
        return returnAddress.pop();
    }

    public void popFrame() {
        runTimeStack.popFrame();
    }

    public int storeStack(int value) {
        return runTimeStack.storeStack(value);
    }

    public int peekStack() {
        return runTimeStack.peek();
    }
}
