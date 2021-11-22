import java.util.concurrent.LinkedBlockingQueue;

public class ATS {
    // очередь звонков
    private LinkedBlockingQueue<Call> calls = new LinkedBlockingQueue<>();
    // добавить звонок в очередь
    public void addCall(Call call) {
        calls.add(call);
    }
    // добавить звонок в очередь
    public void addCall(String number) {
        Call call = new Call(number);
        calls.add(call);
    }
    // взять звонок из очереди
    public Call getCall() {
        Call call;
        call = calls.poll();
        return call;
    }
    // количество звонков в очереди
    public int getCallsSize() {
        return calls.size();
    }

}
