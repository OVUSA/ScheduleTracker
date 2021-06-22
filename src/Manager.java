import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// the class stores all data for the tracker
public class Manager {

    List<Long> startedWorking = new ArrayList<>();
    List<Long> stopWorking = new ArrayList<>();
    List<Long> startedResting = new ArrayList<>();
    List<Long> stopResting = new ArrayList<>();



    static long durationStart=0;
    static long durationStop=0;
    List <Long> durationsAB = new ArrayList<>();

    public void setDurationStart(long start){
        this.durationStart = start;
    }
    public void setDurationStop(long start){
        this.durationStop = start;
    }

    public void calculateDuration(){
        long elapsedTime = durationStop- durationStart;
        durationsAB.add(elapsedTime);
    }

    public String timeFormatting(LocalTime time){
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("hh:mm:ss");
        return  time.format(myFormatObj1);

    }
    public void calculateDuration (Long time){
        List<Long> currentTime = new ArrayList<>();
        if(currentTime.get(0)== null){
            currentTime.add(time);
        }
    }

}

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
