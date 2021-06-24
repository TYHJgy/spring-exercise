package com.example.spring.exercise.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

@RestController
@RequestMapping(path = "/test")
public class TestJavaSEController {

  private final static Logger LOGGER = LoggerFactory.getLogger(TestJavaSEController.class);

  private static int i = 0;

  public static int getI() {
    return i;
  }

  public void setI(int i) {
    this.i = i;
  }

  //测试异常处理
  @GetMapping("exceptionTest")
  public void exceptionTest() {
    try {
      int a[] = new int[2];
      System.out.println("Access element three :" + a[3]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Exception thrown  :" + e);
    }
    System.out.println("Out of the block");
  }


  //测试lambda表达式
  //Lambda 表达式可以对某些接口进行简单的实现
  @GetMapping("testLambda")
  public void testLambda() {
    // 类型声明
    MathOperation addition = (int a, int b) -> a + b;

    // 不用类型声明
    MathOperation subtraction = (a, b) -> a - b;

    // 大括号中的返回语句
    MathOperation multiplication = (int a, int b) -> {
      return a * b;
    };

    // 没有大括号及返回语句(a, b) -> {a - b}
    MathOperation division = (int a, int b) -> a / b;

    System.out.println("10 + 5 = " + operate(10, 5, (int a, int b) -> a + b + 5));
    System.out.println("10 - 5 = " + operate(10, 5, subtraction));
    System.out.println("10 x 5 = " + operate(10, 5, multiplication));
    System.out.println("10 / 5 = " + operate(10, 5, division));
    // 不用括号
    GreetingService greetService1 = message -> System.out.println("Hello " + message);

    // 用括号
    GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

    greetService1.sayMessage("Runoob");
    greetService2.sayMessage("Google");
  }

  interface MathOperation {

    int operation(int a, int b);
  }

  interface GreetingService {

    void sayMessage(String message);
  }

  private int operate(int a, int b, MathOperation mathOperation) {
    return mathOperation.operation(a, b);
  }

  //java 8 特性
  @GetMapping("testJava8New")
  public void testJava8New() {
    List<String> names1 = new ArrayList<String>();
    names1.add("Google ");
    names1.add("Runoob ");
    names1.add("Taobao ");
    names1.add("Baidu ");
    names1.add("Sina ");

    List<String> names2 = new ArrayList<String>();
    names2.add("Google ");
    names2.add("Runoob ");
    names2.add("Taobao ");
    names2.add("Baidu ");
    names2.add("Sina ");

    TestJavaSEController tester = new TestJavaSEController();

    System.out.println("使用 Java 7 语法: ");
    tester.sortUsingJava7(names1);
    System.out.println(names1);

    System.out.println("使用 Java 8 语法: ");
    tester.sortUsingJava8(names2);
    System.out.println(names2);
  }

  private void sortUsingJava7(List<String> names) {
    Collections.sort(names, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return s1.compareTo(s2);
      }
    });
  }

  private void sortUsingJava8(List<String> names) {
    Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
  }

  //双引号操作::
  @GetMapping("testSYH")
  public void testSYH() {
    List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");
    //对象实例语法	instanceRef::methodName
    list.forEach(new TestJavaSEController()::print);
  }

  public void print(String content) {
    System.out.println(content);
  }

  //静态方法
  @GetMapping("testStaticFun")
  public static int testStaticFun() {
    System.out.println("testStaticFun" + getI());
    return 0;
  }

  //正则表达式
  @GetMapping("testPattern")
  public void testPattern() {
    String content = "I am noob from runoob.com.";
    String pattern = ".*runoob*";
    boolean isMatch = Pattern.matches(pattern, content);
    System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
  }

  //字符串替换
  @GetMapping("testReplaceChar")
  public void testReplaceChar() {
    String str = "Hello World，Hello World";
    System.out.println(str.replace('H', 'W'));
    str = "Hello World，Hello World";
    System.out.println(str.replaceFirst("He", "Wa"));
    str = "Hello World，Hello World";
    System.out.println(str.replaceAll("He", "Ha"));
  }

  //删除字符串中的一个元素
  @GetMapping("testDeleteCharFromString")
  public int testDeleteCharFromString(String args[]) {
    String str = "this is Java";
    System.out.println(removeCharAt(str, 3));
    return 0;
  }

  public String removeCharAt(String s, int pos) {
    return s.substring(0, pos) + s.substring(pos + 1);
  }

  //数组排序及元素查找
  @GetMapping("testArraySort")
  public int testArraySort() throws Exception {
    int array[] = {2, 5, -2, 6, -3, 8, 0, -7, -9, 4};
    System.out.println(array);
    Arrays.sort(array);
    System.out.println(array);
    printArray("数组排序结果为", array);
    int index = Arrays.binarySearch(array, 2);
    System.out.println("元素 2  在第 " + index + " 个位置");
    return 0;
  }

  private void printArray(String message, int array[]) {
    System.out.println(message
        + ": [length: " + array.length + "]");
    for (int i = 0; i < array.length; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(array[i]);
    }
    System.out.println();
  }


  //字符串操作
  @GetMapping("testString")
  public int testString() {
    String string = "123";
    //字符串转整形
    int i = Integer.valueOf(string);
    System.out.println("字符串转整形：" + (i + 100));
    char[] c = string.toCharArray();
    System.out.println("字符串转字符数组：" + c);
    String Str = "www.runoob.com";
    System.out.print("返回值 :");
    System.out.println(Str.toCharArray());

    String Str1 = "0字符串转字节0";
    try {
      byte[] Str2 = Str1.getBytes();
      for (byte b : Str2) {
        System.out.print(b + " ");
      }
      System.out.println("返回值：" + Str2);
      Str2 = Str1.getBytes("UTF-8");
      for (byte b : Str2) {
        System.out.print(b + " ");
      }
      System.out.println("(UTF-8)返回值：" + Str2);

      Str2 = Str1.getBytes("Unicode");
      for (byte b : Str2) {
        System.out.print(b + " ");
      }
      System.out.println("(Unicode)返回值：" + Str2);

      Str2 = Str1.getBytes("GB2312");
      for (byte b : Str2) {
        System.out.print(b + " ");
      }
      System.out.println("(GB2312)返回值：" + Str2);
    } catch (UnsupportedEncodingException e) {
      System.out.println("不支持的字符集");
    }

    return 0;
  }

  //测试格式化时间
  @GetMapping(path = "time")
  public int mytime() {
    Date date = new Date();
    System.out.println(date.toString());
    System.out.println(date.getTime());//返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
    String strDateFormat = "yyyy-MM-dd HH:mm:ss.SSS";
    SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
    System.out.println(sdf.format(date));
    return 0;
  }

  //时间戳
  @GetMapping("tesTimestamp")
  public void tesTimestamp() {
    Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
    System.out.println("时间戳：" + timeStamp);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));      // 时间戳转换成时间
    System.out.println("格式化结果：" + sd);

    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
    String sd2 = sdf2.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
    System.out.println("格式化结果：" + sd2);
  }

  //测试泛型
  @GetMapping(path = "1")
  public int test() {
    List<String> name = new ArrayList<>();
    List<Integer> age = new ArrayList<>();
    List<Number> number = new ArrayList<>();

    name.add("icon");
    age.add(18);
    number.add(314);

    //getUperNumber(name);//1
    getUperNumber(age);//2
    getUperNumber(number);//3

    return 0;
  }

  public static void getData(List<?> data) {
    LOGGER.info("data :" + data.get(0));
  }

  public static void getUperNumber(List<? extends Number> data) {
    LOGGER.info("data :" + data.get(0));
  }

  // 泛型方法 printArray
  public <E> void printArray(E[] inputArray) {
    // 输出数组元素
    for (E element : inputArray) {
      System.out.printf("%s ", element);
    }
    System.out.println();
  }

  //测试泛型
  @GetMapping(path = "2")
  public int test2() {
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
    return 0;
  }

  //测试集合框架-ArrayList
  @GetMapping(path = "3")
  public int test3() {
    List<String> list = new ArrayList<String>();
    list.add("Hello");
    list.add("World");
    list.add("HAHAHAHA");
    //第一种遍历方法使用 For-Each 遍历 List
    for (String str : list) {            //也可以改写 for(int i=0;i<list.size();i++) 这种形式
      System.out.println(str);
    }

    //第二种遍历，把链表变为数组相关的内容进行遍历
    String[] strArray = new String[list.size()];
    list.toArray(strArray);
    for (int i = 0; i < strArray.length; i++) //这里也可以改写为  for(String str:strArray) 这种形式
    {
      System.out.println(strArray[i]);
    }

    //第三种遍历 使用迭代器进行相关遍历

    Iterator<String> ite = list.iterator();
    while (ite.hasNext())//判断下一个元素之后有值
    {
      System.out.println(ite.next());
    }
    return 0;
  }

  //测试集合框架-HashMap
  @GetMapping("4")
  public int test4() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "value1");
    map.put("2", "value2");
    map.put("3", "value3");

    //第一种：普遍使用，二次取值
    System.out.println("通过Map.keySet遍历key和value：");
    for (String key : map.keySet()) {
      System.out.println("key= " + key + " and value= " + map.get(key));
    }

    //第二种
    System.out.println("通过Map.entrySet使用iterator遍历key和value：");
    Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<String, String> entry = it.next();
      System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
    }

    //第三种：推荐，尤其是容量大时
    System.out.println("通过Map.entrySet遍历key和value");
    for (Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
    }

    //第四种
    System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
    for (String v : map.values()) {
      System.out.println("value= " + v);
    }
    return 0;
  }
}
