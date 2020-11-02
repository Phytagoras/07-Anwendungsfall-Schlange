package model;

//TODO 01: Fertigstellen das Klasse Schlange gemäß der Dokumentation vom Land.
public class Queue<ContentType> {
    private class Node{
        private Node next;
        private ContentType content;

        public Node(ContentType pContent){
            content = pContent;
            next = null;
        }

        public ContentType getContent(){
            return content;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public Node getNext(){
            return next;
        }
    }

    private Node head;
    private Node tail;

    public Queue(){
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }

    public void enqueue(ContentType pContent){
        if(pContent != null){
            Node newNode = new Node(pContent);
            //Falls die Schlange leer ist...
            if(this.isEmpty()){
                head = newNode;
                tail = newNode;
            }else{ //sonst...
                tail.setNext(newNode);
                tail = newNode;
            }
        }
    }
}