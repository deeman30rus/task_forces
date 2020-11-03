// https://leetcode.com/problems/house-robber/
// 4 ms
// 8.3 MB

#include <iostream>
#include <vector>
#include <algorithm>
#include <cassert>


using namespace std;


class Solution {
public:
    int rob(vector<int>& a) {
        vector<int> dp(a.size() + 2);
        for (int i = (int)a.size() - 1; i >= 0; --i) {
            dp[i] = max(a[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }
};

void test(vector<int> a, int target) {
    Solution sol;
    assert(sol.rob(a) == target);
}

int main() {

    test({ 1,2,3,1 }, 4);
    test({ 2,7,9,3,1 }, 12);
    return 0;
}
