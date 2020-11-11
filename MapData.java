package sorting;

class MapEntry<E, T> {
    private E key;
    T value;

    MapEntry(E key, T value) {
        this.key = key;
        this.value = value;
    }
    E getKey() { return key; }
    T getValue() { return value; }

    boolean compareIt(MapEntry pivot) {
        return value.toString().compareTo(pivot.value.toString()) > 0;
    }
}

public class MapData<E, T> {

    private int index = 0;
    private MapEntry[] map;
    private int length;

    MapData(int length) {
        this.length = length;
        map = new MapEntry[length];
    }

    void put(E key, T value) {
        map[index] = new MapEntry<>(key, value);
        index++;
    }

    T getOrDefault(E key, T value) {
        try {
            return (T) map[0].value;
        } catch (NullPointerException e) { return value; }
    }

    void sort() {

         for (int i = 0; i < index; i++) {

            for (int j = 0; j < index - i - 1; j++) {
                if (map[i].compareIt(map[j])) {
                    swap(map,i);
                }
            }
        }
    }

    private void swap(MapEntry<E, T>[] array, int i) {
        MapEntry<E, T> temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
    }

    MapEntry[] getData() {
        return map;
    }

    boolean contains(E key) {
        for (int i = 0; i < index; i++) {
            if (map[i].getKey() == null) { return false; }
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder bd = new StringBuilder();
        for (int i = 0; i < index; i++) {
            bd.append(map[i].getKey()).append(": ").append(map[i].getValue()).append(" time(s), ")
                    .append(Math.round(((double) (Integer)map[i].value / this.length)*100)).append("%\n");
        }
        return bd.toString();
    }

    E getKey(int index) { return (E) map[index].getKey(); }
    T getValue(int index) { return (T) map[index].getValue(); }

    void updateValue(int index, T i) {
        map[index].value = i;
    }
}
