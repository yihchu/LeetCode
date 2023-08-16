class Solution:
    # 1
    # def lengthOfLongestSubstring(self, s: str) -> int:
    #     if s == "":
    #         return 0
    #     rst = 1
    #     size = len(s)
    #     for idx in range(0, size - 1):
    #         if size - idx == rst:
    #             break
    #         st = {s[idx]}
    #         tmp = 1
    #         for ptr in range(idx + 1, size):
    #             if s[ptr] in st:
    #                 break
    #             tmp += 1
    #             st.add(s[ptr])
    #         rst = tmp if tmp > rst else rst
    #     return rst

    # 2
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s == "":
            return 0
        rst = 1
        size = len(s)
        count = 1
        st = {}
        for idx in range(0, size - 1):
            if size - idx == rst:
                break
            if count == 1:
                st = {s[idx]}
                ptr = idx + 1
            else:
                st.remove(s[idx - 1])
                ptr = idx + count - 1
                count -= 1
            while ptr < size:
                if s[ptr] in st:
                    break
                count += 1
                st.add(s[ptr])
                ptr += 1
            rst = count if count > rst else rst
        return rst


slt = Solution()
print(slt.lengthOfLongestSubstring("abcabcbb"))  # 3
print(slt.lengthOfLongestSubstring("bbbbb"))  # 1
print(slt.lengthOfLongestSubstring("pwwkew"))  # 3
print(slt.lengthOfLongestSubstring("au"))  # 2
