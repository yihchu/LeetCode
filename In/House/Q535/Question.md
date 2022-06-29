<h1>TinyURL的加密与解密</h1>

TinyURL是一种URL简化服务，比如：当你输入一个URL：https://leetcode.com/problems/design-tinyurl时，它将返回一个简化的URL：http://tinyurl.com/4e9iAk。请你设计一个类来加密与解TinyURL。</br>
加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。</br>

实现Solution类：</br>
- Solution()初始化TinyURL系统对象。</br>
- String encode(String longUrl)返回longUrl对应的TinyURL。</br>
- String decode(String shortUrl)返回shortUrl原本的URL。题目数据保证给定的shortUrl是由同一个系统对象加密的。</br>

示例：</br>
输入：url = "https://leetcode.com/problems/design-tinyurl"</br>
输出："https://leetcode.com/problems/design-tinyurl"</br>
解释：</br>
Solution obj = new Solution();</br>
string tiny = obj.encode(url); // 返回加密后得到的TinyURL。</br>
string ans = obj.decode(tiny); // 返回解密后得到的原本的URL。</br>

提示：</br>
1 <= url.length <= 10^4</br>
题目数据保证url是一个有效的URL</br>

[Link](https://leetcode.cn/problems/encode-and-decode-tinyurl/)