import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager implements State {

     static ArrayList<Long> startedWorking = new ArrayList<>();
     static ArrayList<Long> stopWorking = new ArrayList<>();

    List< String> startWorking_String = new ArrayList<>();

    ArrayList<Long> startedResting = new ArrayList<>();
    ArrayList<Long> stopResting = new ArrayList<>();

    List<String> duration = new ArrayList<>();

    // work time duration
    ArrayList<Long> dif = new ArrayList<>();
    // rest time duration
    ArrayList<Long>rest_dif = new ArrayList<>();


    public String timeFormatting(LocalTime time) {
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("hh:mm:ss");
        return time.format(myFormatObj1);

    }
    // populate duration array
    public void calculateDuration(ArrayList<Long>start, ArrayList<Long>stop, ArrayList<Long>difference) {
        for (int i = 0; i < stop.size() - 1; i++) {
            difference.add(stop.get(i) - start.get(i));
        }

    }
    //format time from Long to String
    public String changeTime(Long element) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
            Date date = new Date(element);
            String time = simpleDateFormat.format(date);
            duration.add(time);

        return time;
    }


    public void printReport() throws IOException {
        FileOutputStream fileStream = new FileOutputStream("report.txt");
        PrintWriter pw = new PrintWriter(fileStream);


        // out = new BufferedWriter(new FileWriter());

        LocalDate today = LocalDate.now();
        long element = 0;
        pw.println();
        pw.println("Report for " + today);
        pw.println();
        pw.println("Categories \t Duration:");

        pw.print(" Work   \t  ");
        for (int i = 0; i < dif.size(); i++) {
            element = element + dif.get(i);
        }
        String time = changeTime(element);
        pw.println(time);

        element = 0;
        pw.println();
        pw.print(" Break   \t  ");
        for (int i = 0; i < rest_dif.size(); i++) {
            element = element + rest_dif.get(i);
        }
        String time1 = changeTime(element);
        pw.println(time1);
        pw.close();
    }

    @Override
    public String onWork() {
        return null;
    }

    @Override
    public String onRest() {
        return null;
    }

    @Override
    public String onStop() {
        return null;
    }
}
/*
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("00:mm:ss");
        //Date date1 = new Date(element);
       // String time1 = simpleDateFormat1.format(date1);
      //  System.out.print(workTimeDiff);

    }
}*/
