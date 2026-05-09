package Assignment_4;

public class Vertex {
    private int id; // Бірегей идентификатор

    public Vertex(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
