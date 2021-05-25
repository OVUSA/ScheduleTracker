import java.time.LocalTime;

public class RestingState implements State {
    Tracker tracker;


    RestingState(Tracker tracker){
        this.tracker = tracker;
    }


    @Override
    public String onWork() {
        LocalTime currentTime = LocalTime.now();
        String ct = tracker.timeFormatting(currentTime);
        System.out.println("Stop resting is recorded at: "+ ct);
        tracker.changeState(new WorkState(tracker));
        return "Begin working at "+ ct ;

    }

    @Override
    public String onRest() {
        return "Inactive button... you are resting.\n If you wish to terminate the activity press STOP button";

    }

    public String onStop(){
     LocalTime eTime = LocalTime.now();
     tracker.changeState(new StopState(tracker));
      return "Stop resting at :"+ tracker.timeFormatting(eTime);
    }
}
/*import java.time.Duration;
        import java.time.LocalTime;
        import java.time.format.DateTimeFormatter;
        import java.util.ArrayList;

/*public class BreakState implements State {

        ArrayList<LocalTime> START= new ArrayList<>();
        ArrayList<LocalTime> STOP= new ArrayList<>();
        ArrayList<Duration> DurationRest = new ArrayList<>();


        public void onStart(){
            LocalTime eTime = LocalTime.now();
            START.add(eTime);
            // formatting time
            System.out.println("Started resting at: " + timeFormatting(eTime));

        }

    @Override
    public String onWork() {
        return null;
    }

    @Override
    public String onRest() {
        return null;
    }

    public String onStop(){
            LocalTime eTime = LocalTime.now();
            STOP.add(eTime);
            // formatting time
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
    }*/
