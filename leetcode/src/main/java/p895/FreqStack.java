package p895;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class FreqStack {
    class FreqAndPosition {
        int freq;
        LinkedList<Integer> positions = new LinkedList<>();

        int getHighestPosition() {
            return positions.getLast();
        }
    }

    private int sizeOfStack = 0;
    private Map<Integer, FreqAndPosition> map = new HashMap<>();

    public FreqStack() {
    }

    public void push(int x) {
        sizeOfStack += 1;
        if (map.containsKey(x)) {
            FreqAndPosition fap = map.get(x);
            fap.freq += 1;
            fap.positions.add(sizeOfStack);
        } else {
            FreqAndPosition fap = new FreqAndPosition();
            fap.freq = 1;
            fap.positions.add(sizeOfStack);
            map.put(x, fap);
        }
    }

    public int pop() {
        // find
        Integer numberToPop = null;
        int freq = 0;
        int position = 0;
        for (Map.Entry<Integer, FreqAndPosition> entry : map.entrySet()) {
            if (numberToPop == null) {
                numberToPop = entry.getKey();
                freq = entry.getValue().freq;
                position = entry.getValue().getHighestPosition();
            } else if (
                    entry.getValue().freq > freq ||
                    (entry.getValue().freq == freq && entry.getValue().getHighestPosition() > position)
            ) {
                numberToPop = entry.getKey();
                freq = entry.getValue().freq;
                position = entry.getValue().getHighestPosition();
            }
        }

        // pop
        sizeOfStack -= 1;
        FreqAndPosition fap = map.get(numberToPop);
        if (fap.positions.size() == 1) {
            map.remove(numberToPop);
        } else {
            fap.freq -= 1;
            fap.positions.removeLast();
        }

        for (Map.Entry<Integer, FreqAndPosition> entry : map.entrySet()) {
            LinkedList<Integer> newPositions = new LinkedList<>();
            for (Integer e : entry.getValue().positions) {
                if (e > position) {
                    newPositions.add(e - 1);
                } else {
                    newPositions.add(e);
                }
            }
            entry.getValue().positions = newPositions;
        }

        return numberToPop;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
