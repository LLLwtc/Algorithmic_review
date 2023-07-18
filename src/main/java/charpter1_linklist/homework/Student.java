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
        Student head = new Student("11","Java");

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("aa","Java"));
        students.add(new Student("ca","Python"));
        students.add(new Student("ba","CPP"));
        students.add(new Student("ab","Java"));
        students.add(new Student("cb","Python"));
        students.add(new Student("bb","CPP"));

        Student res = Student.insertAll(head, students);

        while(res!=null){
            System.out.println(res.language+" "+res.name);
            res=res.next;
        }
    }
    public static void test2(){
        //初始化
        Student head = new Student("11","CPP");

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("ca","Python"));
        students.add(new Student("ba","CPP"));
        students.add(new Student("ab","Java"));


        Student res = Student.insertAll(head, students);

        while(res!=null){
            System.out.println(res.language+" "+res.name);
            res=res.next;
        }
    }
    public static void test3(){
        //初始化
        Student head = new Student("11","Python");

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("ab","Java"));
        students.add(new Student("cc","CPP"));


        Student res = Student.insertAll(head, students);

        while(res!=null){
            System.out.println(res.language+" "+res.name);
            res=res.next;
        }
    }

    /**
     * @param head  原链表
     * @param nodes 需要插入的节点列表
     */
    public static Student insertAll(Student head, ArrayList<Student> nodes) {
        Student res=head;

        for (Student node : nodes) {
            Student res1 = insertOne(res, (Student) node);
            res=res1;
        }

        return res;
    }
    /**
     * @param head 原链表
     * @param node 需要插入的节点
     */
    public static Student insertOne(Student head, Student node){
        Student cur=head;
        Student newNode=node;

        if(head==null){
            head=newNode;
            return head;
        }

        //待插入节点是Java
        if(newNode.language.equals("Java")){
            while(cur!=null) {
                if (cur.language.equals("Java")) {
//                    if(!(cur.next!=null&&cur.next.language.equals("Java")))
                    if (cur.next == null
                            ||cur.next.language.equals("CPP")
                            || cur.next.language.equals("Python"))
                        {
                        newNode.next = cur.next;
                        cur.next = newNode;
                        return head;
                    }
                }
                if(!head.language.equals("Java")){
                    newNode.next=head;
                    head=newNode;
                    return head;
                }
                cur = cur.next;
            }
        }

        //待插入节点是cpp
        if(newNode.language.equals("CPP")){
            while(cur!=null) {
                if (cur.language.equals("CPP") && cur.next == null
                        || cur.language.equals("Java") && cur.next == null
                        || cur.language.equals("CPP") && cur.next.language.equals("Python")
                        || cur.language.equals("Java") && cur.next.language.equals("Python")
                        ) {
                    newNode.next = cur.next;
                    cur.next = newNode;
                    return head;
                }
                if(head.language.equals("Python")){
                    newNode.next=head;
                    head=newNode;
                    return head;
                }
                cur=cur.next;
            }
        }

        //待插入节点是python
        if(newNode.language.equals("Python")) {
            while (cur.next != null) {
                cur = cur.next;
            }
            newNode.next=cur.next;
            cur.next=newNode;
            return head;
        }
            return head;
    }

    public Student() {
    }

    public Student(String name, String language) {
        this.name = name;
        this.language = language;
    }

}
