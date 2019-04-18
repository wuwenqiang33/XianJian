import java.util.List;

public class OperationRelationStructure {

	String operation;
	
	List<String> beforeOperationLs;
	
	List<String> nextOperationLs;
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public List<String> getBeforeOperationLs() {
		return beforeOperationLs;
	}

	public void setBeforeOperationLs(List<String> beforeOperationLs) {
		this.beforeOperationLs = beforeOperationLs;
	}

	public List<String> getNextOperationLs() {
		return nextOperationLs;
	}

	public void setNextOperationLs(List<String> nextOperationLs) {
		this.nextOperationLs = nextOperationLs;
	}

	

	
}
