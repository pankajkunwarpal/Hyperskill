package sorting;

public class DataEntry<T> {
    private final T value;
    DataEntry(T data) {
        this.value = data;
    }

    T getValue() {
        return value;
    }

    boolean compareIt(T value, boolean str) {
        if (getValue().toString().contains("-") || value.toString().contains("-")) {
            return getValue().toString().compareTo(value.toString()) < 0;
        }
        if (!str && getValue().toString().length() != value.toString().length()) {
            return getValue().toString().length() < value.toString().length();
        }
        return getValue().toString().compareTo(value.toString()) < 0;
    }
}
