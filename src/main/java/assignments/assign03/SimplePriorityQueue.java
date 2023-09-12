package assignments.assign03;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SimplePriorityQueue<Type> implements PriorityQueue<Type> {

    private Type[] queue;
    private Comparator<? super Type> comparator;

    @SuppressWarnings("unchecked")
    public SimplePriorityQueue()
    {
        queue = (Type[]) new Object[0];
    }

    @SuppressWarnings("unchecked")
    public SimplePriorityQueue(Comparator<? super Type> comp)
    {
        comparator = comp;
        queue = (Type[]) new Object[0];
    }

    @SuppressWarnings("unchecked")
    private int binarySearch(Type target)
    {
        if(this.queue[0] == null) return 0;
        int low = 0, high = this.nonNullElements()-1, mid = high / 2;
        while(low <= high)
        {
            mid = (low + high) / 2;
            if(this.queue[mid] == null) return mid;
            int value = this.comparator == null ? ((Comparable<? super Type>)this.queue[mid]).compareTo(target) : this.comparator.compare(this.queue[mid], target);
            if(value == 0) return mid;
            else if(value < 0) high = mid - 1;
            else low = mid + 1;
        }
        return mid;
    }

    @SuppressWarnings("unchecked")
    private void resize(int reqSize)
    {
        int newSize;
        if(this.size() == 0) newSize = 1;
        else newSize = this.size();
        if(newSize < reqSize) while(newSize < reqSize) newSize *= 2;
        else if(newSize > reqSize) while(true)
        {
            if((newSize / 2) < reqSize) break;
            newSize /= 2;
        }
        Type[] newQueue = (Type[]) new Object[newSize];
        for(int i = 0; i < this.size(); i++)
            newQueue[i] = this.queue[i];
        this.queue = newQueue;
    }

    private int nonNullElements()
    {
        for(int i = 0; i < this.queue.length; i++)
            if(this.queue[i] == null) return i;
        return this.size();
    }

    @Override
    public Type findMax() throws NoSuchElementException
    {
        if(this.isEmpty()) throw new NoSuchElementException("The array is empty.");
        return this.queue[0];
    }

    @Override
    public Type deleteMax() throws NoSuchElementException
    {
        if(this.isEmpty()) throw new NoSuchElementException();
        Type output = this.queue[0];
        for(int i = 0; i < this.size() - 1;i++)
        {
            this.queue[i] = this.queue[i+1];
        }
        return output;
    }

    private void shiftBack(int fromIndex)
    {
        for(int i = this.queue.length - 1; i > 0; i--)
        {
            if(this.queue[i - 1] == null) continue;
            this.queue[i] = this.queue[i - 1];
        }
    }

    @Override
    public void insert(Type item)
    {
        if(this.nonNullElements() + 1 >= this.size()) resize(this.size() + 1);
        int nearestIndex = binarySearch(item);
        int comp;
        if(this.queue[nearestIndex] == null) comp = 0;
        else comp = this.comparator == null ? ((Comparable<? super Type>)this.queue[nearestIndex]).compareTo(item) : this.comparator.compare(this.queue[nearestIndex], item);
        if(comp <= 0)
        {
            shiftBack(nearestIndex);
            this.queue[nearestIndex] = item;
        } else {
            shiftBack(nearestIndex + 1);
            this.queue[nearestIndex + 1] = item;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void insertAll(Collection<? extends Type> coll)
    {
        if(this.nonNullElements() + coll.size() > this.size()) resize(this.nonNullElements() + coll.size());
        Type[] collArray = (Type[]) new Object[coll.size()];
        coll.toArray(collArray);
        for(Type item : collArray)
        {
            this.insert(item);
        }
    }

    @Override
    public boolean contains(Type item)
    {
        return !this.isEmpty() && this.queue[this.binarySearch(item)] != null && this.queue[this.binarySearch(item)].equals(item);
    }

    @Override
    public int size()
    {
        return this.queue.length;
    }

    @Override
    public boolean isEmpty()
    {
        return this.nonNullElements() == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear()
    {
        this.queue = (Type[]) new Object[0];
    }
}
