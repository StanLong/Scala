public class Student {

    private String name;
    private Integer age;
    private static String school = "北京大学";

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // school 属性并不是通过对象调用的，而是通过类名调用的。并不能完全说是面向对象
    public void printInfo(){
        System.out.println(this.name + " " + this.age + " " + Student.school);
    }

    public static void main(String[] args) {
        Student student1 = new Student("张三", 25);
        Student student2 = new Student("李四", 20);
        student1.printInfo();
        student2.printInfo();

    }
}
