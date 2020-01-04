public enum Color {
    Red,
    Black
}

public class Node {
    public Node Left {get; set;}
    public Node Right {get; set;}
    public Node Parent {get; set;}
    public Color Color {get; set;}
}

public class RedBlackTree {
    public void RedBlackDelete(Node z) {
        Node y;
        Color yOriginalColor;

        y = z;
        yOriginalColor = y.Color;

        if (z.Left == null) {
            x = z.Right;
            Transplant(z, z.Right);
        } else if (z.Right == null) {
            x = z.Left;
            Transplant(z, z.left);
        } else {
            y = TreeMinimum(z.Right);
            yOriginalColor = y.Color;
            x = y.Right;

            if (x.p == z) {
                x.p = y;
            } else {
                Transplant(y, y.Right);
                y.Right = z.Right;
                y.Right.Parent = y;
            }
            Transplant(z, y);
            y.Left = z.Left;
            y.Left.Parent = y;
            y.Color = z.Color;
        }

        if (yOriginalColor == Color.Black) {
            DeleteFixup(x);
        }
    }

    public void Transplant(Node toReplace, Node replaceBy) {

    }

    public Node TreeMinimum(Node startNode) {
        return null;
    }

    public void DeleteFixup(Node x) {

    }
}