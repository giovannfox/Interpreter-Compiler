package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    public void dump(){
        ArrayList<Integer> cloneStack;
        cloneStack = (ArrayList) runTimeStack.clone();
        ArrayList holdArray[] = new ArrayList[framePointer.size()];
        for( int i = framePointer.size(); i > 0; i--){
            holdArray[i-1] = new ArrayList<>();
            int top = framePointer.get(i - 1);
            int size = cloneStack.size();
            for(int k = top; k < size; k++ ){
                holdArray[i-1].add(cloneStack.remove(top));
            }
        }
        for(int g = 0; g < framePointer.size(); g++){
            System.out.print(holdArray[g].toString());
        }
        System.out.println();
    }
    public int peek(){
        if(runTimeStack.size() > 0){
            return runTimeStack.get(runTimeStack.size() - 1);
        }
        else{
            return runTimeStack.get(0);
        }
    }
    public int push(int i){
        runTimeStack.add(i);
        return peek();

    }
    public int pop(){
        if(runTimeStack.size()> 0){
            int i = runTimeStack.get(runTimeStack.size() - 1);
            runTimeStack.remove(runTimeStack.size() - 1);
            return i;
        }
        return 0;

    }
    public int store(int offset){
        int top = framePointer.peek();
        runTimeStack.set((offset + top), pop());
        return top;
    }

    public int load(int offset){
        int i = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(i);
        return i;
    }
    public void newFrameAt(int offset){
        framePointer.add((runTimeStack.size()) - offset);
    }

    public void popFrame(){
        int i = runTimeStack.get(runTimeStack.size() - 1);

        while(runTimeStack.size() != framePointer.peek()) {
            runTimeStack.remove(runTimeStack.size()- 1);
        }
        runTimeStack.add(i);
        framePointer.pop();
    }

    public Integer[] getTopFrame() {
        if(getTopFrameSize() < 0)
            return null;
        Integer[] frame = Arrays.copyOf(runTimeStack.toArray(), runTimeStack.size(), Integer[].class);
        return Arrays.copyOfRange(frame, framePointer.peek(), runTimeStack.size());
    }

    public int getTopFrameSize() {
        if(framePointer.isEmpty())
            return -1;
        return runTimeStack.size() - framePointer.get(framePointer.size() - 1);
    }

    public int storeStack(int value) {
        int top = framePointer.peek();
        runTimeStack.set((value + top), pop());
        return top;
    }
}
