package assignments.assign06;

import java.net.URL;
import java.util.NoSuchElementException;

public class WebBrowser {

    private URL currentPage;
    private Stack<URL> last, next;

    public WebBrowser()
    {
        last = new LinkedListStack<>();
        next = new LinkedListStack<>();
    }

    public WebBrowser(SinglyLinkedList<URL> history)
    {
        last = new LinkedListStack<>(history);
        next = new LinkedListStack<>();
    }

    public void visit(URL webpage)
    {
        next.clear();
        if(currentPage != null) last.push(currentPage);
        currentPage = webpage;
    }

    public URL back() throws NoSuchElementException
    {
        if(last.isEmpty()) throw new NoSuchElementException();
        next.push(currentPage);
        currentPage = last.peek();
        return last.pop();
    }

    public URL forward() throws NoSuchElementException
    {
        if(next.isEmpty()) throw new NoSuchElementException();
        last.push(currentPage);
        currentPage = next.peek();
        return next.pop();
    }

    public SinglyLinkedList<URL> history()
    {
        SinglyLinkedList<URL> history = new SinglyLinkedList<>();
        LinkedListStack<URL> temp = new LinkedListStack<>();
        while(!last.isEmpty())
        {
            temp.push(last.pop());
        }
        while(!temp.isEmpty())
        {
            history.insertFirst(temp.peek());
            last.push(temp.pop());
        }
        history.insertFirst(currentPage);
        return history;
    }
}
