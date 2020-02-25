
public class Timer{

    private static Timer instance;
    private long startTime;

    public static Timer getInstance(){
        if(instance == null){
            instance = new Timer();
        }
        return instance;
    }

    private Timer(){

    }

    public void StartTimer(){
        startTime = System.currentTimeMillis();
    }

    public Double ElapsedTime(){
        return (double) (System.currentTimeMillis() - startTime)/1000;
    }
}