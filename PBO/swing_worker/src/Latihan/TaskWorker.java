package Latihan;

import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

public class TaskWorker extends SwingWorker<Integer, Integer> {

    public interface Listener {
        void onProgressUpdate(int progress, int remainingSeconds);
        void onLog(String msg);
        void onCompleted(int result);
        void onCancelled();
        void onError(Exception ex);
    }

    private final Listener listener;

    public TaskWorker(Listener listener) {
        this.listener = listener;
    }

    @Override
    protected Integer doInBackground() throws Exception {
        int total = 100;
        for (int i = 1; i <= total; i++) {
            if (isCancelled()) return null;

            Thread.sleep(80);
            publish(i);
        }
        return total;
    }

    @Override
    protected void process(List<Integer> chunks) {
        if (isCancelled()) return;

        int progress = chunks.get(chunks.size() - 1);
        int remainingSeconds = 8 - (8 * progress / 100);

        listener.onProgressUpdate(progress, remainingSeconds);
        listener.onLog("Persentase pengerjaan task: " + progress + "%");
    }

    @Override
    protected void done() {
        try {
            Integer result = get();
            listener.onCompleted(result);
        } catch (CancellationException e) {
            listener.onCancelled();

        } catch (ExecutionException e) {
            listener.onError(e);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
