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
        tracker.setWorking(true);
        LocalTime eTime = LocalTime.now();
        manager.startedWorking.add(ws.timeFormatting(eTime));
        return "Started work at: "+ eTime;
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