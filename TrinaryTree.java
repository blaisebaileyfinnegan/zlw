package edu.uci.mvu1;

public class TrinaryTree {
    public TrinaryNode head;

    public TrinaryNode insert(int data) {
        if (this.head == null) {
            this.head = new TrinaryNode(data);
            return this.head;
        }

        return this.head.insert(data);
    }

    public MaxAndParent findMaxAndParent(TrinaryNode node) {
        TrinaryNode parent = null;
        while (node.right != null) {
            parent = node;
            node = node.right;
        }

        return new MaxAndParent(node, parent);
    }

    public boolean delete(int data) {
        if (this.head == null) {
            return false;
        }

        TrinaryNode parent = null;
        TrinaryNode target = this.head;
        Direction direction = null;
        while (target != null) {
            if (target.data == data) {
                // Found our target node
                boolean isTargetHead = (parent == null);
                if (target.middle != null) {
                    // In this case, we carry out a special tri-nary deletion
                    if (isTargetHead) {
                        // If the node to delete is the head, simple set the head to refer to the next middle
                        this.head = target.middle;
                    } else {
                        // Whichever direction we came from, set the parent left or right to
                        // the next middle
                        if (direction.equals(Direction.left)) {
                            parent.left = target.middle;
                        } else {
                            parent.right = target.middle;
                        }
                    }

                    // Fix references using old middle
                    target.middle.left = target.left;
                    target.middle.right = target.right;
                } else {
                    // Treat it like a binary tree deletion
                    boolean leftExists = (target.left != null);
                    boolean rightExists = (target.right != null);
                    if (leftExists && rightExists) {
                        // Get in-order predecessor
                        MaxAndParent info = findMaxAndParent(target.left);
                        parent = info.parent;
                        TrinaryNode predecessor = info.max;
                        target.data = predecessor.data;
                        if (parent == null) {
                            // The in-order predecessor is the immediate left
                            target.left = predecessor.left;
                        } else {
                            // The in-order predecessor is at least of depth 2
                            parent.right = predecessor.left;
                        }
                    } else if (leftExists) {
                        if (isTargetHead) {
                            this.head = target.left;
                        } else {
                            if (direction.equals(Direction.right)) {
                                parent.right = target.left;
                            } else {
                                parent.left = target.left;
                            }
                        }
                    } else if (rightExists) {
                        if (isTargetHead) {
                            this.head = target.right;
                        } else {
                            if (direction.equals(Direction.right)) {
                                parent.right = target.right;
                            } else {
                                parent.left = target.right;
                            }
                        }
                    } else {
                        // Target has no children :(
                        if (isTargetHead) {
                            this.head = null;
                        } else {
                            if (direction.equals(Direction.right)) {
                                parent.right = null;
                            } else {
                                parent.left = null;
                            }
                        }
                    }
                }

                return true;
            }

            parent = target;
            if (target.data < data) {
                target = target.right;
                direction = Direction.right;
            } else {
                target = target.left;
                direction = Direction.left;
            }
        }

        return false;
    }

    private class MaxAndParent {
        public TrinaryNode parent;
        public TrinaryNode max;

        public MaxAndParent(TrinaryNode max, TrinaryNode parent) {
            this.parent = parent;
            this.max = max;
        }
    }

    private enum Direction {
        left,
        right
    }
}
