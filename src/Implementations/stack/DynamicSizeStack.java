package Implementations.stack;

public class DynamicSizeStack extends StackImplVariableSize {
    DynamicSizeStack() {
        super();
    }
    DynamicSizeStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) {
        if (this.isFull()) {
            //Creates stack of double size of current length
            int[] temp = new int[stack.length * 2];

            // copy all previous items in new data
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
        }
        return super.push(item);
    }
}
