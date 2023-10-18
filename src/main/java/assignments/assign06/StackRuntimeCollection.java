package assignments.assign06;

public class StackRuntimeCollection {
    public static void main(String[] args)
    {
        int loopCount = 100;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        System.out.println("Begin runtime collection\nArrayStack\nStack size\t| Push\t\t\t| Peek\t\t\t| Pop");

        for(int i = 1; i <= 20; i++)
        {
            double[] averages = new double[3];// 0: push, 1: peek, 2: pop
            arrayStack.clear();
            fill(arrayStack, i * 10000);
            warmup();

            for(int j = 0; j < loopCount; j++)
            {
                long start = System.nanoTime();
                arrayStack.push(42);
                long end = System.nanoTime();
                averages[0] = averages[0] == 0 ? end - start : (averages[0] + (end - start)) / 2.0;
                start = System.nanoTime();
                arrayStack.peek();
                end = System.nanoTime();
                averages[1] = averages[1] == 0 ? end - start : (averages[1] + (end - start)) / 2.0;
                start = System.nanoTime();
                arrayStack.pop();
                end = System.nanoTime();
                averages[2] = averages[2] == 0 ? end - start : (averages[2] + (end - start)) / 2.0;
            }

            System.out.println((i * 10000) + "\t\t" + averages[0] + "\t" + averages[1] + "\t" + averages[2]);
        }

        System.out.println("\n\nBegin runtime collection\nLinkedListStack\nStack size\t| Push\t\t\t| Peek\t\t\t| Pop");

        for(int i = 1; i <= 20; i++)
        {
            double[] averages = new double[3];// 0: push, 1: peek, 2: pop
            linkedListStack.clear();
            fill(linkedListStack, i * 10000);
            warmup();

            for(int j = 0; j < loopCount; j++)
            {
                long start = System.nanoTime();
                linkedListStack.push(42);
                long end = System.nanoTime();
                averages[0] = averages[0] == 0 ? end - start : (averages[0] + (end - start)) / 2.0;
                start = System.nanoTime();
                linkedListStack.peek();
                end = System.nanoTime();
                averages[1] = averages[1] == 0 ? end - start : (averages[1] + (end - start)) / 2.0;
                start = System.nanoTime();
                linkedListStack.pop();
                end = System.nanoTime();
                averages[2] = averages[2] == 0 ? end - start : (averages[2] + (end - start)) / 2.0;
            }

            System.out.println((i * 10000) + "\t\t" + averages[0] + "\t" + averages[1] + "\t" + averages[2]);
        }
    }

    public static void warmup()
    {
        long start = System.nanoTime();
        while(System.nanoTime() - start <= 1E9);
    }

    public static void fill(Stack<Integer> stack, int size)
    {
        for(int i = 0; i < size; i++)
        {
            stack.push(i);
        }
    }
}
