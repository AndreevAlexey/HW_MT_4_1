import java.util.Random;

public class Main {
    final static int CNT_OPERATORS = 4;
    final static int CNT_CALLS_PER_SEC = 5;
    final static int CNT_CALLS_TOTAL = 20;
    final static int TIME_CALL_PROC = 4000;

    public static void main(String[] args) throws InterruptedException{
        ATS ats = new ATS();
        // генератор звонков
        Runnable callsGenerator = new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                int cnt = 0;
                while(cnt < CNT_CALLS_TOTAL) {
                    for (int i = 0; i < CNT_CALLS_PER_SEC; i++) {
                        ats.addCall("891391399" + random.nextInt(100));
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cnt += CNT_CALLS_PER_SEC;
                }
            }
        };
        // обработчик звонков
        Runnable processCalls = new Runnable() {
            @Override
            public void run() {
                Call call;
                while(true) {
                    call = ats.getCall();
                    if(call == null) break;
                    try {
                        Thread.sleep(TIME_CALL_PROC);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+": "+call.toString());
                }
            }
        };
        // поток АТС
        new Thread(null, callsGenerator, "ATS").start();
        Thread.sleep(1000);
        // потоки операторов
        for(int i = 1; i <= CNT_OPERATORS; i++) {
            new Thread(null, processCalls, "operator"+i).start();
        }

    }
}
