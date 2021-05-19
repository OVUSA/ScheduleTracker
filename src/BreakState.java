import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BreakState implements Activity{

        ArrayList<LocalTime> START= new ArrayList<>();
        ArrayList<LocalTime> STOP= new ArrayList<>();
        ArrayList<Duration> DurationRest = new ArrayList<>();


        public void start(){
            LocalTime eTime = LocalTime.now();
            START.add(eTime);
            // formating time
            System.out.println("Started resting at: " + timeFormatting(eTime));

        }
        public void stop(){
            LocalTime eTime = LocalTime.now();
            STOP.add(eTime);
            // formating time
            System.out.println("Finish resting at: " + timeFormatting(eTime));
        }

        public void calculateDuration(){
            int n =0;
            while(n<STOP.size()){
                Duration diff = Duration.between(START.get(n),STOP.get(n));
                System.out.println("You have been working for:" + diff.toHours() + ":" + diff.toMinutes() + ":" + diff.toMillis()/1000);

                //System.out.println(("runtime: " + (endTime - startTime)));
                DurationRest .add(diff);}
        }

        public String timeFormatting(LocalTime time){
            DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("hh:mm:ss");
            String formattedDateStop = time.format(myFormatObj1);
            return formattedDateStop;

        }
    }
