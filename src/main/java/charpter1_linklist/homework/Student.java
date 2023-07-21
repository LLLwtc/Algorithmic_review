package charpter1_linklist.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;



public class Student {
    String name;
    String language;
    Student next;

    public static void main(String[] args) {

        test1();
//        test2();
//        test3();
    }

    //测试1
    public static void test1(){
        //初始化
        Student s1 = new Student("aa", "Java");
        Student s2 = new Student("ab", "Java");
        Student s4 = new Student("ba", "CPP");
        Student s5 = new Student("bb", "CPP");
        Student s6 = new Student("ca", "Python");
        Student s7 = new Student("cb", "Python");
        s1.next=s2;
        s2.next=s4;
        s4.next=s5;
        s5.next=s6;
        s6.next=s7;

        Student addNode = new Student("cc", "Python");
//        Student addNode = new Student("bc", "CPP");
        Student addNode2 = new Student("ac", "Java");
        Student res = Student.addStudentElement(s1, addNode);
//        Student res = Student.addStudentElement(s1, addNode2);

        while(res!=null){
            System.out.println(res.language+" "+res.name);
            res=res.next;
        }
    }
    public static Student addStudentElement(Student node,Student addElement){
        if(node==null){
            return addElement;
        }
        Student dummy=new Student();
        dummy.next=node;
        Student cur=dummy;

        Student temp=null;

        boolean isDummyAdded=false;

        while(cur!=null&&cur.next!=null){
            if(cur.language==addElement.language&&cur.next.language!=addElement.language&&!isDummyAdded){
                temp=cur.next;
                cur.next=addElement;
                addElement.next=temp;
                isDummyAdded=true;
            }
            cur=cur.next;
        }
        return dummy.next;
    }
    
    public Student() {
    }
    public Student(String name, String language) {
        this.name = name;
        this.language = language;
    }

}
