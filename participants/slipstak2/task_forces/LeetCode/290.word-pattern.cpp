// 0 ms
// 6.7 MB
#include <iostream>
#include <vector>
#include <string>
#include <cassert>
#include <sstream>
#include <iterator>
#include <unordered_set>

using namespace std;


class Solution {
public:
	bool wordPattern(string pattern, string s) {
		vector<string> words;
		split(s, ' ', words);

		if (pattern.size() != words.size()) {
			return false;
		}
		
		string hash[255];
		unordered_set<string> unique_words;

		for (int i = 0; i < pattern.size(); ++i) {
			char c = pattern[i];
			const string& word = words[i];
			if (hash[c].empty()) {
				if (unique_words.find(word) != unique_words.end()) {
					return false;
				}
				hash[c] = word;
				unique_words.insert(word);
			} else {
				if (hash[c] != word) {
					return false;
				}
			}
		}
		return true;
	}
private:
	template <typename Out>
	void split(const string& s, char delim, Out result)
	{
		istringstream iss(s);
		string item;
		while (getline(iss, item, delim)) {
			*result++ = item;
		}
	}
	void split(const string& s, char delim, vector<string>& words)
	{
		split(s, delim, back_inserter(words));
	}
};



void test(string pattern, string s, bool target) {
	Solution sol;
	assert(sol.wordPattern(pattern, s) == target);
}


int main() {
	test("abba", "dog cat cat dog", true);
	test("abba", "dog cat cat fish", false);
	test("aaaa", "dog cat cat dog", false);
	test("abba", "dog dog dog dog", false);
	return 0;
}
