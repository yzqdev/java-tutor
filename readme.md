## java-tutor

java语言的学习

包括:java基础语法,java8-java17的变更,一些算法
## 泛型标识符
* E - Element (在集合中使用，因为集合中存放的是元素)
*  T - Type（Java 类）
*  K - Key（键）
*  V - Value（值）
*  N - Number（数值类型）
*  ？ - 表示不确定的 java 类型

## 注释说明

| 标签          | 描述                                                   | 说明                                                         |
| ------------- | ------------------------------------------------------ | ------------------------------------------------------------ |
| @author       | 标识一个类的作者                                       | @author description                                          |
| @deprecated   | 指名一个过期的类或成员                                 | @deprecated description                                      |
| {@docRoot}    | 指明当前文档根目录的路径                               | Directory Path                                               |
| @exception    | 标志一个类抛出的异常                                   | @exception exception-name explanation                        |
| {@inheritDoc} | 从直接父类继承的注释                                   | Inherits a comment from the immediate surperclass.           |
| {@link}       | 插入一个到另一个主题的链接                             | {@link name text}                                            |
| {@linkplain}  | 插入一个到另一个主题的链接，但是该链接显示纯文本字体   | Inserts an in-line link to another topic.                    |
| @param        | 说明一个方法的参数                                     | @param parameter-name explanation                            |
| @return       | 说明返回值类型                                         | @return explanation                                          |
| @see          | 指定一个到另一个主题的链接                             | @see anchor                                                  |
| @serial       | 说明一个序列化属性                                     | @serial description                                          |
| @serialData   | 说明通过writeObject( ) 和 writeExternal( )方法写的数据 | @serialData description                                      |
| @serialField  | 说明一个ObjectStreamField组件                          | @serialField name type description                           |
| @since        | 标记当引入一个特定的变化时                             | @since release                                               |
| @throws       | 和 @exception标签一样.                                 | The @throws tag has the same meaning as the @exception tag.  |
| {@value}      | 显示常量的值，该常量必须是static属性。                 | Displays the value of a constant, which must be a static field. |
| @version      | 指定类的版本                                           | @version info                                                |

### 样例
```java
import java.io.*;
 
/**
* 这个类演示了文档注释
* @author Ayan Amhed
* @version 1.2
*/
public class SquareNum {
   /**
   * This method returns the square of num.
   * This is a multiline description. You can use
   * as many lines as you like.
   * @param num The value to be squared.
   * @return num squared.
   */
   public double square(double num) {
      return num * num;
   }
   /**
   * This method inputs a number from the user.
   * @return The value input as a double.
   * @exception IOException On input error.
   * @see IOException
   */
   public double getNumber() throws IOException {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader inData = new BufferedReader(isr);
      String str;
      str = inData.readLine();
      return (str).doubleValue();
   }
   /**
   * This method demonstrates square().
   * @param args Unused.
   * @return Nothing.
   * @exception IOException On input error.
   * @see IOException
   */
   public static void main(String args[]) throws IOException
   {
      SquareNum ob = new SquareNum();
      double val;
      System.out.println("Enter value to be squared: ");
      val = ob.getNumber();
      val = ob.square(val);
      System.out.println("Squared value is " + val);
   }
}
```
### java系统变量
可以获取系统的配置信息，下面说一下System.getProperty()的参数有那些:

| java.version                  | Java运行时环境版本                |
| ----------------------------- | --------------------------------- |
| java.vendor                   | Java运行时环境供应商              |
| java.vendor.url               | Java供应商的 URL                  |
| java.home                     | Java安装目录                      |
| java.vm.specification.version | Java虚拟机规范版本                |
| java.vm.specification.vendor  | Java虚拟机规范供应商              |
| java.vm.specification.name    | Java虚拟机规范名称                |
| java.vm.version               | Java虚拟机实现版本                |
| java.vm.vendor                | Java虚拟机实现供应商              |
| java.vm.name                  | Java虚拟机实现名称                |
| java.specification.version    | Java运行时环境规范版本            |
| java.specification.vendor     | Java运行时环境规范供应商          |
| java.specification.name       | Java运行时环境规范名称            |
| java.class.version            | Java类格式版本号                  |
| java.class.path               | Java类路径                        |
| java.library.path             | 加载库时搜索的路径列表            |
| java.io.tmpdir                | 默认的临时文件路径                |
| java.compiler                 | 要使用的 JIT 编译器的名称         |
| java.ext.dirs                 | 一个或多个扩展目录的路径          |
| os.name                       | 操作系统的名称                    |
| os.arch                       | 操作系统的架构                    |
| os.version                    | 操作系统的版本                    |
| file.separator                | 文件分隔符（在 UNIX 系统中是“/”） |
| path.separator                | 路径分隔符（在 UNIX 系统中是“:”） |
| line.separator                | 行分隔符（在 UNIX 系统中是“/n”）  |
| user.name                     | 用户的账户名称                    |
| user.home                     | 用户的主目录                      |
| user.dir                      | 用户的当前工作目录                |
###  .scope各种取值详解

| scope取值    | 有效范围（compile, runtime, test） | 依赖传递 | 例子        |
| :----------- | :--------------------------------- | :------- | :---------- |
| **compile**  | all                                | 是       | spring-core |
| **provided** | compile, test                      | 否       | servlet-api |
| **runtime**  | runtime, test                      | 是       | JDBC驱动    |
| **test**     | test                               | 否       | JUnit       |
| **system**   | compile, test                      | 是       |             |

正如上表所示，

**compile** ：为默认的依赖有效范围。如果在定义依赖关系的时候，没有明确指定依赖有效范围的话，则默认采用该依赖有效范围。此种依赖，在编译、运行、测试时均有效。

**provided** ：在编译、测试时有效，但是在运行时无效。例如：servlet-api，运行项目时，容器已经提供，就不需要Maven重复地引入一遍了。

**runtime** ：在运行、测试时有效，但是在编译代码时无效。例如：JDBC驱动实现，项目代码编译只需要JDK提供的JDBC接口，只有在测试或运行项目时才需要实现上述接口的具体JDBC驱动。

**test** ：只在测试时有效，例如：JUnit。

**system** ：在编译、测试时有效，但是在运行时无效。和provided的区别是，使用system范围的依赖时必须通过systemPath元素显式地指定依赖文件的路径。由于此类依赖不是通过Maven仓库解析的，而且往往与本机系统绑定，可能造成构建的不可移植，因此应该谨慎使用。systemPath元素可以引用环境变量
```xml
        <dependency>
            <groupId>javax.sql</groupId>
            <artifactId>jdbc-stdext</artifactId>
            <version>2.0</version>
            <scope>system</scope>
            <systemPath>${java.home}/lib/rt.jar</systemPath>
        </dependency>
```

scope的分类
> compile

默认就是compile，什么都不配置也就是意味着compile。compile表示被依赖项目需要参与当前项目的编译，当然后续的测试，运行周期也参与其中，是一个比较强的依赖。打包的时候通常需要包含进去。

> test

scope为test表示依赖项目仅仅参与测试相关的工作，包括测试代码的编译，执行。比较典型的如junit。

> runntime

runntime表示被依赖项目无需参与项目的编译，不过后期的测试和运行周期需要其参与。与compile相比，跳过编译而已，说实话在终端的项目（非开源，企业内部系统）中，和compile区别不是很大。比较常见的如JSR×××的实现，对应的API jar是compile的，具体实现是runtime的，compile只需要知道接口就足够了。oracle jdbc驱动架包就是一个很好的例子，一般scope为runntime。另外runntime的依赖通常和optional搭配使用，optional为true。我可以用A实现，也可以用B实现。

> provided

provided意味着打包的时候可以不用包进去，别的设施(Web Container)会提供。事实上该依赖理论上可以参与编译，测试，运行等周期。相当于compile，但是在打包阶段做了exclude的动作。

> system

从参与度来说，也provided相同，不过被依赖项不会从maven仓库抓，而是从本地文件系统拿，一定需要配合systemPath属性使用。

> scope的依赖传递

A–>B–>C。当前项目为A，A依赖于B，B依赖于C。知道B在A项目中的scope，那么怎么知道C在A中的scope呢？答案是：
当C是test或者provided时，C直接被丢弃，A不依赖C；
否则A依赖C，C的scope继承于B的scope。

## 什么是classpath

### 各种path获取到的路径的区别
Main.class.getResource(""); 得到的是当前class所在的路径

Main.class.getResourceAsStream(""); 是从当前路径查找资源资源

Main.class.getClassLoader.getResource("");得到的是当前类classloader加载类的起始位置

Main.class.getClassLoader.getResourceAsStream("");从classpath的起始位置查找资源

但是

Main.class.getResource("/"); 表示从classpath目录下找

也就是说 Main.class.getResource("/"); 等价于 Main.class.getClassLoader.getResource("");

但是 Main.class.getClassLoader.getResourceAsStream("/"); 返回的是null

### 关于Servlet 资源路径
ServletContext.getRealPath("/") 返回的是 war 包展开后的从系统根目录到war展开地址的根路径，比如windows 就是 file:///d/path/to/war/

也就是上面做了两个动作， 先从 war 根目录找到资源， 然后返回资源完整路径

同样的 ServletContext.getResource("/") 返回的的是从war 根目录查找到的资源，只不过返回的是 URL ServletContext.getResourceAsStream("/") 返回的是和上面一样的 InputStream

但是 ServletContext.getResource("") 返回的是相对于URL的路径，相当于从当前URL根路径查找资源 ServletContext.getResourceAsStream("") 和上面一样，只不过返回InputStream

### 关于maven工程下springmvc资源路径配置
Java 源代码文件资源在Maven工程中的默认路径是: src/main/java，这个路径就是放置你的Java源代码文件。默认的路径是无需在Maven的pom.xml配置文件中指定的
资源文件的缺省路径为src/main/resources，这样Maven在打包成war文件的时候，会将src/main/resources的资源文件复制到class目录。
因此对于Spring mvc项目，servlet的配置文件springmvc-context.xml缺省会放置在 src/main/resources/springmvc-context.xml。
对应的的web.xml指定的<param-value>classpath:springmvc-context.xml</param-value> 中，servlet的配置文件springmvc-context.xml 需要从 class目录下查找