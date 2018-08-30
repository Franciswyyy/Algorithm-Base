package WantOffer;


// 复杂链表的复制   next是指向下一个，random随机指向一个，可能不指向
public class Solution32 {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return null;
        cloneNodes(pHead);
        connectRandom(pHead);
        return reconnectNodes(pHead);
    }

    private void cloneNodes(RandomListNode head){
        RandomListNode node = head;
        while(node != null){
            RandomListNode clone = new RandomListNode(node.label);
            clone.next = node.next;
            clone.random = null;

            node.next = clone;
            node = clone.next;
        }
    }
    private void connectRandom(RandomListNode head){
        RandomListNode node = head;
        while(node != null){
            RandomListNode clone = node.next;
            if(node.random != null){
                clone.random = node.random.next;
            }
            node = clone.next;
        }
    }
    private RandomListNode reconnectNodes(RandomListNode head){
        RandomListNode node = head;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;

        // 设置头结点
        if(node != null){
            cloneHead = cloneNode = node.next;
            node.next = cloneHead.next;
            node = node.next;
        }
        while(node != null){
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }
}
