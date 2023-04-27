# 学习算法和刷题的思路指南
## ⼀、数据结构的存储⽅式
**数据结构的存储⽅式只有两种：数组（顺序存储）和链表（链式存储）。**  

「图」的两种表⽰⽅法，邻接表就是链表，邻接矩阵就是⼆维数组。邻接矩 阵判断连通性迅速，并可以进⾏矩阵运算解决⼀些问题，但是如果图⽐较稀 疏的话很耗费空间。邻接表⽐较节省空间，但是很多操作的效率上肯定⽐不 过邻接矩阵。   

「散列表」就是通过散列函数把键映射到⼀个⼤数组⾥。⽽且对于解决散列 冲突的⽅法，拉链法需要链表特性，操作简单，但需要额外的空间存储指 针；线性探查法就需要数组特性，以便连续寻址，不需要指针的存储空间， 但操作稍微复杂些。   

「树」，⽤数组实现就是「堆」，因为「堆」是⼀个完全⼆叉树，⽤数组存 储不需要节点指针，操作也⽐较简单；⽤链表实现就是很常⻅的那种 「树」，因为不⼀定是完全⼆叉树，所以不适合⽤数组存储。为此，在这种 链表「树」结构之上，⼜衍⽣出各种巧妙的设计，⽐如⼆叉搜索树、AVL 树、红⿊树、区间树、B 树等等，以应对不同的问题。

## ⼆、数据结构的基本操作

基本操作⽆⾮遍历 + 访问，再具体⼀点就是：增删查改。各种数据结构的遍历 + 访问⽆⾮两种形式：线性的和⾮线性的。  

**线性就是 for/while 迭代为代表，⾮线性就是递归为代表。**