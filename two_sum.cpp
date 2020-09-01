class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        int i, k, a, b;
        
        vector<int> solution;
        
        // loop to get first value from nums
        for(i = 0; i < nums.size(); i++) {
            // loop to get second value from nums
            for(k = 0; k < nums.size(); k++) {
                // make sure the same index isnt used twice AND
                // see if the two indice's value add up to the target value
                if(i != k && nums[i] + nums[k] == target) {
                    // values add up to target so add indices to 
                    solution.push_back(i);
                    solution.push_back(k);
                    return solution;
                    }
                }
            }
        cout << nums.size();
        return solution;   
    }
};