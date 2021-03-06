import java.time.LocalTime;

public class RestingState implements State {
    Tracker tracker;
    Manager dataBase = new Manager();


    RestingState(Tracker tracker){
        this.tracker = tracker;
    }

    // Capture the time the button was pressed , then changes the state
    // record the time to StopResting and StartWorking
    @Override
    public String onWork() {
        LocalTime currentTime = LocalTime.now();
        String ct = dataBase.timeFormatting(currentTime);
        long start = System.currentTimeMillis();
        dataBase.stopResting.add(start);
        dataBase.startedWorking.add(start);
        tracker.changeState(new WorkState(tracker));
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
     dataBase.stopResting.add(stop);
     tracker.changeState(new StopState(tracker));
     return "Stop resting at :"+ dataBase.timeFormatting(eTime);
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
