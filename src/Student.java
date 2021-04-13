/*
 *Student.java : has a collection of students
 *also allow the user add/delete/search for a student
 *@ author : Chloe Snoddy
 *@ date completed : 13/04/2021
 *
 */
import java.io.*;
import java.util.Scanner;
public class Student {
    private static Scanner scan = new Scanner(System.in);
    private String studentName;
    private String dateOfBirth;
    private String address;
    private String gender;

    public static void main(String[] args) throws IOException {

//        String menuInput;
//        // getting a sub menu that will allow the user to select what they want to do with the student file
//        // the options are, adding // deleting // searching a student
        Student studentDetails = new Student();
//        System.out.printf("Enter your choice:\n",
//                " 1 adding a student.\n",
//                " 2 delete a student.\n",
//                " 3 search a student.\n",
//                " 4 exit.\n");
//        menuInput = scan.nextLine();
//        // since the inputnis a string need to convert it into an integer
//        int numberInput = Integer.parseInt(menuInput);
//
//        if (numberInput == 1){
//            studentDetails.addStudent();
//            break;
//        }
//        else if (numberInput == 2){
//            studentDetails.deleteStudent();
//            break;
//            // need to go back or break out
//        }
//        else if (numberInput == 3 ){
//            //studentDetails.searchStudent();
//            // need to go back or break
//        }
//        else if (numberInput == 4){
//            break;
//        }
//        else {
//            System.out.println("Incorrect value please try again.");
//            break;
//        }

        studentDetails.addStudent();
        studentDetails.deleteStudent();
        studentDetails.searchStudent();
    }

    private void addStudent() throws IOException {
        // get students details so i can be added
        System.out.println("Please enter students name: ");
        this.studentName = scan.nextLine();

        System.out.println("Please enter students date of birth (DD/MM/YYYY): ");
        this.dateOfBirth = scan.nextLine();

        System.out.println("Please enter students address: ");
        this.address = scan.nextLine();

        // validation for gender will be created in an IF STATEMENT below
        System.out.println("What is their gender? (Male or Female): ");
        this.gender = scan.nextLine();


        // get the string into an array
        String[] studentDetails = {studentName, dateOfBirth, address, gender};

        // also need to show how many students have already been enrolled
        // need to count the lines that have a student on them
        // also need to make sure that blank lines are not counted
        BufferedReader reader = new BufferedReader(new FileReader("StudentDetails.txt"));
        int lines = 0;
        while(reader.readLine() != null)
            lines++;
        reader.close();

        // makes sure that if there is 20 students enrolled that no more will be added
        if (lines == 20){
            System.out.println("There is already 20 students enrolled.");
        }

        // add to list of students in the course
        // also need to state if something is blank it wont be saved
        else if (studentName.equals("") || dateOfBirth.equals("") || address.equals("") || gender.equals("")){
            System.out.println("Something is missing, student will not be saved.");
        }

        // if everything is correct then it can be saved to the file of student details.
        else if (gender.equals("Female") || gender.equals("Male")){
            File studentFile = new File("StudentDetails.txt");
            FileWriter fr = new FileWriter(studentFile, true);
            fr.write('\n');
            // get the array on a new line so it is easier to read
            // save as an array for later use
            for (String s : studentDetails){
                fr.write(s + " ");

                // \n is to make sure that the next thing entered into the file will be on the next line
            }

            fr.close();
        }

        // the only option left is that if gender does not equal "Male" or "Female"
        // then this message will show up and details wont be saved to file.
        else{
            System.out.println("Gender has been typed incorrectly, data has not been saved.");
        }

    }



    private void deleteStudent() throws IOException {

        // need to access the file
        RandomAccessFile file = new RandomAccessFile("StudentDetails.txt", "rw");
        String delete;
        String task="";
        String lineToRemove;

        System.out.println("Please enter the students name you would like to delete:");
        lineToRemove = scan.nextLine();

        while ((delete = file.readLine()) != null) {
            if (delete.startsWith(lineToRemove)) {
                continue;
            }
            // do the task and delete but also take a new line when the file has been changed
            // this also helps that the students stay in a list
            task += delete +"\n";
        }
        System.out.println(task);
        BufferedWriter writer = new BufferedWriter(new FileWriter("StudentDetails.txt"));
        writer.write(task);
        // close everything used
        file.close();
        writer.close();
    }

    private void searchStudent() throws IOException {
        String searchName;

        File studentFile = new File("StudentDetails.txt");
        FileReader fr = new FileReader("StudentDetails.txt");
        BufferedReader br = new BufferedReader(fr);

        System.out.println("Please enter the students name you would like to find:");
        searchName = scan.nextLine();
        while(studentFile.hasNextLine()){
            final String lineFromLine = studentFile.nextLine();
            if (lineFromFile.contains(searchName)){
                System.out.println(lineFromFile);
            }

        }
        br.close();
        fr.close();

    }

}

//    private void searchStudent() throws IOException {
//        String searchName;
//
//        File studentFile = new File("StudentDetails.txt");
//        FileReader fr = new FileReader("StudentDetails.txt");
//        BufferedReader br = new BufferedReader(fr);
//
//        System.out.println("Please enter the students name you would like to find:");
//        searchName = scan.nextLine();
//        while(studentFile.hasNextLine()){
//            final String lineFromLine = studentFile.nextLine();
//            if (lineFromFile.contains(searchName)){
//                System.out.println(lineFromFile);
//            }
//
//        }
//        br.close();
//        fr.close();
//
//    }
