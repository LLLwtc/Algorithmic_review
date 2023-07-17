package charpter1_linklist.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


//没有按Java cpp Python的顺序
public class Student {
    String name;
    String language;
    Student next;

    public Student(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public static void main(String[] args) {
//        Student[] s1={{"aa","Java"},{"ab","Java"},{"ba","CPP"},{"bb","CPP"},{"ca","Python"},{"cb","Python"}};
        ArrayList<Student> students = new ArrayList<>();
//        students.add(new Student("aa","Java"));
//        students.add(new Student("ab","Java"));
//        students.add(new Student("ba","CPP"));
//        students.add(new Student("bb","CPP"));
//        students.add(new Student("ca","Python"));
//        students.add(new Student("cb","Python"));

        students.add(new Student("aa","Java"));
        students.add(new Student("ca","Python"));
        students.add(new Student("ba","CPP"));
        students.add(new Student("ab","Java"));
        students.add(new Student("cb","Python"));
        students.add(new Student("bb","CPP"));

        Student head = new Student("11","Java");
        Student.insertAll(head,students);

        //输出
        while(head!=null){
            System.out.println(head.name+head.language);
            head=head.next;
        }
    }

    /**
     * @param head  原链表
     * @param nodes 需要插入的节点列表
     * @return
     * @author 帅哥
     */
    public static Student insertAll(Student head, ArrayList<Student> nodes) {
        Student res=head;

        for (Student node : nodes) {
            insertOne(head, (Student) node);
        }

        return res;
    }

    /**
     * @param head 原链表
     * @param node 需要插入的节点列表
     * @return
     * @author 帅哥
     */
    public static Student insertOne(Student head, Student node) {

        Student tmp = head;
        Student newNode = node;

        //插入表头
        if (head == null) {
            newNode = head;
        }

        //插入表中
        while (tmp != null) {
            //找到不同类别的交接点
            if (tmp.next != null && tmp.language.equals(tmp.next.language)) tmp = tmp.next;
            else {
                //判断是否是加入的位置
                if (tmp.language.equals(newNode.language)||tmp.next==null) {
                    //是，插入
                    newNode.next = tmp.next;
                    tmp.next = newNode;
                    return head;
                } else {
                        tmp = tmp.next;
                }
            }
        }
        return head;
    }

}
