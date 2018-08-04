package Algorithm.sort.SelectionSort02;

public class Student implements Comparable<Student>{

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // 分数相等，则按照字母来，分数不等，则分高的在前
    @Override
    public int compareTo(Student o) {
        if(this.score < o.score){
            return -1;
        }else if(this.score > o.score){
            return 1;
        }else {
            return this.name.compareTo(o.name);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
