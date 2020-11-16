// 4 ms
// 7.8 MB
#include <string>
#include <stack>
#include <cassert>

using namespace std;

class Solution {
public:
	int longestValidParentheses(string str) {
		//-1 0 1 2 3 4 5 6 7 8 9
		//   ( ) ( ( ( ) ( ) ) (
		// | |
		// |   ^ [ 1 - (-1) = 2]       
		// |     | | |		     
		// |     | | |
		// |     | |   ^ [5 - 3 = 2]
		// |     | |     |
		// |     | |       ^ [7 - 3 = 4]
		// |     |           ^ [8 - 2 = 6]
		// |     |             |

		// в стеке храним индексы бордеров, справа от которых находится правильная скобочная последовательность 
		// бордером может быть
		// 1) открывающаяся скобка, для которой еще не нашлась пара (может и не найтись)
		// 2) закрывающаяся скобка, которая приводит к дисбалансу
		// 3) отдельный случай - затычка(-1) на старте
		stack<int> s; 
		s.push(-1);
		int max_len = 0;
		for (int i = 0; i < str.size(); ++i) {
			if (str[i] == '(') {
				s.push(i);
			} else {
				s.pop();
				if (s.empty()) {
					s.push(i);
				} else {
					max_len = max(max_len, i - s.top());
				}
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
	test("", 0);
	test("(()", 2);
	return 0;
}