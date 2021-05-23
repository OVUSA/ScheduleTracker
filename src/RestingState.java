import java.time.LocalTime;

public class RestingState implements State {
    Tracker tracker;
    WorkState ws;

    RestingState(Tracker tracker){
        this.tracker = tracker;
    }


    @Override
    public String onWork() {
        return "Inactive";

    }

    @Override
    public String onRest() {
        return "Start resting at : ";

    }

    public String onStop(){
     LocalTime eTime = LocalTime.now();
      return "Stop resting at :"+ws.timeFormatting(eTime);
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
            // formating time
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
    }*/
