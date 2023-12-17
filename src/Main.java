import database.Database;
import models.Group;
import models.Lesson;
import models.Role;
import models.Student;
import service.GroupServiceImpl;
import service.LessonServiceImpl;
import service.MyCenerateId;
import service.StudentServiceImpl;

import javax.swing.text.NavigationFilter;
import java.time.LocalTime;
import java.util.NavigableSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        StudentServiceImpl studentService = new StudentServiceImpl(database);
        GroupServiceImpl groupService = new GroupServiceImpl(database);
        LessonServiceImpl lessonService = new LessonServiceImpl(database);
        Scanner scanner = new Scanner(System.in);
        Scanner scannerForNum = new Scanner(System.in);

        LocalTime localTime = LocalTime.now();
        if (localTime.getHour() >= 5 && localTime.getHour() < 12) {
            System.out.println("Кутман таң! Саат -> " + localTime.getHour() + ":" + localTime.getMinute());
        } else if (localTime.getHour() >= 12 && localTime.getHour() < 18) {
            System.out.println("Кутман күн! Саат -> " + localTime.getHour() + ":" + localTime.getMinute());
        } else if (localTime.getHour() >= 18 && localTime.getHour() <= 23) {
            System.out.println("Кутман кеч! Саат -> " + localTime.getHour() + ":" + localTime.getMinute());
        }
        while (true) {
            System.out.println("Катталган болсоңуз 1 басыңыз. пароль унутуп калып, өзгөртуу үчүн 2 басыңыз!");
            int num = scanner.nextInt();
            switch (num) {
                case 1 -> {
                    System.out.println("Кируу учун электрондук почтанызды жазыныз: ");
                    String email = new Scanner(System.in).nextLine();
                    System.out.println("Паролунузду жазаныз: ");
                    String password = new Scanner(System.in).nextLine();
                    if (Role.ADMIN.getEmail().equals(email)) {
                        if (Role.ADMIN.getPassword().equals(password)) {
                            System.out.println("Кош келиниз!");
                            while(true) {
                                System.out.println("***Бир команда танданыз***");
                                System.out.println("""
                                        1. Add new group
                                        2. Get group by name
                                        3. Update group name
                                        4. Get all groups
                                        5. Add new student to group
                                        6. Update student
                                        7. Find student by first name
                                        8. Get all students by group name
                                        9. Get all student's lesson
                                        10. Delete student by email
                                        11. Add new lesson to group
                                        12. Get lesson by name
                                        13. Get all lesson by group name
                                        14. Delete lesson by ID
                                        15. Delete group by name
                                        """);
                                int answer = scannerForNum.nextInt();
                                switch (answer) {
                                    case 1 -> {
                                        Group group = new Group();
                                        System.out.println("Жаны группага ат жазыныз: ");
                                        group.setGroupName(new Scanner(System.in).nextLine());
                                        System.out.println("Группанын суроттомосун жазыныз: ");
                                        group.setDescription(new Scanner(System.in).nextLine());
                                        groupService.add(group);
                                        System.out.println(group.getGroupName() + " аттуу группа ийгиликтуу сакталды!");
                                        System.out.println(group);
                                    }
                                    case 2 -> {
                                        System.out.println("Группанын атын жазыныз: ");
                                        String groupName = new Scanner(System.in).nextLine();
                                        System.out.println(groupService.getGroupByName(groupName));
                                    }
                                    case 3 -> {
                                        System.out.println("Группанын атын жазыныз: ");
                                        String groupName = new Scanner(System.in).nextLine();
                                        System.out.println("Группага жаны ат жазыныз: ");
                                        String newName = new Scanner(System.in).nextLine();
                                        groupService.updateGroupName(groupName, newName);
                                    }
                                    case 4 -> {
                                        groupService.getAllGroups();
                                    }
                                    case 5 -> {
                                        System.out.println("Кайсы группага студент кошосуз, ошол группанын атын жазыныз: ");
                                        String groupName = new Scanner(System.in).nextLine();
                                        Student student = new Student();
                                        System.out.println("Студенттин атын жазыныз: ");
                                        student.setFirstName(new Scanner(System.in).nextLine());
                                        System.out.println("Фамилиясын жазыныз: ");
                                        student.setLastName(new Scanner(System.in).nextLine());
                                        System.out.println("Электрондук почтасын жазыныз: ");
                                        student.setEmail(new Scanner(System.in).nextLine());
                                        System.out.println("Пароль ойлоп табыныз: ");
                                        student.setPassword(new Scanner(System.in).nextLine());
                                        System.out.println("Жынысын жазыныз: ");
                                        student.setGender(new Scanner(System.in).nextLine());
                                        studentService.addStudent(student, groupName);
                                    }
                                    case 6 -> {
                                        System.out.println("Почтанызды жазыныз: ");
                                        String emaill = new Scanner(System.in).nextLine();
                                        System.out.println("Пароль жазыныз: ");
                                        String passwordd =  new Scanner(System.in).nextLine();
                                                System.out.println("Жаны ат жазыныз: ");
                                                String newName = new Scanner(System.in).nextLine();
                                                System.out.println("Жаны фамилия жазыныз: ");
                                                String newSurname = new Scanner(System.in).nextLine();
                                                studentService.updateStudent(emaill, passwordd, newName, newSurname);
                                    }
                                    case 7 -> {
                                        System.out.println("Студенттин атын жазыныз: ");
                                        String stName = new Scanner(System.in).nextLine();
                                        System.out.println(studentService.findStudent(stName).toString());
                                    }
                                    case 8 -> {
                                        System.out.println("Группанын атын жазыныз: ");
                                        String gpName = new Scanner(System.in).nextLine();
                                        studentService.getAllStudents(gpName);
                                    }
                                    case 9 -> {
                                        System.out.println("Студенттин почтасын жазыныз: ");
                                        String eml = new Scanner(System.in).nextLine();
                                        System.out.println(studentService.getLessons(eml).toString());
                                    }
                                    case 10 ->{
                                        System.out.println("Кимди очуросуз, ошол адамдын постасын жазыныз: ");
                                        String stEmail = new Scanner(System.in).nextLine();
                                        studentService.deleteStudent(stEmail);
                                    }
                                    case 11 ->{
                                        Lesson lesson = new Lesson();
                                        System.out.println("Группанын атын жазыныз: ");
                                        String nameGr = new Scanner(System.in).nextLine();
                                            System.out.println("Сабактын атын жазыныз: ");
                                            lesson.setLessonName(new Scanner(System.in).nextLine());
                                            System.out.println("Тапшырманын суроттомосун жазыныз: ");
                                            lesson.setTaskDescription(new Scanner(System.in).nextLine());
                                            lesson.setId(MyCenerateId.generateId());
                                            lessonService.addNewLessonToGroup(lesson,nameGr);

                                    }
                                    case 12 -> {
                                        System.out.println("Сабактын атын жазыныз: ");
                                        String nameLs = new Scanner(System.in).nextLine();
                                        System.out.println(lessonService.getLessonByName(nameLs).toString());
                                    }
                                    case 13 -> {
                                        System.out.println("Группанын атын жазыныз: ");
                                        String nm = new Scanner(System.in).nextLine();
                                        System.out.println(lessonService.getAllLesson(nm).toString());
                                    }
                                    case 14 -> {
                                        System.out.println("Сабактын IDсин жазыныз: ");
                                        long lesId = new Scanner(System.in).nextLong();
                                        lessonService.deleteLesson(lesId);
                                    }
                                    case 15 -> {
                                        System.out.println("Группанын атын жазыныз: ");
                                        String nameGr = new Scanner(System.in).nextLine();
                                        groupService.deleteGroup(nameGr);
                                    }
                                }
                            }
                            } else System.err.println("Пароль туура эмес!");
                    } else System.err.println("Электрондук почта туура эмес");
                }
                case 2 -> {
                    System.out.println("Пароль озгортуу учун электрондук почтаны жазыныз: ");
                    String email = new Scanner(System.in).nextLine();
                    System.out.println("Жаны пароль жазыныз: ");
                    String newPassword = new Scanner(System.in).nextLine();
                    if (Role.ADMIN.getEmail().equals(email)) {
                        Role.ADMIN.setPassword(newPassword);
                        System.out.println("\n1Сиздин пароль ийгииктуу озгортулду!");
                        System.out.println(Role.ADMIN.toString());
                    } else System.err.println("Электрондук почта туура эмес! ");
                }
                default -> System.err.println("Команда туура эмес!");
            }
        }
    }
}
