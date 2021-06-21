import java.time.LocalTime;

public class RestingState implements State {
    Tracker tracker;
    Manager dataBase = new Manager();
    static LocalTime now;

    RestingState(Tracker tracker){
        this.tracker = tracker;
    }

    // Capture the time the button was pressed , then changes the state
    // record the time to StopResting and StartWorking
    @Override
    public String onWork() {
        LocalTime currentTime = LocalTime.now();
        String ct = tracker.timeFormatting(currentTime);
        long start = System.currentTimeMillis();
        tracker.changeState(new WorkState(tracker));
        dataBase.startedWorking.add(start);
        return "Stop resting is recorded at: "+ ct+" \n"+
                "Begin working at "+ ct ;

    }

    @Override
    public String onRest() {
        return "Inactive button... you are resting.\n If you wish to terminate the activity press STOP button";

    }

    public String onStop(){
     LocalTime eTime = LocalTime.now();
     long stop = System.currentTimeMillis();
     tracker.changeState(new StopState(tracker));
     dataBase.stopResting.add(stop);
     return "Stop resting at :"+ tracker.timeFormatting(eTime);
    }
}


/*public class BreakState implements State {

        public void calculateDuration(){
            int n =0;
            while(n<STOP.size()){
                Duration diff = Duration.between(START.get(n),STOP.get(n));
                System.out.println("You have been working for:" + diff.toHours() + ":" + diff.toMinutes() + ":" + diff.toMillis()/1000);

                //System.out.println(("runtime: " + (endTime - startTime)));
                DurationRest .add(diff);}
        }
    }*/
