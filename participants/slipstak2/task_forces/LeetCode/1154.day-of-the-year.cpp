#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <cassert>

using namespace std;


class Solution {
public:
    int dayOfYear(string date) {
        int days[13] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int y, m, d;
        sscanf(date.c_str(), "%d-%d-%d", &y, &m, &d);
        if (isLeapYear(y)) {
            days[2] = 29;
        }

        int res = d;
        while (--m) {
            res += days[m];
        }        
        return res;
    }
private:
    static bool isLeapYear(int y) {
        return y % 100 != 0 && y % 4 == 0;
    }
    
};



void test(string date, int target) {
    Solution sol;
    assert(sol.dayOfYear(date) == target);
}


int main() {
    test("2019-01-09", 9);
    test("2019-02-10", 41);
    test("2003-03-01", 60);
    test("2004-03-01", 61);

	return 0;
}