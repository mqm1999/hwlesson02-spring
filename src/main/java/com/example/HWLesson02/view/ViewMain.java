//package com.example.HWLesson02.view;
//
//import com.example.HWLesson02.controller.BookController;
//import com.example.HWLesson02.dto.BookWithAuthorName;
//
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Scanner;
//
//public class ViewMain {
//    Scanner sc = new Scanner(System.in);
//
//    public ViewMain() throws SQLException {
//        while (true) {
//            String oldName, nameInput, authorInput;
//            System.out.println("1. Show all books");
//            System.out.println("2. Add book");
//            System.out.println("3. Update book");
//            System.out.println("4. Delete book");
//            System.out.println("Select an option: ");
//            int input = sc.nextInt();
//            switch (input) {
//                case 1:
//                    List<BookWithAuthorName> response = BookController.getInstance().getAllBooks();
//                    for (int i = 0; i < response.size(); i++) {
//                        System.out.println(response.get(i).toString());
//                    }
//                    break;
//
//                case 2:
//                    System.out.println("Book name: ");
//                    nameInput = sc.next();
//                    System.out.println("Book author: ");
//                    authorInput = sc.next();
//                    boolean addResponse = BookController.getInstance().addBook(nameInput, authorInput);
//                    if (addResponse) {
//                        System.out.println("Add success");
//                    } else {
//                        System.out.println("Fail to add");
//                    }
//                    break;
//
//                case 3:
//                    System.out.println("Book want to change name: ");
//                    oldName = sc.next();
//                    System.out.println("New book name: ");
//                    nameInput = sc.next();
//                    boolean updateResponse = BookController.getInstance().updateBook(oldName, nameInput);
//                    if (updateResponse) {
//                        System.out.println("Updated");
//                    } else {
//                        System.out.println("Fail to update");
//                    }
//                    break;
//
//                case 4:
//                    System.out.println("Name book want to delete: ");
//                    nameInput = sc.next();
//                    boolean deleteResponse = BookController.getInstance().deleteBook(nameInput);
//                    if (deleteResponse) {
//                        System.out.println("Success");
//                    } else {
//                        System.out.println("Fail to delete");
//                    }
//                    break;
//
//                default:
//                    System.out.println("Option not found");
//                    break;
//            }
//        }
//    }
//}
