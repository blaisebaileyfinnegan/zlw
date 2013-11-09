package edu.uci.mvu1;

public class TrinaryNode {
    public int data;

    public TrinaryNode middle;
    public TrinaryNode left;
    public TrinaryNode right;

    public TrinaryNode(int data) {
        this.data = data;
    }

    public TrinaryNode insert(int data) {
        if (this.data == data) {
            if (this.middle == null) {
                this.middle = new TrinaryNode(data);
                return this.middle;
            }

            return this.middle.insert(data);
        } else if (this.data < data) {
            if (this.right == null) {
                this.right = new TrinaryNode(data);
                return this.right;
            }

            return this.right.insert(data);
        } else {
            if (this.left == null) {
                this.left = new TrinaryNode(data);
                return this.left;
            }

            return this.left.insert(data);
        }
    }

}
