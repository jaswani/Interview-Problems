package leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by jai around 10/12/15.
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a
 * distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo
 * (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
 *
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are
 * the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is
 * guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect
 * rectangles grounded on an absolutely flat surface at height 0.
 *
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12],
 * [15 20 10], [19 24 8] ] .
 *
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ]
 * that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last
 * key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has
 * zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 *
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8],
 * [24, 0] ].
 *
 * Notes:
 *
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5],
 * [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final
 * output as such: [...[2 3], [4 5], [12 7], ...]
 */
public class SkylineProblem {
    private class HeapElement implements Comparable {
        int key;
        Building building;
        HeapElement(int k, Building b) {
            this.key = k;
            this.building = b;
        }

        public boolean isRightKey() {
            if (key == building.getRight()) return true;
            return false;
        }

        public boolean isLefttKey() {
            if (key == building.getLeft()) return true;
            return false;
        }

        public Building getBuilding() {
            return building;
        }

        public int getLeft() {
            return building.getLeft();
        }
        public int getRight() {
            return building.getRight();
        }
        public int getHeight() {
            return building.getHeight();
        }

        @Override
        public int compareTo(Object o) {
            HeapElement h = (HeapElement) o;
            if (this.key < h.key) return -1;
            if (this.key > h.key) return 1;
            if(isLefttKey()) {
                if (this.getHeight() > h.getHeight()) return -1;
                if (this.getHeight() < h.getHeight()) return 1;
            } else if(isRightKey()) {
                if (this.getHeight() > h.getHeight()) return 1;
                if (this.getHeight() < h.getHeight()) return -1;
            }
            return 0;
        }
    }

    private class Building implements Comparable {
        int[] building;
        public Building(int[] b){
            this.building = b;
        }
        public int getLeft() {
            return building[0];
        }
        public int getRight() {
            return building[1];
        }
        public int getHeight() {
            return building[2];
        }
        @Override
        public int compareTo(Object o) {
            Building b = (Building)o;
            if(this.building[2] > b.building[2]) return -1;
            if(this.building[2] < b.building[2]) return 1;
            return 0;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        PriorityQueue<HeapElement> px = new PriorityQueue<>();
        PriorityQueue<Building> ph = new PriorityQueue<>();
        List<int[]> ans = new ArrayList<>();

        int i = 0;
        int currHeight = 0;
        while(i < buildings.length || !px.isEmpty()) {
            if(i < buildings.length && (px.isEmpty() || px.peek().key >= buildings[i][0])) {
                Building b = new Building(buildings[i]);
                px.add(new HeapElement(buildings[i][0], b));
                px.add(new HeapElement(buildings[i][1], b));
                ph.add(b);
                i++;
            } else {
                HeapElement currMin = px.remove();
                if (currMin.isLefttKey()) {
                    //Adding a new building
                    if (currMin.getHeight() > currHeight) {
                        addToAns(ans, currMin.getLeft(), currMin.getHeight());
                        currHeight = currMin.getHeight();
                    }
                } else if (currMin.isRightKey()) {
                    //Removing a building
                    ph.remove(currMin.getBuilding());
                    if (currMin.getHeight() == currHeight) {
                        if(ph.peek()!= null) {
                            if(ph.peek().getHeight() != currHeight) {
                                currHeight = ph.peek().getHeight();
                                addToAns(ans, currMin.getRight(), currHeight);
                            }
                        } else {
                            addToAns(ans, currMin.getRight(), 0);
                            currHeight = 0;
                        }
                    }
                }
            }
        }

        return ans;
    }

    private void addToAns(List<int[]> ans, int x, int h) {
        int[] temp = new int[2];
        temp[0] = x;
        temp[1] = h;
        ans.add(temp);
    }
}
