package sorting;

public class ListData<T> {
    private int size = 0;
    private int index = 0;
    private DataEntry<T>[] data;
    private int count = 0;
    private int range = 5;
    private T max;
    private final boolean str;

    ListData(boolean str) {
        data = new DataEntry[range];
        this.str = str;
    }

    public void add(T d) {
        if (size >= range) {
            reshape(); }

        data[index] = new DataEntry<>(d);

        if (size == 0) {
            max = data[0].getValue();
        }

        if (data[index].getValue().toString().length() != max.toString().length()) {
            if (max.toString().length() < data[index].getValue().toString().length()) {
                max = data[index].getValue();
                count = 1;
            }
        } else if (max.toString().compareTo(data[index].getValue().toString()) < 0) {
            max = data[index].getValue();
            count = 1;
        } else if (max.toString().compareTo(data[index].getValue().toString()) == 0) {
            count++;
        } index++; size++;
    }

    private void quickSort(DataEntry<T>[] array, int start, int stop) {
        if (start < stop) {
            int pivotIndex = partition(array, start, stop);
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, stop);
        }
    }
    private int partition(DataEntry<T>[] array, int start, int stop) {
        T pivot = array[stop].getValue();
        int partitionIndex = start;
        for (int i = start; i < stop; i++) {
            if (array[i].compareIt(pivot, str)) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(array, partitionIndex, stop);
        return partitionIndex;
    }

    private void swap(DataEntry<T>[] array, int i, int j) {
        DataEntry<T> temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private void resetIndex() {
        size = 0;
        count = 1;
        index = 0;
    }

    private void reshape() {
        this.range += 5;
        resetIndex();
        DataEntry<T>[] temp = data;
        this.data = new DataEntry[range];

        for (DataEntry<T> d : temp) {
            add(d.getValue());
        }
    }
    void sort() { quickSort(data, 0, size - 1); }

    public String toString() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            text.append(data[i].getValue()).append(" ");
        } text.append(data[size - 1].getValue());
        return text.toString();
    }

    T getMax() { return max; }

    int getCount() { return count; }

    int getIndex() { return index; }

    int getSize() { return size; }

    DataEntry[] getData() { return data; }
}
