package WorkPrepare;

public class internTest {

    public static void main(String[] args) {
        //test01();
        //test02();


        String str1 = new String("java");  // 在heap上创建一个，并看常量池中是否已经存在，若不存在，则就创建一个副本（也是有）
        //str1.intern();    // 没什么作用， 因为常量池应有java这个地址了
        String str2 = "java";
        System.out.println(str1 == str2);   //false
        System.out.println(str1.intern() == str2);//true


        String s1 = "abc";   // 直接在常量池中创建这个对象
        String s2 = "abc";   //  之前常量池中有abc，并返回这个
        System.out.println(s1 == s2);   // true

        String s3 = new String("xyz");  //首先在池中找，如果有则不在池中创建，没有就直接创建，并返回在堆上的对象地址
        String s4 = new String("xyz");  // 池子中有，并返回在堆中对象地址
        System.out.println(s3 == s4);  //false
        System.out.println(s3.intern() == s4);  // false   池中的地址与堆中的地址
        System.out.println(s3 == s4.intern());  // false   堆中地址与池中的地址
        System.out.println(s3.intern() == s4.intern()); // true  都是池中的地址


        String s5 = "bfe";
        String s6 = new String("bfe");
        System.out.println(s5 == s6);   // false   s6自身在堆上的地址
        System.out.println(s5 == s6.intern()); // true   s6从池子里找引用

    }

    private static void test02() {
        String str1 = new String("hello") + new String("world");
        // 堆中开辟hello，world两块； 常量池是helloworld
        str1.intern();
        String str2 = "helloworld";   // 直接返回常量池的地址
        System.out.println(str1 == str2);//true
        System.out.println(str1.intern() == str2);//true
    }

    private static void test01() {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello" + "world";   // 编译期就能确定，优化后连接在一起，放入常量池返回一个引用
        String s4 = s1 + s2;             // 运行期才知道，所以常量池并不会在
        String s5 = "helloworld";        // 直接往常量池里放
        System.out.println(s3 == s5);   // true
        System.out.println(s4 == s5);   // false
        System.out.println(s3 == s4);   // false
        System.out.println(s4.intern() == s3); // true
        System.out.println(s5.intern() == s5); // true
        System.out.println(s4.intern() == s3); // true
        System.out.println(s4.intern() == s5); // true
        System.out.println(s1.intern() == s1); // true
        System.out.println(s3.intern() == s3); // true
    }
}
