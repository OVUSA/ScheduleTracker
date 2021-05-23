import java.time.LocalTime;

class StopState implements State{

    Tracker tracker;
    Manager manager;
    WorkState ws;
    StopState(Tracker tracker){
        this.tracker = tracker;
    }


    @Override
    public String onWork() {
        tracker.changeState(new WorkState(tracker));
        tracker.setWorking(false);
        LocalTime eTime = LocalTime.now();
//        manager.startedWorking.add(ws.timeFormatting(eTime));//  save the time!!
        return "Started working at: "+ ws.timeFormatting(eTime);
    }

    @Override
    public String onRest() {
        tracker.changeState(new RestingState(tracker));
        tracker.setWorking(false);
        LocalTime eTime = LocalTime.now();
        return "Started resting at "+ ws.timeFormatting(eTime);
    }

    @Override
    public String onStop() {
        return "Inactive 'STOP' button";
    }


}