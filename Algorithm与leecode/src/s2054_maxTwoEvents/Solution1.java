package s2054_maxTwoEvents;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution1 {
    @Test
    public void test(){
        maxTwoEvents(new int[][]{{1,3,2},{4,5,2},{2,4,3}});
    }
    class Event {
        int ts;
        int op;
        int val;

        Event(int ts, int op, int val) {
            this.ts = ts;
            this.op = op;
            this.val = val;
        }
    }

    public int maxTwoEvents(int[][] events) {
        List<Event> evs = new ArrayList<>();
        for (int i = 0; i < events.length; ++i) {
            evs.add(new Event(events[i][0], 0, events[i][2]));
            evs.add(new Event(events[i][1], 1, events[i][2]));
        }
        Collections.sort(evs, new Comparator<Event>() {
            @Override
            public int compare(Event a, Event b) {
                if (a.ts > b.ts) {
                    return 1;
                } else if (a.ts < b.ts) {
                    return -1;
                }
                return a.op - b.op;
            }
        });
        int ans = 0, bestFirst = 0;
        for (Event ev : evs) {
            if (ev.op == 0) {
                ans = Math.max(ans, ev.val + bestFirst);
            } else {
                bestFirst = Math.max(bestFirst, ev.val);
            }
        }
        return ans;
    }
}