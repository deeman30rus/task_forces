// 4 ms
// 8.2 MB

#include <vector>
#include <algorithm>
#include <cassert>

using namespace std;


class Solution {
public:
	int lengthOfLIS(vector<int>& nums) {
		vector<int> dp(nums.size());

		vector<int> prefix;
		prefix.reserve(nums.size());
		for (int i = 0; i < nums.size(); ++i) {
			int cur = nums[i];
			auto it = lower_bound(prefix.begin(), prefix.end(), cur);
			if (it == prefix.end()) {
				prefix.push_back(cur);
				dp[i] = prefix.size();
			} else {
				*it = cur;
				dp[i] = it - prefix.begin() + 1;
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

	vector<int> arr = { 1, 2, 2, 2, 3 };
	auto it_lower = lower_bound(arr.begin(), arr.end(), 4);
	auto it_upper = upper_bound(arr.begin(), arr.end(), 4);

	test({ 10,9,2,5,3,7,101,18 }, 4);
	test({}, 0);
	return 0;
}