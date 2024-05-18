package java.lang;

/**
 * 双亲委派机制
 */
public class String {
    static {
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
        //报错，因为当本String类被加载器加载，会一直向上委托加载
        //而引导类加载器发现需要加载java.**下的类，则会加载核心包中java.lang.String
        //而核心包中的String无main方法，所以报错
        System.out.println("String run main");
    }
}
