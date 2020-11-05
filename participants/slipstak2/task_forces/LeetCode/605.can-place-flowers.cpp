// 36 ms
// 20.7 MB
#include <vector>
#include <cassert>

using namespace std;

class Solution {
public:
    bool canPlaceFlowers(vector<int>& a, int n) {
        for (int i = 0; i < (int)a.size(); ++i) {
            if (
                (i - 1 >= 0 ? a[i - 1] == 0 : true) && 
                a[i] == 0 && 
                (i + 1 < a.size() ? a[i + 1] == 0: true)
                ) {
                a[i] = 1;
                n--;
            }
        }
        return n <= 0;
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