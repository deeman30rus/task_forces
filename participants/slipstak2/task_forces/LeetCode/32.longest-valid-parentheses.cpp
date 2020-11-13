// 24 ms
// 14 MB

#include <string>
#include <cassert>
#include <vector>


using namespace std;

class Solution {
public:
	int longestValidParentheses(string s) {
		vector<vector<int>> met(2 * s.size() + 2);
		int mpos = s.size(), spos = 0;
		met[mpos].push_back(spos);
		for (int i = 0; i < s.size(); ++i, spos++) {
			int sign = s[i] == '(' ? +1 : -1;
			mpos += sign;
			met[mpos].push_back(sign * (i + 1));
		}

		int max_len = 0;
		for (int i = 0; i < met.size(); ++i) {
			const vector<int>& a = met[i];
			int cur = 0;
			while (cur < a.size()) {
				int start = cur++;
				while (cur < a.size() && a[cur] < 0) {
					++cur;
				}
				max_len = max(max_len, abs(a[cur - 1]) - abs(a[start]));
			}
		}
		return max_len;
	}
};


void test(string s, int target) {
	Solution sol;
	assert(sol.longestValidParentheses(s) == target);
}

int main() {
	test(")()())", 4);
	test("(()", 2);
	return 0;
}