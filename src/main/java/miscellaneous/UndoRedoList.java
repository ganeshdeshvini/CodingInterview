package miscellaneous;

interface Command {
    void undo();

    void redo();
}

public class UndoRedoList<T> implements Command {
    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    Node<T> first;
    Node<T> last;
    Node<T> redo;

    @Override
    public void undo() {
        if (first == null) {
            System.out.println("NO DATA TO UNDO");
        } else {
            T data = this.first.data;
            System.out.println(data + " undo");
            this.first = this.first.next;
            //

        }
    }

    void addToRedoList(T data) {
        Node<T> newNode = new Node<T>(data);
        if (this.redo == null) {
            this.redo = newNode;
        } else {
//			newNode.next = 
            System.out.println(data + " undo");
            this.first = this.first.next;
        }
    }

    @Override
    public void redo() {
        if (redo == null) {
            System.out.println("NO DATA TO UNDO");
        }
    }

    void append(T data) {
        Node<T> newNode = new Node<T>(data);

        if (this.first == null) {
            this.first = newNode;
            this.last = this.first;
        } else {
            this.first.next = this.first;
            this.first = newNode;
        }

    }

    public static void main(String[] args) {

    }
}
