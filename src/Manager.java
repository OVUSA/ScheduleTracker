import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager {

    List<Long> startedWorking = new ArrayList<>();
    List<Long> stopWorking = new ArrayList<>();
    List<Long> startedResting = new ArrayList<>();
    List<Long> stopResting = new ArrayList<>();

    List<String>duration = new ArrayList<>();
    ArrayList <Long>dif = new ArrayList<>();




    public String timeFormatting(LocalTime time){
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("hh:mm:ss");
        return  time.format(myFormatObj1);

    }

    public void calculateDuration() {
        for ( int i  = 0; i <startedWorking.size()-1;i++) {
            dif.add(stopWorking.get(i) - startedWorking.get(i));
        }
    }

    public void changeTime() {
        for (Long i: dif) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
            Date date = new Date(i);
            String time = simpleDateFormat.format(date);
            duration.add(time);

        }
    }
}

   /* public static void printReport( ) throws IOException {
        FileOutputStream fileStream = new FileOutputStream("report.txt");
        PrintWriter pw = new PrintWriter(fileStream);


        // out = new BufferedWriter(new FileWriter());
        pw.println("User name : "+ name);
        LocalDate today = LocalDate.now();
        long element = 0 ;
        pw.println();
        pw.println( "Report for "+ today);
        pw.println();
        pw.println("Categories \t Duration:");

        pw.print(" Work   \t  ");
        for (int i = 0 ; i < DurationWork.size(); i ++) {
            element = element + DurationWork.get(i);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("00:mm:ss");
        Date date = new Date(element);
        String time = simpleDateFormat.format(date);
        pw.println(time);

        element = 0;
        pw.println();
        pw.print(" Break   \t  ");
        for (int i = 0 ; i < DurationBreak.size(); i ++) {
            element = element + DurationBreak.get(i);
        }
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("00:mm:ss");
        Date date1 = new Date(element);
        String time1 = simpleDateFormat1.format(date1);
        pw.println(time1);
        pw.close();
    }*/



/*
     public void report() {

        System.out.println("User name : "+ getUserName());
        LocalDate today = LocalDate.now();

        System.out.println();
        System.out.println( "Report for "+ today);
        System.out.println();
        System.out.println("Categories \t Duration:");

        System.out.print(" Work   \t  ");
        for (int i = 0 ; i < work.DurationWork.size(); i ++) {
             work.DurationWork.get(i);
            System.out.print( work.DurationWork.get(i));
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("00:mm:ss");
       // Date date = new Date(workTimeDiff);
       // String time = simpleDateFormat.format(date);


       // element = 0;

        System.out.println();
        System.out.print(" Break   \t  ");
        for (int i = 0 ; i < resting.DurationRest.size(); i ++) {
             resting.DurationRest.get(i);
            System.out.print(resting.DurationRest.get(i));
        }
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("00:mm:ss");
        //Date date1 = new Date(element);
       // String time1 = simpleDateFormat1.format(date1);
      //  System.out.print(workTimeDiff);

    }
}*/
