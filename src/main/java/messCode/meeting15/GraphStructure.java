package messCode.meeting15;

import java.util.HashMap;
import java.util.LinkedList;

public class GraphStructure<T> {

    private final HashMap<String, Vertex> vertices;

    public GraphStructure()
    {
        this.vertices = new HashMap<>();
    }

    private Edge addEdge()
    {
        return null;
    }

    private Vertex addVertex(String value)
    {
        if(!this.vertices.containsKey(value))
        {
        }
        return null;
    }

    protected class Vertex {

        public T data;
        public LinkedList<Edge> edges;

        public Vertex(T data, LinkedList<Edge> edges)
        {
            this.data = data;
            this.edges = edges;
        }
    }

    protected class Edge {
        private final Vertex destination;

        public Edge(Vertex destination)
        {
            this.destination = destination;
        }

        public Vertex getDestination()
        {
            return this.destination;
        }
    }
}
