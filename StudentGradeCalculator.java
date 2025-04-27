
import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter number of subjects: ");
    int numSubjects=sc.nextInt();
    int[] marks=new int[numSubjects];
    int TotalMarks=0;

    for(int i=0;i<numSubjects;i++){
        System.out.println("Enter marks for subject"+(i+1)+"(out of 100): ");
        marks[i]=sc.nextInt();

        while(marks[i]<0 || marks[i]>100){
            System.out.println("Invalid marks. Please enter again (0-100): ");
            marks[i]=sc.nextInt();
        }
        TotalMarks += marks[i];
    }
        double average=(double)TotalMarks/numSubjects;

        String grade;
        if(average>=90){
            grade="A";
        }
        else if(average>=80){
            grade="B";
        }
        else if(average>=70){
            grade="C";
        }
        else if(average>=60){
            grade="D";
        }
        else{
            grade="E";
        }
        System.out.println("\n---Result Summary---");
        System.out.println("Total Marks: "+TotalMarks);
        System.out.printf("Average percentage: %.2f%%\n",average);
        System.out.println("Grade: "+grade);

        sc.close();
    }
}
