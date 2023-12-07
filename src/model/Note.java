package model;

import java.time.Instant;
import java.util.Objects;

public class Note {
    private Instant timestamp;
    private String key;
    private String value;

    public Note() {
        this.timestamp = Instant.now();
    }

    public Note(String key, String value) {
        this.timestamp = Instant.now();
        this.key = key;
        this.value = value;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note note)) return false;
        return Objects.equals(getTimestamp(), note.getTimestamp()) && Objects.equals(getKey(), note.getKey()) && Objects.equals(getValue(), note.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimestamp(), getKey(), getValue());
    }
}
