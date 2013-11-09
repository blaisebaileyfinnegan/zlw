package edu.uci.mvu1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TrinaryTreeTest {
    @Test
    public void testAdd() throws Exception {
        TrinaryTree tree = new TrinaryTree();
        tree.insert(5);

        assertEquals(5, tree.head.data);

        tree.insert(5);
        tree.insert(5);
        assertEquals(5, tree.head.middle.data);
        assertEquals(5, tree.head.middle.middle.data);

        tree.insert(7);
        tree.insert(-100);
        assertEquals(7, tree.head.right.data);
        assertEquals(-100, tree.head.left.data);

        tree.insert(7);
        assertEquals(7, tree.head.right.middle.data);

        tree.insert(6);
        assertEquals(6, tree.head.right.left.data);

        tree.insert(4);
        tree.insert(2);
        assertEquals(4, tree.head.left.right.data);
        assertEquals(2, tree.head.left.right.left.data);

        tree = new TrinaryTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(9);
        tree.insert(5);
        tree.insert(7);
        tree.insert(2);
        tree.insert(2);

        assertEquals(5, tree.head.data);
        assertEquals(4, tree.head.left.data);
        assertEquals(5, tree.head.middle.data);
        assertEquals(9, tree.head.right.data);
        assertEquals(2, tree.head.left.left.data);
        assertEquals(7, tree.head.right.left.data);
        assertEquals(2, tree.head.left.left.middle.data);
    }

    @Test
    public void testDelete() throws Exception {
        TrinaryTree tree = new TrinaryTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(9);
        tree.insert(5);
        tree.insert(7);
        tree.insert(2);
        tree.insert(2);

        boolean deleted = tree.delete(7);
        assertEquals(true, deleted);

        assertEquals(5, tree.head.data);
        assertEquals(4, tree.head.left.data);
        assertEquals(5, tree.head.middle.data);
        assertEquals(9, tree.head.right.data);
        assertEquals(2, tree.head.left.left.data);
        assertEquals(2, tree.head.left.left.middle.data);

        tree.insert(7);
        deleted = tree.delete(9);
        assertEquals(true, deleted);

        assertEquals(5, tree.head.data);
        assertEquals(4, tree.head.left.data);
        assertEquals(5, tree.head.middle.data);
        assertEquals(7, tree.head.right.data);
        assertEquals(2, tree.head.left.left.data);
        assertEquals(2, tree.head.left.left.middle.data);

        deleted = tree.delete(5);
        assertEquals(true, deleted);

        assertEquals(5, tree.head.data);
        assertEquals(4, tree.head.left.data);
        assertEquals(7, tree.head.right.data);
        assertEquals(2, tree.head.left.left.data);
        assertEquals(2, tree.head.left.left.middle.data);

        deleted = tree.delete(5);
        assertEquals(true, deleted);

        assertEquals(4, tree.head.data);
        assertEquals(2, tree.head.left.data);
        assertEquals(7, tree.head.right.data);
        assertEquals(2, tree.head.left.middle.data);

        tree = new TrinaryTree();
        tree.insert(6);
        tree.insert(2);
        tree.insert(3);
        tree.insert(5);
        tree.insert(4);

        deleted = tree.delete(21414);
        assertEquals(false, deleted);

        deleted = tree.delete(5);
        assertEquals(true, deleted);
        assertEquals(6, tree.head.data);
        assertEquals(2, tree.head.left.data);
        assertEquals(3, tree.head.left.right.data);
        assertEquals(4, tree.head.left.right.right.data);
        assertEquals(null, tree.head.left.right.right.left);
        assertEquals(null, tree.head.left.right.right.right);

        tree = new TrinaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);

        assertEquals(10, tree.head.data);
        assertEquals(5, tree.head.left.data);
        assertEquals(3, tree.head.left.left.data);
        assertEquals(8, tree.head.left.right.data);
        assertEquals(5, tree.head.left.middle.data);
    }
}
