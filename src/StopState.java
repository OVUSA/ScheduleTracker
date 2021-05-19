class StopState implements State{

    Tracker tracker;

    StopState(Tracker tracker){
        this.tracker = tracker;
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