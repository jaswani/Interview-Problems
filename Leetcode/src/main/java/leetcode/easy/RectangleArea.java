package leetcode.easy;

/**
 * Created by jai around 9/28/15.
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Assume that the total area is never beyond the maximum possible value of int.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = getRectangleArea(A,B,C,D) + getRectangleArea(E,F,G,H);
        //non overlap
        if(C <=E || G<=A || D<=F || H<=B) {
            return total;
        }
        //total overlap
        if(isBetween(E,A,C) && isBetween(G,A,C) && isBetween(F,B,D) && isBetween(H,B,D)) {
            return getRectangleArea(A,B,C,D);
        }
        //total overlap
        if(isBetween(A,E,G) && isBetween(C,E,G) && isBetween(B,F,H) && isBetween(D,F,H)) {
            return getRectangleArea(E,F,G,H);
        }
        //partial overlap
        int w,x,y,z;
        w = max(A,E);
        y = min(C,G);
        x = max(B,F);
        z = min(D,H);

        return total - getRectangleArea(w,x,y,z);

    }

    private boolean isBetween(int val, int low, int high) {
        if (val >= low && val <= high) {
            return true;
        }
        return false;
    }

    private int getRectangleArea(int w, int x, int y, int z) {
        int area = (w-y) * (x-z);
        if (area < 0) {
            area *= (-1);
        }
        return area;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    private int min(int a, int b) {
        if (a > b) {
            return b;
        }
        return a;
    }
}
