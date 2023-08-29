class Solution:
    def convert(self, s: str, numRows: int) -> str:
        l = len(s)
        maxGap = max((numRows - 1) * 2, 1)
        result = ''
        for i in range(numRows):
            tmp = numRows - i - 1
            gap1 = (tmp - 1) * 2 + 1 + 1
            gap2 = maxGap - gap1
            gap1 = gap2 if gap1 == 0 else gap1
            gap2 = gap1 if gap2 == 0 else gap2
            flag = True
            j = i
            while j < l:
                result += s[j]
                j += gap1 if flag else gap2
                flag = not flag
        return result

slt = Solution()
print(slt.convert("PAYPALISHIRING", 3))
print(slt.convert("PAYPALISHIRING", 4))
print(slt.convert("A", 1))
