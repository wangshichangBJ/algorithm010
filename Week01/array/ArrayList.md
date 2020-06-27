一、定义

​		ArrayList底层是由线性数组来实现的动态数组。新建一个ArrayList时，就是在底层新建一个线性数组。ArrayList的默认初始的数组长度为10（JDK1.8）；

二、关注点

​	1、ArrayList集合的数据是可以为空的；

​	2、数据有序（集合中数据的顺序和添加数据的顺序相同），从头向尾插入数据；

​	3、线程不安全（多线程同时操作某一个指定集合时，共享数据存在线程安全 问题）

三、ArrayList集合API

​	1、新增元素

​		1）在集合中追加元素

```java
protected transient int modCount = 0;
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
public boolean add(E e) {
  	//计数器
    modCount++;
  	//新增元素操作
    add(e, elementData, size);
    return true;
}

private void add(E e, Object[] elementData, int s) {
  if (s == elementData.length){
    //数组已满，扩展数组
    elementData = grow();
  }
  //将E放置在数组索引为S的位置
  elementData[s] = e;
  //将整个数组的大小加1
  size = s + 1;
}

private Object[] grow() {
  //在原始数组长度的基础上加1
  return grow(size + 1);
}

private Object[] grow(int minCapacity) {
  //获取原始数组的长度，赋值给oldCapacity
  int oldCapacity = elementData.length;
  //判空操作（原始数组的长度大于0，或者该数组不为空数组）
  if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)    
    int newCapacity = ArraysSupport.newLength(oldCapacity,
                                // minimum growth 按照上面代码逻辑差值是1
                                minCapacity - oldCapacity,
                                // preferred growth oldCapacity对2取余
                                oldCapacity >> 1);
    return elementData = Arrays.copyOf(elementData, newCapacity);
  } else {
  	//新建一个Object数组，长度为默认长度10和最小扩展量的最大值
    return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
  }
}

//扩容算法
public static final int MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;
public static int newLength(int oldLength, int minGrowth, int prefGrowth) {
  //保证最小扩展量为1，因为minGrowth一直为1。若preGrowth大于minGrowth,则取preGrowth，否则为1；
  int newLength = Math.max(minGrowth, prefGrowth) + oldLength;
  if (newLength - MAX_ARRAY_LENGTH <= 0) {
    //若扩展值小于MAX_ARRAY_LENGTH，则直接返回扩展值
    return newLength;
  }
  //当newLength的大小（最大扩容量）大于等于Integer.MAX-8的值后，使用该方法
  return hugeLength(oldLength, minGrowth);
}

private static int hugeLength(int oldLength, int minGrowth) {
  //获取最小扩增量1
  int minLength = oldLength + minGrowth;
  if (minLength < 0) { // overflow
    throw new OutOfMemoryError("Required array length too large");
  }
  //原始容量+1后的值（最小扩容量）小于等于integer最大值-8
  if (minLength <= MAX_ARRAY_LENGTH) {
    //返回Integer的最大值-8
    return MAX_ARRAY_LENGTH;
  }
  //最小扩容量大于Integre最大值-8时，直接返回Integrer的最大值
  return Integer.MAX_VALUE;
}
```

​		2）在集合中指定索引位置添加元素

```java
public void add(int index, E element) {
  	//判断添加的索引是否在数组中
    rangeCheckForAdd(index);
    modCount++;
    final int s;
    Object[] elementData;
  	//判断原始数组大小等于数组中元素的长度
    if ((s = size) == (elementData = this.elementData).length){
      	//执行扩容操作
        elementData = grow();
    }
  	//数组复制，将原数组（第一个elementData）从index的索引位置开始复制一系列元素A（长度为s-index）
  	//复制到新数组（第二个elementData）,将A从index+1的位置开始复制。完成后就将index位置空置出来
    System.arraycopy(elementData, index,
                     elementData, index + 1,
                     s - index);
  	//将元素放置在index的位置
    elementData[index] = element;
  	//将数组长度加1；
    size = s + 1;
}

private void rangeCheckForAdd(int index) {
  if (index > size || index < 0)
    throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
}
```

​	3)删除指定索引的元素

```java
public E remove(int index) {
  	//检查索引有没有越界
    Objects.checkIndex(index, size);
  	//对数据做一个备份
    final Object[] es = elementData;
  	//获取要删除的数据，用户结果返回
    @SuppressWarnings("unchecked") E oldValue = (E) es[index];
  	//删除数组中数据
    fastRemove(es, index);
  	//返回被删除的数据
    return oldValue;
}

private void fastRemove(Object[] es, int i) {
  modCount++;
  final int newSize;
  //判断被删除元素后面是否还有元素
  if ((newSize = size - 1) > i){
    //从原数组（第一个es）的第i+1索引处开始复制后面的所有元素
    //新数组（第二个es），将旧数组复制的元素在新数组中从i的索引位置开始复制元素到新数组
    System.arraycopy(es, i + 1, es, i, newSize - i);
  }
  //如果是最后一个元素或者执行完上一步的if语句，直接将最后一个索引的位置设置为null,方便GC回收内存
  es[size = newSize] = null;
}
```

​	4）删除集合中指定的元素

```java
public boolean remove(Object o) {
    final Object[] es = elementData;
    final int size = this.size;
    int i = 0;
  	//获取对应元素的索引值i
    found: {
        if (o == null) {
          	//遍历整个数组，获取第一个元素为null的索引值i
            for (; i < size; i++)
                if (es[i] == null)
                    break found;
        } else {
            for (; i < size; i++)
              	//获取第一个元素值为o的索引值i
                if (o.equals(es[i]))
                    break found;
        }
      	//集合中不存在该元素，直接返回false
        return false;
    }
  	//删除指定索引的元素
    fastRemove(es, i);
    return true;
}
```

四、ArrayLsit的优缺点

​	1、优点

​		1）ArrayList的查询元素的速度是非常快的，由于数组是由索引存在的，直接根绝索引查询即可（指哪打哪）。由于ArrayList实现了RandomAccess接口，所以ArrayList被标记为使用二分法进行查询（使用二分法找到指定的索引）；

​		2）ArrayList在最后的位置添加（删除）元素时，可以直接操作，时间复杂度为0(1)；

​	2、缺点

​		1）在集合的指定位置（非最后的位置）进行添加和删除元素时，都要重新复制数组。增加空间复杂度O(n)，比较耗费性能；

五、为什么ArrayList集合中定义的数组使用elementData[]，使用transient关键字进行修饰？

​	由于ArrayList实现了Serializable接口，则该集合允许进行序列化和反序列化。对于未满的数组来说，真正需要序列化的只有那几个不为null的元素，其余的全部为null，序列化也没有意义。所以为了增强序列化（反序列化）的性能，使用transient来修饰，对数组不进行序列化，然后重写Serializable接口的WriteObject和ReadObject方法，使用重写的方法进行序列化和反序列化，保证只序列化或者反序列化存在的元素；

```java
@java.io.Serial
private void writeObject(java.io.ObjectOutputStream s)
    throws java.io.IOException {
    // Write out element count, and any hidden stuff
    int expectedModCount = modCount;
  	//先调用默认的序列化方法，序列化没有被Transient修饰的元素
    s.defaultWriteObject();

    // Write out size as capacity for behavioral compatibility with clone()
    s.writeInt(size);

    // Write out all elements in the proper order.
    for (int i=0; i<size; i++) {
      	//只序列化存在的元素
        s.writeObject(elementData[i]);
    }

    if (modCount != expectedModCount) {
        throw new ConcurrentModificationException();
    }
}

@java.io.Serial
private void readObject(java.io.ObjectInputStream s)
    throws java.io.IOException, ClassNotFoundException {

    // Read in size, and any hidden stuff
    s.defaultReadObject();

    // Read in capacity
    s.readInt(); // ignored

    if (size > 0) {
        // like clone(), allocate array based upon size not capacity
        SharedSecrets.getJavaObjectInputStreamAccess().checkArray(s, Object[].class, size);
        Object[] elements = new Object[size];

        // Read in all elements in the proper order.
        for (int i = 0; i < size; i++) {
            elements[i] = s.readObject();
        }

        elementData = elements;
    } else if (size == 0) {
        elementData = EMPTY_ELEMENTDATA;
    } else {
        throw new java.io.InvalidObjectException("Invalid size: " + size);
    }
}
```