import com.sun.source.tree.Tree;

import java.util.PrimitiveIterator;

public class BST<E extends Comparable<E>> {
    TreeNode root;
    int amount;
    public BST(){
        amount = 0;
    }


    public boolean contains(E value){
        String list;
        String check = "" + value;
        list = inorder();
        boolean result = list.contains(check);
        return result;
    }

    public int countNodes(){
        String[] arr = inorder().split(",");
        return arr.length;
    }


    public int countLeafNodes(){
        return lhelper(root);
    }

    public int lhelper(TreeNode <E> cur){
        int out =  0;
        if (cur.getRightChild() != null && cur.getLeftChild() != null){
            out = out + lhelper(cur.getRightChild()) + lhelper(cur.getLeftChild());
        }
        else if(cur.getRightChild() != null && cur.getLeftChild() == null){
            out = out + lhelper(cur.getRightChild());
        }
        else if(cur.getRightChild() == null && cur.getLeftChild() != null){
            out = out + lhelper(cur.getLeftChild());
        }
        else{return 1;}

        return out;
    }



    public String inorder(){
        return inhelper(root);
    }

    public String  inhelper(TreeNode <E> cur){
        String output = "";
        if (cur.getRightChild() == null && cur.getLeftChild() == null) {
        return output + cur.getValue();
        }
        else if (cur.getLeftChild() != null  && cur.getRightChild() == null) {
            output = output + inhelper(cur.getLeftChild()) + "," + cur.getValue();
        }
        else if (cur.getLeftChild() == null  && cur.getRightChild() != null) {
            output = output + cur.getValue() + "," + inhelper(cur.getRightChild())  ;
        }
        else {
            output = output + inhelper(cur.getLeftChild()) + "," + cur.getValue() + "," + inhelper(cur.getRightChild());
        }
        return output;
    }



    public String postorder(){
        return posthelper(root);
    }
    public String  posthelper(TreeNode <E> cur){
        String output = "";
        if (cur.getRightChild() == null && cur.getLeftChild() == null) {
            return output + cur.getValue();
        }
        else if (cur.getLeftChild() != null  && cur.getRightChild() == null) {
            output += posthelper(cur.getLeftChild()) + "," + cur.getValue();
        }
        else if (cur.getLeftChild() == null  && cur.getRightChild() != null) {
            output += posthelper(cur.getRightChild())+ "," + cur.getValue()  ;
        }
        else {
            output += posthelper(cur.getLeftChild()) + "," + posthelper(cur.getRightChild())+ "," + cur.getValue() ;
        }
        return output;
    }


    public String preorder(){
        return prehelper(root);
    }
    public String  prehelper(TreeNode <E> cur) {
        String output = "";
        if (cur.getRightChild() == null && cur.getLeftChild() == null) {
            return output + cur.getValue();
        }
        else if (cur.getLeftChild() != null  && cur.getRightChild() == null) {
            output += prehelper(cur.getLeftChild()) + "," + cur.getValue();
        }
        else if (cur.getLeftChild() == null  && cur.getRightChild() != null) {
            output += cur.getValue() + "," + prehelper(cur.getRightChild())  ;
        }
        else {
            output += cur.getValue() + "," + prehelper(cur.getLeftChild())+ "," + prehelper(cur.getRightChild()) ;
        }
        return output;
    }



    public void add(E value){
        if (amount == 0){
            System.out.println("Root : " + value);
            System.out.println("-------------------");
            root = new TreeNode<E>(value,null,null);
            amount =+ 1;
        }

        else{
            TreeNode node = new TreeNode<E>(value,null,null);
            TreeNode current = root;
            boolean empty = true;
            System.out.print(value + " : ");
            while (empty){

                if (current.compareTo(node) == 0 || current.compareTo(node) == 1)   {
                    //go to left
                    if(current.getLeftChild() == null){
                        current.setLeftChild(node);
                        System.out.print("Left,");
                        empty = false;
                    }
                    else{current = current.getLeftChild();System.out.print("Left,");}


                }else {
                    //go to right
                    if(current.getRightChild() == null){
                        current.setRightChild(node);
                        System.out.print("Right,");
                        empty = false;
                    }else{current = current.getRightChild();System.out.print("Right,");}
                }
            }System.out.println();
            System.out.println("-------------------");
        }

    }

}
