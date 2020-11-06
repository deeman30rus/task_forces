// 32 ms
// 20.4 MB
#include <vector>
#include <cassert>

using namespace std;

class Solution {
public:
    bool canPlaceFlowers(vector<int>& a, int n) {
        for (int i = 0; i < (int)a.size(); ++i) {
            if (get(a, i - 1) == 0 && a[i] == 0 && get(a, i + 1) == 0) {
                a[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
    inline int get(const vector<int>& a, int idx) {
        if (0 <= idx && idx < a.size()) {
            return a[idx];
        }
        return 0;
    }
};


void test(vector<int> a, int n, bool target) {
    Solution sol;
    assert(sol.canPlaceFlowers(a, n) == target);
}

int main() {

    test({ 0,0,1,0,1 }, 1, true);
    test({ 1,0,1,0,1,0,1 }, 1, false);
    test({ 1,0,0,0,1 }, 1, true);
    test({ 1,0,0,0,1 }, 2, false);
    
    return 0;
}