import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */


class StackWorklist implements SearchWorklist {
	Stack<Square> contents;
	public StackWorklist() {
		this.contents = new Stack<Square>();
	}
	@Override
	public void add(Square c) {
		// TODO Auto-generated method stub
		contents.push(c);
	}

	@Override
	public Square remove() {
		// TODO Auto-generated method stub
		return contents.pop();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return contents.empty();
	}
	
}

class QueueWorklist implements SearchWorklist {
	
	ArrayList<Square> contents;
	
	public QueueWorklist() {
		this.contents = new ArrayList<Square>();
	}
	@Override
	public void add(Square c) {
		// TODO Auto-generated method stub
		contents.add(c);
	}

	@Override
	public Square remove() {
		// TODO Auto-generated method stub
		return contents.remove(0);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return contents.isEmpty();
	}

}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
