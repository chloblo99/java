import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class Student {
    private String studentName;
    private String dateOfBirth;
    private String address;
    private String gender;

    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Student studentDetails = new Student();
        studentDetails.addStudent();
        studentDetails.searchStudent();
    }

    private void addStudent() throws IOException {
        // get students name
        System.out.println("Please enter students name: ");
        this.studentName = scan.nextLine();

        System.out.println("Please enter students date of birth (DD/MM/YYYY): ");
        this.dateOfBirth = scan.nextLine();

        System.out.println("Please enter students address: ");
        this.address = scan.nextLine();

        // validation for gender
        System.out.println("What is their gender? (Male or Female): ");
        this.gender = scan.nextLine();



        String[] studentDetails = {studentName, dateOfBirth, address, gender};
        System.out.println(Arrays.toString(studentDetails));



        // add to list of students in the course
        // also need to state if something is blank it wont be saved
        if (studentName.equals("") || dateOfBirth.equals("") || address.equals("") || gender.equals("")){
            System.out.println("Something is missing, student will not be saved.");
        }

        // if everthing is correct then it can be saved to the file of student details.
        else if (gender.equals("Female") || gender.equals("Male")){
            File file = new File("StudentDetails.txt");
            FileWriter fr = new FileWriter(file, true);
            // get the array on a new line so it is easier to read
            // save as an array for later use
            for (String s : studentDetails){
                fr.write(s + ", ");
                fr.write("/n");
                // \n is to make sure that the next thing entered into the file will be on the next line
            }
            fr.close();
        }
        else{
            System.out.println("Gender has been inputed incorrectly, data has not been saved.");
        }

    }

    private void searchStudent() throws IOException {
        String searchName;
        System.out.println("Please enter the students name you would like to find:");
        searchName = scan.nextLine();

        File file = new File("StudentDetails.txt");
        FileReader fr = new FileReader("StudentDetails.txt");
        BufferedReader br = new BufferedReader(fr);

        while(searchName == br.readLine()){
            try{
                readLines(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        br.close();
        fr.close();

    }

    private void deleteStudent(){
        File inputFile = new File("myFile.txt");
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove;
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(inputFile);
    }



}
