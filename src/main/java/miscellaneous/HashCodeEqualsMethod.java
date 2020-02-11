package miscellaneous;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;


public class HashCodeEqualsMethod {
    static class Student {
        private String registrationNumber;
        private int id;

        Student(int id, String registrationNumber) {
            this.setId(id);
            this.registrationNumber = registrationNumber;
        }

        public String getRegistrationNumber() {
            return registrationNumber;
        }

        public void setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            System.out.println("equals called");
            if (obj != null && obj instanceof Student) {
                Student student = (Student) obj;
                String regNumber = student.getRegistrationNumber();
                if (regNumber != null && regNumber.equals(this.registrationNumber) && student.getId() == this.id) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            System.out.println("hashcode called");
            return id + this.registrationNumber.hashCode();
        }
    }

    static class ReportCard {
        private int mathScore;

        ReportCard() {
            // marks from 1- 100
            this.mathScore = 1 + (new Random()).nextInt(100);
        }

        public int getMathScore() {
            return mathScore;
        }

        public void setMathScore(int mathScore) {
            this.mathScore = mathScore;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "H234");
        Student s2 = new Student(1, "H234");
        Student s3 = new Student(2, "H234");
        Student s4 = new Student(2, "234");
        System.out.println(s1.equals(s2));

        Map<Student, ReportCard> studentsReport = new HashMap<Student, ReportCard>();
        studentsReport.put(s1, new ReportCard());
        studentsReport.put(s2, new ReportCard());
        studentsReport.put(s3, new ReportCard());
        studentsReport.put(s4, new ReportCard());
        studentsReport.get(s1);

        System.out.println(studentsReport.size());
    }

}
