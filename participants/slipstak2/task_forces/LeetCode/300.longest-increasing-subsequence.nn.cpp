// 84 ms
// 7.9 MB

#include <vector>
#include <algorithm>
#include <cassert>

using namespace std;


class Solution {
public:
	int lengthOfLIS(vector<int>& nums) {
		vector<int> dp(nums.size());
		for (int i = 0; i < nums.size(); ++i) {
			dp[i] = 1;
			for (int j = 0; j < i; ++j) {
				if (nums[j] < nums[i]) {
					dp[i] = max(dp[i], dp[j] + 1);
				}
			}
		}
		return nums.size() ? *max_element(dp.begin(), dp.end()) : 0;
	}
};

void test(vector<int> nums, int target) {
	Solution sol;
	assert(sol.lengthOfLIS(nums) == target);
}

int main() {

	test({}, 0);
	test({ 10,9,2,5,3,7,101,18 }, 4);

	return 0;
}