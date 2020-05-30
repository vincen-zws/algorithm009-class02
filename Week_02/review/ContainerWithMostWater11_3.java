package review;

public class ContainerWithMostWater11_3 {
    public int maxArea(int[] height) {
        return _func1DouIndex(height);
    }

    private int _func1DouIndex(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int h = 0;
            if ( height[left] < height[right] ) {
                h = height[left++];
            } else {
                h = height[right--];
            }
            int area = width *  h;
            maxArea = maxArea > area ? maxArea : area;
        }
        return maxArea;
    }
}
