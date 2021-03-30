import java.util.*;

class Solution_largest_water_container {

    public static void main(String[] args){
        Solution_largest_water_container sol = 
            new Solution_largest_water_container();
            int[] heights = {4,3,2,1,4};
            System.out.print(sol.maxArea(heights));

            
        
        
    }

    // I THINK IT WORKS BUT LEETCODE DOESNT ACCEPT IT
    public int maxArea(int[] height) {

        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int currentCalculatedArea = 0;
        int maxCalculatedArea = 0;

        // no area possible. TWO WALLS ARE NEEDED
        if (height.length < 2) {
            return 0; 
        }
        
        while (leftIndex < rightIndex) {
        
                // find smaller of two heights and calculate area for smaller height
                if (height[leftIndex] < height[rightIndex]) {
                    currentCalculatedArea = (rightIndex - leftIndex) * height[leftIndex];
                    leftIndex++;
                } 
                else {
                    currentCalculatedArea = (rightIndex - leftIndex) * height[rightIndex];
                    rightIndex--;
                }
                
                // check if the area just calculated is larger than the max area calculated
                if (currentCalculatedArea > maxCalculatedArea) {
                    maxCalculatedArea = currentCalculatedArea;
                }
            }

            return maxCalculatedArea;
        }
    
}


