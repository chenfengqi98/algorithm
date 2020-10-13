package com.bulider;

/**
 * @Description : TODO
 * @Author : chen qi
 * @Date: 2020-09-18 11:28
 */
public class Student {
    private Integer studentNo;
    private String name;
    private String phone;
    private Integer age;
    private String sex;

    @Override
    public String toString() {
        return "Student{" +
                "studentNo=" + studentNo +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    private Student(Builder builder) {
        this.studentNo = builder.studentNo;
        this.name = builder.name;
        this.phone = builder.phone;
        this.age = builder.age;
        this.sex = builder.sex;
    }

    public static class Builder {
        private Integer studentNo;
        private String name;
        private String phone;
        private Integer age;
        private String sex;

        public Builder studentNo(Integer studentNo) {
            this.studentNo = studentNo;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public static void main(String[] args) {
        Student build = new Student.Builder().age(1).name("2").studentNo(1).phone("1231").sex("2").build();
        System.out.println(build.toString());
    }
}
