package com.example.sms;
else System.out.println("Failed to add student.");
}


private static void listStudents() {
List<Student> list = dao.getAllStudents();
if (list.isEmpty()) System.out.println("No students found.");
else list.forEach(System.out::println);
}


private static void viewStudent() {
System.out.print("Enter ID: ");
int id = Integer.parseInt(sc.nextLine());
Student s = dao.getStudentById(id);
if (s == null) System.out.println("Student not found.");
else System.out.println(s);
}


private static void updateStudent() {
System.out.print("Enter ID to update: ");
int id = Integer.parseInt(sc.nextLine());
Student existing = dao.getStudentById(id);
if (existing == null) { System.out.println("Not found."); return; }
System.out.print("Name ("+existing.getName()+"): ");
String name = sc.nextLine(); if (!name.isBlank()) existing.setName(name);
System.out.print("Email ("+existing.getEmail()+"): ");
String email = sc.nextLine(); if (!email.isBlank()) existing.setEmail(email);
System.out.print("Course ("+existing.getCourse()+"): ");
String course = sc.nextLine(); if (!course.isBlank()) existing.setCourse(course);
System.out.print("Year ("+existing.getYear()+"): ");
String yearStr = sc.nextLine(); if (!yearStr.isBlank()) existing.setYear(Integer.parseInt(yearStr));
if (dao.updateStudent(existing)) System.out.println("Updated.");
else System.out.println("Update failed.");
}


private static void deleteStudent() {
System.out.print("Enter ID to delete: ");
int id = Integer.parseInt(sc.nextLine());
if (dao.deleteStudent(id)) System.out.println("Deleted.");
else System.out.println("Delete failed or ID not present.");
}
}
