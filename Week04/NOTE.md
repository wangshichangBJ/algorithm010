# BFS与DFS

### 一、搜索算法

​		搜索算法可以大致分成四类

​			1）一般的搜索算法就是不含有任何技巧的暴力搜索，即将所有的节点全部遍历一遍，然后也不考虑是否重复查找某一个相同的节点；找到目标·				  即可；

​			2）广度优先搜索算法（BFS），在树（图）中按照层级来进行搜索，第一层 -> 第二层 ->...... ->叶子节点层。不按照树的父子关系来进行遍			      历。使用**队列**或者数组来保存数据；

​			3）深度优先搜索算法（DFS），在树（图）中按照父子关系来进行遍历，根节点->左子节点->左子节点->左子叶子节点->左子叶子节点父节点				  的右子节点，按照这个规则遍历所有的节点。使用栈来实现；

​			4）优先级优先搜索（启发式搜索，基于深度学习），现在的推荐算法都是按照优先级优先算法实现的（搜索算法按照具体条件的计算），例如				  头条和抖音的内容推荐；

### 二、深度优先搜索算法（depth-first-search）

​		1、二叉树递归模板

```java
//定义二叉树类
public class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  public TreeNode(int _val){
    this.val = _val;
    this,left = null;
    this.right = null;
  }
}

//定义set集合，存储已经被访问过的节点，防止同一节点多次访问，提高效率
Set<TreeNode> visited = new HashSet<>();
public void DFS(TreeNode root, Set<TreeNode> visited){
	// 跳出递归或者返回递归上一层的条件
  if (visited.contains(root)){
    //如果该节点已被访问过，跳出当前梦境，上探到上一层梦境
    return;
  }
  
  //处理当前梦境的逻辑.若当前节点没有被访问过，将当前节点保存到set结合中
  visited.add(root);
  
  //下探到子节点
  //先递归遍历所有的左子节点
  DFS(root.left,visited);
  //在左子节点全部遍历完成后，再递归遍历所有的右子节点
  DFS(root.right,visited);
}
```

​		2、多叉树的递归模板

```java
//定义多叉树类
public class TreeNode{
  int val;
  List<TreeNode> children;
  
  public TreeNode(int _val, List<TreeNode> _children){
    this.val = _val;
    this.children = _children;
  }
}

//定义set集合，存储已经被访问过的节点，防止节点被重复访问
Set<TreeNode> visited = new HashSet<>();
public void DFS(TreeNode root){
  //跳出递归或者返回递归上一层梦境
  if(visited.contains(root)){
    //节点已被访问过，返回上一层梦境
    return;
  }
  //处理当前递归层的逻辑
  visited.add(root);
  //遍历所有的节点
  for(TreeNode node: root.children)
    if(!visited.contains(node)){
      DFS(node,visited)
    }
}
```

### 三、广度优先遍历算法（breadth-first-search）

​		1、多叉树的广度优先算法

```java
//定义树的类
public class TreeNode{
  int val;
  List<TreeNode> children;
  public TreeNode(int _val, list<TreeNode> _children){
    this.val = _val;
    this.children = _children;
  }
}

public void BFS(TreeNode root){
  if(root == null){
    return;
  }
  //定义队列存放遍历的节点
  Queue<TreeNode> queue = new LinkedList<>();
  queue.offer(root);
  while(!queue.isEmpty()){
    //poll出队列头部第一个子节点，获取其对应的子节点
    TreeNode nodeQueueHead = queue.poll();
    for(TreeNode node : root.children){
      //遍历父节点的子节点，并将其子节点存储到队列中
      queue.offer(node);
    }
  } 
}
```

​		2、二叉树的广度优先算法

```java
//定义二叉树的类
public class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  public TreeNode(int _val){
    this.val = _val;
    this.left = null;
    this.right = null;
  }
}

public void BFS(TreeNode root){
  if(root == null){
    return;
  }
  Queue queue = new LinkedList<>();
  queue.offer(root);
  if(!queue.isEmpty()){
    TreeNode nodeQueueHead = queue.poll();
    if(nodeQueueHead.left != null){
      queue.offer(nodeQueueHead.left);
    }
    if(nodeQueueHead.right != null){
      queue.offer(nodeQueueHead.rigth);
    }
  }
}
```