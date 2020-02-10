package p895;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class FreqStack {
    class FreqAndPosition {
        int freq;
        List<Integer> positions = new LinkedList<>();

        int getHighestPosition() {
            return positions.get(positions.size() - 1);
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
            fap.positions.remove(fap.positions.size() - 1);
        }

        for (Map.Entry<Integer, FreqAndPosition> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().positions.size(); i++) {
                int pos = entry.getValue().positions.get(i);
                if (pos > position) {
                    entry.getValue().positions.set(i, pos - 1);
                }
            }
        }

        return numberToPop;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(4);
        freqStack.push(0);
        freqStack.push(9);
        freqStack.push(3);
        freqStack.push(4);
        freqStack.push(2);
        freqStack.pop();
        freqStack.push(6);
        freqStack.pop();
        freqStack.push(1);
        freqStack.pop();
        freqStack.push(4);
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();

        System.out.println("DONE");
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
