package model;

import java.util.Objects;

public class Document {
    private DocumentType type;
    private String id;

    public Document () {
    }

    public Document(DocumentType type, String field) {
        this.type = type;
        this.id = field;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document document)) return false;
        return getType() == document.getType() && Objects.equals(getId(), document.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getId());
    }
}
