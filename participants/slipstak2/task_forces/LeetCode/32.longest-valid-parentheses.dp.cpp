// 4 ms
// 7.7 MB

#include <string>
#include <vector>
#include <algorithm>
#include <cassert>

using namespace std;

class Solution {
public:
	int longestValidParentheses(string s) {
		vector<int> dp(s.size());
		for (int i = 0; i < s.size(); ++i) {
			if (s[i] == ')') {
				int prv = i - val(dp, i - 1) - 1;
				if (val(s, prv) == '(') {
					dp[i] = i - prv + 1;
				}
			}
			if (dp[i]) {
				int prv = i - dp[i];
				if (val(dp, prv)) {
					dp[i] += dp[prv];
				}
			}
		}
		return s.size() ? *max_element(dp.begin(), dp.end()) : 0;
	}
	int val(const vector<int>& a, int idx) {
		if (0 <= idx && idx < a.size()) {
			return a[idx];
		}
		return 0;
	}
	char val(const string& s, int idx) {
		if (0 <= idx && idx < s.size()) {
			return s[idx];
		}
		return ' ';
	}
};


void test(string s, int target) {
	Solution sol;
	assert(sol.longestValidParentheses(s) == target);
}

int main() {
	test("", 0);
	test("(()", 2);
	test(")()())", 4);

	return 0;
}