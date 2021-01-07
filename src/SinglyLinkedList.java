
public class SinglyLinkedList {

	private NODE headNode;
	
	public void addHeadNode(int xPosition, int yPosition){
		NODE obj = new NODE(xPosition, yPosition);
		obj.nextNode = headNode;
		headNode = obj;
	}
	
	public NODE removeHeadNode(){
		
		NODE oTemp = headNode;
		if (headNode == null){
			return null;
		}
		headNode = headNode.nextNode;
		return oTemp;
	}
}
