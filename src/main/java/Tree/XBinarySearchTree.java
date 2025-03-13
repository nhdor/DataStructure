package Tree;

import java.util.List;

public class XBinarySearchTree<T extends Comparable<T>> implements XBinaryTree<T> {

    Node<T> root;

    public XBinarySearchTree() {
        root = null;
    }

    @Override
    public void insert(T value) {
        Node<T> NewNode = new Node<>(value);

        if(root == null) {
            root = NewNode;
            return;
        }

        Node<T> current = root;

        // -1 / 0 / 1
        int compareNum;
        Node<T> parentNode;

        //current가 null이 아니면 반복
        do{
             compareNum = current.data.compareTo(value);
             parentNode = current;
             if(compareNum < 0) {
                 current = current.right;
             }else if(compareNum > 0) {
                 current = current.left;
             }else{
                 //중복값(current.data == value.data)
                 return;
             }
        }while(current != null);

        //current = null
        current = new Node<>(value);
        current.parent = parentNode;
    }

    /**
     * 1. 삭제되는 노드의 자리의 successor 찾기
     * @param node : 삭제되는 노드
     * @return successor
     */

    public Node<T> getSuccessorAndUnlink(Node<T> node) {
        Node<T> parent = node;
        Node<T> successor = node.right;

        //왼쪽 자식 노드가 없는 경우, 오른쪾 자식 노드가 바로 후계자
        if(successor.left == null) {
            parent.right = successor.right;
            if(successor.right != null) {
                successor.right.parent = parent;
            }
            return successor;
        }

        while(successor.left != null){
            parent = successor;
            successor = successor.left;
        }

        if(successor.right != null) {
            parent.left = successor.right;
            successor.right.parent = parent;
        }

        successor.right = null;
        return successor;
    }

    //후계자 찾기
    @Override
    public void delete(T value) {

        Node<T> parent = null;
        Node<T> current = root;

        boolean hasLeft = false;

        int compareNum;

        do{
            compareNum = current.data.compareTo(value);
            parent = current;
            if(compareNum < 0) {
                hasLeft = false;
                current = current.right;
            }else if(compareNum > 0) {
                hasLeft = true;
                current = current.left;
            }else{
                break;
            }
        }while(current != null);

        if(current == null) {
            return;
        }
        if(parent == null) {
            deleteNode(current);
        }

        //삭제하려는 노드가 부모노드의 왼쪽 자식일 경우
        if(hasLeft) {
            parent.left = current;
            deleteNode(current);
            if(parent.left != null) {
                parent.left.parent = parent;
            }
        }else{
            parent.right = current;
            deleteNode(current);
            if(parent.right != null) {
                parent.right.parent = parent;
            }
        }
    }

    public void deleteNode(Node<T> node) {

        //1. 삭제하려는 노드가 자식 노드를 갖고 있지 않을 때
        if(node.left == null && node.right == null) {
            if(node == root) {
                root = null;
            }
            else{
                node = null;
            }
        }
        ///3. 삭제하는 노드가 왼쪽, 오른쪽 자식 모두 갖고 있을 때
        if(node.left != null && node.right != null) {
            node.data = getSuccessorAndUnlink(node).data;
        }else if(node.left != null) {
            //2. 삭제하려는 노드가 왼쪽 자식 노드를 갖고있을 때
            if(node == root){
                node = node.left;
                root = node;
                root.parent = null;
            }else{
                node = node.left;
            }
        }else if(node.right != null) {
            //2. 삭제하는 노드가 오른쪽 자식 노드를 갖고있을 때
            if(node == root){
                node = node.right;
                root = node;
                root.parent = null;
            }else{
                node = node.right;
            }
        }
    }


    @Override
    public boolean search(T value)
    {
        Node<T> current = root;
        int compareNum;
        //current가 null이 아니면 반복
        do{
            compareNum = current.data.compareTo(value);
            if(compareNum < 0) {
                current = current.right;
            }else if(compareNum > 0) {
                current = current.left;
            }else{
                return true;
            }
        }while(current != null);
        return false;
    }


    @Override
    public List<T> inorderTraversal() {
        return List.of();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }




    private class Node<T> {

        private T data;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;

        Node(T data) {
            this.data = data;
        }

    }

}
