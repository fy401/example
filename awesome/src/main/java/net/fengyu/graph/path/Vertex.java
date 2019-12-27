package net.fengyu.graph.path;

import java.io.Serializable;

/**
 * 图中节点自定义类，用于参考，实际业务使用的类需要重写equals 和 hashCode方法
 */
public class Vertex implements Serializable {

    private int id;
    private String name;

    public Vertex(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Vertex that = (Vertex) o;
        if((this.id == that.id) && (this.name.equals(that.name))) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("vertex[id=").append(this.id).append(",");
        sb.append("name='").append(this.name).append("']");
        return sb.toString();
    }
}
