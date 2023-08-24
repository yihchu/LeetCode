
class Solution:
    def longestPalindrome(self, s: str) -> str:
        sLen = len(s)
        if sLen < 2:
            return s
        count = 1
        idx = 0
        dp = [[True for _ in range(sLen)] for _ in range(sLen)]
        chars = [c for c in s]
        for l in range(2, sLen + 1):
            for i in range(sLen):
                j = i + l - 1
                if j >= sLen:
                    break
                dp[i][j] = False if chars[i] != chars[j] else (True if j - i < 3 else dp[i + 1][j - 1])
                if dp[i][j] is False or j - i + 1 <= count:
                    continue
                count = j - i + 1
                idx = i
        return s[idx: idx + count]

slt = Solution()
print(slt.longestPalindrome('babad')) # bab
print(slt.longestPalindrome('cbbd')) # bb
print(slt.longestPalindrome('a')) # a
print(slt.longestPalindrome('ac')) # a
print(slt.longestPalindrome('abb')) # bb
print(slt.longestPalindrome('bb')) # bb




