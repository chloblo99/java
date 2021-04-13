/*
 *Course.java : shows the course details and -
 *will output a report of the course details and students enrolled
 *@ author : Michael Kelly
 *@ date completed : 13/04/2021
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Course {

    public static void main(String[] args) {

        try {

            FileWriter writer = new FileWriter("Coursedetails.txt", true);
            writer.write("Courses:Maths,Science");
            writer.write("\r\n");   // write new line
            writer.write("Lecturers for courses: Dr Wilson, Dr Whan.");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            FileReader reader = new FileReader("Coursedetails.txt, studentdetails.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                System.out.println(line);

            }

            reader.close();



        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    private String Coursename;

    private String lecturername;



    String[] CourseDetails = {Coursename, lecturername,};



}