package month_202212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_5639 {
    static class Node{
        int num;
        Node left, right;

        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        public Node(int num) {
            this.num = num;
        }

        public void insertNode(int num){
            if(num<this.num){
                if(this.left==null)this.left=new Node(num);
                else this.left.insertNode(num);
            }else{
                if(this.right==null)this.right=new Node(num);
                else this.right.insertNode(num);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while(true){
            String input = br.readLine();
            if(input==null || input.equals("")){
                break;
            }
            root.insertNode(Integer.parseInt(input));
        }

        printNode(root);
    }

    private static void printNode(Node root) {
        if(root.left!=null)printNode(root.left);
        if(root.right!=null)printNode(root.right);
        System.out.println(root.num);
        return;

    }
}
