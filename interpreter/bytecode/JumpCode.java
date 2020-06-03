package interpreter.bytecode;

public abstract class JumpCode extends ByteCode {
    public abstract String getLabel();
    public void setAddress(int address){
    }
}
