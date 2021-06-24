package com.example.spring.exercise.generics;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ExerciseApplicationTestGenerics {

  // 泛型方法 printArray
  <E>
  void printArray(E[] inputArray) {
    // 输出数组元素
    for (E element : inputArray) {
      System.out.printf("%s ", element);
    }
    System.out.println();
  }

  @Test
  void test1() {
    // 创建不同类型数组： Integer, Double 和 Character
    Integer[] intArray = {1, 2, 3, 4, 5};
    Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
    Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

    System.out.println("整型数组元素为:");
    printArray(intArray); // 传递一个整型数组

    System.out.println("\n双精度型数组元素为:");
    printArray(doubleArray); // 传递一个双精度型数组

    System.out.println("\n字符型数组元素为:");
    printArray(charArray); // 传递一个字符型数组
  }
}

//泛型类
class Box<T> {

  private T t;

  public void add(T t) {
    this.t = t;
  }

  public T get() {
    return t;
  }

  public static void main(String[] args) {
    Box<Integer> integerBox = new Box<Integer>();
    Box<String> stringBox = new Box<String>();

    integerBox.add(new Integer(10));
    stringBox.add(new String("菜鸟教程"));

    System.out.printf("整型值为 :%d\n\n", integerBox.get());
    System.out.printf("字符串为 :%s\n", stringBox.get());
  }
}

//通配符（?）
class GenericTest {

  public static void main(String[] args) {
    List<String> name = new ArrayList<String>();
    List<Integer> age = new ArrayList<Integer>();
    List<Number> number = new ArrayList<Number>();

    name.add("icon");
    age.add(18);
    number.add(314);

    getData(name);
    getData(age);
    getData(number);

  }

  public static void getData(List<?> data) {
    System.out.println("data :" + data.get(0));
  }
}

