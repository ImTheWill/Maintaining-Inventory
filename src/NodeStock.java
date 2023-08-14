import java.io.Serializable;

public class NodeStock implements Serializable {
    StockItem item;
    NodeStock next;

    NodeStock(StockItem newItem){
        item = newItem;
        next = null;
    }
    NodeStock(StockItem newItem, NodeStock nextNode){
        item = newItem;
        next = nextNode;
    }

}
