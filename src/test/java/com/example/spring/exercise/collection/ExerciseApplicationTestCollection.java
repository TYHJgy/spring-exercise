package com.example.spring.exercise.collection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/*JAVA中有许多的集合，常用的有List(ArrayList/LinkedList)，Set(HashSet/TreeSet)，Queue，Map(HashMap/TreeMap)*/

/*
1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
2.对于随机访问get和set，ArrayList优于LinkedList，因为ArrayList可以随机定位，而LinkedList要移动指针一步一步的移动到节点处。（参考数组与链表来思考）
3.对于新增和删除操作add和remove，LinedList比较占优势，只需要对指针进行修改即可，而ArrayList要移动数据来填补被删除的对象的空间。
*/
@SpringBootTest
class ExerciseApplicationTestCollection {

  private <E> void LOGGER(E e) {
    System.out.println(e);
  }

  @Test
  void testArrayList() {
    List list = new ArrayList();
    list.add("aaa");
    list.add(2);    //可以存放不同类型的元素
    byte b = 8;
    list.add(b);

    LOGGER(list.size());
    LOGGER(list.get(0));
    LOGGER(list.get(1));
  }

  @Test
  void testArrayList2() {
    ArrayList<String> list = new ArrayList<>();
    list.add("aaa");
    list.add("111");
    LOGGER(list.size());
    LOGGER(list.get(0));
    LOGGER(list.get(1));
  }

  @Test
  void testLinkedList() {
    List list = new LinkedList();
    list.add("aaa");
    list.add(2);
    LOGGER(list.size());
    LOGGER(list.get(0));
    LOGGER(list.get(1));
  }

  @Test
  void testLinkedList2() {
    List<Integer> list = new LinkedList<Integer>();
    list.add(0);
    list.add(20);
    LOGGER(list.size());
    LOGGER(list.get(0));
    LOGGER(list.get(1));
  }

  /*
   * HashMap 是一个散列表，它存储的内容是键值对(key-value)映射。
   * HashMap 实现了 Map 接口，根据键的 HashCode 值存储数据，具有很快的访问速度，最多允许一条记录的键为 null，不支持线程同步。
   * HashMap 是无序的，即不会记录插入的顺序。
   * HashMap 继承于AbstractMap，实现了 Map、Cloneable、java.io.Serializable 接口。
   * */
  @Test
  void testHashMap() {
    // 创建 HashMap 对象 Sites
    Map<Integer, String> Sites = new HashMap<Integer, String>();
    // 添加键值对
    Sites.put(1, "Google");
    Sites.put(2, "Runoob");
    Sites.put(3, "Taobao");
    Sites.put(4, "Zhihu");
    System.out.println("集合元素：" + Sites);
    System.out.println("集合大小：" + Sites.size());
    System.out.println("集合key=3元素：" + Sites.get(3));
    Sites.remove(3);
    System.out.println("删除key=3后集合元素：" + Sites);
    System.out.println("删除key=3后集合大小：" + Sites.size());
    // 输出 key 和 value
    System.out.println("遍历所有key，根据key输出value：");
    for (Integer i : Sites.keySet()) {
      System.out.println("key: " + i + " value: " + Sites.get(i));
    }
    // 返回所有 value 值
    System.out.print("遍历所有value：");
    for (String value : Sites.values()) {
      // 输出每一个value
      System.out.print(value + " ");
    }
    System.out.println();
    Sites.clear();
    System.out.println("清除集合后元素：" + Sites);
    System.out.println("清除集合后大小：" + Sites.size());
  }

  //HashSet 基于 HashMap 来实现的，是一个不允许有重复元素的集合。
  @Test
  void testHashSet() {
    HashSet<String> sites = new HashSet<String>();
    sites.add("Google");
    sites.add("Runoob");
    sites.add("Taobao");
    sites.add("Zhihu");
    sites.add("Runoob");                            // 重复的元素不会被添加
    System.out.println("删除前:" + sites);
    System.out.println("Taobao是否存在:" + sites.contains("Taobao"));   //使用 contains() 方法来判断元素是否存在于集合当中
    sites.remove("Taobao");                     // 删除元素，删除成功返回 true，否则为 false
    System.out.println("删除后:" + sites);
    System.out.println("集合大小:" + sites.size());   //计算大小
  }
}
