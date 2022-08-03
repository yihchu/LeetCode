<h1>文件的最长绝对路径</h1>

假设有一个同时存储文件和目录的文件系统。下图展示了文件系统的一个示例：</br>
</br>![](./image/1.jpeg)</br></br>
这里将dir作为根目录中的唯一目录。dir包含两个子目录subdir1和subdir2。subdir1包含文件file1.ext和子目录subsubdir1；subdir2包含子目录subsubdir2，该子目录下包含文件file2.ext。</br>
在文本格式中，如下所示(⟶表示制表符)：</br>

     dir
     ⟶ subdir1
     ⟶ ⟶ file1.ext
     ⟶ ⟶ subsubdir1
     ⟶ subdir2
     ⟶ ⟶ subsubdir2
     ⟶ ⟶ ⟶ file2.ext

如果是代码表示，上面的文件系统可以写为"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"。'\n'和'\t'分别是换行符和制表符。</br>
文件系统中的每个文件和文件夹都有一个唯一的绝对路径，即必须打开才能到达文件/目录所在位置的目录顺序，所有路径用'/'连接。上面例子中，指向file2.ext的绝对路径是"dir/subdir2/subsubdir2/file2.ext"。每个目录名由字母、数字和/或空格组成，每个文件名遵循name.extension的格式，其中name和extension由字母、数字和/或空格组成。</br>
给定一个以上述格式表示文件系统的字符串input，返回文件系统中指向文件的最长绝对路径的长度。如果系统中没有文件，返回0。</br>

示例1：</br>
</br>![](./image/2.jpeg)</br></br>
输入：input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"</br>
输出：20</br>
解释：只有一个文件，绝对路径为"dir/subdir2/file.ext"，路径长度20</br>

示例2：</br>
</br>![](./image/2.jpeg)</br></br>
输入：input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"</br>
输出：32</br>
解释：存在两个文件：</br>
"dir/subdir1/file1.ext"，路径长度21</br>
"dir/subdir2/subsubdir2/file2.ext"，路径长度32</br>
返回32，因为这是最长的路径</br>

示例3：</br>
输入：input = "a"</br>
输出：0</br>
解释：不存在任何文件</br>

示例4：</br>
输入：input = "file1.txt\nfile2.txt\nlongfile.txt"</br>
输出：12</br>
解释：根目录下有3个文件。</br>
因为根目录中任何东西的绝对路径只是名称本身，所以答案是"longfile.txt"，路径长度为12</br>

提示：
- 1 <= input.length <= 10^4
- input可能包含小写或大写的英文字母，一个换行符'\n'，一个制表符'\t'，一个点'.'，一个空格' '，和数字。

[Link](https://leetcode.cn/problems/longest-absolute-file-path/)